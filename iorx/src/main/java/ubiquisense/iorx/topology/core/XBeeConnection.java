/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import com.rapplogic.xbee.api.XBee;

public interface XBeeConnection   {
	XBee getXbee();
	void setXbee(XBee value);

} // XBeeConnection
