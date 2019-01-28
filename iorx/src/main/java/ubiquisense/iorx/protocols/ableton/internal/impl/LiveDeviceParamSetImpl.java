/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDeviceParamSet;

public class LiveDeviceParamSetImpl extends AbletonLiveSndCmdImpl implements LiveDeviceParamSet {
	int trackID;
	int deviceID;
	Object value;
	int pIndex;
	float min;
	float max;
	boolean status;
	int type;
	
	public LiveDeviceParamSetImpl() {
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object newValue) {
		value = newValue;
	}

	public int getPIndex() {
		return pIndex;
	}

	public void setPIndex(int newPIndex) {
		pIndex = newPIndex;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float newMin) {
		min = newMin;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float newMax) {
		max = newMax;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean newStatus) {
		status = newStatus;
	}

	public int getType() {
		return type;
	}

	public void setType(int newType) {
		type = newType;
	}

} //LiveDeviceParamSetImpl
