/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSolo;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_SOLO_STATUS;

public class LiveReturnSoloImpl extends AbletonLiveSndCmdImpl implements LiveReturnSolo {
	TRACK_SOLO_STATUS soloStatus;
	int trackID;
	
	public LiveReturnSoloImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_SOLO_STATUS getStatus() {
		return soloStatus;
	}

	public void setStatus(TRACK_SOLO_STATUS newStatus) {
		soloStatus = newStatus;
	}

} //LiveReturnSoloImpl
