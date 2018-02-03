/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11.impl;

import ubiquisense.iorx.protocols.osc.internal.impl.OscRcvCmdImpl;
import ubiquisense.iorx.protocols.tuio.TuioCursor;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.STATE;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.Tuio2DCur;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tuio2
 * DCur</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getS_id
 * <em>Sid</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getXpos
 * <em>Xpos</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getYpos
 * <em>Ypos</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getXspeed
 * <em>Xspeed</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getYspeed
 * <em>Yspeed</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getMaccel
 * <em>Maccel</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getTuioCursor <em>Tuio
 * Cursor</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getUpdateTime <em>Update
 * Time</em>}</li>
 * <li>{@link net.sf.smbt.osc.eztuio.impl.Tuio2DCurImpl#getState
 * <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Tuio2DCurImpl extends OscRcvCmdImpl implements Tuio2DCur {
	TuioCursor tuioCursor;
	STATE state;
	long S_id;
	float XPos;
	float YPos;
	float XSpeed;
	float YSpeed;
	float mAccel;
	long updateTime;

	public long getS_id() {
		return S_id;
	}

	public void setS_id(long newS_id) {
		S_id = newS_id;
	}

	public float getXpos() {
		return XPos;
	}

	public void setXpos(float newXpos) {
		XPos = newXpos;
	}

	public float getYpos() {
		return YPos;
	}

	public void setYpos(float newYpos) {
		YPos = newYpos;
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

	public float getMaccel() {
		return mAccel;
	}

	public void setMaccel(float newMaccel) {
		mAccel = newMaccel;
	}

	public TuioCursor getTuioCursor() {
		return tuioCursor;
	}

	public void setTuioCursor(TuioCursor newTuioCursor) {

	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long newUpdateTime) {
	}

	public STATE getState() {
		return state;
	}

	public void setState(STATE newState) {
		state = newState;
	}

} // Tuio2DCurImpl
