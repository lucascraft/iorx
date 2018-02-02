package ubiquisense.iorx.qx.impl;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.PRIORITY;

public class CmdImpl implements Cmd {
	long stamp;
	PRIORITY priority;
	
	@Override
	public void setStamp(long time) {
		stamp = time;
	}
	
	@Override
	public long getStamp() {
		return stamp;
	}
	
	@Override
	public PRIORITY getPriority() {
		return priority;
	}
	
	@Override
	public void setPriority(PRIORITY value) {
		priority = value;
	}
}
