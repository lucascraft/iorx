/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveMasterMeter;
import ubiquisense.iorx.protocols.ableton.internal.METER_INPUT;

public class LiveMasterMeterImpl extends AbletonLiveSndCmdImpl implements LiveMasterMeter {
	float level;
	METER_INPUT meterInput;
	public LiveMasterMeterImpl() {
		super();
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

} //LiveMasterMeterImpl
