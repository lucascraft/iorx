/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Track View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezabletonctrl.LiveTrackView#getDevice <em>Device</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveTrackView()
 * @model
 * @generated
 */
public interface LiveTrackView  {
	/**
	 * Returns the value of the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' reference.
	 * @see #setDevice(AbstractLiveDevice)
	 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveTrackView_Device()
	 * @model
	 * @generated
	 */
	AbstractLiveDevice getDevice();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezabletonctrl.LiveTrackView#getDevice <em>Device</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(AbstractLiveDevice value);

} // LiveTrackView
