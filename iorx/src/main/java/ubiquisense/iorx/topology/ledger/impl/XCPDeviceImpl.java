package ubiquisense.iorx.topology.ledger.impl;

import javax.jmdns.ServiceInfo;

import ubiquisense.iorx.dndns.services.DnDnsService;
import ubiquisense.iorx.registry.DnsSdRegistry;
import ubiquisense.iorx.registry.GuiceRegistery;
import ubiquisense.iorx.topology.ledger.XCPAddress;
import ubiquisense.iorx.topology.ledger.XCPAddressUtils;
import ubiquisense.iorx.topology.ledger.XCPDevice;
import ubiquisense.iorx.topology.ledger.XCPServiceStatus;

public class XCPDeviceImpl extends GuiceRegistery implements XCPDevice {
	DnDnsService service;
	XCPServiceStatus status;
	Object device;
	ServiceInfo serviceInfo;
	String ServiceInfo;
	String name;
	XCPAddress addr;
	
	public XCPDeviceImpl()
	{
		
	}
	
	public XCPDeviceImpl(DnDnsService service, XCPServiceStatus status) {
		this.service = service;
		this.status = status;
		serviceInfo = service.getServiceInfo();
		name = serviceInfo.getName();
		addr = XCPAddressUtils.INSTANCE.createXCPAddress(serviceInfo);
	}
	
	public XCPDeviceImpl(ServiceInfo serviceInfo, XCPServiceStatus status) {
		this.service = (DnDnsService) DnsSdRegistry.INSTANCE.getDsDnsServicesDescritionl(serviceInfo.getName());
		this.status = status;
		this.serviceInfo = serviceInfo;
		name = serviceInfo.getName();
		addr = XCPAddressUtils.INSTANCE.createXCPAddress(serviceInfo);
	}
	
	@Override
	public DnDnsService getServices() {
		return service;
	}

	@Override
	public void setServices(DnDnsService value) {
		service = value;
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
