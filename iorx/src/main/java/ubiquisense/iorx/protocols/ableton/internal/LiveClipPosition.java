/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveClipPosition extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	int getClipID();
	void setClipID(int value);
	float getPosition();
	void setPosition(float value);
	float getLength();
	void setLength(float value);
	float getLoopStart();
	void setLoopStart(float value);
	float getLoopEnd();
	void setLoopEnd(float value);

} // LiveClipPosition
