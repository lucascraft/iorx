package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.pipe.CmdPipe;
import ubiquisense.iorx.pipe.EngineApplication;
import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;

/**
 * Unit test for simple App.
 */
public class AppTest extends GuiceInjectionTest
{
	CmdPipe pipe;
	CmdEngine engineClient;
	QuanticMojo mojo;

	@Before
	public void initEngines()
	{
		pipe = injector.getInstance(CmdPipe.class);
		engineClient = injector.getInstance(CmdEngine.class);
		mojo = new QuanticMojo();
	}
	
	@Test
	public void testBuildEngineApp() {
		EngineApplication engineApp = mojo.buildEngineApp("truc", "midi");
		
		assertNotNull(engineApp);
		assertNotNull(engineApp.getClients());
		assertNotNull(engineApp.getEngine());
		
		engineApp.getClients().forEach(c -> assertNotNull(c.getApplication()));
		engineApp.getClients().forEach(c -> assertNotNull(c.getEngines()));
		engineApp.getClients().forEach(c -> assertNotNull(c.getRunner()));
		
		CmdPipe engine = engineApp.getEngine().get(0);
		
		assertEquals("midi", engine.getCommunicationProtocol());
		assertTrue(engine.getInputInterpreter() instanceof MidiQxCmdHandler);
		assertTrue(engine.getOutputInterpreter() instanceof MidiQxCmdHandler);
	}
	
	@Test
	public void testApp() 
	{
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
