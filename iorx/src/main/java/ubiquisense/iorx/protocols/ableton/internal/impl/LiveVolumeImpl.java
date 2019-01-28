/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveVolume;

public class LiveVolumeImpl extends AbletonLiveSndCmdImpl implements LiveVolume {
	float level;
	int trackID;
	
	public LiveVolumeImpl() {
		super();
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveVolumeImpl
