
package ubiquisense.iorx.comm.usb.io;

import java.io.OutputStream;

/**
 * 
 * API contract for Serial reader
 *
 */
public interface ISerialWriter {
	/**
	 * Getter for the current serial stream handling the output data.
	 * 
	 * @return The given {@link OutputStream} reference
	 */
	OutputStream getOutpuStream();
	
	/**
	 * 
	 * @param what
	 */
	void write(int what);
	
	/**
	 * 
	 * @param bytes
	 */
	void write(byte bytes[]);
	
	/**
	 * 
	 * @param what
	 */
	void write(String what);
}
