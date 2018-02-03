/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import javax.bluetooth.L2CAPConnection;

import ubiquisense.iorx.topology.core.BluetoothConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bluetooth Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.impl.BluetoothConnectionImpl#getL2cap <em>L2cap</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BluetoothConnectionImpl implements BluetoothConnection {
	L2CAPConnection l2capConnection;
	public L2CAPConnection getL2cap() {
		return l2capConnection
				;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2cap(L2CAPConnection newL2cap) {
		l2capConnection = newL2cap;
	}

} //BluetoothConnectionImpl
