/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ARDUINO STATUS MODE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_STATUS_MODE()
 * @model
 * @generated
 */
public enum ARDUINO_STATUS_MODE  {

	CONNECTED(1, "CONNECTED", "Connected"),


	DISCONNECTED(0, "DISCONNECTED", "Disconnected"),

	
	TRANSMITTING(2, "TRANSMITTING", "Transmitting");

	public static final int CONNECTED_VALUE = 1;

	public static final int DISCONNECTED_VALUE = 0;


	public static final int TRANSMITTING_VALUE = 2;


	private static final ARDUINO_STATUS_MODE[] VALUES_ARRAY =
		new ARDUINO_STATUS_MODE[] {
			CONNECTED,
			DISCONNECTED,
			TRANSMITTING,
		};


	public static final List<ARDUINO_STATUS_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));


	public static ARDUINO_STATUS_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_STATUS_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}


	public static ARDUINO_STATUS_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_STATUS_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_STATUS_MODE get(int value) {
		switch (value) {
			case CONNECTED_VALUE: return CONNECTED;
			case DISCONNECTED_VALUE: return DISCONNECTED;
			case TRANSMITTING_VALUE: return TRANSMITTING;
		}
		return null;
	}

	
	private final int value;

	private final String name;

	private final String literal;

	private ARDUINO_STATUS_MODE(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	public int getValue() {
	  return value;
	}

	public String getName() {
	  return name;
	}

	public String getLiteral() {
	  return literal;
	}

	@Override
	public String toString() {
		return literal;
	}
	
} //ARDUINO_STATUS_MODE
