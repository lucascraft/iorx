/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import javax.bluetooth.L2CAPConnection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bluetooth Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.BluetoothConnection#getL2cap <em>L2cap</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getBluetoothConnection()
 * @model
 * @generated
 */
public interface BluetoothConnection  {
	/**
	 * Returns the value of the '<em><b>L2cap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>L2cap</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>L2cap</em>' attribute.
	 * @see #setL2cap(L2CAPConnection)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getBluetoothConnection_L2cap()
	 * @model dataType="net.sf.smbt.comm.ezxtopology.BluetoothL2CAPConnection"
	 * @generated
	 */
	L2CAPConnection getL2cap();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.BluetoothConnection#getL2cap <em>L2cap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2cap</em>' attribute.
	 * @see #getL2cap()
	 * @generated
	 */
	void setL2cap(L2CAPConnection value);

} // BluetoothConnection
