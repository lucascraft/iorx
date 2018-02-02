/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Song Select</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.SongSelect#getSongNumber <em>Song Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getSongSelect()
 * @model
 * @generated
 */
public interface SongSelect extends DSLMidiMessage {

	/**
	 * Returns the value of the '<em><b>Song Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Song Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Song Number</em>' attribute.
	 * @see #setSongNumber(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getSongSelect_SongNumber()
	 * @model
	 * @generated
	 */
	int getSongNumber();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.SongSelect#getSongNumber <em>Song Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Song Number</em>' attribute.
	 * @see #getSongNumber()
	 * @generated
	 */
	void setSongNumber(int value);
} // SongSelect
