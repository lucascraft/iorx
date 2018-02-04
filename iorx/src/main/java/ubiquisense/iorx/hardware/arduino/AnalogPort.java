/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analog Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.mdl.arduino.AnalogPort#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getAnalogPort()
 * @model
 * @generated
 */
public interface AnalogPort extends Port {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getAnalogPort_Value()
	 * @model transient="true"
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link net.sf.smbt.mdl.arduino.AnalogPort#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);
} // AnalogPort
