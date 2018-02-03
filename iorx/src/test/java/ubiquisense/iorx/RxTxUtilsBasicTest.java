package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import gnu.io.RXTXCommDriver;
import ubiquisense.iorx.comm.rxtx.RXTXSerialUtil;
import ubiquisense.iorx.protocols.midi.internal.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OSCQxCmdHandler;
import ubiquisense.iorx.registry.ProtocolReactor;
import ubiquisense.iorx.registry.ProtocolWithSpecificTransportConfig;

public class RxTxUtilsBasicTest {

	@Test
	public void testInitRxTxUtils()
	{

//		String rxtxVersio = RXTXCommDriver.nativeGetVersion();
//		
//		System.out.println(rxtxVersio);
//
		RXTXSerialUtil.INSTANCE.getPortMap().forEach((k, v) -> System.out.println(k + "->" + v));
		

	}
}
