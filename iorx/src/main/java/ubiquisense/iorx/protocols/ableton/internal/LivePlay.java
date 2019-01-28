/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Play</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LivePlay#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePlay()
 * @model
 * @generated
 */
public interface LivePlay extends AbletonLiveSndCmd {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.ezableton.PLAY_STATUS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see net.sf.smbt.ezableton.PLAY_STATUS
	 * @see #setStatus(PLAY_STATUS)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLivePlay_Status()
	 * @model
	 * @generated
	 */
	PLAY_STATUS getStatus();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LivePlay#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see net.sf.smbt.ezableton.PLAY_STATUS
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(PLAY_STATUS value);

} // LivePlay
