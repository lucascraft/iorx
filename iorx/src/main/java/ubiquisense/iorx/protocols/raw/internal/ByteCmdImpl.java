package ubiquisense.iorx.protocols.raw.internal;

import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.protocols.raw.ByteCmd;

public class ByteCmdImpl extends CmdImpl implements ByteCmd {
	
	public byte[] getMessage()
	{
		return new byte[0];
	}
	
	public void setMessage(byte[] value)
	{
		
	}

} // ByteCmd
