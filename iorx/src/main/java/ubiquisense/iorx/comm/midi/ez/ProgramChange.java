/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.ProgramChange#getPreset <em>Preset</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getProgramChange()
 * @model
 * @generated
 */
public interface ProgramChange extends DSLMidiMessage {

	/**
	 * Returns the value of the '<em><b>Preset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preset</em>' attribute.
	 * @see #setPreset(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getProgramChange_Preset()
	 * @model
	 * @generated
	 */
	int getPreset();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.ProgramChange#getPreset <em>Preset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preset</em>' attribute.
	 * @see #getPreset()
	 * @generated
	 */
	void setPreset(int value);
} // ProgramChange
