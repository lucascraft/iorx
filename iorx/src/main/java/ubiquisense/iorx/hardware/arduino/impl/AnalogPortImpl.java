/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino.impl;

import ubiquisense.iorx.hardware.arduino.AnalogPort;


public class AnalogPortImpl extends PortImpl implements AnalogPort {

	
	float value;
	public float getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(float newValue) {
		value = newValue;
	}

} //AnalogPortImpl
