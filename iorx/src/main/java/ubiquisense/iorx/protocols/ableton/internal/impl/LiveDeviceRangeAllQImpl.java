/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRangeAllQ;

public class LiveDeviceRangeAllQImpl extends AbletonLiveSndCmdImpl implements LiveDeviceRangeAllQ {
	int trackID;
	int deviceID;

	public LiveDeviceRangeAllQImpl() {
		super();
	}



	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int newDeviceID) {
		deviceID = newDeviceID;
	}

} //LiveDeviceRangeAllQImpl
