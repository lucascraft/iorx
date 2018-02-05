/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2010, Lucas Bigeardel
 * 
 * The library is released under:
 * 
 * A) LGPL
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA 02110-1301 USA
 * 
 * B) EPL
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Lucas Bigeardel <lucas.bigeardel@gmail.com> - Initial API and implementation
 ***********************************************************************************/

package ubiquisense.iorx.discovery;

import java.net.DatagramSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.rapplogic.xbee.api.XBee;

import gnu.io.CommPort;
import ubiquisense.iorx.discovery.visitors.ITopologyVisitor;
import ubiquisense.iorx.topology.core.AbstractTopologyItem;
import ubiquisense.iorx.topology.core.TopologyGroup;
import ubiquisense.iorx.topology.core.TopologyNode;
import ubiquisense.iorx.topology.ledger.XCPDevice;
import ubiquisense.iorx.topology.ledger.XCPDeviceAdapterManager;

public class TopologyManager implements IDeviceManager {
	public final static TopologyManager INSTANCE = new TopologyManager();
	
	//private TopologyCache cache;
	private ContinuousDiscoveryAgent discoAgent;
	
	public TopologyManager() {
		this(true);
	}
	
	public TopologyManager(boolean startDiscovery) {
		discoAgent = new ContinuousDiscoveryAgent();
	}
	
	public void startContinuousDiscovery() {
		//discoAgent.schedule();
	}
	public void stopContinuousDiscovery() {
		discoAgent.interrupt();
	}
	
	
	/**
	 * Populates {@link ModelSearchScope} with potential resource participants for the 
	 * given resource.
	 */
	@SuppressWarnings("unused")
	private void walk(List<AbstractTopologyItem> nodes, ITopologyVisitor<AbstractTopologyItem> visitor) {
		for (AbstractTopologyItem node : nodes) {
			accept(node, visitor);
		}
	}
	
	private void accept(AbstractTopologyItem node, ITopologyVisitor<AbstractTopologyItem> visitor) {
		if (node instanceof TopologyGroup) {
			for (AbstractTopologyItem n : ((TopologyGroup)node).getChildren()) {
				accept(n, visitor);
			}
		} else if (node instanceof TopologyNode) {
			visitor.visit(node);
		}
	}

	//
	// Bluetooth btsp (L2CAP/RFCOMM to explore)
	//

	/*
	public List<RemoteDevice> getBTDevicesFromCache() {
		List<RemoteDevice> devices = new ArrayList<RemoteDevice>();
		 if (cache != null) {
			BluetoothTopologyVisitor<AbstractTopologyItem> visitor = new BluetoothTopologyVisitor<AbstractTopologyItem>(null, true);
			walk(cache.getNodes(), visitor);
			for (AbstractTopologyItem node : visitor.getNodes()) {
				if (node instanceof TopologyNode) {
					if (((TopologyNode) node).getDevice().getDevice() instanceof RemoteDevice) {
						devices.add((RemoteDevice)((TopologyNode) node).getDevice().getDevice());
					}
				}
			}
		}
		return devices; 
	}
	 */

	//
	// XBee ZigBee 802.15.4
	//
	public List<XBee> getXBeeDevicesFromCache() {
		List<XBee> devices = new ArrayList<XBee>();
		/*
		XBeeTopologyVisitor<AbstractTopologyItem> visitor = new XBeeTopologyVisitor<AbstractTopologyItem>(null, true);
		walk(cache.getNodes(), visitor);
		for (AbstractTopologyItem node : visitor.getNodes()) {
			if (node instanceof TopologyNode) {
				if (((TopologyNode) node).getDevice().getDevice() instanceof RemoteDevice) {
					devices.add((XBee)((TopologyNode) node).getDevice().getDevice());
				}
			}
		}
		*/
		return devices; 
	}

	//
	// Serial  (RS232 for now)
	//
	public List<CommPort> getUSBDevicesFromCache() {
		List<CommPort> devices = new ArrayList<CommPort>();
		/*
		UsbTopologyVisitor<AbstractTopologyItem> visitor = new UsbTopologyVisitor<AbstractTopologyItem>(null, true);
		walk(cache.getNodes(), visitor);
		for (AbstractTopologyItem node : visitor.getNodes()) {
			if (node instanceof TopologyNode) {
				if (((TopologyNode) node).getDevice().getDevice() instanceof RemoteDevice) {
					devices.add((CommPort)((TopologyNode) node).getDevice().getDevice());
				}
			}
		}
		*/
		return devices; 
	}
	
	//
	// UDP DS-DNS (coming from device connection trough DsDns service registered service ... lets dig ...)
	//
	public List<DatagramSocket> getDsDnsUdpDevicesFromCache() {
		List<DatagramSocket> devices = new ArrayList<DatagramSocket>();
		/*
		UdpTopologyVisitor<AbstractTopologyItem> visitor = new UdpTopologyVisitor<AbstractTopologyItem>(null, true);
		walk(cache.getNodes(), visitor);
		for (AbstractTopologyItem node : visitor.getNodes()) {
			if (node instanceof TopologyNode) {
				if (((TopologyNode) node).getDevice().getDevice() instanceof RemoteDevice) {
					devices.add((DatagramSocket)((TopologyNode) node).getDevice().getDevice());
				}
			}
		}
		*/
		return devices; 
	}
	
	//
	// TCP DS-DNS (coming from device connection trough DsDns service registered service ... lets dig ...)
	//
	public List<Socket> getDsDnsTcpDevicesFromCache() {
		List<Socket> devices = new ArrayList<Socket>();
		/*
		UsbTopologyVisitor<AbstractTopologyItem> visitor = new UsbTopologyVisitor<AbstractTopologyItem>(null, true);
		walk(cache.getNodes(), visitor);
		for (AbstractTopologyItem node : visitor.getNodes()) {
			if (node instanceof TopologyNode) {
				if (((TopologyNode) node).getDevice().getDevice() instanceof RemoteDevice) {
					devices.add((Socket)((TopologyNode) node).getDevice().getDevice());
				}
			}
		}
		*/
		return devices; 
	}
	
	//
	// General cache mechanism
	//
	
	//
	// Delegate connection lifecycle to an adapter compliant w/ IDeviceManager
	//
	@Override
	public boolean addDevice(Object device) {
		Object obj = XCPDeviceAdapterManager.INSTANCE.getDeviceManager(device);
		if (obj instanceof IDeviceManager) {
			return ((IDeviceManager)obj).addDevice(device);
		}
		return false;
	}

	@Override
	public boolean removeDevice(Object device) {
		Object obj = XCPDeviceAdapterManager.INSTANCE.getDeviceManager(device);
		if (obj instanceof IDeviceManager) {
			return ((IDeviceManager)obj).removeDevice(device);
		}
		return false;
	}
	
	@Override
	public boolean connectDevice(Object device) {
		Object obj = XCPDeviceAdapterManager.INSTANCE.getDeviceManager(device);
		if (obj instanceof IDeviceManager) {
			return ((IDeviceManager)obj).connectDevice(device);
		}
		return false;
	}
	
	@Override
	public boolean disconnetDevice(Object device) {
		Object obj = XCPDeviceAdapterManager.INSTANCE.getDeviceManager(device);
		if (obj instanceof IDeviceManager) {
			return ((IDeviceManager)obj).disconnetDevice(device);
		}
		return false;
	}

	@Override
	public boolean reconnectDevice(Object device) {
		Object obj = XCPDeviceAdapterManager.INSTANCE.getDeviceManager(device);
		if (obj instanceof IDeviceManager) {
			return ((IDeviceManager)obj).reconnectDevice(device);
		}
		return false;
	}

	//
	// Adapt a device
	//
	
	@Override
	public XCPDevice adapt(Object device) {
		Object obj = XCPDeviceAdapterManager.INSTANCE.getDeviceManager(device);
		if (obj instanceof IDeviceManager) {
			return ((IDeviceManager)obj).adapt(device);
		}
		return null;
	}

	@Override
	public boolean addService(Object service) {
		return false;
	}

	@Override
	public boolean removeService(Object service) {
		return false;
	}

	@Override
	public boolean resolveService(Object service) {
		return false;
	}
}
