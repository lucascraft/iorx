/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveMasterVolumeReq;

public class LiveMasterVolumeReqImpl extends AbletonLiveSndCmdImpl implements LiveMasterVolumeReq {
	int trackID;
	float level;
	
	public LiveMasterVolumeReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

} //LiveMasterVolumeReqImpl
