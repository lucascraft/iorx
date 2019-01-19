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

public class TopologyCacheImpl implements TopologyCache {
	private List<AbstractTopologyItem> topologyItems;

	private SessionManager sessionManager;

	public TopologyCacheImpl() {
		topologyItems = new ArrayList<AbstractTopologyItem>();
	}

	public List<AbstractTopologyItem> getNodes() {
		return topologyItems;
	}

	public SessionManager getSession() {
		return sessionManager;
	}

	public void setSession(SessionManager newSession) {
		sessionManager = newSession;
	}

} // TopologyCacheImpl
