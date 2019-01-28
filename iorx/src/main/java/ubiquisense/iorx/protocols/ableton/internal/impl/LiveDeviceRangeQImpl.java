/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceRangeQ;

public class LiveDeviceRangeQImpl extends AbletonLiveSndCmdImpl implements LiveDeviceRangeQ {
	int trackID;
	int deviceID;
	int param;

	public LiveDeviceRangeQImpl() {
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
	public int getParam() {
		return param;
	}

	public void setParam(int newParam) {
		param = newParam;
	}

} //LiveDeviceRangeQImpl
