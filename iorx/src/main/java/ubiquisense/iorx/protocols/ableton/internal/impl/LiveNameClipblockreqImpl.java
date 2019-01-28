/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveNameClipblockreq;

public class LiveNameClipblockreqImpl extends AbletonLiveSndCmdImpl implements LiveNameClipblockreq {
	int sizeX, sizeY, trackID, clipID;
	
	public LiveNameClipblockreqImpl() {
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

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int newSizeX) {
		sizeX = newSizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int newSizeY) {
		sizeY = newSizeY;
	}

} //LiveNameClipblockreqImpl
