/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDeviceRangeAll;

public class LiveReturnDeviceRangeAllImpl extends AbletonLiveSndCmdImpl implements LiveReturnDeviceRangeAll {
	int trackID;
	int deviceID;
	public LiveReturnDeviceRangeAllImpl() {
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

} //LiveReturnDeviceRangeAllImpl
