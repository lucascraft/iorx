package ubiquisense.iorx.io;

import ubiquisense.iorx.qx.Cmd;

public interface IXCmdInterpreter {
	String getID();
	void setID(String value);
	byte[] cmd2ByteArray(Cmd cmd);

}
