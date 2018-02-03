package ubiquisense.iorx.cmd;

import ubiquisense.iorx.qx.Qx;

public interface Cmd {
	void setStamp(long time);
	long getStamp();
	PRIORITY getPriority();
	void setPriority(PRIORITY value);
	Qx getQx();
	void setQx(Qx qx);
}
