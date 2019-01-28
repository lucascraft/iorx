/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Return Meter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveReturnMeter#getTrackID <em>Track ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveReturnMeter#getLevel <em>Level</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveReturnMeter#getWhich <em>Which</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveReturnMeter()
 * @model
 * @generated
 */
public interface LiveReturnMeter extends AbletonLiveSndCmd {
	/**
	 * Returns the value of the '<em><b>Track ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Track ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Track ID</em>' attribute.
	 * @see #setTrackID(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveReturnMeter_TrackID()
	 * @model
	 * @generated
	 */
	int getTrackID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveReturnMeter#getTrackID <em>Track ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track ID</em>' attribute.
	 * @see #getTrackID()
	 * @generated
	 */
	void setTrackID(int value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(float)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveReturnMeter_Level()
	 * @model
	 * @generated
	 */
	float getLevel();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveReturnMeter#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(float value);

	/**
	 * Returns the value of the '<em><b>Which</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.ezableton.METER_INPUT}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Which</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Which</em>' attribute.
	 * @see net.sf.smbt.ezableton.METER_INPUT
	 * @see #setWhich(METER_INPUT)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveReturnMeter_Which()
	 * @model
	 * @generated
	 */
	METER_INPUT getWhich();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveReturnMeter#getWhich <em>Which</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Which</em>' attribute.
	 * @see net.sf.smbt.ezableton.METER_INPUT
	 * @see #getWhich()
	 * @generated
	 */
	void setWhich(METER_INPUT value);

} // LiveReturnMeter
