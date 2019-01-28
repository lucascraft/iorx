/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnDevicelist;

public class LiveReturnDevicelistImpl extends AbletonLiveSndCmdImpl implements LiveReturnDevicelist {
	int trackID;
	public LiveReturnDevicelistImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveReturnDevicelistImpl
