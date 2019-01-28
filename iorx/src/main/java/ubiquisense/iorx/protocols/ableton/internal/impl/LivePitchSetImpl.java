/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LivePitchSet;

public class LivePitchSetImpl extends AbletonLiveSndCmdImpl implements LivePitchSet {
	int trackID;
	int clipID;
	int fine;
	int coarse;
	
	public LivePitchSetImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID =  newTrackID;
	}

	public int getClip() {
		return clipID;
	}

	public void setClip(int newClip) {
		clipID = newClip;
	}

	public int getCoarse() {
		return coarse;
	}

	public void setCoarse(int newCoarse) {
		coarse = newCoarse;
	}

	public int getFine() {
		return fine;
	}
	public void setFine(int newFine) {
		fine = newFine;
	}

} //LivePitchSetImpl
