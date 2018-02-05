/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;

public interface UsbConnection   {
	UsbSerialTransportCommunicator getSerial();
	void setSerial(UsbSerialTransportCommunicator value);

} // UsbConnection
