/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino.impl;

import ubiquisense.iorx.hardware.arduino.DigitalPort;



public class DigitalPortImpl extends PortImpl implements DigitalPort {
	
	int value;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		value = newValue;
	}

} //DigitalPortImpl
