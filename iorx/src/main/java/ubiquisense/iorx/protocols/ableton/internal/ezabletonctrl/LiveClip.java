/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.awt.Color;

import ubiquisense.iorx.protocols.ableton.internal.CLIP_STATE;
public interface LiveClip {
	int getClipID();
	void setClipID(int value);
	String getClipName();
	void setClipName(String value);
	CLIP_STATE getClipState();
	void setClipState(CLIP_STATE value);
	int getSizeX();
	void setSizeX(int value);
	int getSizeY();
	void setSizeY(int value);
	int getCoarse();
	void setCoarse(int value);
	int getFine();
	void setFine(int value);
	float getPosition();
	void setPosition(float value);
	float getLength();
	void setLength(float value);
	float getLoopStart();
	void setLoopStart(float value);
	float getLoopEnd();
	void setLoopEnd(float value);
	LiveTrack getTrack();
	void setTrack(LiveTrack value);
	long getLastSeen();
	void setLastSeen(long value);
	boolean isIsAudioClip();
	void setIsAudioClip(boolean value);
	boolean isIsMidiClip();
	void setIsMidiClip(boolean value);
	boolean isIsTriggered();
	void setIsTriggered(boolean value);
	MASTER_CTRL getPlayingStatus();
	void setPlayingStatus(MASTER_CTRL value);
	boolean isNotes();
	void setNotes(boolean value);
	int getSignature_denominator();
	void setSignature_denominator(int value);
	int getSignature_numerator();
	void setSignature_numerator(int value);
	boolean isWarping();
	void setWarping(boolean value);
	boolean isWill_recording_on_start();
	void setWill_recording_on_start(boolean value);
	Color getColor();
	void setColor(Color value);

} // LiveClip
