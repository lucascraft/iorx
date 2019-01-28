/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipReq;

public class LiveNameClipReqImpl extends AbletonLiveSndCmdImpl implements LiveNameClipReq {
	int color;
	int clipID;
	int trackID;
	String label;
	
	public LiveNameClipReqImpl() {
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String newLabel) {
		label = newLabel;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

} //LiveNameClipReqImpl
