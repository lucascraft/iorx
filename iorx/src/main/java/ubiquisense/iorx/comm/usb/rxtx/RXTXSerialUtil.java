/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2010, Lucas Bigeardel
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

package ubiquisense.iorx.comm.usb.rxtx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import ubiquisense.iorx.comm.usb.io.ISerialCommunicator;
import ubiquisense.iorx.comm.usb.io.Serial;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.EventImpl;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.pipe.CmdPipe;

public class RXTXSerialUtil implements IRXTXSerialUtils {
	
	/** Singleton */
	public static RXTXSerialUtil INSTANCE = new RXTXSerialUtil();
	
	/** Mapping for ports */ 
	private Map<String, Serial>	portMap;
	private Map<String, Port>	engineMap;
	private SerialInputJob 		inputJob;

	/** Ctor */
	public RXTXSerialUtil() {
		portMap 	= new HashMap<String, Serial>();
		engineMap 	= new HashMap<String, Port>(); 
		inputJob 	= new SerialInputJob();
//		if (!Platform.getOS().equals(Platform.OS_WIN32)) {
//			try {
//				Runtime.getRuntime().exec("sudo rm -f /var/lock/*");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	public boolean isAlreadyOpen(String portID) {
		return portMap.keySet().contains(portID);
	}
	
	@Override
	public ISerialCommunicator openPort(Port port, String portID, int speed,
			int dataBits, int stopBits, int parity) {
		return openPort(port, portID, speed, dataBits, stopBits, parity, false, true, SerialPort.FLOWCONTROL_NONE);
	}
	
	@Override
	public ISerialCommunicator openPort(Port port, final String portID, int speed,
			int dataBits, int stopBits, int parity,
			boolean notifyOnOutputEmpty, boolean notifyOnDataAvailable,
			int flowControlMode) {
		if (!engineMap.keySet().contains(portID)) {
			engineMap.put(portID, port);
		}
		if (!portMap.keySet().contains(portID)) {
			Serial serial = new Serial(portID, speed);
			if (serial != null && serial.getSerialPort() != null) {
				try {
					serial.getSerialPort().setSerialPortParams(
						speed,
						dataBits, 
						stopBits,
						parity
					);
					serial.getSerialPort().notifyOnOutputEmpty(notifyOnOutputEmpty);
					serial.getSerialPort().notifyOnDataAvailable(notifyOnDataAvailable);
					serial.getSerialPort().setFlowControlMode(flowControlMode);
				} catch (UnsupportedCommOperationException e) {
					e.printStackTrace();
				}
				portMap.put(portID, serial);
			}
		} else {
			return portMap.get(portID);
		}
		final Serial serial = portMap.get(portID);
		if (serial != null && serial.getSerialPort() != null) {
			try {
				serial.getSerialPort().addEventListener(
					new SerialPortEventListener() {
						public void serialEvent(SerialPortEvent event) {
							inputJob.setParameters(serial, event, portID);
							inputJob.start();
						}
					}
				);
			} catch (TooManyListenersException e) {
				e.printStackTrace();
			}
		}
		return serial;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.smbt.comm.utils.IRXTXSerialUtils#openPort(java.lang.String)
	 */
	public ISerialCommunicator openPort(final ubiquisense.iorx.io.Port port, final String portID, int speed) {
		return openPort(port, portID, speed, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE, false, true, SerialPort.FLOWCONTROL_NONE);
	}
	
	public ISerialCommunicator openPort(final Port port, final String portID, int speed, Map<Object, Object> options) {
		int dataBit 					= SerialPort.DATABITS_8;
		int stopBit 					= SerialPort.STOPBITS_1;
		int parity						= SerialPort.PARITY_NONE;
		boolean notifyOnOutput 			= false;
		boolean notifyOnDataAvailable	= true;
		int flowControl					= SerialPort.FLOWCONTROL_NONE;
		
		if (options != null) {
			if (options.containsKey("data")) {
				Object dBit = options.get("data");
				if (dBit instanceof Integer) {
					dataBit = ((Integer)dBit).intValue(); 
				}
			}
			if (options.containsKey("stop")) {
				Object sBit = options.get("stop");
				if (sBit instanceof Integer) {
					stopBit = ((Integer)sBit).intValue(); 
				}
			}
			if (options.containsKey("parity")) {
				Object pBit = options.get("parity");
				if (pBit instanceof Integer) {
					parity = ((Integer)pBit).intValue(); 
				}
			}
			if (options.containsKey("flow")) {
				Object fBit = options.get("flow");
				if (fBit instanceof Integer) {
					flowControl = ((Integer)fBit).intValue(); 
				}
			}
			if (options.containsKey("notifyOnOutput")) {
				Object nooBit = options.get("notifyOnOutput");
				if (nooBit instanceof Boolean) {
					notifyOnOutput = ((Boolean)nooBit).booleanValue(); 
				}
			}
			if (options.containsKey("notifyOnDataAvailable")) {
				Object nodaBit = options.get("notifyOnDataAvailable");
				if (nodaBit instanceof Boolean) {
					notifyOnDataAvailable = ((Boolean)nodaBit).booleanValue(); 
				}
			}
		}
		
		return openPort(port, portID, speed, dataBit, stopBit, parity, notifyOnOutput, notifyOnDataAvailable, flowControl);
	}
	
	
	final class SerialInputJob extends Thread {
		public long execptionNb;
		private Serial serial;
		private String portID;
		private SerialPortEvent event;
		
		public SerialInputJob() {
			super("Serial Input Job");
			execptionNb = 0l;
		}
		public void setParameters(Serial serial, SerialPortEvent event, String portID) {
			this.serial = serial;
			this.event = event;
			this.portID = portID;
		}
		@Override
		public void run() {
			switch (event.getEventType()) {
				case SerialPortEvent.DATA_AVAILABLE:
				{
					int bytesAvailable = 0;
					try {
						if (serial!=null && serial.getInpustream() != null) {
							bytesAvailable = serial.getInpustream().available();
						}
					} catch (IOException e) {
						e.printStackTrace();
//						execptionNb++;
//						if (execptionNb>=25) {
//							engineMap.get(portID).stopInput();
//							cancel();
//						}
					}
					if (bytesAvailable>0) {
						final byte[] frame = new byte[bytesAvailable];
						try {
							serial.getInpustream().read(frame);
						} catch (IOException e) {
							e.printStackTrace();
	//						execptionNb++;
	//						if (execptionNb>=25) {
	//							engineMap.get(portID).stopInput();
	//							cancel();
	//						}
						}
		
						if (engineMap.get(portID) != null) {
							Port p = engineMap.get(portID);
							if (p.getChannel() != null) {
								p.getChannel().setLastFrame(frame);
								for (IQxEventHandler h : p.getChannel().getEventListeners()) {
									try {
										Event e = new EventImpl();
										e.setKind(EVENT_KIND.RX_FRAME);
										e.setBytes(frame);
										h.handleQxEvent(e);
									} catch( Throwable t) {
										t.printStackTrace();
	//									execptionNb++;
	//									if (execptionNb>=25) {
	//										p.stopInput();
	//										cancel();
	//									}
									}
								}
							}
							
							CmdPipe pipe = p.getEngine();
							if (pipe != null) {
								try {
									pipe.receive(frame);
								} catch( Throwable t) {
									t.printStackTrace();
	//								pipe.deactivateAll();
	//								execptionNb++;
	//								if (execptionNb>=25) {
	//									p.stopInput();
	//									cancel();
	//								}
								}
							}
						}
					}
					break;
				}
			}
		}
	}
	
	/**
	 *  Getter for Serial ports as a {@link Map}
	 *  
	 * @return serial port map
	 */
	public Map<String, Serial> getPortMap() {
		return portMap;
	}

	@Override
	public void closePort(String portID) {
		if (portMap.containsKey(portID)) {
			portMap.remove(portID);
		}
//		if (!Platform.getOS().equals(Platform.OS_WIN32)) {
//			try {
//				Runtime.getRuntime().exec("sudo rm -f /var/lock/*");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
