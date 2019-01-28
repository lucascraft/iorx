/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackVolume;

public class LiveTrackVolumeImpl extends AbletonLiveSndCmdImpl implements LiveTrackVolume {
	float volume;
	int trackID;
	
	public LiveTrackVolumeImpl() {
		super();
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float newVolume) {
		volume = newVolume;
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveTrackVolumeImpl
