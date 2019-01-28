/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveMasterPanReq;

public class LiveMasterPanReqImpl extends AbletonLiveSndCmdImpl implements LiveMasterPanReq {
	int trackID;
	float pan;
	
	public LiveMasterPanReqImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getPan() {
		return pan;
	}

	public void setPan(float newPan) {
		pan = newPan;
	}

} //LiveMasterPanReqImpl
