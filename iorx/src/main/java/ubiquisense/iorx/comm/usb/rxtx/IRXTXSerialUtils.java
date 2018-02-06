
package ubiquisense.iorx.comm.usb.rxtx;

import ubiquisense.iorx.comm.usb.io.ISerialCommunicator;
import ubiquisense.iorx.io.Port;

public interface IRXTXSerialUtils {

	public abstract ISerialCommunicator openPort(Port port, String portID, int speed);
	
	public abstract ISerialCommunicator openPort(Port port, String portID, int speed, int dataBits, int stopBits, int parity);
	
	public abstract ISerialCommunicator openPort(Port port, String portID, int speed, int dataBits, int stopBits, int parity, boolean notifyOnOutputEmpty, boolean notifyOnDataAvailable, int flowControlMode);
	
	public abstract void closePort(String portID);
	
	public boolean isAlreadyOpen(String portID);
	
}