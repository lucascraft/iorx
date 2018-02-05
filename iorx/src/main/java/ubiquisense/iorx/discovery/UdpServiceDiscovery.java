package ubiquisense.iorx.discovery;

import ubiquisense.iorx.annotations.TransportProtocol;

@TransportProtocol(type = "udp://")
public class UdpServiceDiscovery extends ZeroconfDeviceDiscovery {
	@Override
	public void scan() {
		
	}
}
