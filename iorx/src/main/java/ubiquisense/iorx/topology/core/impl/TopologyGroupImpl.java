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
import ubiquisense.iorx.topology.core.TopologyGroup;

public class TopologyGroupImpl extends AbstractTopologyItemImpl implements TopologyGroup {
	private List<AbstractTopologyItem> children;
	public TopologyGroupImpl() {
		children = new ArrayList<>();
	}

	public List<AbstractTopologyItem> getChildren() {
		return  children;
	}

} //TopologyGroupImpl
