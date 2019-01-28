package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnPanReq;

public class LiveReturnPanReqImpl extends AbletonLiveSndCmdImpl implements LiveReturnPanReq {
	int trackID;
	float pan;
	
	public LiveReturnPanReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getPan() {
		return pan;
	}

	public void setPan(float newPan) {
		pan = newPan;
	}

} //LiveReturnPanReqImpl
