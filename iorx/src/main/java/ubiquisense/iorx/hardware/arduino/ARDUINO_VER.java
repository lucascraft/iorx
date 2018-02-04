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
 * A representation of the literals of the enumeration '<em><b>ARDUINO VER</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_VER()
 * @model
 * @generated
 */
public enum ARDUINO_VER  {
	/**
	 * The '<em><b>ARDUINO VER DIECIMILA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_VER_DIECIMILA_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_VER_DIECIMILA(0, "ARDUINO_VER_DIECIMILA", "ARDUINO_VER_DIECIMILA"),

	/**
	 * The '<em><b>ARDUINO VER DUEMILANOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_VER_DUEMILANOVE_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_VER_DUEMILANOVE(1, "ARDUINO_VER_DUEMILANOVE", "ARDUINO_VER_DUEMILANOVE"),

	/**
	 * The '<em><b>ARDUINO VER NANO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_VER_NANO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_VER_NANO(2, "ARDUINO_VER_NANO", "ARDUINO_VER_NANO"),

	/**
	 * The '<em><b>FUNNEL IO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNNEL_IO_VALUE
	 * @generated
	 * @ordered
	 */
	FUNNEL_IO(3, "FUNNEL_IO", "FUNNEL_IO"),

	/**
	 * The '<em><b>LILIPAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LILIPAD_VALUE
	 * @generated
	 * @ordered
	 */
	LILIPAD(4, "LILIPAD", "LILIPAD"),

	/**
	 * The '<em><b>ADUINO MINI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADUINO_MINI_VALUE
	 * @generated
	 * @ordered
	 */
	ADUINO_MINI(5, "ADUINO_MINI", "ADUINO_MINI"), /**
	 * The '<em><b>ARDUINO NANO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_NANO_VALUE
	 * @generated
	 * @ordered
	 */
	ARDUINO_NANO(6, "ARDUINO_NANO", "ARDUINO_NANO");

	/**
	 * The '<em><b>ARDUINO VER DIECIMILA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO VER DIECIMILA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_VER_DIECIMILA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_VER_DIECIMILA_VALUE = 0;

	/**
	 * The '<em><b>ARDUINO VER DUEMILANOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO VER DUEMILANOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_VER_DUEMILANOVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_VER_DUEMILANOVE_VALUE = 1;

	/**
	 * The '<em><b>ARDUINO VER NANO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO VER NANO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_VER_NANO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_VER_NANO_VALUE = 2;

	/**
	 * The '<em><b>FUNNEL IO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUNNEL IO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNNEL_IO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FUNNEL_IO_VALUE = 3;

	/**
	 * The '<em><b>LILIPAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LILIPAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LILIPAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LILIPAD_VALUE = 4;

	/**
	 * The '<em><b>ADUINO MINI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADUINO MINI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADUINO_MINI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADUINO_MINI_VALUE = 5;

	/**
	 * The '<em><b>ARDUINO NANO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARDUINO NANO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARDUINO_NANO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARDUINO_NANO_VALUE = 6;

	/**
	 * An array of all the '<em><b>ARDUINO VER</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ARDUINO_VER[] VALUES_ARRAY =
		new ARDUINO_VER[] {
			ARDUINO_VER_DIECIMILA,
			ARDUINO_VER_DUEMILANOVE,
			ARDUINO_VER_NANO,
			FUNNEL_IO,
			LILIPAD,
			ADUINO_MINI,
			ARDUINO_NANO,
		};

	/**
	 * A public read-only list of all the '<em><b>ARDUINO VER</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ARDUINO_VER> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ARDUINO VER</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_VER get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO VER</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_VER getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO VER</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_VER get(int value) {
		switch (value) {
			case ARDUINO_VER_DIECIMILA_VALUE: return ARDUINO_VER_DIECIMILA;
			case ARDUINO_VER_DUEMILANOVE_VALUE: return ARDUINO_VER_DUEMILANOVE;
			case ARDUINO_VER_NANO_VALUE: return ARDUINO_VER_NANO;
			case FUNNEL_IO_VALUE: return FUNNEL_IO;
			case LILIPAD_VALUE: return LILIPAD;
			case ADUINO_MINI_VALUE: return ADUINO_MINI;
			case ARDUINO_NANO_VALUE: return ARDUINO_NANO;
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
	private ARDUINO_VER(int value, String name, String literal) {
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
	
} //ARDUINO_VER
