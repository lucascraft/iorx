/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import ubiquisense.iorx.comm.usb.io.Serial;
import ubiquisense.iorx.topology.core.UsbConnection;

public class UsbConnectionImpl  implements UsbConnection {
	Serial serial;
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial newSerial) {
		serial = newSerial;
	}

} //UsbConnectionImpl
