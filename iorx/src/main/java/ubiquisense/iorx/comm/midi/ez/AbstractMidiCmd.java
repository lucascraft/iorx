/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez;

import ubiquisense.iorx.qx.Cmd;

public interface AbstractMidiCmd extends Cmd {
	byte getAddr();
	void setAddr(byte value);
	int getMsgSize();
	void setMsgSize(int value);
	byte getByte1();
	void setByte1(byte value);
	byte getByte2();
	void setByte2(byte value);
	byte[] getMessage();
	void setMessage(byte[] value);

} 
