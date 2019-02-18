package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;

import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.dmx.DMXQxCmdHandler;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXCmd;
import ubiquisense.iorx.protocols.dmx.internal.util.OpenDmxCmdUtils;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.protocols.raw.internal.impl.ByteCmdImpl;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

import com.illposed.osc.OSCMessage;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Unit test for simple App.
 */
public class DmxAppTest extends GuiceInjectionTest {
	private CmdPipe pipe;
	private CmdEngine engineClient;
	private Ubq mojo;

	public DmxAppTest() {
	}

	@Before
	public void initEngines() {
		pipe = injector.getInstance(CmdPipe.class);
		engineClient = injector.getInstance(CmdEngine.class);
		mojo = new Ubq();
	}

	// @Test
	public void testBuildEngineApp() {
		CmdPipe engine = mojo.buildEngineApp("dmxMood", "dmx");
		assertEquals("dmx", engine.getCommunicationProtocolIn());
		assertEquals("dmx", engine.getCommunicationProtocolOut());
		assertTrue(engine.getInputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(engine.getOutputInterpreter() instanceof DMXQxCmdHandler);
	}

	// @Test
	public void testDmxFadeToRedOnChannel001() {
		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", "/dev/ttyUSB0", 57600);
		assertNotNull(dmxUsbCom4);

		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);

		for (int n = 0; n < 10; n += 1) {
			for (int i = 0; i < 255; i += 1) {
				OpenDMXCmd c1 = OpenDmxCmdUtils.INSTANCE.createFadeBRG(1, i, 255 - i, (2 * i) % 255);
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
	public void testRcvDmxFadeToRaimbowOnChannel064Step100() {
		String port = "";
		String OSName = System.getProperty("os.name");

		System.out.println("OS Name : " + OSName);

		if (OSName.equalsIgnoreCase("Windows 10")) {
			port = "COM5";
		} else {
			port = "/dev/ttyUSB0";
		}

		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", port, 115200);

		CmdPipe oscControlPipe = mojo.openUdpPipe("osc", 6789);

		oscControlPipe.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind())) {
					if (event.getCmd() instanceof OscCmd) {
						System.out.println("msg");
						OscCmd cmd = (OscCmd) event.getCmd();
						OSCMessage message = (OSCMessage) cmd.getMsg();
						if (message.getAddress().startsWith("/play")) {
							System.out.println("message : " + message.getAddress());
							String command = message.getAddress().split("/")[2];
							if ("raimbow".equals(command)) {
								System.out.println("before raimbow");
								rainbow(dmxUsbCom4);
								System.out.println("after raimbow");
							} else if ("blink".equals(command)) {
								System.out.println("before blink");
								blink(dmxUsbCom4);
								System.out.println("after blink");
							} else if ("shut".equals(command)) {
								System.out.println("before shut");
								shut(dmxUsbCom4);
								System.out.println("after shut");
							} else if ("dmx".equals(command)) {
								// todo
							}
						} else if (message.getAddress().startsWith("/set/led"))
						{
							int c = (int) message.getArguments().get(0);
							int r = (int) message.getArguments().get(1);
							int g = (int) message.getArguments().get(2);
							int b = (int) message.getArguments().get(3);  
							System.out.println("set led on channel " + c + " with : [" + r+ ", " + g +", "+ b + "]");
							dmxUsbCom4.send(OpenDmxCmdUtils.INSTANCE.createFadeBRG(c + 64, r, g, b));
						}
					} else if (event.getCmd() instanceof ByteCmd) {
						dmxUsbCom4.send(event.getCmd());
					}
				}
			}
		});

		assertNotNull(dmxUsbCom4);
		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);

		Scanner scanner = new Scanner(System.in);
		String line = "";
		while (!line.equals("stop")) {
			line = scanner.nextLine();
			try {
				Thread.sleep(25l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scanner.close();
		}

	}

	// @Test
	public void testDmxFadeToRaimbowOnChannel064Step100() {
		String port = "";
		String OSName = System.getProperty("os.name");

		System.out.println("OS Name : " + OSName);

		if (OSName.equalsIgnoreCase("Windows 10")) {
			port = "COM5";
		} else {
			port = "/dev/ttyUSB0";
		}

		CmdPipe dmxUsbCom4 = mojo.openUsbPipe("dmx", "dmxMood1", port, 115200);

		assertNotNull(dmxUsbCom4);
		assertTrue(dmxUsbCom4.getOutputInterpreter() instanceof DMXQxCmdHandler);
		assertTrue(dmxUsbCom4.getPort().getChannel() instanceof UsbSerialTransportCommunicator);

//		rainbow(dmxUsbCom4);
		blink(dmxUsbCom4);

	}

	private void blink(CmdPipe pipe) {
		for (int n = 0; n < 10; n += 1) {
			for (int i = 0; i < 255; i += 3) {
				List<OpenDMXCmd> stack = Lists.newArrayList();
				for (int c = 0; c < 450; c += 3) {
					stack.add(OpenDmxCmdUtils.INSTANCE.createFadeBRG(c + 64, i, 0, 125));
				}

				pipe.send(new ByteCmdImpl(OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd(stack)));

				try {
					Thread.sleep(10l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void rainbow(CmdPipe pipe) {
		for (int n = 0; n < 10; n += 1) {
			for (int i = 0; i < 255; i += 3) {
				List<OpenDMXCmd> stack = Lists.newArrayList();
				for (int c = 0; c < 450; c += 3) {
					stack.add(OpenDmxCmdUtils.INSTANCE.createFadeBRG(c + 64, i, (c + 255 - i) % 255, (2 * i) % 255));
				}

				pipe.send(new ByteCmdImpl(OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd(stack)));

				try {
					Thread.sleep(10l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void shut(CmdPipe pipe) {
		List<OpenDMXCmd> stack = Lists.newArrayList();
		for (int c = 0; c < 450; c += 3) {
			stack.add(OpenDmxCmdUtils.INSTANCE.createFadeBRG(c + 64, 0, 0, 0));
		}

		pipe.send(new ByteCmdImpl(OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd(stack)));

		try {
			Thread.sleep(10l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
