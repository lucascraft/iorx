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


/**
 * Describe contract API for continuous discovery agent such as feed topology session manager for active connections
 * USB, UDP, Bluetooth, XBee
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
	
	//
	// XBee global reconciliation, eg: not a the node level but at a pool level
	//
	void reconcileSessionXBeeConnections();
}
