package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

public class QxRcvEventsSanitizeTest extends GuiceInjectionTest {
	
	private int pipeIo1Count;
	private int pipeIo2Count;
	private int pipeIo3Count;
	private int pipeIo4Count;
	
	private int pipeOut1Count;
	private int pipeOut2Count;
	private int pipeOut3Count;
	private int pipeOut4Count;
	
	private static QxRcvEventsSanitizeTest INSTANCE = new QxRcvEventsSanitizeTest();
	
	public QxRcvEventsSanitizeTest() {
	}

	@Before
	public void init()
	{
		pipeIo1Count = 0;
		pipeIo2Count = 0;
		pipeIo3Count = 0;
		pipeIo4Count = 0;

		pipeOut1Count = 0;
		pipeOut2Count = 0;
		pipeOut3Count = 0;
		pipeOut4Count = 0;
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
	
	@Test
	public void testOscQxEventsHandling()
	{
		CmdPipe pipeOut1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4444", new int[] {}, -1, null, true);
		CmdPipe pipeOut2 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4445", new int[] {}, -1, null, true);
		CmdPipe pipeOut3 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4446", new int[] {}, -1, null, true);
		CmdPipe pipeOut4 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4447", new int[] {}, -1, null, true);
		
		CmdPipe pipeIn1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4444}, -1, null, true);
		CmdPipe pipeIn2 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4445}, -1, null, true);
		CmdPipe pipeIn3 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4446}, -1, null, true);
		CmdPipe pipeIn4 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4447}, -1, null, true);
		
		pipeIn1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					pipeIo1Count++;
				} 
			}
		});
		
		pipeIn2.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					pipeIo2Count++;
				} 
			}
		});
		
		pipeIn3.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					pipeIo3Count++;
				}
			}
		});
		
		pipeIn4.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					pipeIo4Count++;
				}
			}
		});
		
		pipeOut1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					System.out.println(((OSCMessage)((OscCmd)event.getCmd()).getMsg()).getAddress());
					pipeOut1Count++;
				} 
			}
		});
		
		pipeOut2.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					System.out.println(((OSCMessage)((OscCmd)event.getCmd()).getMsg()).getAddress());
					pipeOut2Count++;
				} 
			}
		});
		
		pipeOut3.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					System.out.println(((OSCMessage)((OscCmd)event.getCmd()).getMsg()).getAddress());
					pipeOut3Count++;
				}
			}
		});
		
		pipeOut4.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					System.out.println(((OSCMessage)((OscCmd)event.getCmd()).getMsg()).getAddress());
					pipeOut4Count++;
				}
			}
		});
	
		for (int i = 1; i<=10; i++)
		{
			pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo1/message_" + i));
			pipeOut2.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo2/message_" + i));
			pipeOut3.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo3/message_" + i));
			pipeOut4.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo4/message_" + i));
		}
		
		
		System.out.println("Sent " + pipeIo1Count + "on localhost:4444");
		System.out.println("Sent " + pipeIo2Count + "on localhost:4445");
		System.out.println("Sent " + pipeIo3Count + "on localhost:4446");
		System.out.println("Sent " + pipeIo4Count + "on localhost:4447");
		
		System.out.println("Rcv " + pipeIo1Count + "on 4444");
		System.out.println("Rcv " + pipeIo2Count + "on 4445");
		System.out.println("Rcv " + pipeIo3Count + "on 4446");
		System.out.println("Rcv " + pipeIo4Count + "on 4447");
		
		try {
			Thread.sleep(250l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(10, pipeIo1Count);
		assertEquals(10, pipeIo2Count);
		assertEquals(10, pipeIo3Count);
		assertEquals(10, pipeIo4Count);

		assertEquals(10, pipeOut1Count);
		assertEquals(10, pipeOut2Count);
		assertEquals(10, pipeOut3Count);
		assertEquals(10, pipeOut4Count);
			
	}
}
