package ubiquisense.iorx.qx.impl;

import ubiquisense.iorx.qx.Cmd;

public class CmdImpl implements Cmd {
	long stamp;
	
	@Override
	public void setStamp(long time) {
		stamp = time;
	}
	
	@Override
	public long getStamp() {
		return stamp;
	}

}
