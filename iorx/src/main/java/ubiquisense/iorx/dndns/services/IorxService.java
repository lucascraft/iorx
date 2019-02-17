package ubiquisense.iorx.dndns.services;

import javax.inject.Named;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.ServiceInfoImpl;

import com.google.inject.Inject;

@Named("iorx")
public class IorxService implements DnDnsService {
	ServiceInfo serviceInfo;
	
	@Inject
	public IorxService() {
		serviceInfo = new ServiceInfoImpl("udp", "iorx", "", 5555, 1, 1, false, "");
	}	
	
	@Override
	public String getName() {
		return "iorx";
	}

	@Override
	public String getProtocol() {
		return "udp";
	}

	@Override
	public String getDomain() {
		return "localhost";
	}
	
	@Override
	public int getPort() {
		return 5555;
	}

	@Override
	public String getServiceName() {
		return "_iorx._udp._localhost";
	}

	@Override
	public String toString()
	{
		return "_iorx._udp._localhost[3568]";
	}

	@Override
	public void init() {
	}

	@Override
	public void connect() {
		
	}

	@Override
	public void disconnect() {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}
}
