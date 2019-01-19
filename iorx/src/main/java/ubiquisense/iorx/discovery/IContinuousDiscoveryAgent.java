
package ubiquisense.iorx.discovery;


/**
 * Describe contract API for continuous discovery agent such as feed topology session manager for active connections
 * USB, UDP, Bluetooth
 * 
 * Reconcilliation to be added in near future to be able to properly handle the 
 * fluctuant nature of mobile devices connections to UBQT framework
 * 
 * @author lucas
 *
 */
public interface IContinuousDiscoveryAgent {
	//
	//
	//
	// Discovery stuff (direct scan)
	//
	//
	//
	
	//
	// Mainly scanning proximal Bluetooth devices
	//
	void handleBTStuff();
	
	//
	// Purpose : DN-DNS zeroconf feast
	//
	void handleTcpStuff();
	
	//
	// Purpose : DN-DNS zeroconf feast
	//
	void handleUdpStuff();
	
	//
	// Serial discovery thanks to RxTx native binding : listPortrs() ...
	//
	void handleUsbStuff();
	
	//
	//
	//
	// Check and fix new/lagging/deco stuff
	//
	//
	//
	
	//
	// BT global reconciliation, eg: not a the node level but at a pool level
	//
	void reconcileSessionBTConnections();
	
	//
	// Tcp global reconciliation, eg: not a the node level but at a pool level
	//
	void reconcileSessionTcpConnections();
	
	//
	// Udp global reconciliation, eg: not a the node level but at a pool level
	//
	void reconcileSessionUdpConnections();
	
	//
	// Usb global reconciliation, eg: not a the node level but at a pool level
	//
	void reconcileSessionUSBConnections();
	
}
