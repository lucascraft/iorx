/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveStopTrackReq;

public class LiveStopTrackReqImpl extends AbletonLiveSndCmdImpl implements LiveStopTrackReq {
	int trackID;
	public LiveStopTrackReqImpl() {
		super();
	}
	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveStopTrackReqImpl
