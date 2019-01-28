/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackJump;

public class LiveTrackJumpImpl extends AbletonLiveSndCmdImpl implements LiveTrackJump {
	int trackID;
	float beats;
	public LiveTrackJumpImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getBeats() {
		return beats;
	}

	public void setBeats(float newBeats) {
		beats = newBeats;
	}

} //LiveTrackJumpImpl
