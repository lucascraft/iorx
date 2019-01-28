/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Track Solo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveTrackSolo#getTrackID <em>Track ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveTrackSolo#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTrackSolo()
 * @model
 * @generated
 */
public interface LiveTrackSolo extends AbletonLiveSndCmd {
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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTrackSolo_TrackID()
	 * @model
	 * @generated
	 */
	int getTrackID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveTrackSolo#getTrackID <em>Track ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track ID</em>' attribute.
	 * @see #getTrackID()
	 * @generated
	 */
	void setTrackID(int value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.ezableton.TRACK_SOLO_STATUS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see net.sf.smbt.ezableton.TRACK_SOLO_STATUS
	 * @see #setState(TRACK_SOLO_STATUS)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTrackSolo_State()
	 * @model
	 * @generated
	 */
	TRACK_SOLO_STATUS getState();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveTrackSolo#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see net.sf.smbt.ezableton.TRACK_SOLO_STATUS
	 * @see #getState()
	 * @generated
	 */
	void setState(TRACK_SOLO_STATUS value);

} // LiveTrackSolo
