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

import java.io.IOException;

public class ContinuousDiscoveryAgent extends Thread implements IContinuousDiscoveryAgent {
	private BluetoothDeviceDiscovery btDeviceDiscovery;
	private USbDeviceDiscovery usbDeviceDiscovery;
	private ZeroconfDeviceDiscovery zeroconfDeviceDiscovery;
	private XBeeDeviceDiscovery xbeeDeviceDiscovery;

	public ContinuousDiscoveryAgent() {
		super("Tansversal Discovery Topology Agent");
		btDeviceDiscovery		= new BluetoothDeviceDiscovery();
		usbDeviceDiscovery		= new USbDeviceDiscovery();
		//zeroconfDeviceDiscovery = new ZeroconfDeviceDiscovery();
		xbeeDeviceDiscovery		= new XBeeDeviceDiscovery();
	}
	
	
/*	public JmDNS getJmDNS() {
		return zeroconfDeviceDiscovery.getJmDNS();
	}
*/	
	@Override
	public void run() {
		do
		{
			handleBTStuff();
			//handleHttpStuff(); /..... hmm, think to that later ...
			//handleUdpStuff();
			//handleTcpStuff();
			//handleUsbStuff();
			//handleXBeeStuff();
			
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
		reconcileSessionTcpConnections();
	}

	/**
	 * 
	 */
	public void handleUdpStuff() {
		//zeroconfDeviceDiscovery.discoverUdpZeroconfDevices();
		reconcileSessionUdpConnections();
	}

	/**
	 * 
	 */
	public void handleUsbStuff() {
		usbDeviceDiscovery.usbPortsScan();
		reconcileSessionUSBConnections();
	}
	
	public void handleXBeeStuff() {
		xbeeDeviceDiscovery.scanZigBeeNet();
		reconcileSessionXBeeConnections();
		
		 System.out.println("XBee topology scanning not implemented yet ...");
		
		//
		// XBee stuff coming soon after Hayes AT commands 
		//
		// throw new UnsupportedOperationException("Not implemented yet !!!");
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
	public void reconcileSessionXBeeConnections() {
		// Insert here the XBee devices scan for registered bonjour ext point registration in XBee form
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
