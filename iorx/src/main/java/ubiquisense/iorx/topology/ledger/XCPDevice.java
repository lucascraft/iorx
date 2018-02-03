/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.ledger;

import javax.jmdns.ServiceInfo;

import ubiquisense.iorx.topology.Services;


public interface XCPDevice {
	Services getServices();

	void setServices(Services value);
	XCPServiceStatus getStatus();
	void setStatus(XCPServiceStatus value);
	Object getDevice();
	void setDevice(Object value);
	String getName();
	void setName(String value);
	ServiceInfo getDnsSd();
	void setDnsSd(ServiceInfo value);

	XCPAddress getAddr();
	void setAddr(XCPAddress value);

} // XCPDevice
