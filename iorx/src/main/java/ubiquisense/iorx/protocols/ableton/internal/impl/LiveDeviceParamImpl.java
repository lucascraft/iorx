/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceParam;

public class LiveDeviceParamImpl extends AbletonLiveSndCmdImpl implements LiveDeviceParam {
	int trackID;
	int deviceID;
	int param;
	Object value;
	String type;
	String name;
	
	public LiveDeviceParamImpl() {
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object newValue) {
		value = newValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String newType) {
		type = newType;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

} //LiveDeviceParamImpl
