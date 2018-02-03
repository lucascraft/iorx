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
 * A representation of the model object '<em><b>Topology Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.TopologyGroup#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyGroup()
 * @model
 * @generated
 */
public interface TopologyGroup extends AbstractTopologyItem {

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.smbt.comm.ezxtopology.AbstractTopologyItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTopologyGroup_Children()
	 * @model containment="true"
	 * @generated
	 */
	 List<AbstractTopologyItem> getChildren();
} // TopologyGroup
