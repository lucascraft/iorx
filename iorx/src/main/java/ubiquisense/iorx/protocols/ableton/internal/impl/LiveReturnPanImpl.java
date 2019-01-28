/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnPan;

public class LiveReturnPanImpl extends AbletonLiveSndCmdImpl implements LiveReturnPan {
	int trackID;
	float pan;
	
	public LiveReturnPanImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getPan() {
		return pan;
	}

	public void setPan(float newPan) {
		pan = newPan;
	}

} //LiveReturnPanImpl
