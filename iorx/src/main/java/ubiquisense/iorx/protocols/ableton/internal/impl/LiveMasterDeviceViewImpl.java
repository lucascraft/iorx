/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveMasterDeviceView;

public class LiveMasterDeviceViewImpl extends AbletonLiveSndCmdImpl implements LiveMasterDeviceView {
	int deviceID;
	
	public LiveMasterDeviceViewImpl() {
		super();
	}

	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int newDeviceID) {
		deviceID = newDeviceID;
	}

} //LiveMasterDeviceViewImpl
