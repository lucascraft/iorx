/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveMasterMeter extends AbletonLiveSndCmd {
	float getLevel();
	void setLevel(float value);
	METER_INPUT getWhich();
	void setWhich(METER_INPUT value);

} // LiveMasterMeter
