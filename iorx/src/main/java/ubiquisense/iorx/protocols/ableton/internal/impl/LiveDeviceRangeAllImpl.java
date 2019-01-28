/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRangeAll;

public class LiveDeviceRangeAllImpl extends AbletonLiveSndCmdImpl implements LiveDeviceRangeAll {
	int trackID;
	int deviceID;

	public LiveDeviceRangeAllImpl() {
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

} //LiveDeviceRangeAllImpl
