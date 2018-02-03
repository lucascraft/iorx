package ubiquisense.iorx.discovery;

import ubiquisense.iorx.cmd.CmdPipe;

public interface ICmdPipeLifecycleListener {
	void open(CmdPipe pipe);
	void remove(CmdPipe pipe);
}
