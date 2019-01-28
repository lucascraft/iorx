/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackName;

public class LiveTrackNameImpl extends AbletonLiveSndCmdImpl implements LiveTrackName {
	String trackName;
	int trackID;
	
	public LiveTrackNameImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public String getName() {
		return trackName;
	}

	public void setName(String newName) {
		trackName = newName;
	}

} //LiveTrackNameImpl
