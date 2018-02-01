package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;

/**
 * Unit test for simple App.
 */
public class AppTest {
	Injector injector;

	CmdPipe pipe;
	CmdEngine engineClient;

	@Before
	public void init() {
		injector = Guice.createInjector(new ConfigurationModule());
		pipe = injector.getInstance(CmdPipe.class);
		engineClient = injector.getInstance(CmdEngine.class);
	}

	@Test
	public void testApp() {

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
		

	}
}
