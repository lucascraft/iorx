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

	public int getValue() {
		return value;
	}

	public void setValue(int newValue) {
		value = newValue;
	}

} //DigitalPortImpl
