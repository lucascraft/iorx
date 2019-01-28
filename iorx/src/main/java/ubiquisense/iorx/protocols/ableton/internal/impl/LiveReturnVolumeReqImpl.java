/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnVolumeReq;

public class LiveReturnVolumeReqImpl extends AbletonLiveSndCmdImpl implements LiveReturnVolumeReq {
	int trackID;
	 float level;

		public LiveReturnVolumeReqImpl() {
			super();
		}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}
	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

} //LiveReturnVolumeReqImpl
