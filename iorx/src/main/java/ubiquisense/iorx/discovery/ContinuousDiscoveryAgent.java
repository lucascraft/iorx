
package ubiquisense.iorx.discovery;

import java.io.IOException;

public class ContinuousDiscoveryAgent extends Thread implements IContinuousDiscoveryAgent {
	private BluetoothDeviceDiscovery btDeviceDiscovery;
	private USbDeviceDiscovery usbDeviceDiscovery;
	private TcpServiceDiscovery tcpDeviceDiscovery;
	private UdpServiceDiscovery udpDeviceDiscovery;

	public ContinuousDiscoveryAgent() {
		super("Tansversal Discovery Topology Agent");
		btDeviceDiscovery		= new BluetoothDeviceDiscovery();
		usbDeviceDiscovery		= new USbDeviceDiscovery();
		tcpDeviceDiscovery 		= new TcpServiceDiscovery();
		udpDeviceDiscovery 		= new UdpServiceDiscovery();
	}
	
	
/*	public JmDNS getJmDNS() {
		return zeroconfDeviceDiscovery.getJmDNS();
	}
*/	
	@Override
	public void run() {
		do
		{
			//handleBTStuff();
			//handleHttpStuff(); /..... hmm, think to that later ...
			//handleUdpStuff();
			//handleTcpStuff();
			//handleUsbStuff();
			
			//topologyCacheCoherenceChecker();
	
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // lets schedule it every 10 seconds for the moment
		}while(true);
	}
	
	/**
	 * 
	 */
	public void handleBTStuff() {
		try {
			btDeviceDiscovery.discoverDevices();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reconcileSessionBTConnections();
	}

	/**
	 * 
	 */
	public void handleTcpStuff() {
		//zeroconfDeviceDiscovery.discoverTcpZeroconfDevices();
		tcpDeviceDiscovery.scan();
		reconcileSessionTcpConnections();
	}

	/**
	 * 
	 */
	public void handleUdpStuff() {
		//zeroconfDeviceDiscovery.discoverUdpZeroconfDevices();
		udpDeviceDiscovery.scan();
		reconcileSessionUdpConnections();
	}

	/**
	 * 
	 */
	public void handleUsbStuff() {
		usbDeviceDiscovery.usbPortsScan();
		reconcileSessionUSBConnections();
	}


	/**
	 * 
	 */
	public void topologyCacheCoherenceChecker() {
		// 
		// Its very likely that all this bloody mess will 
		// have to get its intrinsec coherence checked at some point
		//
	}

	/**
	 * 
	 */
	@Override
	public void reconcileSessionBTConnections() {
		// Insert here the BT scan for proximal Bluetooth engines
	}

	/**
	 * 
	 */
	@Override
	public void reconcileSessionUdpConnections() {
		// Insert here the DsDns scan for registered bonjour ext point registration in Udp form
	}

	/**
	 * 
	 */
	@Override
	public void reconcileSessionTcpConnections() {
		// Insert here the DsDns scan for registered bonjour ext point registration in Tcp form
	}


	/**
	 * 
	 */
	@Override
	public void reconcileSessionUSBConnections() {
		// Lets gonna do it first w/ USB devices thanks to very simple lifecycle actually
		/*
		for (UsbConnection usb : TopologyManager.INSTANCE.getSessionManager().getUsbConnections()) {
			for (Serial serial : RXTXSerialUtil.INSTANCE.getPortMap().values()) {
				if (usb != null && usb.getSerial() != null && serial != null) {
					if (usb.getSerial().equals(serial)) { // Is it sufficient
						// already here !!! : what about real connection state (stalled, frozen ...) ????
					}
				}
			}
		}
		*/
	}
}
