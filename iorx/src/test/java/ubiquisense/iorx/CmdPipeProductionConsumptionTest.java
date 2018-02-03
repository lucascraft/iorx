package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.qx.impl.QxMonitorJob;
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
		
		Thread t =new Thread(new QxMonitorJob(pipe));
		t.start();
		
		for (int i = 1; i<10000; i++)
		{
			pipe.send(CmdUtil.INSTANCE.generateRamdomCmd());
		}
		
		while(t.isAlive());
	}
}