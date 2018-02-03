/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DObj#getTuioObject <em>Tuio Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuio Object</em>' attribute.
	 * @see #getTuioObject()
	 * @generated
	 */
	void setTuioObject(TuioObject value);

	/**
	 * Returns the value of the '<em><b>Update Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Time</em>' attribute.
	 * @see #setUpdateTime(long)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DObj_UpdateTime()
	 * @model
	 * @generated
	 */
	long getUpdateTime();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DObj#getUpdateTime <em>Update Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Time</em>' attribute.
	 * @see #getUpdateTime()
	 * @generated
	 */
	void setUpdateTime(long value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.osc.eztuio.STATE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see net.sf.smbt.osc.eztuio.STATE
	 * @see #setState(STATE)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DObj_State()
	 * @model
	 * @generated
	 */
	STATE getState();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DObj#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see net.sf.smbt.osc.eztuio.STATE
	 * @see #getState()
	 * @generated
	 */
	void setState(STATE value);
} // Tuio2DObj
