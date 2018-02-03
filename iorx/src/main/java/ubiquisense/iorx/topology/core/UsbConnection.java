/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import ubiquisense.iorx.comm.usb.io.Serial;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usb Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.UsbConnection#getSerial <em>Serial</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getUsbConnection()
 * @model
 * @generated
 */
public interface UsbConnection   {
	/**
	 * Returns the value of the '<em><b>Serial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serial</em>' attribute.
	 * @see #setSerial(Serial)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getUsbConnection_Serial()
	 * @model dataType="net.sf.smbt.comm.ezxtopology.Serial"
	 * @generated
	 */
	Serial getSerial();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.UsbConnection#getSerial <em>Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serial</em>' attribute.
	 * @see #getSerial()
	 * @generated
	 */
	void setSerial(Serial value);

} // UsbConnection
