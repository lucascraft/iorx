/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import com.rapplogic.xbee.api.XBee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBee Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.XBeeConnection#getXbee <em>Xbee</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getXBeeConnection()
 * @model
 * @generated
 */
public interface XBeeConnection   {
	/**
	 * Returns the value of the '<em><b>Xbee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xbee</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xbee</em>' attribute.
	 * @see #setXbee(XBee)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getXBeeConnection_Xbee()
	 * @model dataType="net.sf.smbt.comm.ezxtopology.XBee"
	 * @generated
	 */
	XBee getXbee();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.XBeeConnection#getXbee <em>Xbee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xbee</em>' attribute.
	 * @see #getXbee()
	 * @generated
	 */
	void setXbee(XBee value);

} // XBeeConnection
