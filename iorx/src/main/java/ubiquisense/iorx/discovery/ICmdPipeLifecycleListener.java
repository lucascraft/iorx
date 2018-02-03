package ubiquisense.iorx.discovery;

import ubiquisense.iorx.pipe.CmdPipe;

public interface ICmdPipeLifecycleListener {
	void open(CmdPipe pipe);
	void remove(CmdPipe pipe);
}
