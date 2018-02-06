package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.utils.CmdUtil;

public class CmdPipeProductionConsumptionTest extends GuiceInjectionTest {

	
	@Test
	public void testTxRxProdConsCmd()
	{
		CmdPipe pipe = injector.getInstance(CmdPipe.class);
		CmdEngine engineClient = injector.getInstance(CmdEngine.class);

		assertNotNull(injector);
		assertNotNull(pipe);

		Rx rx = pipe.getRx();
		Tx tx = pipe.getTx();

		assertNotNull(rx);
		assertNotNull(tx);

		engineClient.setId("test");
		engineClient.getEngines().add(pipe);

		pipe.setClient(engineClient);
		pipe.setId("Engine_1");
		
		for (int i = 1; i<10; i++)
		{
			pipe.send(CmdUtil.INSTANCE.generateRamdomCmd());
		}
	}
}
