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

package ubiquisense.iorx.topology.ledger;

import java.net.DatagramSocket;
import java.net.Socket;
import java.util.List;

import javax.bluetooth.RemoteDevice;

import gnu.io.SerialPort;
import ubiquisense.iorx.discovery.IBluetoothDeviceManager;
import ubiquisense.iorx.discovery.IDeviceManager;
import ubiquisense.iorx.discovery.ITcpDeviceManager;
import ubiquisense.iorx.discovery.IUSbDeviceManager;
import ubiquisense.iorx.discovery.IUdpDeviceManager;
import ubiquisense.iorx.discovery.NetBind;
import ubiquisense.iorx.protocols.midi.internal.raw.MidiDevice;
import ubiquisense.iorx.topology.ledger.impl.XCPAddressImpl;
import ubiquisense.iorx.topology.ledger.impl.XCPDeviceImpl;

public class XCPDeviceAdapterManager {
	public final static XCPDeviceAdapterManager INSTANCE = new XCPDeviceAdapterManager();

	private IDeviceManager btDeviceManager, 
							serialDeviceManager, 
							tcpDeviceManager, 
							udpDeviceManager, 
							midiDeviceManager;
	
	public XCPDeviceAdapterManager() {
		btDeviceManager =  new IBluetoothDeviceManager() {
			@Override
			public boolean removeDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectDevice(Object device) {
				return false;
			}
			
			@Override
			public boolean disconnetDevice(Object device) {
				return false;
			}
			@Override
			public boolean connectDevice(Object device) {
				return false;
			}
			@Override
			public boolean addDevice(Object device) {
				
				return false;
			}
			@Override
			public XCPDevice adapt(Object device) {
				XCPDevice cachedDevice = null;
				RemoteDevice rDevice = null;
				if (device instanceof RemoteDevice) {
					rDevice = (RemoteDevice) device;
					
					cachedDevice = new XCPDeviceImpl();

					XCPAddress addr = new XCPAddressImpl();
					addr.setName(rDevice.getBluetoothAddress());
					addr.setType(XCPAddrType.XCP_ADDR_BLUETOOTH.getName());
					
					cachedDevice.setAddr(addr);
					cachedDevice.setDevice(device);
				}
				
				return cachedDevice;
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
		};
		serialDeviceManager =  new IUSbDeviceManager() {
			@Override
			public boolean removeDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectDevice(Object device) {
				return false;
			}
			@Override
			public boolean disconnetDevice(Object device) {
				return false;
			}
			@Override
			public boolean connectDevice(Object device) {
				return false;
			}
			@Override
			public boolean addDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectUdpDevice(NetBind bind) {
				return false;
			}
			@Override
			public List<NetBind> getUdpDevices() {
				return null;
			}
			@Override
			public boolean disconnectUdpDevice(NetBind bind) {
				return false;
			}
			@Override
			public boolean connectUdpDevice(NetBind bind) {
				return false;
			}
			@Override
			public XCPDevice adapt(Object device) {
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
		};
		tcpDeviceManager = new ITcpDeviceManager() {
			@Override
			public boolean removeDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectDevice(Object device) {
				return false;
			}
			@Override
			public boolean disconnetDevice(Object device) {
				return false;
			}
			@Override
			public boolean connectDevice(Object device) {
				return false;
			}
			@Override
			public boolean addDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectTcpDevice(NetBind bind) {
				return false;
			}
			@Override
			public List<NetBind> getTcpDevices() {
				return null;
			}
			@Override
			public boolean disconnectTcpDevice(NetBind bind) {
				return false;
			}
			@Override
			public boolean connectTcpDevice(NetBind bind) {
				return false;
			}
			@Override
			public XCPDevice adapt(Object device) {
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
		};
		udpDeviceManager = new IUdpDeviceManager() {
			@Override
			public boolean removeDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectDevice(Object device) {
				return false;
			}
			@Override
			public boolean disconnetDevice(Object device) {
				return false;
			}
			@Override
			public boolean connectDevice(Object device) {
				return false;
			}
			@Override
			public boolean addDevice(Object device) {
				return false;
			}
			@Override
			public boolean reconnectUdpDevice(NetBind bind) {
				return false;
			}
			@Override
			public List<NetBind> getUdpDevices() {
				return null;
			}
			@Override
			public boolean disconnectUdpDevice(NetBind bind) {
				return false;
			}
			@Override
			public boolean connectUdpDevice(NetBind bind) {
				return false;
			}
			@Override
			public XCPDevice adapt(Object device) {
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
		};
	}
		
	public IDeviceManager getDeviceManager(Object device) {
		if (device instanceof RemoteDevice) {
			return btDeviceManager;
		} else if (device instanceof SerialPort) {
			return serialDeviceManager;
		} else if (device instanceof Socket) {
			return tcpDeviceManager;
		} else if (device instanceof DatagramSocket) {
			return udpDeviceManager;
		} else if (device instanceof MidiDevice) {
			return midiDeviceManager;
		}  
		return null;
	}
}
