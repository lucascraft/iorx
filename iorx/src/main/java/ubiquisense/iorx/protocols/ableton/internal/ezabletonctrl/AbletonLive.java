/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.List;

import ubiquisense.iorx.app.IConnectedUnit;

public interface AbletonLive extends IConnectedUnit {
	String getVer();
	void setVer(String value);
	List<LiveTrack> getTracks();
	List<LiveScene> getScenes();
	List<LiveClip> getClips();
	LiveScene getCurrentScene();
	void setCurrentScene(LiveScene value);
	LiveMaster getMasterTrack();
	void setMasterTrack(LiveMaster value);
	MASTER_CTRL getState();
	void setState(MASTER_CTRL value);
	boolean isOverdub();
	void setOverdub(boolean value);
	float getVolume();
	void setVolume(float value);
	long getTime();
	void setTime(long value);
	float getTempo();
	void setTempo(float value);
	boolean isUbqtNotificationOn();
	void setUbqtNotificationOn(boolean value);
	List<ControlSurface> getControlSurfaces();

} // AbletonLive
