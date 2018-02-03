/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import ubiquisense.iorx.topology.ledger.XCPDevice;

public interface TopologyNode extends AbstractTopologyItem {
	/**
	 * Returns the value of the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' reference.
	 * @see #setDevice(XCPDevice)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyNode_Device()
	 * @model
	 * @generated
	 */
	XCPDevice getDevice();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.TopologyNode#getDevice <em>Device</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(XCPDevice value);

	/**
	 * Returns the value of the '<em><b>Mime</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.comm.ezxtopology.Mime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mime</em>' attribute.
	 * @see net.sf.smbt.comm.ezxtopology.Mime
	 * @see #setMime(Mime)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyNode_Mime()
	 * @model
	 * @generated
	 */
	Mime getMime();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.TopologyNode#getMime <em>Mime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mime</em>' attribute.
	 * @see net.sf.smbt.comm.ezxtopology.Mime
	 * @see #getMime()
	 * @generated
	 */
	void setMime(Mime value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyNode_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.TopologyNode#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Heart Beat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heart Beat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heart Beat</em>' attribute.
	 * @see #setHeartBeat(int)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyNode_HeartBeat()
	 * @model
	 * @generated
	 */
	int getHeartBeat();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.TopologyNode#getHeartBeat <em>Heart Beat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heart Beat</em>' attribute.
	 * @see #getHeartBeat()
	 * @generated
	 */
	void setHeartBeat(int value);

} // TopologyNode
