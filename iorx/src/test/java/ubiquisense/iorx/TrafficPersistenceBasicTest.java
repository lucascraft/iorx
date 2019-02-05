package ubiquisense.iorx;

import java.util.UUID;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;
import ubiquisense.iorx.replay.TrafficPersister;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrafficPersistenceBasicTest 
{
	private CmdPipe pipe;
	private TrafficPersister tp;
	
	@Before
	public void initPipe()
	{
		if (pipe == null)
		{
			pipe = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4444", new int[] {}, -1, null, true);
		}
		
		if (tp == null)
		{
			tp = new TrafficPersister(pipe);
			tp.setRecording(true);
		}
	}
	
	
	@Test
	public void testPersitence01TrafficRecordOSC()
	{
		for (int i = 1; i<=10000; i++)
		{
			pipe.send(OscCmdUtils.INSTANCE.createOscCmd("/osc/test/message/pipe/message_" + i));
		}
	}
	
//	
//	@Test
//	public void testPersitence02TrafficLoadOSC()
//	{
//		tp.load();
//	}
//

}
