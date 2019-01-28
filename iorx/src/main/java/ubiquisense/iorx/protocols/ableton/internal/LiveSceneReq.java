/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Scene Req</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveSceneReq#getMode <em>Mode</em>}</li>
 *   <li>{@link net.sf.smbt.ezableton.LiveSceneReq#getSceneID <em>Scene ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveSceneReq()
 * @model
 * @generated
 */
public interface LiveSceneReq extends AbletonLiveSndCmd {
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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveSceneReq_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveSceneReq#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveSceneReq_SceneID()
	 * @model
	 * @generated
	 */
	int getSceneID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveSceneReq#getSceneID <em>Scene ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene ID</em>' attribute.
	 * @see #getSceneID()
	 * @generated
	 */
	void setSceneID(int value);

} // LiveSceneReq
