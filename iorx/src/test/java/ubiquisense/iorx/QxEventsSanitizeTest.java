package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

public class QxEventsSanitizeTest extends GuiceInjectionTest {
	
	private int pipeIo1Count;
	private int pipeIo2Count;
	private int pipeIo3Count;
	private int pipeIo4Count;

	@Before
	public void init()
	{
		pipeIo1Count = 0;
		pipeIo2Count = 0;
		pipeIo3Count = 0;
		pipeIo4Count = 0;
	}
	
	//@Test
	public void testOscQxEventsHandling()
	{
		
		CmdPipe pipeIo1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4444", new int[] {1235}, -1, null, true);
		CmdPipe pipeIo2 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4445", new int[] {1236}, -1, null, true);
		CmdPipe pipeIo3 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4446", new int[] {1237}, -1, null, true);
		CmdPipe pipeIo4 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4447", new int[] {1238}, -1, null, true);
		
		
		pipeIo1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					super.handleQxEvent(event);
					pipeIo1Count++;
				}
			}
		});
		pipeIo2.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					super.handleQxEvent(event);
					pipeIo2Count++;
				}
			}
		});
		pipeIo3.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					super.handleQxEvent(event);
					pipeIo3Count++;
				}
			}
		});
		pipeIo4.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					super.handleQxEvent(event);
					pipeIo4Count++;
				}
			}
		});
	
		for (int i = 1; i<=1000; i++)
		{
			pipeIo1.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo1/message_" + i));
			pipeIo2.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo2/message_" + i));
			pipeIo3.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo3/message_" + i));
			pipeIo4.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipeIo4/message_" + i));
		}
		
		assertEquals(1000, pipeIo1Count);
		assertEquals(1000, pipeIo2Count);
		assertEquals(1000, pipeIo3Count);
		assertEquals(1000, pipeIo4Count);

	}
	
	
	@After
	public void after()
	{
		Ubq.Reactor.closeAll();
	}

}
