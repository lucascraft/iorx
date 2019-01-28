/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Name Scene Req</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameSceneReq#getSceneID <em>Scene ID</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveNameSceneReq#getSceneName <em>Scene Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameSceneReq()
 * @model
 * @generated
 */
public interface LiveNameSceneReq extends AbletonLiveSndCmd {
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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameSceneReq_SceneID()
	 * @model
	 * @generated
	 */
	int getSceneID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameSceneReq#getSceneID <em>Scene ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene ID</em>' attribute.
	 * @see #getSceneID()
	 * @generated
	 */
	void setSceneID(int value);

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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveNameSceneReq_SceneName()
	 * @model
	 * @generated
	 */
	String getSceneName();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveNameSceneReq#getSceneName <em>Scene Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene Name</em>' attribute.
	 * @see #getSceneName()
	 * @generated
	 */
	void setSceneName(String value);

} // LiveNameSceneReq
