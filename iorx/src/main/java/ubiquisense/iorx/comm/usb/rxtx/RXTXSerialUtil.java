package ubiquisense.iorx.comm.usb.rxtx;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.usb.io.ISerialCommunicator;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.event.impl.EventImpl;
import ubiquisense.iorx.io.Port;

public class RXTXSerialUtil implements IRXTXSerialUtils {
	
	/** Singleton */
	public static RXTXSerialUtil INSTANCE = new RXTXSerialUtil();
	
	/** Mapping for ports */ 
	private Map<String, UsbSerialTransportCommunicator>	portMap;
	private Map<String, Port>	engineMap;
	private SerialInputJob 		inputJob;

	/** Ctor */
	public RXTXSerialUtil() {
		portMap 	= new HashMap<String, UsbSerialTransportCommunicator>();
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
			UsbSerialTransportCommunicator serial = new UsbSerialTransportCommunicator(portID, speed);
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
		final UsbSerialTransportCommunicator serial = portMap.get(portID);
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
		private UsbSerialTransportCommunicator serial;
		private String portID;
		private SerialPortEvent event;
		
		public SerialInputJob() {
			super("Serial Input Job");
			execptionNb = 0l;
		}
		public void setParameters(UsbSerialTransportCommunicator serial, SerialPortEvent event, String portID) {
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
					}
					if (bytesAvailable>0) {
						final byte[] frame = new byte[bytesAvailable];
						try {
							serial.getInpustream().read(frame);
						} catch (IOException e) {
							e.printStackTrace();
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
									}
								}
							}
							
							CmdPipe pipe = p.getEngine();
							if (pipe != null) {
								try {
									pipe.receive(frame);
								} catch( Throwable t) {
									t.printStackTrace();
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
	public Map<String, UsbSerialTransportCommunicator> getPortMap() {
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
	
	public Set<String> getSerialList()
	{
		return portMap.keySet();
	}
	
	
	public void display()
	{
		
		System.out.println("cvbn,");
	}
	
	
	
	
	
	
	public  void listPorts()
    {
        Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
        while ( portEnum.hasMoreElements() ) 
        {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            System.out.println(portIdentifier.getName()  +  " - " +  getPortTypeName(portIdentifier.getPortType()) );
        }        
    }
    
    String getPortTypeName ( int portType )
    {
        switch ( portType )
        {
            case CommPortIdentifier.PORT_I2C:
                return "I2C";
            case CommPortIdentifier.PORT_PARALLEL:
                return "Parallel";
            case CommPortIdentifier.PORT_RAW:
                return "Raw";
            case CommPortIdentifier.PORT_RS485:
                return "RS485";
            case CommPortIdentifier.PORT_SERIAL:
                return "Serial";
            default:
                return "unknown type";
        }
    }
}
