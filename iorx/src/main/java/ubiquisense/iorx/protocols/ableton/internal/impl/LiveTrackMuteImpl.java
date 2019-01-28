/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackMute;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;

public class LiveTrackMuteImpl extends AbletonLiveSndCmdImpl implements LiveTrackMute {
	TRACK_MUTE_STATUS muteStatus;
	int trackID;
	public LiveTrackMuteImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_MUTE_STATUS getState() {
		return muteStatus;
	}

	public void setState(TRACK_MUTE_STATUS newState) {
		muteStatus = newState;
	}

} //LiveTrackMuteImpl
