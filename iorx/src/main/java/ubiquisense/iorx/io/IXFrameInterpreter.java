package ubiquisense.iorx.io;

import ubiquisense.iorx.qx.Cmd;

public interface IXFrameInterpreter {
	String getID();


	Cmd byteArray2Cmd(byte[] stream);

}
