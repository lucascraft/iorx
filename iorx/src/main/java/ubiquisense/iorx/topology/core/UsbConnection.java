/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import ubiquisense.iorx.comm.usb.io.Serial;

public interface UsbConnection   {
	Serial getSerial();
	void setSerial(Serial value);

} // UsbConnection
