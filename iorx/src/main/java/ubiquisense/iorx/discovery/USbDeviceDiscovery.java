package ubiquisense.iorx.discovery;

import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.comm.usb.rxtx.RXTXSerialUtil;

@TransportProtocol(type="usb://")
public class USbDeviceDiscovery implements DeviceDiscovery {
	public void usbPortsScan() {
		for (String portId : UsbSerialTransportCommunicator.list()) {
			if (portId != null && !portId.equals("")) {	
				boolean absent = true;
				for (String k : RXTXSerialUtil.INSTANCE.getSerialList()) {
					UsbSerialTransportCommunicator serial = RXTXSerialUtil.INSTANCE.getPortMap().get(k);
					if (serial instanceof UsbSerialTransportCommunicator) {
						if (serial.getSerialPort().getName().equals(portId)) {
							absent = false;
						}
					}
				}
				if (absent) {
					RXTXSerialUtil.INSTANCE.getPortMap().remove(portId);
				}
			}
		}
	}
}
