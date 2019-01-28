/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;


import ubiquisense.iorx.protocols.ableton.internal.CLIP_STATE;
import ubiquisense.iorx.protocols.ableton.internal.LiveClipInfo;

public class LiveClipInfoImpl extends AbletonLiveSndCmdImpl implements LiveClipInfo {
	int trackID;
	CLIP_STATE clipState;
	int clipID;
	public LiveClipInfoImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public CLIP_STATE getStatus() {
		return clipState;
	}

	public void setStatus(CLIP_STATE newStatus) {
		clipState = newStatus;
	}
	public int getClipID() {
		return clipID;
	}

	public void setClipID(int newClipID) {
		clipID = newClipID;
	}

} //LiveClipInfoImpl
