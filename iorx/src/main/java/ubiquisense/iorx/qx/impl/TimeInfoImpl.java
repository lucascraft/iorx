package ubiquisense.iorx.qx.impl;

import ubiquisense.iorx.qx.TimeInfo;

public class TimeInfoImpl implements TimeInfo {
long start;
int duration;
	@Override
	public long getStart() {
		return 0;
	}

	@Override
	public void setStart(long value) {
		start = value;
	}


	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public void setDuration(int value) {
		duration = value;
	}


}
