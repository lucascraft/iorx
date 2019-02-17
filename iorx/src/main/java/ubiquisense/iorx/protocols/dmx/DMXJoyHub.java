package ubiquisense.iorx.protocols.dmx;

import java.util.Scanner;
import java.util.UUID;

import java.util.Scanner;
import java.util.UUID;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.GuiceInjectionTest;
import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;
import ubiquisense.iorx.protocols.osc.internal.impl.OscCmdImpl;

public class DMXJoyHub {
	
	private static DMXJoyHub INSTANCE = new DMXJoyHub();
	
	public DMXJoyHub() {
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
		CmdPipe pipeIn1 = Ubq.Reactor.createPipe(
			TRANSPORT_PROTOCOL.UDP.getLiteral(), 
			"osc", 
			"osc@" + UUID.randomUUID().toString(), 
			"localhost", 
			new int[] {5555}, 
			-1, 
			null, 
			true
		);
		
		pipeIn1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (event.getCmd() instanceof OscCmd /* EVENT_KIND.RX_READY.equals(event.getKind())*/)
				{
					OSCMessage msg = (OSCMessage) ((OscCmdImpl)event.getCmd()).getMsg();
					System.out.println(msg.getAddress());
					super.handleQxEvent(event);
				} 
			}
		});
		
	}


}
