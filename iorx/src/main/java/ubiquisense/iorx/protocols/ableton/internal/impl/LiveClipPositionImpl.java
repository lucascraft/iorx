/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveClipPosition;

public class LiveClipPositionImpl extends AbletonLiveSndCmdImpl implements LiveClipPosition {
	int trackID;
	int clipID;
	float position;
	float length;
	float loopStart;
	float loopEnd;
	
	public LiveClipPositionImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public int getClipID() {
		return clipID;
	}

	public void setClipID(int newClipID) {
		clipID = newClipID;
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

} //LiveClipPositionImpl
