/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveStopClipReq;

public class LiveStopClipReqImpl extends AbletonLiveSndCmdImpl implements LiveStopClipReq {
	int trackID;
	int clipID;
	
	public LiveStopClipReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getClipID() {
		return clipID;
	}

	public void setClipID(int newClipID) {
		clipID = newClipID;
	}

} //LiveStopClipReqImpl
