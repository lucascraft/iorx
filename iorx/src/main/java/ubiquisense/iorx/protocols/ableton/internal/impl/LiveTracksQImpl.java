/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTracksQ;

public class LiveTracksQImpl extends AbletonLiveSndCmdImpl implements LiveTracksQ {
	int numTracks;
	public LiveTracksQImpl() {
		super();
	}

	public int getNumTracks() {
		return numTracks;
	}

	public void setNumTracks(int newNumTracks) {
		numTracks  = newNumTracks;
	}

} //LiveTracksQImpl
