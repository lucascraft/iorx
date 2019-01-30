package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.dmx.DMXQxCmdHandler;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXCmd;
import ubiquisense.iorx.protocols.dmx.internal.util.OpenDmxCmdUtils;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.raw.internal.impl.RawCmdImpl;

/**
 * Unit test for simple App.
 */
public class OscToDmxAppTest extends GuiceInjectionTest
{
	private CmdPipe pipe;
	private CmdEngine engineClient;
	private Ubq mojo;

	@Before
	public void initEngines()
	{
		pipe = injector.getInstance(CmdPipe.class);
		engineClient = injector.getInstance(CmdEngine.class);
		mojo = new Ubq();
	}
	
	//@Test
	public void testDmxFadeToRaimbowOnChannel064Step100()
	{
		CmdPipe pipeOut1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4444", new int[] {}, -1, null, true);

		CmdPipe pipeIn1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4444}, -1, null, true);
	
		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", "COM5", 57600);
		assertNotNull(dmxUsbCom4);
		
		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);
		
		pipeIn1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					System.out.println("hello");
					if (event.getCmd() instanceof CompoundCmd)
					{
						List<OpenDMXCmd> stack = Lists.newArrayList();
						CompoundCmd cc = (CompoundCmd) event.getCmd();
						cc.getChildren().stream().forEach(c -> {
							OSCMessage msg = (OSCMessage) ((OscCmd)c).getMsg();
							int channel = (int) msg.getArguments().get(0);
							int r = (int) msg.getArguments().get(1);
							int g = (int) msg.getArguments().get(2);
							int b = (int) msg.getArguments().get(3);
							stack.add(OpenDmxCmdUtils.INSTANCE.createFadeBRG(channel, r, g, b));
						});
						dmxUsbCom4.send(cc);
					}
				} 
			}
		});

		for (int n = 1; n<=10; n++)
		{
			OSCBundle bundle = new OSCBundle();
			for (int i=0;i<255;i+=1)
			{
				for (int c=0;c<300;c+=3)
				{
					OSCMessage cc = new OSCMessage("/dmx/fade/bgr");
					cc.addArgument(new Integer(c+64));
					cc.addArgument(new Integer(i));
					cc.addArgument(new Integer(255-i));
					cc.addArgument(new Integer((2*i)%255));
					bundle.addPacket(cc);
					System.out.println("added");
				}
			}
			
			try {
				Thread.sleep(25l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			RawCmdImpl raw = new RawCmdImpl();
			raw.setBytes(bundle.getByteArray());
			System.out.println("send");
			pipeOut1.send(raw);
			System.out.println("sent");
		}
		
		Scanner scanner = new Scanner(System.in);
		String line = "";
		while(!line.equals("stop"))
		{
			 line = scanner.nextLine();
			try {
				Thread.sleep(25l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scanner.close();
		}
	}
}
