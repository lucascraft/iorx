package ubiquisense.iorx.protocols.raw.internal.impl;

import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;

public class ByteCmdImpl extends CmdImpl implements ByteCmd {
	private byte[] message;
	
	public ByteCmdImpl(byte[] value) {
		message = value;
	}
	
	public ByteCmdImpl() {
		message = new byte[0];
	}
	
	public byte[] getMessage()
	{
		return message;
	}
	
	public void setMessage(byte[] value)
	{
		message = value;
	}

} // ByteCmd
