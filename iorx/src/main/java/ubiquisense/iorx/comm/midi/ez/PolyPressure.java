/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Poly Pressure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.PolyPressure#getNote <em>Note</em>}</li>
 *   <li>{@link net.sf.smbt.midi.ezmidi.PolyPressure#getPressure <em>Pressure</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getPolyPressure()
 * @model
 * @generated
 */
public interface PolyPressure extends DSLMidiMessage {

	/**
	 * Returns the value of the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' attribute.
	 * @see #setNote(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getPolyPressure_Note()
	 * @model
	 * @generated
	 */
	int getNote();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.PolyPressure#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(int value);

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
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getPolyPressure_Pressure()
	 * @model
	 * @generated
	 */
	int getPressure();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.PolyPressure#getPressure <em>Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pressure</em>' attribute.
	 * @see #getPressure()
	 * @generated
	 */
	void setPressure(int value);
} // PolyPressure
