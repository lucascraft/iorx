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
 * A representation of the literals of the enumeration '<em><b>ARDUINO FIRMWARE MODE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_FIRMWARE_MODE()
 * @model
 * @generated
 */
public enum ARDUINO_FIRMWARE_MODE {

	ARDUINO_FIRMATA_V10(0, "ARDUINO_FIRMATA_V10", "Firmata 1.0"),


	ARDUINO_FIRMATA_V20(2, "ARDUINO_FIRMATA_V20", "Firmata 2.0"), 

	ARDUINO_FIRMATA_V11(1, "ARDUINO_FIRMATA_V11", "Firmata 1.1"),

	ARDUINO_FIRMATA_V23(18, "ARDUINO_FIRMATA_V23", "Firmata 2.3"), 

	ARDUINO_FIRMATA_V22(13, "ARDUINO_FIRMATA_V22", "Firmata 2.2"),

	ARDUINO_FIRMATA_V21(3, "ARDUINO_FIRMATA_V21", "Firmata 2.1"),

	ARDUINO_FIRMATA_V10_I2C(4, "ARDUINO_FIRMATA_V10_I2C", "Firmata I2C 1.0"),

	ARDUINO_FIRMATA_V11_I2C(5, "ARDUINO_FIRMATA_V11_I2C", "Firmata I2C 1.1"),

	ARDUINO_FIRMATA_V20_I2C(6, "ARDUINO_FIRMATA_V20_I2C", "Firmata I2C 2.0"),

	ARDUINO_FIRMATA_V23_I2C(17, "ARDUINO_FIRMATA_V23_I2C", "Firmata I2C 2.3"),

	ARDUINO_FIRMATA_V22_I2C(14, "ARDUINO_FIRMATA_V22_I2C", "Firmata I2C 2.2"),

	ARDUINO_FIRMATA_V21_I2C(7, "ARDUINO_FIRMATA_V21_I2C", "Firmata I2C 2.1"),

	ARDUINO_FIRMATA_V10_SERVO(8, "ARDUINO_FIRMATA_V10_SERVO", "Firmata Servo 1.0"),

	ARDUINO_FIRMATA_V20_SERVO(10, "ARDUINO_FIRMATA_V20_SERVO", "Firmata Servo 2.0"),

	ARDUINO_FIRMATA_V11_SERVO(9, "ARDUINO_FIRMATA_V11_SERVO", "Firmata Servo 1.1"),

	ARDUINO_FIRMATA_V23_SERVO(16, "ARDUINO_FIRMATA_V23_SERVO", "Firmata Servo 2.3"),

	ARDUINO_FIRMATA_V22_SERVO(15, "ARDUINO_FIRMATA_V22_SERVO", "Firmata Servo 2.2"),

	ARDUINO_FIRMATA_V21_SERVO(11, "ARDUINO_FIRMATA_V21_SERVO", "Firmata Servo 2.1"), 

	ARDUINO_DEFAULT(12, "ARDUINO_DEFAULT", "Firmata Default");

	public static final int ARDUINO_FIRMATA_V10_VALUE = 0;

	public static final int ARDUINO_FIRMATA_V20_VALUE = 2;
	
	public static final int ARDUINO_FIRMATA_V11_VALUE = 1;

	public static final int ARDUINO_FIRMATA_V23_VALUE = 18;


	public static final int ARDUINO_FIRMATA_V22_VALUE = 13;


	public static final int ARDUINO_FIRMATA_V21_VALUE = 3;


	public static final int ARDUINO_FIRMATA_V10_I2C_VALUE = 4;


	public static final int ARDUINO_FIRMATA_V11_I2C_VALUE = 5;


	public static final int ARDUINO_FIRMATA_V20_I2C_VALUE = 6;

	public static final int ARDUINO_FIRMATA_V23_I2C_VALUE = 17;


	public static final int ARDUINO_FIRMATA_V22_I2C_VALUE = 14;


	public static final int ARDUINO_FIRMATA_V21_I2C_VALUE = 7;


	public static final int ARDUINO_FIRMATA_V10_SERVO_VALUE = 8;


	public static final int ARDUINO_FIRMATA_V20_SERVO_VALUE = 10;


	public static final int ARDUINO_FIRMATA_V11_SERVO_VALUE = 9;


	public static final int ARDUINO_FIRMATA_V23_SERVO_VALUE = 16;


	public static final int ARDUINO_FIRMATA_V22_SERVO_VALUE = 15;


	public static final int ARDUINO_FIRMATA_V21_SERVO_VALUE = 11;


	public static final int ARDUINO_DEFAULT_VALUE = 12;


	private static final ARDUINO_FIRMWARE_MODE[] VALUES_ARRAY =
		new ARDUINO_FIRMWARE_MODE[] {
			ARDUINO_FIRMATA_V10,
			ARDUINO_FIRMATA_V20,
			ARDUINO_FIRMATA_V11,
			ARDUINO_FIRMATA_V23,
			ARDUINO_FIRMATA_V22,
			ARDUINO_FIRMATA_V21,
			ARDUINO_FIRMATA_V10_I2C,
			ARDUINO_FIRMATA_V11_I2C,
			ARDUINO_FIRMATA_V20_I2C,
			ARDUINO_FIRMATA_V23_I2C,
			ARDUINO_FIRMATA_V22_I2C,
			ARDUINO_FIRMATA_V21_I2C,
			ARDUINO_FIRMATA_V10_SERVO,
			ARDUINO_FIRMATA_V20_SERVO,
			ARDUINO_FIRMATA_V11_SERVO,
			ARDUINO_FIRMATA_V23_SERVO,
			ARDUINO_FIRMATA_V22_SERVO,
			ARDUINO_FIRMATA_V21_SERVO,
			ARDUINO_DEFAULT,
		};


	public static final List<ARDUINO_FIRMWARE_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));


	public static ARDUINO_FIRMWARE_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_FIRMWARE_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}


	public static ARDUINO_FIRMWARE_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_FIRMWARE_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_FIRMWARE_MODE get(int value) {
		switch (value) {
			case ARDUINO_FIRMATA_V10_VALUE: return ARDUINO_FIRMATA_V10;
			case ARDUINO_FIRMATA_V20_VALUE: return ARDUINO_FIRMATA_V20;
			case ARDUINO_FIRMATA_V11_VALUE: return ARDUINO_FIRMATA_V11;
			case ARDUINO_FIRMATA_V23_VALUE: return ARDUINO_FIRMATA_V23;
			case ARDUINO_FIRMATA_V22_VALUE: return ARDUINO_FIRMATA_V22;
			case ARDUINO_FIRMATA_V21_VALUE: return ARDUINO_FIRMATA_V21;
			case ARDUINO_FIRMATA_V10_I2C_VALUE: return ARDUINO_FIRMATA_V10_I2C;
			case ARDUINO_FIRMATA_V11_I2C_VALUE: return ARDUINO_FIRMATA_V11_I2C;
			case ARDUINO_FIRMATA_V20_I2C_VALUE: return ARDUINO_FIRMATA_V20_I2C;
			case ARDUINO_FIRMATA_V23_I2C_VALUE: return ARDUINO_FIRMATA_V23_I2C;
			case ARDUINO_FIRMATA_V22_I2C_VALUE: return ARDUINO_FIRMATA_V22_I2C;
			case ARDUINO_FIRMATA_V21_I2C_VALUE: return ARDUINO_FIRMATA_V21_I2C;
			case ARDUINO_FIRMATA_V10_SERVO_VALUE: return ARDUINO_FIRMATA_V10_SERVO;
			case ARDUINO_FIRMATA_V20_SERVO_VALUE: return ARDUINO_FIRMATA_V20_SERVO;
			case ARDUINO_FIRMATA_V11_SERVO_VALUE: return ARDUINO_FIRMATA_V11_SERVO;
			case ARDUINO_FIRMATA_V23_SERVO_VALUE: return ARDUINO_FIRMATA_V23_SERVO;
			case ARDUINO_FIRMATA_V22_SERVO_VALUE: return ARDUINO_FIRMATA_V22_SERVO;
			case ARDUINO_FIRMATA_V21_SERVO_VALUE: return ARDUINO_FIRMATA_V21_SERVO;
			case ARDUINO_DEFAULT_VALUE: return ARDUINO_DEFAULT;
		}
		return null;
	}


	private final int value;


	private final String name;

	private final String literal;

	private ARDUINO_FIRMWARE_MODE(int value, String name, String literal) {
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
	
} //ARDUINO_FIRMWARE_MODE
