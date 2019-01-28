/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackPan;

public class LiveTrackPanImpl extends AbletonLiveSndCmdImpl implements LiveTrackPan {
	int trackID;
	float pan;

	public LiveTrackPanImpl() {
		super();
	}

	public float getPan() {
		return pan;
	}

	public void setPan(float newPan) {
		pan = newPan;
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveTrackPanImpl
