/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSL Midi Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.DSLMidiMessage#getChannel <em>Channel</em>}</li>
 *   <li>{@link net.sf.smbt.midi.ezmidi.DSLMidiMessage#getCmd <em>Cmd</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getDSLMidiMessage()
 * @model
 * @generated
 */
public interface DSLMidiMessage extends AbstractMidiCmd {

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' attribute.
	 * @see #setChannel(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getDSLMidiMessage_Channel()
	 * @model
	 * @generated
	 */
	int getChannel();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.DSLMidiMessage#getChannel <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' attribute.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(int value);

	/**
	 * Returns the value of the '<em><b>Cmd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cmd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cmd</em>' attribute.
	 * @see #setCmd(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getDSLMidiMessage_Cmd()
	 * @model
	 * @generated
	 */
	int getCmd();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.DSLMidiMessage#getCmd <em>Cmd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cmd</em>' attribute.
	 * @see #getCmd()
	 * @generated
	 */
	void setCmd(int value);
} // DSLMidiMessage
