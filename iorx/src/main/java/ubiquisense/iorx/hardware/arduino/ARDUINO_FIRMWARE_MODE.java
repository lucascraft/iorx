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
	/**
	 * The '<em><b>ARDUINO FIRMATA V10</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V10_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V10(0, "ARDUINO_FIRMATA_V10", "Firmata 1.0"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V20</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V20_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V20(2, "ARDUINO_FIRMATA_V20", "Firmata 2.0"), /**
	 * The '<em><b>ARDUINO FIRMATA V11</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V11_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V11(1, "ARDUINO_FIRMATA_V11", "Firmata 1.1"), /**
	 * The '<em><b>ARDUINO FIRMATA V23</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V23_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V23(18, "ARDUINO_FIRMATA_V23", "Firmata 2.3"), /**
	 * The '<em><b>ARDUINO FIRMATA V22</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V22_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V22(13, "ARDUINO_FIRMATA_V22", "Firmata 2.2"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V21</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V21_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V21(3, "ARDUINO_FIRMATA_V21", "Firmata 2.1"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V10 I2C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V10_I2C_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V10_I2C(4, "ARDUINO_FIRMATA_V10_I2C", "Firmata I2C 1.0"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V11 I2C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V11_I2C_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V11_I2C(5, "ARDUINO_FIRMATA_V11_I2C", "Firmata I2C 1.1"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V20 I2C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V20_I2C_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V20_I2C(6, "ARDUINO_FIRMATA_V20_I2C", "Firmata I2C 2.0"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V23 I2C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V23_I2C_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V23_I2C(17, "ARDUINO_FIRMATA_V23_I2C", "Firmata I2C 2.3"), /**
	 * The '<em><b>ARDUINO FIRMATA V22 I2C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V22_I2C_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V22_I2C(14, "ARDUINO_FIRMATA_V22_I2C", "Firmata I2C 2.2"), /**
	 * The '<em><b>ARDUINO FIRMATA V21 I2C</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V21_I2C_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V21_I2C(7, "ARDUINO_FIRMATA_V21_I2C", "Firmata I2C 2.1"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V10 SERVO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V10_SERVO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V10_SERVO(8, "ARDUINO_FIRMATA_V10_SERVO", "Firmata Servo 1.0"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V20 SERVO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V20_SERVO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V20_SERVO(10, "ARDUINO_FIRMATA_V20_SERVO", "Firmata Servo 2.0"), /**
	 * The '<em><b>ARDUINO FIRMATA V11 SERVO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V11_SERVO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V11_SERVO(9, "ARDUINO_FIRMATA_V11_SERVO", "Firmata Servo 1.1"),

	/**
	 * The '<em><b>ARDUINO FIRMATA V23 SERVO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V23_SERVO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V23_SERVO(16, "ARDUINO_FIRMATA_V23_SERVO", "Firmata Servo 2.3"), /**
	 * The '<em><b>ARDUINO FIRMATA V22 SERVO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V22_SERVO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V22_SERVO(15, "ARDUINO_FIRMATA_V22_SERVO", "Firmata Servo 2.2"), /**
	 * The '<em><b>ARDUINO FIRMATA V21 SERVO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V21_SERVO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_FIRMATA_V21_SERVO(11, "ARDUINO_FIRMATA_V21_SERVO", "Firmata Servo 2.1"), /**
	 * The '<em><b>ARDUINO DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_DEFAULT(12, "ARDUINO_DEFAULT", "Firmata Default");

	/**
	 * The '<em><b>ARDUINO FIRMATA V10</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V10</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V10
	 * @model literal="Firmata 1.0"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V10_VALUE = 0;

	/**
	 * The '<em><b>ARDUINO FIRMATA V20</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V20</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V20
	 * @model literal="Firmata 2.0"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V20_VALUE = 2;

	/**
	 * The '<em><b>ARDUINO FIRMATA V11</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V11</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V11
	 * @model literal="Firmata 1.1"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V11_VALUE = 1;

	/**
	 * The '<em><b>ARDUINO FIRMATA V23</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V23</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V23
	 * @model literal="Firmata 2.3"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V23_VALUE = 18;

	/**
	 * The '<em><b>ARDUINO FIRMATA V22</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V22</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V22
	 * @model literal="Firmata 2.2"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V22_VALUE = 13;

	/**
	 * The '<em><b>ARDUINO FIRMATA V21</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V21</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V21
	 * @model literal="Firmata 2.1"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V21_VALUE = 3;

	/**
	 * The '<em><b>ARDUINO FIRMATA V10 I2C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V10 I2C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V10_I2C
	 * @model literal="Firmata I2C 1.0"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V10_I2C_VALUE = 4;

	/**
	 * The '<em><b>ARDUINO FIRMATA V11 I2C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V11 I2C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V11_I2C
	 * @model literal="Firmata I2C 1.1"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V11_I2C_VALUE = 5;

	/**
	 * The '<em><b>ARDUINO FIRMATA V20 I2C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V20 I2C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V20_I2C
	 * @model literal="Firmata I2C 2.0"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V20_I2C_VALUE = 6;

	/**
	 * The '<em><b>ARDUINO FIRMATA V23 I2C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V23 I2C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V23_I2C
	 * @model literal="Firmata I2C 2.3"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V23_I2C_VALUE = 17;

	/**
	 * The '<em><b>ARDUINO FIRMATA V22 I2C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V22 I2C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V22_I2C
	 * @model literal="Firmata I2C 2.2"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V22_I2C_VALUE = 14;

	/**
	 * The '<em><b>ARDUINO FIRMATA V21 I2C</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V21 I2C</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V21_I2C
	 * @model literal="Firmata I2C 2.1"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V21_I2C_VALUE = 7;

	/**
	 * The '<em><b>ARDUINO FIRMATA V10 SERVO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V10 SERVO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V10_SERVO
	 * @model literal="Firmata Servo 1.0"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V10_SERVO_VALUE = 8;

	/**
	 * The '<em><b>ARDUINO FIRMATA V20 SERVO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V20 SERVO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V20_SERVO
	 * @model literal="Firmata Servo 2.0"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V20_SERVO_VALUE = 10;

	/**
	 * The '<em><b>ARDUINO FIRMATA V11 SERVO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V11 SERVO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V11_SERVO
	 * @model literal="Firmata Servo 1.1"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V11_SERVO_VALUE = 9;

	/**
	 * The '<em><b>ARDUINO FIRMATA V23 SERVO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V23 SERVO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V23_SERVO
	 * @model literal="Firmata Servo 2.3"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V23_SERVO_VALUE = 16;

	/**
	 * The '<em><b>ARDUINO FIRMATA V22 SERVO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V22 SERVO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V22_SERVO
	 * @model literal="Firmata Servo 2.2"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V22_SERVO_VALUE = 15;

	/**
	 * The '<em><b>ARDUINO FIRMATA V21 SERVO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO FIRMATA V21 SERVO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_FIRMATA_V21_SERVO
	 * @model literal="Firmata Servo 2.1"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_FIRMATA_V21_SERVO_VALUE = 11;

	/**
	 * The '<em><b>ARDUINO DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_DEFAULT
	 * @model literal="Firmata Default"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_DEFAULT_VALUE = 12;

	/**
	 * An array of all the '<em><b>ARDUINO FIRMWARE MODE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * A public read-only list of all the '<em><b>ARDUINO FIRMWARE MODE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ARDUINO_FIRMWARE_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ARDUINO FIRMWARE MODE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_FIRMWARE_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_FIRMWARE_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO FIRMWARE MODE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_FIRMWARE_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_FIRMWARE_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO FIRMWARE MODE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ARDUINO_FIRMWARE_MODE(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

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
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ARDUINO_FIRMWARE_MODE
