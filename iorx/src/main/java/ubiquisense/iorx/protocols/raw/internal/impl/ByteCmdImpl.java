package ubiquisense.iorx.protocols.raw.internal.impl;

import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;

public class ByteCmdImpl extends CmdImpl implements ByteCmd {
	
	public byte[] getMessage()
	{
		return new byte[0];
	}
	
	public void setMessage(byte[] value)
	{
		
	}

} // ByteCmd
