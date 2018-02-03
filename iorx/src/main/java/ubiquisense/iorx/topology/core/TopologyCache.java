/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topology Cache</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.TopologyCache#getNodes <em>Nodes</em>}</li>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.TopologyCache#getSession <em>Session</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyCache()
 * @model
 * @generated
 */
public interface TopologyCache   {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.smbt.comm.ezxtopology.AbstractTopologyItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyCache_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	 List<AbstractTopologyItem> getNodes();

	/**
	 * Returns the value of the '<em><b>Session</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' containment reference.
	 * @see #setSession(SessionManager)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyCache_Session()
	 * @model containment="true"
	 * @generated
	 */
	SessionManager getSession();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.TopologyCache#getSession <em>Session</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' containment reference.
	 * @see #getSession()
	 * @generated
	 */
	void setSession(SessionManager value);

} // TopologyCache
