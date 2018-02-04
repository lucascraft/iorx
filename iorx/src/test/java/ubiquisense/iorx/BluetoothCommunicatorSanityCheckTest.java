package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import ubiquisense.iorx.cmd.CmdPipe;

public class BluetoothCommunicatorSanityCheckTest extends GuiceInjectionTest
{
	
	public void testBluetootLibraryLoad()
	{
		CmdPipe udpOscIoPipe = Ubq.Reactor.createPipe("bt://", "osc", "osc_pipe_bt_1", "127.0.0.0:1234", new int[] {9056}, -1, new HashMap<Object, Object>(), false);

		assertNotNull(udpOscIoPipe);
		assertNotNull(udpOscIoPipe.getAddr());
		assertNotNull(udpOscIoPipe.getPort());
		assertNotNull(udpOscIoPipe.getPorts());
	}

}
