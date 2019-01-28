/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTrackMeter;
import ubiquisense.iorx.protocols.ableton.internal.METER_INPUT;

public class LiveTrackMeterImpl extends AbletonLiveSndCmdImpl implements LiveTrackMeter {
	METER_INPUT meterInput;
	float level;
	int trackID;
	public LiveTrackMeterImpl() {
		super();
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newTrackID) {
		trackID = newTrackID;
	}

	public METER_INPUT getWhich() {
		return meterInput;
	}

	public void setWhich(METER_INPUT newWhich) {
		meterInput = newWhich;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float newLevel) {
		level = newLevel;
	}

} //LiveTrackMeterImpl
