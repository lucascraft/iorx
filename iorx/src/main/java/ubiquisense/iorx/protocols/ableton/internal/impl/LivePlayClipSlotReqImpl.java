/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LivePlayClipSlotReq;

public class LivePlayClipSlotReqImpl extends AbletonLiveSndCmdImpl implements LivePlayClipSlotReq {
	int trackID;
	int clipID;
	public LivePlayClipSlotReqImpl() {
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

} //LivePlayClipSlotReqImpl
