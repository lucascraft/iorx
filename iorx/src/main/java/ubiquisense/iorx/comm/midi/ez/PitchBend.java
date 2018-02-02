/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pitch Bend</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.PitchBend#getBend <em>Bend</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getPitchBend()
 * @model
 * @generated
 */
public interface PitchBend extends DSLMidiMessage {

	/**
	 * Returns the value of the '<em><b>Bend</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bend</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bend</em>' attribute.
	 * @see #setBend(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getPitchBend_Bend()
	 * @model
	 * @generated
	 */
	int getBend();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.PitchBend#getBend <em>Bend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bend</em>' attribute.
	 * @see #getBend()
	 * @generated
	 */
	void setBend(int value);
} // PitchBend
