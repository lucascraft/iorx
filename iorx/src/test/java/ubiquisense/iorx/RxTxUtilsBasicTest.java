package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;

public class RxTxUtilsBasicTest {

	@Test
	public void testInitRxTxUtils()
	{
		
		
		UsbSerialTransportCommunicator usbCommunicator = new UsbSerialTransportCommunicator("COM3", 57600);
		
		assertNotNull("USP port shouldn't have been null", usbCommunicator);

		
		assertEquals(usbCommunicator.getBaudRate(), 57600);
		assertEquals(usbCommunicator.getDataBits(), 8);
		assertEquals(usbCommunicator.getStopBits(), 1);
		assertEquals(usbCommunicator.getParity(), 0);
	

	}
}
