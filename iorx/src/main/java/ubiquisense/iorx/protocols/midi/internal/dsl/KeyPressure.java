/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Pressure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.KeyPressure#getKey <em>Key</em>}</li>
 *   <li>{@link net.sf.smbt.midi.ezmidi.KeyPressure#getPressure <em>Pressure</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getKeyPressure()
 * @model
 * @generated
 */
public interface KeyPressure extends DSLMidiMessage {

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getKeyPressure_Key()
	 * @model
	 * @generated
	 */
	int getKey();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.KeyPressure#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(int value);

	/**
	 * Returns the value of the '<em><b>Pressure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pressure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pressure</em>' attribute.
	 * @see #setPressure(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getKeyPressure_Pressure()
	 * @model
	 * @generated
	 */
	int getPressure();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.KeyPressure#getPressure <em>Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure</em>' attribute.
	 * @see #getPressure()
	 * @generated
	 */
	void setPressure(int value);
} // KeyPressure
