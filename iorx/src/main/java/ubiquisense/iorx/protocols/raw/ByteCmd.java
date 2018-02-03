package ubiquisense.iorx.protocols.raw;

import ubiquisense.iorx.cmd.Cmd;

public interface ByteCmd extends Cmd {
	byte[] getMessage();
	void setMessage(byte[] value);

} // ByteCmd
