package ubiquisense.iorx.topology.ledger.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.topology.ledger.XCPAddress;

public class XCPAddressImpl implements XCPAddress {
	String type, addr, alias, name, transportID, protocolID;
	int speed, port;
	List<Integer> ports;
	
	public XCPAddressImpl() {
		ports = Lists.newArrayList();
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String value) {
		type = value;
	}

	@Override
	public String getAddr() {
		return addr;
	}

	@Override
	public void setAddr(String value) {
		addr = value;
	}

	@Override
	public List<Integer> getPorts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlias() {
		return alias;
	}

	@Override
	public void setAlias(String value) {
		alias = value;
	}

	@Override
	public String getTransportID() {
		return transportID;
	}

	@Override
	public void setTransportID(String value) {
		transportID = value;
	}

	@Override
	public String getProtocolID() {
		return protocolID;
	}

	@Override
	public void setProtocolID(String value) {
		protocolID = value;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int value) {
		speed = value;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public void setPort(int value) {
		port = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

}
