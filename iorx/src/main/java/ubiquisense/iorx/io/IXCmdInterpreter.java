package ubiquisense.iorx.io;

import ubiquisense.iorx.qx.Cmd;

public interface IXCmdInterpreter {
	String getID();
	byte[] cmd2ByteArray(Cmd cmd);

}
