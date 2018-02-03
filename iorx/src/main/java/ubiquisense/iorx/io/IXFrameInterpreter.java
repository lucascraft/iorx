package ubiquisense.iorx.io;

import ubiquisense.iorx.cmd.Cmd;

public interface IXFrameInterpreter {
	String getID();


	Cmd byteArray2Cmd(byte[] stream);

}
