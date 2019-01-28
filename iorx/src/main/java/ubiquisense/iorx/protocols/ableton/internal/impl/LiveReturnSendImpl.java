/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnSend;

public class LiveReturnSendImpl extends AbletonLiveSndCmdImpl implements LiveReturnSend {
	 int trackID;
	 int send;
	 float level;
	
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

} //LiveReturnSendImpl
