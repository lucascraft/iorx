/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.mdl.arduino.Processor#getFreq <em>Freq</em>}</li>
 *   <li>{@link net.sf.smbt.mdl.arduino.Processor#getProc <em>Proc</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getProcessor()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Processor {
	/**
	 * Returns the value of the '<em><b>Freq</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Freq</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Freq</em>' attribute.
	 * @see #setFreq(int)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getProcessor_Freq()
	 * @model
	 * @generated
	 */
	int getFreq();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.Processor#getFreq <em>Freq</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Freq</em>' attribute.
	 * @see #getFreq()
	 * @generated
	 */
	void setFreq(int value);

	/**
	 * Returns the value of the '<em><b>Proc</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.smbt.mdl.arduino.BOARD_KIND}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proc</em>' attribute.
	 * @see net.sf.smbt.mdl.arduino.BOARD_KIND
	 * @see #setProc(BOARD_KIND)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getProcessor_Proc()
	 * @model
	 * @generated
	 */
	BOARD_KIND getProc();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.Processor#getProc <em>Proc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proc</em>' attribute.
	 * @see net.sf.smbt.mdl.arduino.BOARD_KIND
	 * @see #getProc()
	 * @generated
	 */
	void setProc(BOARD_KIND value);

} // Processor
