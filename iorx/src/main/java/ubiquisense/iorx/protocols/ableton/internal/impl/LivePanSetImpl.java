/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LivePanSet;

public class LivePanSetImpl extends AbletonLiveSndCmdImpl implements LivePanSet {
	int trackID;
	float value;
	public LivePanSetImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float newValue) {
		value = newValue;
	}

} //LivePanSetImpl
