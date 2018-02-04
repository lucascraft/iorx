/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.util.List;

public interface TopologyCache   {
	List<AbstractTopologyItem> getNodes();

	SessionManager getSession();

	void setSession(SessionManager value);

} // TopologyCache
