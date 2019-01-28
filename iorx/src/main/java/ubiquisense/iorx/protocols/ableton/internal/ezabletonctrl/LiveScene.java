/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Scene</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezabletonctrl.LiveScene#getSceneID <em>Scene ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezabletonctrl.LiveScene#getMode <em>Mode</em>}</li>
 *   <li>{@link net.sf.smbt.ezabletonctrl.LiveScene#getSceneName <em>Scene Name</em>}</li>
 *   <li>{@link net.sf.smbt.ezabletonctrl.LiveScene#getLastSeen <em>Last Seen</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveScene()
 * @model
 * @generated
 */
public interface LiveScene {
	/**
	 * Returns the value of the '<em><b>Scene ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scene ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scene ID</em>' attribute.
	 * @see #setSceneID(int)
	 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveScene_SceneID()
	 * @model
	 * @generated
	 */
	int getSceneID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezabletonctrl.LiveScene#getSceneID <em>Scene ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene ID</em>' attribute.
	 * @see #getSceneID()
	 * @generated
	 */
	void setSceneID(int value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveScene_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezabletonctrl.LiveScene#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Returns the value of the '<em><b>Scene Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scene Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scene Name</em>' attribute.
	 * @see #setSceneName(String)
	 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveScene_SceneName()
	 * @model
	 * @generated
	 */
	String getSceneName();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezabletonctrl.LiveScene#getSceneName <em>Scene Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene Name</em>' attribute.
	 * @see #getSceneName()
	 * @generated
	 */
	void setSceneName(String value);

	/**
	 * Returns the value of the '<em><b>Last Seen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Seen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Seen</em>' attribute.
	 * @see #setLastSeen(long)
	 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getLiveScene_LastSeen()
	 * @model
	 * @generated
	 */
	long getLastSeen();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezabletonctrl.LiveScene#getLastSeen <em>Last Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Seen</em>' attribute.
	 * @see #getLastSeen()
	 * @generated
	 */
	void setLastSeen(long value);

} // LiveScene
