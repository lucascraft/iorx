/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11.impl;

import ubiquisense.iorx.protocols.osc.internal.impl.OscRcvCmdImpl;
import ubiquisense.iorx.protocols.tuio.TuioObject;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.STATE;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.Tuio2DObj;

public class Tuio2DObjImpl extends OscRcvCmdImpl implements Tuio2DObj {
	STATE state;
	TuioObject tuoiObj;
	long S_id;
	int F_id;
	float XPos;
	float YPos;
	float ZPos;
	float angle;
	float XSpeed;
	float YSpeed;
	float ZSpeed;
	float RSpeed;
	float RAccel;
	float mAccel;
	long updateTime;
	
	public long getS_id() {
		return S_id;
	}

	
	public void setS_id(long newS_id) {
		S_id = newS_id;
	}

	public int getF_id() {
		return F_id;
	}

	
	public void setF_id(int newF_id) {
		F_id = newF_id;
	}


	public float getXpos() {
		return XPos;
	}

	
	public void setXpos(float newXpos) {
		XPos = newXpos;
	}


	public float getYpos() {
		return YPos ;
	}

	
	public void setYpos(float newYpos) {
		YPos = newYpos;
	}

	
	public float getAngle() {
		return angle;
	}

	
	public void setAngle(float newAngle) {
		angle = newAngle;
	}

	
	public float getXspeed() {
		return XSpeed;
	}

	
	public void setXspeed(float newXspeed) {
		XSpeed = newXspeed;
	}

	
	public float getYspeed() {
		return YSpeed;
	}

	public void setYspeed(float newYspeed) {
		
	}

	public float getRspeed() {
		return RSpeed;
	}

	public void setRspeed(float newRspeed) {
		RSpeed = newRspeed;
	}

	public float getMaccel() {
		return mAccel;
	}

	public void setMaccel(float newMaccel) {
	}

	public float getRaccel() {
		return RAccel;
	}

	public void setRaccel(float newRaccel) {
		RAccel = newRaccel;
	}

	public TuioObject getTuioObject() {
		return tuoiObj;
	}

	public void setTuioObject(TuioObject newTuioObject) {
		tuoiObj = newTuioObject;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long newUpdateTime) {
		updateTime = newUpdateTime;
	}

	public STATE getState() {
		return state;
	}

	public void setState(STATE newState) {
		state = newState;
	}

} //Tuio2DObjImpl
