/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Scenes Q</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.ezableton.LiveScenesQ#getNumScenes <em>Num Scenes</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveScenesQ()
 * @model
 * @generated
 */
public interface LiveScenesQ extends AbletonLiveSndCmd {

	/**
	 * Returns the value of the '<em><b>Num Scenes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Scenes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Scenes</em>' attribute.
	 * @see #setNumScenes(int)
	 * @see net.sf.smbt.ezableton.EzabletonPackage#getLiveScenesQ_NumScenes()
	 * @model
	 * @generated
	 */
	int getNumScenes();

	/**
	 * Sets the value of the '{@link net.sf.smbt.ezableton.LiveScenesQ#getNumScenes <em>Num Scenes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Scenes</em>' attribute.
	 * @see #getNumScenes()
	 * @generated
	 */
	void setNumScenes(int value);
} // LiveScenesQ
