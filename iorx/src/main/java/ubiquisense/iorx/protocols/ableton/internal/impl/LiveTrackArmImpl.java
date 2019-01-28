/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackArm;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_ARM_STATUS;

public class LiveTrackArmImpl extends AbletonLiveSndCmdImpl implements LiveTrackArm {
	TRACK_ARM_STATUS trackArmStatus;
	int trackID;
	
	public LiveTrackArmImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public TRACK_ARM_STATUS getState() {
		return trackArmStatus;
	}

	public void setState(TRACK_ARM_STATUS newState) {
		trackArmStatus = newState;
	}

} //LiveTrackArmImpl
