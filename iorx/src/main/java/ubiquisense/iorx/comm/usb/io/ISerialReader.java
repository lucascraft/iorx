

package ubiquisense.iorx.comm.usb.io;

import java.io.InputStream;

/**
 * 
 * API contract for Serial reader
 * 
 */
public interface ISerialReader {
	/**
	 * Getter for the current serial stream handling the input data.
	 * 
	 * @return The given {@link InputStream} reference
	 */
	InputStream getInpustream();
	
	/**
	 * Read and return the number of bytes available in the buffer.
	 * 
	 * @return the number of bytes available in the buffer
	 */
	int read();
	
	/**
	 * 
	 * @return
	 */
	int last();
	
	/**
	 * 
	 * @return
	 */
	char readChar();
	
	/**
	 * 
	 * @return
	 */
	char lastChar();
	
	/**
	 * Read a bytes buffer from the currently active {@link InputStream} owned reference.
	 * 
	 * @return some bytes according to the buffer length
	 */
	byte[] readBytes();
	
	/**
	 * 
	 * @param outgoing
	 * @return
	 */
	int readBytes(byte outgoing[]);
	
	/**
	 * 
	 * @param interesting
	 * @return
	 */
	byte[] readBytesUntil(int interesting);
	
	/**
	 * 
	 * @param interesting
	 * @param outgoing
	 * @return
	 */
	int readBytesUntil(int interesting, byte outgoing[]);
	
	/**
	 * Read buffer as a String
	 * 
	 * @return String coming from a buffer
	 */
	String readString();
	
	/**
	 * Read buffer until reaching a given interesting point.
	 * 
	 * @param interesting
	 * @return
	 */
	String readStringUntil(int interesting);
}
