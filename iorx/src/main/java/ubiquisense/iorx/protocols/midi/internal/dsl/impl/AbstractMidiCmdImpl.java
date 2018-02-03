/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl.impl;

import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.protocols.midi.internal.dsl.AbstractMidiCmd;
import ubiquisense.iorx.utils.CmdUtil;

public abstract class AbstractMidiCmdImpl extends CmdImpl implements AbstractMidiCmd {
	
	byte addr;
	byte byte1;
	byte byte2;
	int msgSize;
	byte[] message;

	protected AbstractMidiCmdImpl() {
		super();
	}

	public byte getAddr() {
		return addr;
	}

	public void setAddr(byte newAddr) {
		addr = newAddr;
	}

	public int getMsgSize() {
		return msgSize;
	}

	public void setMsgSize(int newMsgSize) {
		msgSize = newMsgSize;
	}

	public byte getByte1() {
		return byte1;
	}

	public void setByte1(byte newByte1) {
		byte1 = newByte1;
	}

	public byte getByte2() {
		return byte2;
	}
	
	public void setByte2(byte newByte2) {
		byte2 = newByte2;
	}

	public byte[] getMessage() {
		return message;
	}

	public void setMessage(byte[] newMessage) {
		message = newMessage;
	}
	
	public String toString() {
		return CmdUtil.INSTANCE.getFrameHexInfo(getMessage());
	};

} //AbstractMidiCmdImpl
