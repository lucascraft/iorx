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
 * A representation of the literals of the enumeration '<em><b>ARDUINO VER BRAND NAME</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_VER_BRAND_NAME()
 * @model
 * @generated
 */
public enum ARDUINO_VER_BRAND_NAME  {
	/**
	 * The '<em><b>ARDUINO DIECIMILA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_DIECIMILA_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_DIECIMILA(0, "ARDUINO_DIECIMILA", "Arduino Diecimila"), /**
	 * The '<em><b>ARDUINO DUEMILANOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_DUEMILANOVE_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_DUEMILANOVE(1, "ARDUINO_DUEMILANOVE", "Arduino Duemilanove"), /**
	 * The '<em><b>ARDUINO NANO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_NANO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_NANO(2, "ARDUINO_NANO", "Arduino Nano"), /**
	 * The '<em><b>FUNNEL IO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNNEL_IO_VALUE
	 * @generated
	 * @ordered
	 */
	FUNNEL_IO(3, "FUNNEL_IO", "Funnel IO"), /**
	 * The '<em><b>LILYPAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LILYPAD_VALUE
	 * @generated
	 * @ordered
	 */
	LILYPAD(4, "LILYPAD", "Lilipad"), /**
	 * The '<em><b>ARDUINO MINI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_MINI_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_MINI(5, "ARDUINO_MINI", "Arduino Mini"), /**
	 * The '<em><b>ARDUINO UNO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_UNO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_UNO(6, "ARDUINO_UNO", "Arduino Uno"), /**
	 * The '<em><b>ARDUINO LEONARDO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_LEONARDO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_LEONARDO(7, "ARDUINO_LEONARDO", "Arduino Leonardo"), /**
	 * The '<em><b>ARDUINO PRO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_PRO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_PRO(8, "ARDUINO_PRO", "Arduino Pro"), /**
	 * The '<em><b>UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(0, "UNKNOWN", "Unknown");

	/**
	 * The '<em><b>ARDUINO DIECIMILA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO DIECIMILA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_DIECIMILA
	 * @model literal="Arduino Diecimila"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_DIECIMILA_VALUE = 0;

	/**
	 * The '<em><b>ARDUINO DUEMILANOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO DUEMILANOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_DUEMILANOVE
	 * @model literal="Arduino Duemilanove"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_DUEMILANOVE_VALUE = 1;

	/**
	 * The '<em><b>ARDUINO NANO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO NANO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_NANO
	 * @model literal="Arduino Nano"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_NANO_VALUE = 2;

	/**
	 * The '<em><b>FUNNEL IO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUNNEL IO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNNEL_IO
	 * @model literal="Funnel IO"
	 * @generated
	 * @ordered
	 */
	public static final int FUNNEL_IO_VALUE = 3;

	/**
	 * The '<em><b>LILYPAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LILYPAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LILYPAD
	 * @model literal="Lilipad"
	 * @generated
	 * @ordered
	 */
	public static final int LILYPAD_VALUE = 4;

	/**
	 * The '<em><b>ARDUINO MINI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO MINI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_MINI
	 * @model literal="Arduino Mini"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_MINI_VALUE = 5;

	/**
	 * The '<em><b>ARDUINO UNO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO UNO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_UNO
	 * @model literal="Arduino Uno"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_UNO_VALUE = 6;

	/**
	 * The '<em><b>ARDUINO LEONARDO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO LEONARDO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_LEONARDO
	 * @model literal="Arduino Leonardo"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_LEONARDO_VALUE = 7;

	/**
	 * The '<em><b>ARDUINO PRO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO PRO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_PRO
	 * @model literal="Arduino Pro"
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_PRO_VALUE = 8;

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
	 * An array of all the '<em><b>ARDUINO VER BRAND NAME</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ARDUINO_VER_BRAND_NAME[] VALUES_ARRAY =
		new ARDUINO_VER_BRAND_NAME[] {
			ARDUINO_DIECIMILA,
			ARDUINO_DUEMILANOVE,
			ARDUINO_NANO,
			FUNNEL_IO,
			LILYPAD,
			ARDUINO_MINI,
			ARDUINO_UNO,
			ARDUINO_LEONARDO,
			ARDUINO_PRO,
			UNKNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>ARDUINO VER BRAND NAME</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ARDUINO_VER_BRAND_NAME> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ARDUINO VER BRAND NAME</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_VER_BRAND_NAME get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER_BRAND_NAME result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO VER BRAND NAME</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_VER_BRAND_NAME getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER_BRAND_NAME result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO VER BRAND NAME</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_VER_BRAND_NAME get(int value) {
		switch (value) {
			case ARDUINO_DIECIMILA_VALUE: return ARDUINO_DIECIMILA;
			case ARDUINO_DUEMILANOVE_VALUE: return ARDUINO_DUEMILANOVE;
			case ARDUINO_NANO_VALUE: return ARDUINO_NANO;
			case FUNNEL_IO_VALUE: return FUNNEL_IO;
			case LILYPAD_VALUE: return LILYPAD;
			case ARDUINO_MINI_VALUE: return ARDUINO_MINI;
			case ARDUINO_UNO_VALUE: return ARDUINO_UNO;
			case ARDUINO_LEONARDO_VALUE: return ARDUINO_LEONARDO;
			case ARDUINO_PRO_VALUE: return ARDUINO_PRO;
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
	private ARDUINO_VER_BRAND_NAME(int value, String name, String literal) {
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
	
} //ARDUINO_VER_BRAND_NAME
