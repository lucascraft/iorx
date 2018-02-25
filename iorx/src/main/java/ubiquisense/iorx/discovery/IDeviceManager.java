
package ubiquisense.iorx.discovery;


public interface IDeviceManager {
	//
	// XCP Device adapter
	//
	ubiquisense.iorx.topology.ledger.XCPDevice adapt(Object device);

	//
	// Device stuff
	//
	boolean addDevice(Object device);
	boolean removeDevice(Object device);
	boolean connectDevice(Object device);
	boolean disconnetDevice(Object device);
	boolean reconnectDevice(Object device);
	
	//
	// Service stuff
	//
	boolean addService(Object service);
	boolean removeService(Object service);
	boolean resolveService(Object service);
}
