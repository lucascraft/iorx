/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneBlockReq;

public class LiveNameSceneBlockReqImpl extends AbletonLiveSndCmdImpl implements LiveNameSceneBlockReq {
	int trackID;
	int size;
	public LiveNameSceneBlockReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int newSize) {
		size = newSize;
	}

} //LiveNameSceneBlockReqImpl
