package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.protocols.dmx.DMXQxCmdHandler;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXCmd;
import ubiquisense.iorx.protocols.dmx.internal.util.OpenDmxCmdUtils;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.utils.CmdUtil;

/**
 * Unit test for simple App.
 */
public class DmxAppTest extends GuiceInjectionTest
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
	
	@Test
	public void testBuildEngineApp() {
		CmdPipe engine = mojo.buildEngineApp("dmxMood", "dmx");
		
		assertEquals("dmx", engine.getCommunicationProtocolIn());
		assertEquals("dmx", engine.getCommunicationProtocolOut());
		assertTrue(engine.getInputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(engine.getOutputInterpreter() instanceof DMXQxCmdHandler);
	}
	
	@Test
	public void testApp() 
	{
		assertNotNull(injector);
		assertNotNull(pipe);

		Rx rx = pipe.getRx();
		Tx tx = pipe.getTx();

		assertNotNull(rx);
		assertNotNull(tx);

		engineClient.setId("testDmxMood");
		engineClient.getEngines().add(pipe);

		pipe.setClient(engineClient);
		pipe.setId("Engine_DMX_1");
	}
	
	@Test
	public void testDmxFadeToRedOnChannel001()
	{
		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", "COM5", 57600);
		assertNotNull(dmxUsbCom4);
		
		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);
		
		dmxUsbCom4.addQxEventHandler(new IQxEventHandler() {
			@Override
			public void handleQxEvent(Event event) {
//				if (event.getKind().equals(EVENT_KIND.RX_READY))
				{
					System.out.println(
						CmdUtil.INSTANCE.getFrameHexInfo(
							OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd(
								(OpenDMXCmd)event.getCmd()
							)
						)
					);
				}
			}
			
			@Override
			public String getID() {
				return null;
			}
		});
		
		OpenDMXCmd cmd = OpenDmxCmdUtils.INSTANCE.createOpenDMXFadeLRGBFullCmd(255, 255, 0, 0);
		cmd.setChannel(1);
		
		dmxUsbCom4.send(cmd);
	}
}
