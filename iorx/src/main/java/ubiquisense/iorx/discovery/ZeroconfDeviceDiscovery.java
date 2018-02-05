/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2010 - 2012, Lucas Bigeardel
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


public class ZeroconfDeviceDiscovery implements DeviceDiscovery{
	//
	// UDP/TCP service discovery
	//
	/*
	private DnDnsDiscovery udpServicesDiscoveryThread;

	public class DnDnsDiscovery extends Thread {
		private JmDNS jmdns;
		public JmDNS getJmdns() {
			return jmdns;
		}

		private String mdns_type;
		private ArrayList<ServiceInfo> services;
		private Boolean running;
		private long refreshInterval;
		private List<ServiceListener> serviceListeners;
		
		//
		// Add service listener
		//
		public void addServiceListener(ServiceListener serviceListener) {
			serviceListeners.add(serviceListener);
		}
		
		//
		// Remove service listener
		//
		public void removeServiceListener(ServiceListener serviceListener) {
			serviceListeners.add(serviceListener);
		}
		
		public void run() {
		    while (running) {
		        ServiceInfo[] infos = jmdns.list(mdns_type);
		        if (infos != null && infos.length > 0) {
		            ArrayList<ServiceInfo> temp = new ArrayList<ServiceInfo>();
		            for (int i = 0; i < infos.length; i++) { temp.add(infos[i]);}
		            services = temp;
		            try {Thread.sleep(refreshInterval);} catch (InterruptedException e) {break;}
		        }
		    }
		}
		
		//
		// Start refreshing service
		//
		public void startRefreshingServices() { if (!running){running=true;this.start();}}
		
		//
		// Stop refreshing service
		//
		public void stopRefreshingServices() { running = false; }
		
		public ArrayList<ServiceInfo> getServices(){return services;}
		
		public DnDnsDiscovery(String mdns_type) {
		    refreshInterval = 5000;
		    running = Boolean.FALSE;
		    //long start = System.currentTimeMillis();
		    try {jmdns = JmDNS.create();} catch (Exception e) {e.printStackTrace();}
		    this.mdns_type = mdns_type;
		    services = new ArrayList<ServiceInfo>();
		    serviceListeners = new ArrayList<ServiceListener>();
		}
		
		public void waitForReady() {
		    boolean notReady = true;
		    while (notReady) {
		        if (services.size() > 0) {notReady = false;}
		        try {Thread.sleep(500);}catch(InterruptedException e) {break;}
		    }
		}
		
		public void close() {
		    stopRefreshingServices();
		    jmdns.unregisterAllServices();
		   // try {
				jmdns.close();
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}
		}
	}
	
	public JmDNS getJmDNS() {
		return udpServicesDiscoveryThread.getJmdns();
	}

	public ZeroconfDeviceDiscovery() {
//		tcpServicesDiscoveryThread = new DnDnsDiscovery(TopologyUtils.DS_DNS_UBQT_TCP_LOCAL_DNS_SERVICE_NAME);
//		tcpServicesDiscoveryThread.addServiceListener(new ServiceListener() {
//			@Override
//			public void serviceResolved(ServiceEvent service) {
//				TopologyManager.INSTANCE.resolveService(service.getInfo());
//			}
//			@Override
//			public void serviceRemoved(ServiceEvent service) {
//				TopologyManager.INSTANCE.removeService(service.getInfo());
//			}
//			@Override
//			public void serviceAdded(ServiceEvent service) {
//				TopologyManager.INSTANCE.addService(service.getInfo());
//			}
//		});
//		
		udpServicesDiscoveryThread = new DnDnsDiscovery(TopologyUtils.DS_DNS_EZMOJO_UDP_LOCAL_DNS_SERVICE_NAME);
//
//		udpServicesDiscoveryThread.addServiceListener(new ServiceListener() {
//			@Override
//			public void serviceResolved(ServiceEvent service) {
//				TopologyManager.INSTANCE.resolveService(service.getInfo());
//			}
//			@Override
//			public void serviceRemoved(ServiceEvent service) {
//				TopologyManager.INSTANCE.removeService(service.getInfo());
//			}
//			@Override
//			public void serviceAdded(ServiceEvent service) {
//				TopologyManager.INSTANCE.addService(service.getInfo());
//			}
//		});
	}
	
	public void discoverUdpZeroconfDevices() {
		//udpServicesDiscoveryThread.startRefreshingServices();
	}

	public void discoverTcpZeroconfDevices() {
		//tcpServicesDiscoveryThread.startRefreshingServices();
	}
	 */		
}
