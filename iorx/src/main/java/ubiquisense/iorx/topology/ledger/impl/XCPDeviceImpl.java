package ubiquisense.iorx.topology.ledger.impl;

import javax.jmdns.ServiceInfo;

import ubiquisense.iorx.topology.Services;
import ubiquisense.iorx.topology.ledger.XCPAddress;
import ubiquisense.iorx.topology.ledger.XCPDevice;
import ubiquisense.iorx.topology.ledger.XCPServiceStatus;

public class XCPDeviceImpl implements XCPDevice {
	Services services;
	XCPServiceStatus status;
	Object device;
	ServiceInfo serviceInfo;
	String ServiceInfo;
	String name;
	XCPAddress addr;
	
	@Override
	public Services getServices() {
		return services;
	}

	@Override
	public void setServices(Services value) {
		services = value;
	}

	@Override
	public XCPServiceStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(XCPServiceStatus value) {
		status = value;
	}

	@Override
	public Object getDevice() {
		return device;
	}

	@Override
	public void setDevice(Object value) {
		device = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public ServiceInfo getDnsSd() {
		return serviceInfo;
	}

	@Override
	public void setDnsSd(ServiceInfo info) {
		serviceInfo = info;
	}

	@Override
	public XCPAddress getAddr() {
		return addr;
	}

	@Override
	public void setAddr(XCPAddress value) {
		addr = value;
	}

}
