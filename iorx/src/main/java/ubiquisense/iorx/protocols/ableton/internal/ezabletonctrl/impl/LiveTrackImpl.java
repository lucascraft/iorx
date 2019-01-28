/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.protocols.ableton.internal.TRACK_ARM_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_MUTE_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.TRACK_SOLO_STATUS;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbstractLiveDevice;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveClip;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveTrack;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveTrackView;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.TRACK_CONTROL;

public class LiveTrackImpl implements LiveTrack {
	int trackID;
	float liveTrackVolume;
	float pan;
	TRACK_SOLO_STATUS soloStatus;
	TRACK_ARM_STATUS armStatus;
	TRACK_MUTE_STATUS muteStatus;
	int send;
	float delay;
	int coarse;
	int fine;
	List<AbstractLiveDevice> devices;
	float beats;
	TRACK_CONTROL controlState;
	List<LiveClip> clips;
	String trackName;
	LiveTrackView trackView;
	long lastSeen;
	int color;
	float leftMeter;
	float rightMeter;
	
	public LiveTrackImpl() {
		super();
		devices = Lists.newArrayList();
		clips = Lists.newArrayList();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getVolume() {
		return liveTrackVolume;
	}

	public void setVolume(float newVolume) {
		liveTrackVolume = newVolume;
	}

	public float getPan() {
		return pan;
	}

	public void setPan(float newPan) {
		pan = newPan;
	}

	public TRACK_SOLO_STATUS getSolo() {
		return soloStatus;
	}

	public void setSolo(TRACK_SOLO_STATUS newSolo) {
		soloStatus = newSolo;
	}

	public int getSend() {
		return send;
	}

	public void setSend(int newSend) {
		send = newSend;
	}

	public TRACK_ARM_STATUS getArm() {
		return armStatus;
	}

	public void setArm(TRACK_ARM_STATUS newArm) {
		armStatus = newArm;
	}

	public TRACK_MUTE_STATUS getMute() {
		return muteStatus;
	}

	public void setMute(TRACK_MUTE_STATUS newMute) {
		muteStatus = newMute;
	}

	public float getDelay() {
		return delay;
	}

	public void setDelay(float newDelay) {
		delay = newDelay;
	}

	public int getCoarse() {
		return coarse;
	}

	public void setCoarse(int newCoarse) {
		coarse = newCoarse;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int newFine) {
		fine = newFine;
	}

	public float getBeats() {
		return beats;
	}

	public void setBeats(float newBeats) {
		beats = newBeats;
	}

	@SuppressWarnings("unchecked")
	public List<AbstractLiveDevice> getDevices() {
		return devices;
	}

	public TRACK_CONTROL getState() {
		return controlState;
	}

	public void setState(TRACK_CONTROL newState) {
		controlState = newState;
	}

	@SuppressWarnings("unchecked")
	public List<LiveClip> getClips() {
		return clips;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String newTrackName) {
		trackName = newTrackName;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public float getLeftMeter() {
		return leftMeter;
	}

	public void setLeftMeter(float newLeftMeter) {
		leftMeter = newLeftMeter;
	}

	public float getRightMeter() {
		return rightMeter;
	}

	public void setRightMeter(float newRightMeter) {
		rightMeter = newRightMeter;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(long newLastSeen) {
		lastSeen = newLastSeen;
	}

	public LiveTrackView getView() {
		return trackView;
	}

	public void setView(LiveTrackView newView) {
		trackView = newView;
	}

} //LiveTrackImpl
