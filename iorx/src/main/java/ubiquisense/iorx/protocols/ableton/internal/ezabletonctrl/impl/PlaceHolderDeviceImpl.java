/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveParam;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.PlaceHolderDevice;


public class PlaceHolderDeviceImpl implements PlaceHolderDevice {
	String deviceName;
	int deviceID;
	long lastSeen;
	List<LiveParam> parameters;
	
	public PlaceHolderDeviceImpl() {
		super();
		parameters = Lists.newArrayList();
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String newDeviceName) {
		deviceName = newDeviceName;
	}

	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int newDeviceID) {
		deviceID = newDeviceID;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSeen(long newLastSeen) {
		lastSeen = newLastSeen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<LiveParam> getParameters() {
		return parameters;
	}

} //PlaceHolderDeviceImpl
