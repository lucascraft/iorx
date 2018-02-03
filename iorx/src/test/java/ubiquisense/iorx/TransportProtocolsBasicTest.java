package ubiquisense.iorx;

import java.util.UUID;

import org.junit.Test;

import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.xp.QuanticMojo;
import ubiquisense.iorx.xp.TRANSPORT_PROTOCOL;

public class TransportProtocolsBasicTest extends GuiceInjectionTest {
	

	
	@Test
	public void testProtocolInterpretersInjection()
	{
		
		CmdPipe p1 = QuanticMojo.INSTANCE.createPipe(TRANSPORT_PROTOCOL.USB.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:3567", new int[] {}, -1, null, true);
		CmdPipe p2 = QuanticMojo.INSTANCE.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4587", new int[] {}, -1, null, true);
		CmdPipe p3 = QuanticMojo.INSTANCE.createPipe(TRANSPORT_PROTOCOL.TCP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:8965", new int[] {}, -1, null, true);
		CmdPipe p4 = QuanticMojo.INSTANCE.createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:5632", new int[] {}, -1, null, true);
		CmdPipe p5 = QuanticMojo.INSTANCE.createPipe(TRANSPORT_PROTOCOL.BLUETOOTH.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4856", new int[] {}, -1, null, true);
	}

}
