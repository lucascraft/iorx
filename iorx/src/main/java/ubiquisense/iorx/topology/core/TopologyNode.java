/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import ubiquisense.iorx.topology.ledger.XCPDevice;

public interface TopologyNode extends AbstractTopologyItem {
	XCPDevice getDevice();
	void setDevice(XCPDevice value);
	Mime getMime();
	void setMime(Mime value);
	String getID();
	void setID(String value);
	int getHeartBeat();
	void setHeartBeat(int value);

} // TopologyNode
