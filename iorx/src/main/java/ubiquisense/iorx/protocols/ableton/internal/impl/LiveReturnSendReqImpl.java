/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSendReq;

public class LiveReturnSendReqImpl extends AbletonLiveSndCmdImpl implements LiveReturnSendReq {
	 int trackID;
	 int send;
	 float level;
	public LiveReturnSendReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getSend() {
		return send;
	}

	public void setSend(int newSend) {
		send = newSend;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

} //LiveReturnSendReqImpl
