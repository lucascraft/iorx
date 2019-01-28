/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveSendReq;

public class LiveSendReqImpl extends AbletonLiveSndCmdImpl implements LiveSendReq {
	int trackID;
	int value;
	
	public LiveSendReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}


	public int getValue() {
		return value;
	}

	public void setValue(int newValue) {
		value = newValue;
	}

} //LiveSendReqImpl
