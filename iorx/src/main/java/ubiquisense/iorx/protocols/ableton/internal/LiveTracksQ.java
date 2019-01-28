/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Tracks Q</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveTracksQ#getNumTracks <em>Num Tracks</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTracksQ()
 * @model
 * @generated
 */
public interface LiveTracksQ extends AbletonLiveSndCmd {

	/**
	 * Returns the value of the '<em><b>Num Tracks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Tracks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Tracks</em>' attribute.
	 * @see #setNumTracks(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveTracksQ_NumTracks()
	 * @model
	 * @generated
	 */
	int getNumTracks();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveTracksQ#getNumTracks <em>Num Tracks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Tracks</em>' attribute.
	 * @see #getNumTracks()
	 * @generated
	 */
	void setNumTracks(int value);
} // LiveTracksQ
