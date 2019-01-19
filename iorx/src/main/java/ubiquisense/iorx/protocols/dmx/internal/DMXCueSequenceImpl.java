/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

public class DMXCueSequenceImpl implements DMXCueSequence {
	protected DMXFixtureValuations prev;
	protected DMXFixtureValuations next;
	protected static final long START_EDEFAULT = 0L;
	protected long start = START_EDEFAULT;
	protected static final long DURATION_EDEFAULT = 0L;
	protected long duration = DURATION_EDEFAULT;
	protected static final long SPEED_EDEFAULT = 0L;
	protected long speed = SPEED_EDEFAULT;
	protected static final boolean LOOP_EDEFAULT = false;
	protected boolean loop = LOOP_EDEFAULT;
	protected static final int TIMES_EDEFAULT = 0;
	protected int times = TIMES_EDEFAULT;
	protected DMXCueSequenceImpl() {
		super();
	}
	public DMXFixtureValuations getPrev() {
		return prev;
	}
	public DMXFixtureValuations basicGetPrev() {
		return prev;
	}
	public void setPrev(DMXFixtureValuations newPrev) {
		DMXFixtureValuations oldPrev = prev;
		prev = newPrev;
	}
	public DMXFixtureValuations getNext() {
		return next;
	}
	public DMXFixtureValuations basicGetNext() {
		return next;
	}
	public void setNext(DMXFixtureValuations newNext) {
		DMXFixtureValuations oldNext = next;
		next = newNext;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long newStart) {
		long oldStart = start;
		start = newStart;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long newDuration) {
		long oldDuration = duration;
		duration = newDuration;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long newSpeed) {
		long oldSpeed = speed;
		speed = newSpeed;
	}
	public boolean isLoop() {
		return loop;
	}
	public void setLoop(boolean newLoop) {
		boolean oldLoop = loop;
		loop = newLoop;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int newTimes) {
		int oldTimes = times;
		times = newTimes;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (start: ");
		result.append(start);
		result.append(", duration: ");
		result.append(duration);
		result.append(", speed: ");
		result.append(speed);
		result.append(", loop: ");
		result.append(loop);
		result.append(", times: ");
		result.append(times);
		result.append(')');
		return result.toString();
	}

} //DMXCueSequenceImpl
