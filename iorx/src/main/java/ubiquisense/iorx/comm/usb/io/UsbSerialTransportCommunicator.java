
package ubiquisense.iorx.comm.usb.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;

import javax.inject.Named;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.io.impl.TransportChannelImpl;

@TransportProtocol(type = "usb://")
@Named("usb://")
public class UsbSerialTransportCommunicator extends TransportChannelImpl implements ISerialCommunicator, SerialPortEventListener {

	//
	// properties can be passed in for default values
	// otherwise defaults to 9600 N-8-1
	//
	//
	// these could be made static, which might be a solution
	// for the class loading problem.. because if code ran again,
	// the static class would have an object that could be closed
	//
	public SerialPort port;

	//
	//
	//
	public int rate;
	
	//
	//
	//
	public int parity;
	
	//
	//
	//
	public int databits;
	
	//
	//
	//
	public int stopbits;

	// read buffer and streams

	//
	//
	//
	protected InputStream input;

	//
	//
	//
	protected OutputStream output;

	//
	//
	//
	protected byte buffer[] = new byte[56700];
	
	//
	//
	//
	protected int bufferIndex;
	
	//
	//
	//
	protected int bufferLast;

	// boolean bufferUntil = false;
	protected int bufferSize = 1; // how big before reset or event firing
	protected boolean bufferUntil;
	protected int bufferUntilByte;

	// defaults

	static String dname 	= "COM1";
	static int drate 		= 9600;
	static char dparity 	= 'N';
	static int ddatabits 	= 8;
	static float dstopbits 	= 1;

	public UsbSerialTransportCommunicator() {
		this(dname, drate, dparity, ddatabits, dstopbits);
	}

	public UsbSerialTransportCommunicator(int irate) {
		this(dname, irate, dparity, ddatabits, dstopbits);
	}

	public UsbSerialTransportCommunicator(String iname, int irate) {
		this(iname, irate, dparity, ddatabits, dstopbits);
	}

	public UsbSerialTransportCommunicator(String iname) {
		this(iname, drate, dparity, ddatabits, dstopbits);
	}

	public UsbSerialTransportCommunicator(String iname, int irate, char iparity, int idatabits,
			float istopbits) {
		// if (port != null) port.close();
		// parent.attach(this);

		this.rate = irate;

		parity = SerialPort.PARITY_NONE;
		if (iparity == 'E')
			parity = SerialPort.PARITY_EVEN;
		if (iparity == 'O')
			parity = SerialPort.PARITY_ODD;

		this.databits = idatabits;

		stopbits = SerialPort.STOPBITS_1;
		if (istopbits == 1.5f)
			stopbits = SerialPort.STOPBITS_1_5;
		if (istopbits == 2)
			stopbits = SerialPort.STOPBITS_2;

		try {
			Enumeration<?> portList = CommPortIdentifier.getPortIdentifiers();
			while (portList.hasMoreElements()) {
				CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
					if (portId.getName().equals(iname)) {
						port = (SerialPort) portId.open("serial madness", 2000);
						input = port.getInputStream();
						output = port.getOutputStream();
						port.setSerialPortParams(rate, databits, stopbits, parity);
						port.notifyOnDataAvailable(true);
					}
				}
			}

		} catch (Exception e) {
			errorMessage("<init>", e);
			e.printStackTrace();
			port = null;
			input = null;
			output = null;
		}
	}

	/**
	 * Stop talking to serial and shut things down.
	 * <P>
	 * Basically just a user-accessible version of dispose(). For now, it just
	 * calls dispose(), but dispose shouldn't be called from applets, because in
	 * some libraries, dispose() blows shit up if it's called by a user who
	 * doesn't know what they're doing.
	 */
	public void stop() {
		dispose();
	}

	/**
	 * Used by PApplet to shut things down.
	 */
	private void dispose() {
		try {
			// do io streams need to be closed first?
			if (input != null)
				input.close();
			if (output != null)
				output.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		input = null;
		output = null;

		try {
			if (port != null)
				port.close(); // close the port

		} catch (Exception e) {
			e.printStackTrace();
		}
		port = null;
	}

	/**
	 * Set the DTR line. Addition from Tom Hulbert.
	 */
	public void setDTR(boolean state) {
		port.setDTR(state);
	}

	synchronized public void serialEvent(SerialPortEvent serialEvent) {
		if (serialEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				while (input.available() > 0) {
					synchronized (buffer) {
						if (bufferLast == buffer.length) {
							byte temp[] = new byte[bufferLast << 1];
							System.arraycopy(buffer, 0, temp, 0, bufferLast);
							buffer = temp;
						}
						buffer[bufferLast++] = (byte) input.read();
					}
				}

			} catch (IOException e) {
				errorMessage("serialEvent", e);
			}
		}
	}

	/**
	 * Set number of bytes to buffer before calling serialEvent() in the host
	 * applet.
	 */
	public void buffer(int count) {
		bufferUntil = false;
		bufferSize = count;
	}

	/**
	 * Set a specific byte to buffer until before calling serialEvent() in the
	 * host applet.
	 */
	public void bufferUntil(int what) {
		bufferUntil = true;
		bufferUntilByte = what;
	}

	/**
	 * Returns the number of bytes that have been read from serial and are
	 * waiting to be dealt with by the user.
	 */
	public int available() {
		return (bufferLast - bufferIndex);
	}

	/**
	 * Ignore all the bytes read so far and empty the buffer.
	 */
	public void clear() {
		bufferLast = 0;
		bufferIndex = 0;
	}

	/**
	 * Returns a number between 0 and 255 for the next byte that's waiting in
	 * the buffer. Returns -1 if there was no byte (although the user should
	 * first check available() to see if things are ready to avoid this)
	 */
	public int read() {
		if (bufferIndex == bufferLast)
			return -1;

		synchronized (buffer) {
			int outgoing = buffer[bufferIndex++] & 0xff;
			if (bufferIndex == bufferLast) { // rewind
				bufferIndex = 0;
				bufferLast = 0;
			}
			return outgoing;
		}
	}

	/**
	 * Same as read() but returns the very last value received and clears the
	 * buffer. Useful when you just want the most recent value sent over the
	 * port.
	 */
	public int last() {
		if (bufferIndex == bufferLast)
			return -1;
		synchronized (buffer) {
			int outgoing = buffer[bufferLast - 1];
			bufferIndex = 0;
			bufferLast = 0;
			return outgoing;
		}
	}

	/**
	 * Returns the next byte in the buffer as a char. Returns -1, or 0xffff, if
	 * nothing is there.
	 */
	public char readChar() {
		if (bufferIndex == bufferLast)
			return (char) (-1);
		return (char) read();
	}

	/**
	 * Just like last() and readChar().
	 */
	public char lastChar() {
		if (bufferIndex == bufferLast)
			return (char) (-1);
		return (char) last();
	}

	/**
	 * Return a byte array of anything that's in the serial buffer. Not
	 * particularly memory/speed efficient, because it creates a byte array on
	 * each read, but it's easier to use than readBytes(byte b[]) (see below).
	 */
	public byte[] readBytes() {
		if (bufferIndex == bufferLast)
			return null;

		synchronized (buffer) {
			int length = bufferLast - bufferIndex;
			byte outgoing[] = new byte[length];
			System.arraycopy(buffer, bufferIndex, outgoing, 0, length);

			bufferIndex = 0; // rewind
			bufferLast = 0;
			return outgoing;
		}
	}

	/**
	 * Grab whatever is in the serial buffer, and stuff it into a byte buffer
	 * passed in by the user. This is more memory/time efficient than
	 * readBytes() returning a byte[] array.
	 * 
	 * Returns an int for how many bytes were read. If more bytes are available
	 * than can fit into the byte array, only those that will fit are read.
	 */
	public int readBytes(byte outgoing[]) {
		if (bufferIndex == bufferLast)
			return 0;

		synchronized (buffer) {
			if (buffer != null && buffer.length>0) {
				int length = bufferLast - bufferIndex;
				if (length > outgoing.length)
					length = outgoing.length;
				System.arraycopy(buffer, bufferIndex, outgoing, 0, length);
	
				bufferIndex += length;
				if (bufferIndex == bufferLast) {
					bufferIndex = 0; // rewind
					bufferLast = 0;
				}
				return length;
			}
			return 0;
		}
	}

	/**
	 * Reads from the serial port into a buffer of bytes up to and including a
	 * particular character. If the character isn't in the serial buffer, then
	 * 'null' is returned.
	 */
	public byte[] readBytesUntil(int interesting) {
		if (bufferIndex == bufferLast)
			return null;
		byte what = (byte) interesting;

		synchronized (buffer) {
			int found = -1;
			for (int k = bufferIndex; k < bufferLast; k++) {
				if (buffer[k] == what) {
					found = k;
					break;
				}
			}
			if (found == -1)
				return null;

			int length = found - bufferIndex + 1;
			byte outgoing[] = new byte[length];
			System.arraycopy(buffer, bufferIndex, outgoing, 0, length);

			bufferIndex = 0; // rewind
			bufferLast = 0;
			return outgoing;
		}
	}

	/**
	 * Reads from the serial port into a buffer of bytes until a particular
	 * character. If the character isn't in the serial buffer, then 'null' is
	 * returned.
	 * 
	 * If outgoing[] is not big enough, then -1 is returned, and an error
	 * message is printed on the console. If nothing is in the buffer, zero is
	 * returned. If 'interesting' byte is not in the buffer, then 0 is returned.
	 */
	public int readBytesUntil(int interesting, byte outgoing[]) {
		if (bufferIndex == bufferLast)
			return 0;
		byte what = (byte) interesting;

		synchronized (buffer) {
			int found = -1;
			for (int k = bufferIndex; k < bufferLast; k++) {
				if (buffer[k] == what) {
					found = k;
					break;
				}
			}
			if (found == -1)
				return 0;

			int length = found - bufferIndex + 1;
			if (length > outgoing.length) {
				System.err.println("readBytesUntil() byte buffer is"
						+ " too small for the " + length
						+ " bytes up to and including char " + interesting);
				return -1;
			}
			// byte outgoing[] = new byte[length];
			System.arraycopy(buffer, bufferIndex, outgoing, 0, length);

			bufferIndex += length;
			if (bufferIndex == bufferLast) {
				bufferIndex = 0; // rewind
				bufferLast = 0;
			}
			return length;
		}
	}

	/**
	 * Return whatever has been read from the serial port so far as a String. It
	 * assumes that the incoming characters are ASCII.
	 * 
	 * If you want to move Unicode data, you can first convert the String to a
	 * byte stream in the representation of your choice (i.e. UTF8 or two-byte
	 * Unicode data), and send it as a byte array.
	 */
	public String readString() {
		if (bufferIndex == bufferLast)
			return null;
		return new String(readBytes());
	}

	/**
	 * Combination of readBytesUntil and readString. See caveats in each
	 * function. Returns null if it still hasn't found what you're looking for.
	 * 
	 * If you want to move Unicode data, you can first convert the String to a
	 * byte stream in the representation of your choice (i.e. UTF8 or two-byte
	 * Unicode data), and send it as a byte array.
	 */
	public String readStringUntil(int interesting) {
		byte b[] = readBytesUntil(interesting);
		if (b == null)
			return null;
		return new String(b);
	}

	/**
	 * This will handle both ints, bytes and chars transparently.
	 */
	public void write(int what) { // will also cover char
		try {
			output.write(what & 0xff); // for good measure do the &
			output.flush(); // hmm, not sure if a good idea
		} catch (Exception e) { // null pointer or serial port dead
			errorMessage("write", e);
		}
	}

	public void write(byte bytes[]) {
		try {
			if (output instanceof OutputStream) {
				output.write(bytes);
				//output.flush(); // hmm, not sure if a good idea
			}
		} catch (Exception e) { // null pointer or serial port dead
			e.printStackTrace();
		}
	}

	/**
	 * Write a String to the output. Note that this doesn't account for Unicode
	 * (two bytes per char), nor will it send UTF8 characters.. It assumes that
	 * you mean to send a byte buffer (most often the case for networking and
	 * serial i/o) and will only use the bottom 8 bits of each char in the
	 * string. (Meaning that internally it uses String.getBytes)
	 * 
	 * If you want to move Unicode data, you can first convert the String to a
	 * byte stream in the representation of your choice (i.e. UTF8 or two-byte
	 * Unicode data), and send it as a byte array.
	 */
	public void write(String what) {
		write(what.getBytes());
	}

	/**
	 * If this just hangs and never completes on Windows, it may be because the
	 * DLL doesn't have its exec bit set. Why the hell that'd be the case, who
	 * knows.
	 */
	static public String[] list() {
		Vector<String> list = new Vector<String>();
		try {
			Enumeration<?> portList = CommPortIdentifier.getPortIdentifiers();
			while (portList.hasMoreElements()) {
				CommPortIdentifier portId = (CommPortIdentifier) portList
						.nextElement();

				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
					String name = portId.getName();
					list.addElement(name);
				}
			}

		} catch (UnsatisfiedLinkError e) {
			errorMessage("ports", e);
		} catch (Exception e) {
			errorMessage("ports", e);
		}
		String outgoing[] = new String[list.size()];
		list.copyInto(outgoing);
		return outgoing;
	}

	/**
	 * General error reporting, all corraled here just in case I think of
	 * something slightly more intelligent to do.
	 */
	static public void errorMessage(String where, Throwable e) {
		e.printStackTrace();
		throw new RuntimeException("Error inside Serial." + where + "()");
	}

	public InputStream getInpustream() {
		return input;
	}

	public OutputStream getOutpuStream() {
		return output;
	}
	
	public int getDataBits() {
		return databits;
	}
	
	public int getParity() {
		return parity;
	}
	
	public int getBaudRate() {
		return rate;
	}
	
	public int getStopBits() {
		return stopbits;
	}
	
	public SerialPort getSerialPort() {
		return port;
	}
	
	@Override
	public void send(byte[] bytes) {
		write(bytes);
	}
	
	@Override
	public void receive(byte[] bytes) {
		readBytes(bytes);
	}
}
