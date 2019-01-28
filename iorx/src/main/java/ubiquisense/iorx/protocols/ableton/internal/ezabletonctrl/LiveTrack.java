/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.List;

import ubiquisense.iorx.protocols.ableton.internal.TRACK_ARM_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_SOLO_STATUS;

public interface LiveTrack  {
	int getTrackID();
	void setTrackID(int value);
	float getVolume();
	void setVolume(float value);
	float getPan();
	void setPan(float value);
	TRACK_SOLO_STATUS getSolo();
	void setSolo(TRACK_SOLO_STATUS value);
	int getSend();
	void setSend(int value);
	TRACK_ARM_STATUS getArm();
	void setArm(TRACK_ARM_STATUS value);
	TRACK_MUTE_STATUS getMute();
	void setMute(TRACK_MUTE_STATUS value);
	float getDelay();
	void setDelay(float value);
	int getCoarse();
	void setCoarse(int value);
	int getFine();
	void setFine(int value);
	float getBeats();
	void setBeats(float value);
	List<AbstractLiveDevice> getDevices();
	TRACK_CONTROL getState();
	void setState(TRACK_CONTROL value);
	List<LiveClip> getClips();
	String getTrackName();
	void setTrackName(String value);
	int getColor();
	void setColor(int value);
	float getLeftMeter();
	void setLeftMeter(float value);
	float getRightMeter();
	void setRightMeter(float value);
	long getLastSeen();
	void setLastSeen(long value);
	LiveTrackView getView();
	void setView(LiveTrackView value);

} // LiveTrack
