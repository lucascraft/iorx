package ubiquisense.iorx.cmd.impl;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.PRIORITY;
import ubiquisense.iorx.qx.Qx;

public class CmdImpl implements Cmd 
{
	long stamp;
	PRIORITY priority;
	Qx qx;
	
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

	@Override
	public Qx getQx() {
		return qx;
	}

	@Override
	public void setQx(Qx qx) {
		this.qx = qx;
	}
}
