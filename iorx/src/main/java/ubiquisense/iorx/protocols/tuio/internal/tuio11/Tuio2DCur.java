/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import ubiquisense.iorx.protocols.osc.internal.OscRcvCmd;
import ubiquisense.iorx.protocols.tuio.TuioCursor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuio2 DCur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getS_id <em>Sid</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getXpos <em>Xpos</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getYpos <em>Ypos</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getXspeed <em>Xspeed</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getYspeed <em>Yspeed</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getMaccel <em>Maccel</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getTuioCursor <em>Tuio Cursor</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getUpdateTime <em>Update Time</em>}</li>
 *   <li>{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur()
 * @model
 * @generated
 */
public interface Tuio2DCur extends OscRcvCmd {

	/**
	 * Returns the value of the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sid</em>' attribute.
	 * @see #setS_id(long)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_S_id()
	 * @model
	 * @generated
	 */
	long getS_id();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getS_id <em>Sid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sid</em>' attribute.
	 * @see #getS_id()
	 * @generated
	 */
	void setS_id(long value);

	/**
	 * Returns the value of the '<em><b>Xpos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xpos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xpos</em>' attribute.
	 * @see #setXpos(float)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_Xpos()
	 * @model
	 * @generated
	 */
	float getXpos();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getXpos <em>Xpos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xpos</em>' attribute.
	 * @see #getXpos()
	 * @generated
	 */
	void setXpos(float value);

	/**
	 * Returns the value of the '<em><b>Ypos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ypos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ypos</em>' attribute.
	 * @see #setYpos(float)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_Ypos()
	 * @model
	 * @generated
	 */
	float getYpos();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getYpos <em>Ypos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ypos</em>' attribute.
	 * @see #getYpos()
	 * @generated
	 */
	void setYpos(float value);

	/**
	 * Returns the value of the '<em><b>Xspeed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xspeed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xspeed</em>' attribute.
	 * @see #setXspeed(float)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_Xspeed()
	 * @model
	 * @generated
	 */
	float getXspeed();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getXspeed <em>Xspeed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xspeed</em>' attribute.
	 * @see #getXspeed()
	 * @generated
	 */
	void setXspeed(float value);

	/**
	 * Returns the value of the '<em><b>Yspeed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yspeed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yspeed</em>' attribute.
	 * @see #setYspeed(float)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_Yspeed()
	 * @model
	 * @generated
	 */
	float getYspeed();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getYspeed <em>Yspeed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yspeed</em>' attribute.
	 * @see #getYspeed()
	 * @generated
	 */
	void setYspeed(float value);

	/**
	 * Returns the value of the '<em><b>Maccel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maccel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maccel</em>' attribute.
	 * @see #setMaccel(float)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_Maccel()
	 * @model
	 * @generated
	 */
	float getMaccel();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getMaccel <em>Maccel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maccel</em>' attribute.
	 * @see #getMaccel()
	 * @generated
	 */
	void setMaccel(float value);

	/**
	 * Returns the value of the '<em><b>Tuio Cursor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuio Cursor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuio Cursor</em>' attribute.
	 * @see #setTuioCursor(TuioCursor)
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_TuioCursor()
	 * @model dataType="net.sf.smbt.osc.eztuio.TuioCursor"
	 * @generated
	 */
	TuioCursor getTuioCursor();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getTuioCursor <em>Tuio Cursor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuio Cursor</em>' attribute.
	 * @see #getTuioCursor()
	 * @generated
	 */
	void setTuioCursor(TuioCursor value);

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
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_UpdateTime()
	 * @model
	 * @generated
	 */
	long getUpdateTime();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getUpdateTime <em>Update Time</em>}' attribute.
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
	 * @see net.sf.smbt.osc.eztuio.EztuioPackage#getTuio2DCur_State()
	 * @model
	 * @generated
	 */
	STATE getState();

	/**
	 * Sets the value of the '{@link net.sf.smbt.osc.eztuio.Tuio2DCur#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see net.sf.smbt.osc.eztuio.STATE
	 * @see #getState()
	 * @generated
	 */
	void setState(STATE value);
} // Tuio2DCur
