package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.utils.CmdUtil;

public class CmdPipeBasicTest extends GuiceInjectionTest {

	
	@Test
	public void testTxPostCmd()
	{
		CmdPipe pipe = injector.getInstance(CmdPipe.class);
		
		Set<Rx> rxQueues = Sets.newHashSet(pipe.getRx());
		Set<Tx> txQueues = Sets.newHashSet(pipe.getTx()); 
		
		assertEquals("Only one rx queue allowed in normal pipes", 1, rxQueues.size());
		assertEquals("Only one tx queue allowed in normal pipes", 1, txQueues.size());
		
		for (int i = 1; i<10; i++)
		{
			pipe.send(CmdUtil.INSTANCE.generateRamdomCmd());
		}
	}
}
