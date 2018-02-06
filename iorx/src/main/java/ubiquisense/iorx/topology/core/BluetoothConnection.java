/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import javax.bluetooth.L2CAPConnection;

public interface BluetoothConnection  {
	L2CAPConnection getL2cap();
	void setL2cap(L2CAPConnection value);

} // BluetoothConnection
