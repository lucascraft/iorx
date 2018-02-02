package ubiquisense.iorx.utils;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.PRIORITY;

public interface ICmdUtil {
	
	/**
	 * Stamp a {@link Command} with date/time for tracing purposes
	 * 
	 * @param <T> some command type extending {@link Cmd}
	 * @param cmd the command to be stamped
	 * 
	 * @return the freshly stamped command
	 */
	<T extends Cmd> T stampCmd(T cmd);
	
	/**
	 * Generate a pseudo random command 
	 * 
	 * @return a pseudo generated command
	 */
	Cmd generateRamdomCmd();

	/**
	 * Generate a random PRIORITY
	 * 
	 * @return a pseudo random PRIORITY
	 */
	PRIORITY getRandomPRIORITY();
	
	/**
	 * Randomizer for int type
	 * 
	 * @param size wanted random size range
	 * 
	 * @return a random size range
	 */
	int getSomeInt(int size);
	
	/**
	 * Dump a command info
	 * 
	 * @param c a given command
	 */
	void dumpCmdInfo(Cmd c);
	
	/**
	 * Return a command info as a String
	 * 
	 * @param c a given command
	 * 
	 * @return an info for a given command
	 */
	String getCmdInfo(Cmd c);
	
	/**
	 * Get frame information
	 * 
	 * @param frame a given frame
	 * 
	 * @return frame information as a String
	 */
	String getFrameInfo(byte[] frame);
}

