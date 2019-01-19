/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

public interface DMXCueSequence  {
	DMXFixtureValuations getPrev();
	void setPrev(DMXFixtureValuations value);
	DMXFixtureValuations getNext();
	void setNext(DMXFixtureValuations value);
	long getStart();
	void setStart(long value);
	long getDuration();
	void setDuration(long value);
	long getSpeed();
	void setSpeed(long value);
	boolean isLoop();
	void setLoop(boolean value);
	int getTimes();
	void setTimes(int value);

} // DMXCueSequence
