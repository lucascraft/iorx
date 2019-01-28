/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackSolo;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_SOLO_STATUS;

public class LiveTrackSoloImpl extends AbletonLiveSndCmdImpl implements LiveTrackSolo {
	TRACK_SOLO_STATUS soloStatus;
	int trackID;
	public LiveTrackSoloImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_SOLO_STATUS getState() {
		return soloStatus;
	}

	public void setState(TRACK_SOLO_STATUS newState) {
		soloStatus = newState;
	}

} //LiveTrackSoloImpl
