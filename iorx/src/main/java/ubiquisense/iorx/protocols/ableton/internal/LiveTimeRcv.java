/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Time Rcv</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveTimeRcv#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTimeRcv()
 * @model
 * @generated
 */
public interface LiveTimeRcv extends AbletonLiveSndCmd {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(float)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTimeRcv_Time()
	 * @model
	 * @generated
	 */
	float getTime();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveTimeRcv#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(float value);

} // LiveTimeRcv
