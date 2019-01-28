/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDevice;

public class LiveDeviceImpl extends AbletonLiveSndCmdImpl implements LiveDevice {
	int trackID;
	int deviceID;
	int param;
	int s;
	
	public LiveDeviceImpl() {
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

	public int getS() {
		return s;
	}

	public void setS(int newS) {
		s = newS;
	}

} //LiveDeviceImpl
