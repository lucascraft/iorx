/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import javax.bluetooth.L2CAPConnection;

import ubiquisense.iorx.topology.core.BluetoothConnection;

public class BluetoothConnectionImpl implements BluetoothConnection {
	L2CAPConnection l2capConnection;
	public L2CAPConnection getL2cap() {
		return l2capConnection
				;
	}

	public void setL2cap(L2CAPConnection newL2cap) {
		l2capConnection = newL2cap;
	}

} //BluetoothConnectionImpl
