/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveVolumeSet;

public class LiveVolumeSetImpl extends AbletonLiveSndCmdImpl implements LiveVolumeSet {
	int trackID;
	float level;
	
	public LiveVolumeSetImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		level = newTrackID;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

} //LiveVolumeSetImpl
