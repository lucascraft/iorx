/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackInfo;

public class LiveTrackInfoImpl extends AbletonLiveSndCmdImpl implements LiveTrackInfo {
	int trackID;
	
	public LiveTrackInfoImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

} //LiveTrackInfoImpl
