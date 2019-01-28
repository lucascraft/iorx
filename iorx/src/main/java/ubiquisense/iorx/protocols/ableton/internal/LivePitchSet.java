/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Pitch Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LivePitchSet#getTrackID <em>Track ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LivePitchSet#getClip <em>Clip</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LivePitchSet#getCoarse <em>Coarse</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LivePitchSet#getFine <em>Fine</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePitchSet()
 * @model
 * @generated
 */
public interface LivePitchSet extends AbletonLiveSndCmd {
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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePitchSet_TrackID()
	 * @model
	 * @generated
	 */
	int getTrackID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LivePitchSet#getTrackID <em>Track ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track ID</em>' attribute.
	 * @see #getTrackID()
	 * @generated
	 */
	void setTrackID(int value);

	/**
	 * Returns the value of the '<em><b>Clip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clip</em>' attribute.
	 * @see #setClip(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePitchSet_Clip()
	 * @model
	 * @generated
	 */
	int getClip();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LivePitchSet#getClip <em>Clip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clip</em>' attribute.
	 * @see #getClip()
	 * @generated
	 */
	void setClip(int value);

	/**
	 * Returns the value of the '<em><b>Coarse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coarse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coarse</em>' attribute.
	 * @see #setCoarse(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePitchSet_Coarse()
	 * @model
	 * @generated
	 */
	int getCoarse();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LivePitchSet#getCoarse <em>Coarse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coarse</em>' attribute.
	 * @see #getCoarse()
	 * @generated
	 */
	void setCoarse(int value);

	/**
	 * Returns the value of the '<em><b>Fine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fine</em>' attribute.
	 * @see #setFine(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePitchSet_Fine()
	 * @model
	 * @generated
	 */
	int getFine();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LivePitchSet#getFine <em>Fine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fine</em>' attribute.
	 * @see #getFine()
	 * @generated
	 */
	void setFine(int value);

} // LivePitchSet
