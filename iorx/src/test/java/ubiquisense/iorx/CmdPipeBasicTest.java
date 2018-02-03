package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.utils.CmdUtil;
import ubiquisense.iorx.utils.EngineUtil;

public class CmdPipeBasicTest extends GuiceInjectionTest {

	
	@Test
	public void testTxPostCmd()
	{
		CmdPipe pipe = injector.getInstance(CmdPipe.class);
		
		Set<Rx> rxQueues = EngineUtil.INSTANCE.getRxQueues(pipe);
		Set<Tx> txQueues = EngineUtil.INSTANCE.getTxQueues(pipe);
		
		assertEquals("Only one rx queue allowed in normal pipes", 1, rxQueues.size());
		assertEquals("Only one tx queue allowed in normal pipes", 1, txQueues.size());
		
		for (int i = 1; i<10000; i++)
		{
			pipe.send(CmdUtil.INSTANCE.generateRamdomCmd());
		}
	}
}
