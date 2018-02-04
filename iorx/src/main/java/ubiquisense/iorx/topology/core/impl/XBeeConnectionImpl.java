/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import com.rapplogic.xbee.api.XBee;

import ubiquisense.iorx.topology.core.XBeeConnection;

public class XBeeConnectionImpl  implements XBeeConnection {
	XBee xbee;
	public XBee getXbee() {
		return xbee;
	}

	public void setXbee(XBee newXbee) {
		xbee = newXbee;
	}

} //XBeeConnectionImpl
