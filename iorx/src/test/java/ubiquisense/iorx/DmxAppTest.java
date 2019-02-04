package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.protocols.dmx.DMXQxCmdHandler;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXCmd;
import ubiquisense.iorx.protocols.dmx.internal.util.OpenDmxCmdUtils;
import ubiquisense.iorx.protocols.raw.internal.impl.ByteCmdImpl;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;

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
	
	//@Test
	public void testDmxFadeToRedOnChannel001()
	{
		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", "COM5", 57600);
		assertNotNull(dmxUsbCom4);
		
		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);

		for (int n=0;n<10;n+=1)
		{
			for (int i=0;i<255;i+=1)
			{
				OpenDMXCmd c1 = OpenDmxCmdUtils.INSTANCE.createFadeBRG(1, i, 255-i, (2*i)%255);
				dmxUsbCom4.send(c1);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testDmxFadeToRaimbowOnChannel064Step100()
	{
		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", "COM5", 57600);
		assertNotNull(dmxUsbCom4);
		
		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);
		
		for (int n=0;n<10;n+=1)
		{
			for (int i=0;i<255;i+=1)
			{
				List<OpenDMXCmd> stack = Lists.newArrayList();
				for (int c=0;c<450;c+=3)
				{
					stack.add(OpenDmxCmdUtils.INSTANCE.createFadeBRG(c+64, i, 255-i, (2*i)%255));
				}				
				
				dmxUsbCom4.send(new ByteCmdImpl(OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd(stack)));
				
				try {
					Thread.sleep(25l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
