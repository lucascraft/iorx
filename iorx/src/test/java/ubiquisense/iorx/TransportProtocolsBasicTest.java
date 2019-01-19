package ubiquisense.iorx;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;

public class TransportProtocolsBasicTest extends GuiceInjectionTest {
	
	@Test
	public void testProtocolInterpretersInjection()
	{
		
		CmdPipe p1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:3567", new int[] {}, -1, null, true);
		CmdPipe p2 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "tuio11", "osc@" + UUID.randomUUID().toString(), "localhost:4587", new int[] {}, -1, null, true);
		CmdPipe p3 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.TCP.getLiteral(), "midi", "osc@" + UUID.randomUUID().toString(), "localhost:8965", new int[] {}, -1, null, true);
		CmdPipe p4 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), "raw", "osc@" + UUID.randomUUID().toString(), "localhost:5632", new int[] {}, -1, null, true);
//		CmdPipe p5 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.BLUETOOTH.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4856", new int[] {}, -1, null, true);
		CmdPipe p6 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "dmx", "dmx@" + UUID.randomUUID().toString(), "localhost:4589", new int[] {}, -1, null, true);
		
		
		assertTrue(p1.getTransportProtocol().equals(TRANSPORT_PROTOCOL.UDP.getLiteral()));
		assertTrue(p2.getTransportProtocol().equals(TRANSPORT_PROTOCOL.UDP.getLiteral()));
		assertTrue(p3.getTransportProtocol().equals(TRANSPORT_PROTOCOL.TCP.getLiteral()));
		assertTrue(p4.getTransportProtocol().equals(TRANSPORT_PROTOCOL.HTTP.getLiteral()));
//		assertTrue(p5.getTransportProtocol().equals(TRANSPORT_PROTOCOL.BLUETOOTH.getLiteral()));
		assertTrue(p6.getTransportProtocol().equals(TRANSPORT_PROTOCOL.UDP.getLiteral()));

		assertTrue(p1.getCommunicationProtocolIn().equals("osc"));
		assertTrue(p1.getCommunicationProtocolOut().equals("osc"));
		assertTrue(p2.getCommunicationProtocolIn().equals("tuio11"));
		assertTrue(p2.getCommunicationProtocolOut().equals("tuio11"));
		assertTrue(p3.getCommunicationProtocolIn().equals("midi"));
		assertTrue(p3.getCommunicationProtocolOut().equals("midi"));
		assertTrue(p4.getCommunicationProtocolIn().equals("raw"));
		assertTrue(p4.getCommunicationProtocolOut().equals("raw"));
//		assertTrue(p5.getCommunicationProtocolIn().equals("bt"));
//		assertTrue(p5.getCommunicationProtocolOut().equals("bt"));
		assertTrue(p6.getCommunicationProtocolIn().equals("dmx"));
		assertTrue(p6.getCommunicationProtocolOut().equals("dmx"));
	}

}
