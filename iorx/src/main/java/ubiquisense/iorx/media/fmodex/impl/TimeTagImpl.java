/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import ubiquisense.iorx.media.fmodex.CLIP_STATUS;
import ubiquisense.iorx.media.fmodex.TimeTag;


public class TimeTagImpl  implements TimeTag {

	protected static final long TIME_EDEFAULT = 0L;


	protected long time = TIME_EDEFAULT;


	protected static final long DURATION_EDEFAULT = 0L;

	
	protected long duration = DURATION_EDEFAULT;

	
	protected static final CLIP_STATUS STATUS_EDEFAULT = CLIP_STATUS.PLAY;

	
	protected CLIP_STATUS status = STATUS_EDEFAULT;




	public long getTime() {
		return time;
	}

	
	public void setTime(long newTime) {
		time = newTime;
	}


	public long getDuration() {
		return duration;
	}


	public void setDuration(long newDuration) {
		duration = newDuration;
	}

	
	public CLIP_STATUS getStatus() {
		return status;
	}

	public void setStatus(CLIP_STATUS newStatus) {
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
	}


} //TimeTagImpl
