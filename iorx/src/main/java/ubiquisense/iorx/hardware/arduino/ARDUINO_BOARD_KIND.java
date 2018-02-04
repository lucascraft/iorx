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
 * A representation of the literals of the enumeration '<em><b>ARDUINO BOARD KIND</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_BOARD_KIND()
 * @model
 * @generated
 */
public enum ARDUINO_BOARD_KIND  {
	/**
	 * The '<em><b>ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	ATMEGA_168(0, "ATMEGA_168", "ATMega 168"),

	/**
	 * The '<em><b>ATMEGA 8</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATMEGA_8_VALUE
	 * @generated
	 * @ordered
	 */
	ATMEGA_8(3, "ATMEGA_8", "ATMega 8"),

	/**
	 * The '<em><b>BT ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BT_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	BT_ATMEGA_168(1, "BT_ATMEGA_168", "Bluetooth ATMega 168"),

	/**
	 * The '<em><b>LILYPAD 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LILYPAD_168_VALUE
	 * @generated
	 * @ordered
	 */
	LILYPAD_168(2, "LILYPAD_168", "Lilipad 168"), /**
	 * The '<em><b>MINI 328P</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_328P_VALUE
	 * @generated
	 * @ordered
	 */
	MINI_328P(4, "MINI_328P", "Mini 328P"), /**
	 * The '<em><b>MINI 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_168_VALUE
	 * @generated
	 * @ordered
	 */
	MINI_168(5, "MINI_168", "Mini 168"), /**
	 * The '<em><b>UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(0, "UNKNOWN", "Unknown");

	/**
	 * The '<em><b>ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATMEGA_168
	 * @model literal="ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int ATMEGA_168_VALUE = 0;

	/**
	 * The '<em><b>ATMEGA 8</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATMEGA 8</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATMEGA_8
	 * @model literal="ATMega 8"
	 * @generated
	 * @ordered
	 */
	public static final int ATMEGA_8_VALUE = 3;

	/**
	 * The '<em><b>BT ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BT ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BT_ATMEGA_168
	 * @model literal="Bluetooth ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int BT_ATMEGA_168_VALUE = 1;

	/**
	 * The '<em><b>LILYPAD 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LILYPAD 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LILYPAD_168
	 * @model literal="Lilipad 168"
	 * @generated
	 * @ordered
	 */
	public static final int LILYPAD_168_VALUE = 2;

	/**
	 * The '<em><b>MINI 328P</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINI 328P</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINI_328P
	 * @model literal="Mini 328P"
	 * @generated
	 * @ordered
	 */
	public static final int MINI_328P_VALUE = 4;

	/**
	 * The '<em><b>MINI 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINI 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINI_168
	 * @model literal="Mini 168"
	 * @generated
	 * @ordered
	 */
	public static final int MINI_168_VALUE = 5;

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model literal="Unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = 0;

	/**
	 * An array of all the '<em><b>ARDUINO BOARD KIND</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ARDUINO_BOARD_KIND[] VALUES_ARRAY =
		new ARDUINO_BOARD_KIND[] {
			ATMEGA_168,
			ATMEGA_8,
			BT_ATMEGA_168,
			LILYPAD_168,
			MINI_328P,
			MINI_168,
			UNKNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>ARDUINO BOARD KIND</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ARDUINO_BOARD_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ARDUINO BOARD KIND</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_BOARD_KIND get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_KIND result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO BOARD KIND</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_BOARD_KIND getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_KIND result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO BOARD KIND</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_BOARD_KIND get(int value) {
		switch (value) {
			case ATMEGA_168_VALUE: return ATMEGA_168;
			case ATMEGA_8_VALUE: return ATMEGA_8;
			case BT_ATMEGA_168_VALUE: return BT_ATMEGA_168;
			case LILYPAD_168_VALUE: return LILYPAD_168;
			case MINI_328P_VALUE: return MINI_328P;
			case MINI_168_VALUE: return MINI_168;
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
	private ARDUINO_BOARD_KIND(int value, String name, String literal) {
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
	
} //ARDUINO_BOARD_KIND
