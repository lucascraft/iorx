

package ubiquisense.iorx.discovery;

import javax.jmdns.ServiceInfo;

import ubiquisense.iorx.registry.DnsSdRegistry;
import ubiquisense.iorx.topology.core.AbstractTopologyItem;
import ubiquisense.iorx.topology.core.TopologyCache;
import ubiquisense.iorx.topology.core.TopologyNode;
import ubiquisense.iorx.topology.core.impl.TopologyNodeImpl;
import ubiquisense.iorx.topology.ledger.XCPDevice;

public class Supervisor extends Thread implements IXCPDeviceLifecycleListener {
	private TopologyCache cache;
	public Supervisor(TopologyCache cache) {
		super("Ubiquisense_Supervisor"); 
		this.cache = cache;
	}
	@Override
	public void run() {
		checkToplogy();
		try {
			sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // every 9 sec	
	}
	
	@Override
	public void onDeviceAdd(XCPDevice device, long time) {
		System.out.println(device.toString() + " added.");
		boolean absent = true;
		for (AbstractTopologyItem node : cache.getNodes()) {
			if (node instanceof TopologyNode) {
				XCPDevice nodeDevice = ((TopologyNode)node).getDevice();
				if (nodeDevice instanceof XCPDevice) {
					if (nodeDevice.getAddr().equals(device.getAddr())) {
						absent = false;
					} else {
						// Exists or conflict !!!
					}
				}
			}
		}
		
		if (absent) {
			TopologyNode node = new TopologyNodeImpl();
			node.setDevice(device);
			cache.getNodes().add(node);
		} else {
			// check + update + reconcilliation if needed ?
		}
	}
	
	@Override
	public void onDeviceRemove(XCPDevice device, long time) {
		System.out.println(device.toString() + " removed.");
	}
	
	@Override
	public void onDeviceUpdate(XCPDevice device, long time) {
		System.out.println(device.toString() + " updated.");
	}
	
	/**
	 * this class has responsability to check Device/configuration status and to
	 * behave accordingly to its supervision role.
	 * 
	 * It can disable/enable/renew/remove/suspend/create connections
	 * 
	 * It can trigger a reconciliation or other scan if necessary on a device 
	 * or a group of devices.
	 */
	void checkToplogy() {
		for (ServiceInfo info : DnsSdRegistry.INSTANCE.getDnsSdRegistry().list("_ezmojo._udp.local.")) {
			if (info instanceof ServiceInfo) {
				DnsSdRegistry.INSTANCE.checkForDistantPipes(info);
			}
		}
	}
}
