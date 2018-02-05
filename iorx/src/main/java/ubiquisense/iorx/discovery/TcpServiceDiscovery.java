package ubiquisense.iorx.discovery;

import ubiquisense.iorx.annotations.TransportProtocol;

@TransportProtocol(type = "tcp://")
public class TcpServiceDiscovery extends ZeroconfDeviceDiscovery {
	@Override
	public void scan() {
		
	}
}
