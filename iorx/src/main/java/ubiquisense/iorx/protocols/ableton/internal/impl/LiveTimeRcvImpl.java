/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTimeRcv;

public class LiveTimeRcvImpl extends AbletonLiveSndCmdImpl implements LiveTimeRcv {
	float time;
	
	public LiveTimeRcvImpl() {
		super();
	}

	public float getTime() {
		return time;
	}

	public void setTime(float newTime) {
		time = newTime;
	}

} //LiveTimeRcvImpl
