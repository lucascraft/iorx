/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Name Clipblockreq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getTrackID <em>Track ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getClipID <em>Clip ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getSizeX <em>Size X</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getSizeY <em>Size Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameClipblockreq()
 * @model
 * @generated
 */
public interface LiveNameClipblockreq extends AbletonLiveSndCmd {
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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameClipblockreq_TrackID()
	 * @model
	 * @generated
	 */
	int getTrackID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getTrackID <em>Track ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Track ID</em>' attribute.
	 * @see #getTrackID()
	 * @generated
	 */
	void setTrackID(int value);

	/**
	 * Returns the value of the '<em><b>Clip ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clip ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clip ID</em>' attribute.
	 * @see #setClipID(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameClipblockreq_ClipID()
	 * @model
	 * @generated
	 */
	int getClipID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getClipID <em>Clip ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clip ID</em>' attribute.
	 * @see #getClipID()
	 * @generated
	 */
	void setClipID(int value);

	/**
	 * Returns the value of the '<em><b>Size X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size X</em>' attribute.
	 * @see #setSizeX(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameClipblockreq_SizeX()
	 * @model
	 * @generated
	 */
	int getSizeX();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getSizeX <em>Size X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size X</em>' attribute.
	 * @see #getSizeX()
	 * @generated
	 */
	void setSizeX(int value);

	/**
	 * Returns the value of the '<em><b>Size Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Y</em>' attribute.
	 * @see #setSizeY(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameClipblockreq_SizeY()
	 * @model
	 * @generated
	 */
	int getSizeY();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameClipblockreq#getSizeY <em>Size Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Y</em>' attribute.
	 * @see #getSizeY()
	 * @generated
	 */
	void setSizeY(int value);

} // LiveNameClipblockreq
