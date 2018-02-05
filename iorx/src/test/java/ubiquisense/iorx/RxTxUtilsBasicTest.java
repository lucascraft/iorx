package ubiquisense.iorx;

import org.junit.Test;

import gnu.io.RXTXCommDriver;
import ubiquisense.iorx.comm.usb.io.ISerialCommunicator;
import ubiquisense.iorx.comm.usb.rxtx.RXTXSerialUtil;

public class RxTxUtilsBasicTest {

//	@Test
	public void testInitRxTxUtils()
	{

		String rxtxVersio = RXTXCommDriver.nativeGetVersion();
		
		System.out.println(rxtxVersio);

		RXTXSerialUtil.INSTANCE.listPorts();
		
		RXTXSerialUtil.INSTANCE.getPortMap().forEach((k, v) -> System.out.println(k + "->" + v));
		
		ISerialCommunicator serial = RXTXSerialUtil.INSTANCE.openPort(null, "COM1", 19200);

		int baudRate = serial.getBaudRate();
		
		System.out.println(baudRate);
	

	}
}
