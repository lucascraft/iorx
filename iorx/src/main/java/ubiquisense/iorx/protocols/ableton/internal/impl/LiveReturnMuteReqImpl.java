/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnMuteReq;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;

public class LiveReturnMuteReqImpl extends AbletonLiveSndCmdImpl implements LiveReturnMuteReq {
	TRACK_MUTE_STATUS trackMuteStatus;
	int trackID;
	
	public LiveReturnMuteReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_MUTE_STATUS getStatus() {
		return trackMuteStatus;
	}

	public void setStatus(TRACK_MUTE_STATUS newStatus) {
		trackMuteStatus = newStatus;
	}

} //LiveReturnMuteReqImpl
