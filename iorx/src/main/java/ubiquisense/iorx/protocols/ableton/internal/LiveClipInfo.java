/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveClipInfo extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	CLIP_STATE getStatus();
	void setStatus(CLIP_STATE value);
	int getClipID();
	void setClipID(int value);

} // LiveClipInfo
