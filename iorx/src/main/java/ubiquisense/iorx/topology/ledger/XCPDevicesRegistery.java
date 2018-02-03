/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.ledger;

import java.util.List;

public interface XCPDevicesRegistery  {
	List<XCPDevice> getDevices();
	List<XCPDevice> getDevicesFromType(String type);

} // XCPDevicesRegistery
