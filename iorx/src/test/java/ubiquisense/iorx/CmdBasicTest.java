package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.utils.CmdUtil;

public class CmdBasicTest extends GuiceInjectionTest {
	
	@Test
	public void testCreateRandomCommand()
	{
		Cmd randomCmd = injector.getInstance(Cmd.class);
		
		assertNotNull(randomCmd);

		randomCmd.setPriority(CmdUtil.INSTANCE.getRandomPRIORITY());
		randomCmd.setStamp(System.currentTimeMillis());

	}

}
