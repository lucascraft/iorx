package ubiquisense.iorx.dndns.services;

import ubiquisense.iorx.dndns.ISmartDnsServiceManager;

public interface DnDnsService  extends ISmartDnsServiceManager{
	String getName();
	String getProtocol();
	String getDomain();
	int getPort();
} // Services
