/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveArmReq extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	TRACK_ARM_STATUS getStatus();
	void setStatus(TRACK_ARM_STATUS value);

} // LiveArmReq
