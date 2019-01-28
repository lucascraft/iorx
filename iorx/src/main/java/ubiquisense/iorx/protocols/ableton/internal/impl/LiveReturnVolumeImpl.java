/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnVolume;

public class LiveReturnVolumeImpl extends AbletonLiveSndCmdImpl implements LiveReturnVolume {
	int trackID;
	 float level;

	 public LiveReturnVolumeImpl() {
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

} //LiveReturnVolumeImpl
