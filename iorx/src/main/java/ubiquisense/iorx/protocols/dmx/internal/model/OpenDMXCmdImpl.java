/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;


import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.utils.CmdUtil;

public abstract class OpenDMXCmdImpl extends CmdImpl implements OpenDMXCmd {
	byte start, label, end;
	byte[] data;
	protected OpenDMXCmdImpl() {
		super();
	}
	public byte getStart() {
		return start;
	}
	public void setStart(byte newStart) {
		start = newStart;
	}
	public byte getLabel() {
		return label;
	}
	public void setLabel(byte newLabel) {
		label = newLabel;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] newData) {
		data = newData;
	}
	public byte getEnd() {
		return end;
	}
	public void setEnd(byte newEnd) {
		end = newEnd;
	}
	
	@Override
	public String toString() {
		return CmdUtil.INSTANCE.getFrameHexInfo(getData());
	}

} //OpenDMXCmdImpl
