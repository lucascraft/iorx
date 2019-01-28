/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveMuteReq;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;

public class LiveMuteReqImpl extends AbletonLiveSndCmdImpl implements LiveMuteReq {
	TRACK_MUTE_STATUS muteStatus;
	int trackID;
	public LiveMuteReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_MUTE_STATUS getStatus() {
		return muteStatus;
	}

	public void setStatus(TRACK_MUTE_STATUS newStatus) {
		muteStatus = newStatus;
	}

} //LiveMuteReqImpl
