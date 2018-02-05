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

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

import ubiquisense.iorx.annotations.TransportProtocol;

 
 
/**
 * Class that discovers all bluetooth devices in the neighborhood
 * and displays their name and bluetooth address.
 */
@TransportProtocol(type = "bt://")
public class BluetoothDeviceDiscovery implements DeviceDiscovery{
	
    //object used for waiting
    private static Object lock = new Object();
   
    protected final DiscoveryListener listener = new DiscoveryListener() {
        /**
         * This call back method will be called for each discovered bluetooth devices.
         */
        public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
            System.out.println("Device discovered: " + btDevice.getBluetoothAddress());
            
            TopologyManager.INSTANCE.addDevice(btDevice);
            TopologyManager.INSTANCE.connectDevice(btDevice);
            
            //add the device to the cache
        }
     
        //no need to implement this method since services are not being discovered
        public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            System.out.println("Services discovered [" + transID + "] : ");
            
            if (servRecord != null && servRecord.length>0) {
            	int size = servRecord.length;
            	for (int i = 0; i<size; i++) {
            		if (servRecord[i] != null) {
            			servRecord[i].getAttributeIDs();
            			servRecord[i].getHostDevice();
            			System.out.println("\t\t" +servRecord[i].getHostDevice().getBluetoothAddress() + " => " + servRecord[i].toString());
            		}
            	}
            }
        }
     
        //no need to implement this method since services are not being discovered
        public void serviceSearchCompleted(int transID, int respCode) {
        }
     
       
        /**
         * This callback method will be called when the device discovery is
         * completed.
         */
        public void inquiryCompleted(int discoType) {
            synchronized(lock){
                lock.notify();
            }
           
            switch (discoType) {
                case DiscoveryListener.INQUIRY_COMPLETED :
                    System.out.println("INQUIRY_COMPLETED");
                    break;
                   
                case DiscoveryListener.INQUIRY_TERMINATED :
                    System.out.println("INQUIRY_TERMINATED");
                    break;
                   
                case DiscoveryListener.INQUIRY_ERROR :
                    System.out.println("INQUIRY_ERROR");
                    break;
     
                default :
                    System.out.println("Unknown Response Code");
                    break;
            }
        }//end method
	};
    
    public BluetoothDeviceDiscovery() {
    	
	}
   
    public void discoverDevices() throws IOException {
        //display local device address and name
        LocalDevice localDevice = LocalDevice.getLocalDevice();
        System.out.println("Address: "+localDevice.getBluetoothAddress());
        System.out.println("Name: "+localDevice.getFriendlyName());
       
        //find devices
        DiscoveryAgent agent = localDevice.getDiscoveryAgent();
      
        System.out.println("Starting device inquiry...");
        agent.startInquiry(DiscoveryAgent.GIAC, listener);
       
        try {
            synchronized(lock){
                lock.wait();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        System.out.println("Device Inquiry Completed. ");
       
        //print all devices in vecDevices
//        if(TopologyManager.INSTANCE.getBTDevicesFromCache().size() <= 0){
//            System.out.println("No Devices Found .");
//        } else{
//            //print bluetooth device addresses and names in the format [ No. address (name) ]
//            System.out.println("Bluetooth Devices: ");
//            int i = 0;
//            for (RemoteDevice device : TopologyManager.INSTANCE.getBTDevicesFromCache()) {
//                System.out.println(++i + ". "+device.getBluetoothAddress()+" ("+device.getFriendlyName(true)+")");
//           }
//        }
    }//end main
    //methods of DiscoveryListener
   
}//end class

