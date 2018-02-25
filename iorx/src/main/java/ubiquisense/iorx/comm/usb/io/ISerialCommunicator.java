

package ubiquisense.iorx.comm.usb.io;

import gnu.io.SerialPort;
import ubiquisense.iorx.io.TransportChannel;


public interface ISerialCommunicator extends ISerialReader, ISerialWriter, ISerialParams, TransportChannel {
	void stop();
	void setDTR(boolean state);
	void buffer(int count);
	void bufferUntil(int what);
	int available();
	void clear();
	SerialPort getSerialPort();
}
