package ubiquisense.iorx.nojunit;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.UUID;

import ubiquisense.iorx.GuiceInjectionTest;
import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

public class OscRcvMessagesTest extends GuiceInjectionTest {
	
	private static OscRcvMessagesTest INSTANCE = new OscRcvMessagesTest();
	public OscRcvMessagesTest() {
	}

	//@Before
	public void init()
	{
	}
	
	public static void main(String[] args) {
		INSTANCE.testOscQxEventsHandling();
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
	
	//@Test
	public void testOscQxEventsHandling()
	{
		
		CmdPipe pipeIn1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4444}, -1, null, true);
		
		pipeIn1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					super.handleQxEvent(event);
				} 
			}
		});
		
	}
}
