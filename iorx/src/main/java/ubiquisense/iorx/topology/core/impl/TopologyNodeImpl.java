/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import ubiquisense.iorx.topology.core.Mime;
import ubiquisense.iorx.topology.core.TopologyNode;
import ubiquisense.iorx.topology.ledger.XCPDevice;

public class TopologyNodeImpl extends AbstractTopologyItemImpl implements TopologyNode {
	XCPDevice device;
	Mime mime;
	String id;
	int beat;

	public XCPDevice getDevice() {
		return device;
	}

	public void setDevice(XCPDevice newDevice) {
		device = newDevice;
	}

	public Mime getMime() {
		return mime;
	}

	public void setMime(Mime newMime) {
		mime = newMime;
	}

	public String getID() {
		return id;
	}

	public void setID(String newID) {
		id = newID;
	}

	public int getHeartBeat() {
		return beat;
	}

	public void setHeartBeat(int newHeartBeat) {
		beat = newHeartBeat;
	}

} // TopologyNodeImpl
