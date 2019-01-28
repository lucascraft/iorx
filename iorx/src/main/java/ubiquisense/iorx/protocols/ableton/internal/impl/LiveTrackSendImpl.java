/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackSend;

public class LiveTrackSendImpl extends AbletonLiveSndCmdImpl implements LiveTrackSend {
	int trackID;
	float send;
	
	public LiveTrackSendImpl() {
		super();
	}
	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getSend() {
		return send;
	}

	public void setSend(float newSend) {
		send = newSend;
	}

} //LiveTrackSendImpl
