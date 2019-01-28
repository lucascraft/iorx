/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveMasterVolume;

public class LiveMasterVolumeImpl extends AbletonLiveSndCmdImpl implements LiveMasterVolume {
	float level;
	int trackID;
	public LiveMasterVolumeImpl() {
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

} //LiveMasterVolumeImpl
