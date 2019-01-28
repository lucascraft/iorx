package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveArmReq;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_ARM_STATUS;

public class LiveArmReqImpl extends AbletonLiveSndCmdImpl implements LiveArmReq {
	int trackID;
	TRACK_ARM_STATUS trackArmStatus;
	public LiveArmReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_ARM_STATUS getStatus() {
		return trackArmStatus;
	}

	public void setStatus(TRACK_ARM_STATUS newStatus) {
		trackArmStatus = newStatus;
	}

} //LiveArmReqImpl
