package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceView;

public class LiveReturnDeviceViewImpl extends AbletonLiveSndCmdImpl implements LiveReturnDeviceView {
	int trackID;
	int deviceID;

	public LiveReturnDeviceViewImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int newDeviceID) {
		deviceID = newDeviceID;
	}

} //LiveReturnDeviceViewImpl
