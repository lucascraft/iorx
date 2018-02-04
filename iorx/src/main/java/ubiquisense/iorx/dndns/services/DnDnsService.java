package ubiquisense.iorx.dndns.services;

public interface DnDnsService  extends ISmartDnsServiceManager{
	String getName();
	String getProtocol();
	String getDomain();
	int getPort();
} // Services
