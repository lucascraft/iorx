package ubiquisense.iorx.xp;

import ubiquisense.iorx.qx.CmdPipe;

public interface ICmdPipeLifecycleListener {
	void open(CmdPipe pipe);
	void remove(CmdPipe pipe);
}
