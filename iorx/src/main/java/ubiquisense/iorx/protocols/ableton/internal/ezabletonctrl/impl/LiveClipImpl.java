/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import java.awt.Color;

import ubiquisense.iorx.protocols.ableton.internal.CLIP_STATE;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveClip;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveTrack;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.MASTER_CTRL;

public class LiveClipImpl implements LiveClip {
	int clipID;
	String clipName;
	CLIP_STATE clipState;
	int sizeX;
	int sizeY;
	int coarse;
	MASTER_CTRL palyingStatus;
	boolean isTriggered;
	int fine;
	float position;
	float length;
	float loopStart;
	float loopEnd;
	LiveTrack liveTrack;
	long lastSeen;
	boolean audioClip;
	boolean midiClip;
	boolean notes;
	Color color;
	int sigDenominator;
	int sigNumerator;
	boolean warping;
	boolean willRecordingOnStart;
	
	public LiveClipImpl() {
		super();
	}
	public int getClipID() {
		return clipID;
	}

	public void setClipID(int newClipID) {
		clipID = newClipID;
	}

	public String getClipName() {
		return clipName;
	}

	public void setClipName(String newClipName) {
		clipName = newClipName;
	}

	public CLIP_STATE getClipState() {
		return clipState;
	}

	public void setClipState(CLIP_STATE newClipState) {
		clipState = newClipState;
	}

	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int newSizeX) {
		sizeX = newSizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int newSizeY) {
		sizeY = newSizeY;
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

	public float getPosition() {
		return position;
	}

	public void setPosition(float newPosition) {
		position = newPosition;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float newLength) {
		length = newLength;
	}

	public float getLoopStart() {
		return loopStart;
	}

	public void setLoopStart(float newLoopStart) {
		loopStart = newLoopStart;
	}

	public float getLoopEnd() {
		return loopEnd;
	}

	public void setLoopEnd(float newLoopEnd) {
		loopEnd = newLoopEnd;
	}

	public LiveTrack getTrack() {
		return liveTrack;
	}

	public void setTrack(LiveTrack newTrack) {
		liveTrack = newTrack;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(long newLastSeen) {
		lastSeen = newLastSeen;
	}

	public boolean isIsAudioClip() {
		return audioClip;
	}

	public void setIsAudioClip(boolean newIsAudioClip) {
		audioClip = newIsAudioClip;
	}

	public boolean isIsMidiClip() {
		return midiClip;
	}

	public void setIsMidiClip(boolean newIsMidiClip) {
		midiClip = newIsMidiClip;
	}

	public boolean isIsTriggered() {
		return isTriggered;
	}

	public void setIsTriggered(boolean newIsTriggered) {
		isTriggered = newIsTriggered;
	}

	public MASTER_CTRL getPlayingStatus() {
		return palyingStatus;
	}

	public void setPlayingStatus(MASTER_CTRL newPlayingStatus) {
		palyingStatus = newPlayingStatus;
	}

	public boolean isNotes() {
		return notes;
	}

	public void setNotes(boolean newNotes) {
		notes = newNotes;
	}

	public int getSignature_denominator() {
		return sigDenominator;
	}

	public void setSignature_denominator(int newSignature_denominator) {
		sigDenominator = newSignature_denominator;
	}

	public int getSignature_numerator() {
		return sigNumerator;
	}

	public void setSignature_numerator(int newSignature_numerator) {
		sigNumerator = newSignature_numerator;
	}

	public boolean isWarping() {
		return warping;
	}

	public void setWarping(boolean newWarping) {
		warping = newWarping;
	}

	public boolean isWill_recording_on_start() {
		return willRecordingOnStart;
	}

	public void setWill_recording_on_start(boolean newWill_recording_on_start) {
		willRecordingOnStart = newWill_recording_on_start;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {
		color = newColor;
	}

} //LiveClipImpl
