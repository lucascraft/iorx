/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unofficial Bus Select</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.midi.ezmidi.UnofficialBusSelect#getBusNumber <em>Bus Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getUnofficialBusSelect()
 * @model
 * @generated
 */
public interface UnofficialBusSelect extends DSLMidiMessage {

	/**
	 * Returns the value of the '<em><b>Bus Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bus Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus Number</em>' attribute.
	 * @see #setBusNumber(int)
	 * @see net.sf.smbt.midi.ezmidi.EzmidiPackage#getUnofficialBusSelect_BusNumber()
	 * @model
	 * @generated
	 */
	int getBusNumber();

	/**
	 * Sets the value of the '{@link net.sf.smbt.midi.ezmidi.UnofficialBusSelect#getBusNumber <em>Bus Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Number</em>' attribute.
	 * @see #getBusNumber()
	 * @generated
	 */
	void setBusNumber(int value);
} // UnofficialBusSelect
