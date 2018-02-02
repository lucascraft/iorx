package ubiquisense.iorx.io;

import ubiquisense.iorx.qx.Cmd;

public interface IXFrameInterpreter {
	String getID();

	void setID(String value);

	Cmd byteArray2Cmd(byte[] stream);

}
