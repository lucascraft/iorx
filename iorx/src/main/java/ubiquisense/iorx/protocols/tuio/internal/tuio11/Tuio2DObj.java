package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import ubiquisense.iorx.protocols.osc.internal.OscRcvCmd;
import ubiquisense.iorx.protocols.tuio.TuioObject;

public interface Tuio2DObj extends OscRcvCmd {

	long getS_id();
	void setS_id(long value);
	int getF_id();
	void setF_id(int value);
	float getXpos();
	void setXpos(float value);
	float getYpos();
	void setYpos(float value);
	float getAngle();
	void setAngle(float value);
	float getXspeed();
	void setXspeed(float value);
	float getYspeed();
	void setYspeed(float value);
	float getRspeed();
	void setRspeed(float value);
	float getMaccel();
	void setMaccel(float value);
	float getRaccel();
	void setRaccel(float value);
	TuioObject getTuioObject();
	void setTuioObject(TuioObject value);
	long getUpdateTime();
	void setUpdateTime(long value);
	STATE getState();
	void setState(STATE value);
} // Tuio2DObj
