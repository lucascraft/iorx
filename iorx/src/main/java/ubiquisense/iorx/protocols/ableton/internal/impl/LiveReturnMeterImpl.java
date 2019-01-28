/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveReturnMeter;
import ubiquisense.iorx.protocols.ableton.internal.METER_INPUT;

public class LiveReturnMeterImpl extends AbletonLiveSndCmdImpl implements LiveReturnMeter {
	int trackID;
	float level;
	METER_INPUT meterInput;
	
	public LiveReturnMeterImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

	public METER_INPUT getWhich() {
		return meterInput;
	}

	public void setWhich(METER_INPUT newWhich) {
		meterInput = newWhich;
	}

} //LiveReturnMeterImpl
