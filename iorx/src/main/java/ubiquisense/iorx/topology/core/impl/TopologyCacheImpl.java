/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import java.util.ArrayList;
import java.util.List;

import ubiquisense.iorx.topology.core.AbstractTopologyItem;
import ubiquisense.iorx.topology.core.SessionManager;
import ubiquisense.iorx.topology.core.TopologyCache;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Topology Cache</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link net.sf.smbt.comm.ezxtopology.impl.TopologyCacheImpl#getNodes
 * <em>Nodes</em>}</li>
 * <li>{@link net.sf.smbt.comm.ezxtopology.impl.TopologyCacheImpl#getSession
 * <em>Session</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopologyCacheImpl implements TopologyCache {
	List<AbstractTopologyItem> topologyItems;

	SessionManager sessionManager;

	public TopologyCacheImpl() {
		topologyItems = new ArrayList<AbstractTopologyItem>();
	}

	@SuppressWarnings("unchecked")
	public List<AbstractTopologyItem> getNodes() {
		return topologyItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionManager getSession() {
		return sessionManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSession(SessionManager newSession) {
		sessionManager = newSession;
	}

} // TopologyCacheImpl
