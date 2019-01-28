/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Scene</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveScene#getSceneID <em>Scene ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveScene()
 * @model
 * @generated
 */
public interface LiveScene extends AbletonLiveSndCmd {
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
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveScene_SceneID()
	 * @model
	 * @generated
	 */
	int getSceneID();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveScene#getSceneID <em>Scene ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scene ID</em>' attribute.
	 * @see #getSceneID()
	 * @generated
	 */
	void setSceneID(int value);

} // LiveScene
