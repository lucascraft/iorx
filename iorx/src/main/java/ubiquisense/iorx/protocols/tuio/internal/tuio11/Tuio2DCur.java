/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import ubiquisense.iorx.protocols.osc.internal.OscRcvCmd;
import ubiquisense.iorx.protocols.tuio.TuioCursor;

public interface Tuio2DCur extends OscRcvCmd {

	long getS_id();
	void setS_id(long value);
	float getXpos();
	void setXpos(float value);
	float getYpos();
	void setYpos(float value);
	float getXspeed();
	void setXspeed(float value);
	float getYspeed();
	void setYspeed(float value);
	float getMaccel();
	void setMaccel(float value);
	TuioCursor getTuioCursor();
	void setTuioCursor(TuioCursor value);
	long getUpdateTime();
	void setUpdateTime(long value);
	STATE getState();
	void setState(STATE value);
} // Tuio2DCur
