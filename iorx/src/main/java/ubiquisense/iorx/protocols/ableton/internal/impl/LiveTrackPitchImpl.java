/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackPitch;

public class LiveTrackPitchImpl extends AbletonLiveSndCmdImpl implements LiveTrackPitch {
	public LiveTrackPitchImpl() {
		super();
	}
	int trackID;
	float pitch;
	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float newPitch) {
		pitch = newPitch;
	}

} //LiveTrackPitchImpl
