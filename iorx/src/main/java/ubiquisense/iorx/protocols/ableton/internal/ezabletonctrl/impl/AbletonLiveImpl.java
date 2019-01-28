/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbletonLive;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.ControlSurface;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveClip;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveMaster;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveScene;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveTrack;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.MASTER_CTRL;


public class AbletonLiveImpl implements AbletonLive {
	List<CmdPipe> engines;
	String version;
	List<LiveScene> scenes;
	List<LiveTrack> tracks;
	List<LiveClip> clips;
	LiveScene currentScene;
	LiveMaster masterTrack;
	MASTER_CTRL state;
	boolean overdub;
	float tempo;
	float volume;
	long time;
	CmdPipe defaultPipe;
	boolean ubqtNotification;
	List<ControlSurface> surfaces;
	 
	public  AbletonLiveImpl() {
		super();
		engines = Lists.newArrayList();
		scenes = Lists.newArrayList();
		tracks = Lists.newArrayList();
		clips = Lists.newArrayList();
		surfaces = Lists.newArrayList();
	}

	@SuppressWarnings("unchecked")
	public List<CmdPipe> getEngines() {
		return engines;
	}

	public String getVer() {
		return version;
	}

	public void setVer(String newVer) {
		version = newVer;
	}

	@SuppressWarnings("unchecked")
	public List<LiveTrack> getTracks() {
		return tracks;
	}

	@SuppressWarnings("unchecked")
	public List<LiveScene> getScenes() {
		return scenes;
	}

	@SuppressWarnings("unchecked")
	public List<LiveClip> getClips() {
		return clips;
	}

	public LiveScene getCurrentScene() {
		return currentScene;
	}

	public void setCurrentScene(LiveScene newCurrentScene) {
		currentScene = newCurrentScene;
	}

	public LiveMaster getMasterTrack() {
		return masterTrack;
	}

	public void setMasterTrack(LiveMaster newMasterTrack) {
		masterTrack = newMasterTrack;
	}

	public MASTER_CTRL getState() {
		return state;
	}

	public void setState(MASTER_CTRL newState) {
		state = newState;
	}

	public boolean isOverdub() {
		return overdub;
	}

	public void setOverdub(boolean newOverdub) {
		overdub = newOverdub;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float newVolume) {
		volume = newVolume;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long newTime) {
		time = newTime;
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float newTempo) {
		tempo = newTempo;
	}

	public CmdPipe getDefault() {
		return defaultPipe;
	}

	public void setDefault(CmdPipe newDefault) {
		defaultPipe = newDefault;
	}

	public boolean isUbqtNotificationOn() {
		return ubqtNotification;
	}

	public void setUbqtNotificationOn(boolean newUbqtNotificationOn) {
		ubqtNotification = newUbqtNotificationOn;
	}

	@SuppressWarnings("unchecked")
	public List<ControlSurface> getControlSurfaces() {
		return surfaces;
	}

} //AbletonLiveImpl
