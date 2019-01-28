/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Name Track Req</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameTrackReq#getTrackName <em>Track Name</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameTrackReq#getColor <em>Color</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameTrackReq#getTrackID <em>Track ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameTrackReq()
 * @model
 * @generated
 */
public interface LiveNameTrackReq extends AbletonLiveSndCmd {
	/**
	 * Returns the value of the '<em><b>Track Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Track Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Track Name</em>' attribute.
	 * @see #setTrackName(String)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameTrackReq_TrackName()
	 * @model
	 * @generated
	 */
	String getTrackName();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameTrackReq#getTrackName <em>Track Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track Name</em>' attribute.
	 * @see #getTrackName()
	 * @generated
	 */
	void setTrackName(String value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameTrackReq_Color()
	 * @model
	 * @generated
	 */
	int getColor();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameTrackReq#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(int value);

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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameTrackReq_TrackID()
	 * @model
	 * @generated
	 */
	int getTrackID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameTrackReq#getTrackID <em>Track ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track ID</em>' attribute.
	 * @see #getTrackID()
	 * @generated
	 */
	void setTrackID(int value);

} // LiveNameTrackReq
