/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveNameTrackReq;

public class LiveNameTrackReqImpl extends AbletonLiveSndCmdImpl implements LiveNameTrackReq {
	String trackName;
	int color;
	int trackID;
	
	public LiveNameTrackReqImpl() {
		super();
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String newTrackName) {
		trackName = newTrackName;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int newColor) {
		color =  newColor;
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveNameTrackReqImpl
