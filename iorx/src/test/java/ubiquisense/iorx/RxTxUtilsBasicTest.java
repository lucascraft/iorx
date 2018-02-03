package ubiquisense.iorx;

import org.junit.Test;

import ubiquisense.iorx.comm.usb.rxtx.RXTXSerialUtil;

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
