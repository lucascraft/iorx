/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.topology.core.UsbConnection;

public class UsbConnectionImpl  implements UsbConnection {
	private UsbSerialTransportCommunicator serial;
	public UsbSerialTransportCommunicator getSerial() {
		return serial;
	}

	public void setSerial(UsbSerialTransportCommunicator newSerial) {
		serial = newSerial;
	}

} //UsbConnectionImpl
