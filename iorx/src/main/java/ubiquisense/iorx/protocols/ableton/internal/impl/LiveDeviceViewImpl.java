/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceView;

public class LiveDeviceViewImpl extends AbletonLiveSndCmdImpl implements LiveDeviceView {
	int trackID;
	int deviceID;

	public LiveDeviceViewImpl() {
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

} //LiveDeviceViewImpl
