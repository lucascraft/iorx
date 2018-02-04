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
 * A representation of the literals of the enumeration '<em><b>ARDUINO BOARD UID</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_BOARD_UID()
 * @model
 * @generated
 */
public enum ARDUINO_BOARD_UID  {
	/**
	 * The '<em><b>DIECMILA ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIECMILA_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	DIECMILA_ATMEGA_168(0, "DIECMILA_ATMEGA_168", "Diecimila ATMega 168"),

	/**
	 * The '<em><b>DIECIMILA ATMEGA328</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIECIMILA_ATMEGA328_VALUE
	 * @generated
	 * @ordered
	 */
	DIECIMILA_ATMEGA328(1, "DIECIMILA_ATMEGA328", "DIECIMILA_ATMEGA328"),

	/**
	 * The '<em><b>DIECIMILA ATMEGA 328P</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIECIMILA_ATMEGA_328P_VALUE
	 * @generated
	 * @ordered
	 */
	DIECIMILA_ATMEGA_328P(2, "DIECIMILA_ATMEGA_328P", "Diecimila ATMega 328P"),

	/**
	 * The '<em><b>MINI ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	MINI_ATMEGA_168(3, "MINI_ATMEGA_168", "Mini ATMega 168"),

	/**
	 * The '<em><b>MEGA ATMEGA 1280</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGA_ATMEGA_1280_VALUE
	 * @generated
	 * @ordered
	 */
	MEGA_ATMEGA_1280(4, "MEGA_ATMEGA_1280", "Mega ATMega 1280"),

	/**
	 * The '<em><b>LILIPAD ATMEGA 328V</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LILIPAD_ATMEGA_328V_VALUE
	 * @generated
	 * @ordered
	 */
	LILIPAD_ATMEGA_328V(5, "LILIPAD_ATMEGA_328V", "Lilipad ATMega 328V"),

	/**
	 * The '<em><b>DUEMILANOVE ATMEGA 328</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUEMILANOVE_ATMEGA_328_VALUE
	 * @generated
	 * @ordered
	 */
	DUEMILANOVE_ATMEGA_328(6, "DUEMILANOVE_ATMEGA_328", "Duemilanove ATMega 328"),

	/**
	 * The '<em><b>DUEMILANOVE ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUEMILANOVE_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	DUEMILANOVE_ATMEGA_168(7, "DUEMILANOVE_ATMEGA_168", "Duemilanove ATMega 168"),

	/**
	 * The '<em><b>MINI PRO ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_PRO_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	MINI_PRO_ATMEGA_168(8, "MINI_PRO_ATMEGA_168", "Mini Pro ATMega 168"),

	/**
	 * The '<em><b>NANO 30 ATMEGA328</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO_30_ATMEGA328_VALUE
	 * @generated
	 * @ordered
	 */
	NANO_30_ATMEGA328(9, "NANO_30_ATMEGA328", "Nano 30 ATMega 328"),

	/**
	 * The '<em><b>NANO 23 ATMEGA168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO_23_ATMEGA168_VALUE
	 * @generated
	 * @ordered
	 */
	NANO_23_ATMEGA168(10, "NANO_23_ATMEGA168", "Nano 23 ATMega 168"),

	/**
	 * The '<em><b>FUNNEL IO ATMEGA328P</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNNEL_IO_ATMEGA328P_VALUE
	 * @generated
	 * @ordered
	 */
	FUNNEL_IO_ATMEGA328P(11, "FUNNEL_IO_ATMEGA328P", "Funnel IO ATMega 328P"),

	/**
	 * The '<em><b>PRO ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRO_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	PRO_ATMEGA_168(12, "PRO_ATMEGA_168", "Pro ATMega 168"),

	/**
	 * The '<em><b>PRO ATMEGA 328</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRO_ATMEGA_328_VALUE
	 * @generated
	 * @ordered
	 */
	PRO_ATMEGA_328(13, "PRO_ATMEGA_328", "Pro ATMega 328"),

	/**
	 * The '<em><b>BT ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BT_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	BT_ATMEGA_168(14, "BT_ATMEGA_168", "Bluetooth ATMega 168"),

	/**
	 * The '<em><b>PRO MINI ATMEGA 168</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRO_MINI_ATMEGA_168_VALUE
	 * @generated
	 * @ordered
	 */
	PRO_MINI_ATMEGA_168(15, "PRO_MINI_ATMEGA_168", "Pro Mini ATMega 168"), /**
	 * The '<em><b>UNO ATMEGA328</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNO_ATMEGA328_VALUE
	 * @generated
	 * @ordered
	 */
	UNO_ATMEGA328(16, "UNO_ATMEGA328", "UNO ATMega 328"), /**
	 * The '<em><b>LEONARDO ATMEGA32U4</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEONARDO_ATMEGA32U4_VALUE
	 * @generated
	 * @ordered
	 */
	LEONARDO_ATMEGA32U4(17, "LEONARDO_ATMEGA32U4", "Leonardo ATMega 32U4"), /**
	 * The '<em><b>PLACEHOLDER VOID BOARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLACEHOLDER_VOID_BOARD_VALUE
	 * @generated
	 * @ordered
	 */
	PLACEHOLDER_VOID_BOARD(0, "PLACEHOLDER_VOID_BOARD", "Placeholder Void Board");

	/**
	 * The '<em><b>DIECMILA ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIECMILA ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIECMILA_ATMEGA_168
	 * @model literal="Diecimila ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int DIECMILA_ATMEGA_168_VALUE = 0;

	/**
	 * The '<em><b>DIECIMILA ATMEGA328</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIECIMILA ATMEGA328</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIECIMILA_ATMEGA328
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIECIMILA_ATMEGA328_VALUE = 1;

	/**
	 * The '<em><b>DIECIMILA ATMEGA 328P</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIECIMILA ATMEGA 328P</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIECIMILA_ATMEGA_328P
	 * @model literal="Diecimila ATMega 328P"
	 * @generated
	 * @ordered
	 */
	public static final int DIECIMILA_ATMEGA_328P_VALUE = 2;

	/**
	 * The '<em><b>MINI ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINI ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINI_ATMEGA_168
	 * @model literal="Mini ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int MINI_ATMEGA_168_VALUE = 3;

	/**
	 * The '<em><b>MEGA ATMEGA 1280</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEGA ATMEGA 1280</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEGA_ATMEGA_1280
	 * @model literal="Mega ATMega 1280"
	 * @generated
	 * @ordered
	 */
	public static final int MEGA_ATMEGA_1280_VALUE = 4;

	/**
	 * The '<em><b>LILIPAD ATMEGA 328V</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LILIPAD ATMEGA 328V</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LILIPAD_ATMEGA_328V
	 * @model literal="Lilipad ATMega 328V"
	 * @generated
	 * @ordered
	 */
	public static final int LILIPAD_ATMEGA_328V_VALUE = 5;

	/**
	 * The '<em><b>DUEMILANOVE ATMEGA 328</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DUEMILANOVE ATMEGA 328</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DUEMILANOVE_ATMEGA_328
	 * @model literal="Duemilanove ATMega 328"
	 * @generated
	 * @ordered
	 */
	public static final int DUEMILANOVE_ATMEGA_328_VALUE = 6;

	/**
	 * The '<em><b>DUEMILANOVE ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DUEMILANOVE ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DUEMILANOVE_ATMEGA_168
	 * @model literal="Duemilanove ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int DUEMILANOVE_ATMEGA_168_VALUE = 7;

	/**
	 * The '<em><b>MINI PRO ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINI PRO ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINI_PRO_ATMEGA_168
	 * @model literal="Mini Pro ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int MINI_PRO_ATMEGA_168_VALUE = 8;

	/**
	 * The '<em><b>NANO 30 ATMEGA328</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NANO 30 ATMEGA328</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANO_30_ATMEGA328
	 * @model literal="Nano 30 ATMega 328"
	 * @generated
	 * @ordered
	 */
	public static final int NANO_30_ATMEGA328_VALUE = 9;

	/**
	 * The '<em><b>NANO 23 ATMEGA168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NANO 23 ATMEGA168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANO_23_ATMEGA168
	 * @model literal="Nano 23 ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int NANO_23_ATMEGA168_VALUE = 10;

	/**
	 * The '<em><b>FUNNEL IO ATMEGA328P</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUNNEL IO ATMEGA328P</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNNEL_IO_ATMEGA328P
	 * @model literal="Funnel IO ATMega 328P"
	 * @generated
	 * @ordered
	 */
	public static final int FUNNEL_IO_ATMEGA328P_VALUE = 11;

	/**
	 * The '<em><b>PRO ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRO ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRO_ATMEGA_168
	 * @model literal="Pro ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int PRO_ATMEGA_168_VALUE = 12;

	/**
	 * The '<em><b>PRO ATMEGA 328</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRO ATMEGA 328</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRO_ATMEGA_328
	 * @model literal="Pro ATMega 328"
	 * @generated
	 * @ordered
	 */
	public static final int PRO_ATMEGA_328_VALUE = 13;

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
	public static final int BT_ATMEGA_168_VALUE = 14;

	/**
	 * The '<em><b>PRO MINI ATMEGA 168</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRO MINI ATMEGA 168</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRO_MINI_ATMEGA_168
	 * @model literal="Pro Mini ATMega 168"
	 * @generated
	 * @ordered
	 */
	public static final int PRO_MINI_ATMEGA_168_VALUE = 15;

	/**
	 * The '<em><b>UNO ATMEGA328</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNO ATMEGA328</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNO_ATMEGA328
	 * @model literal="UNO ATMega 328"
	 * @generated
	 * @ordered
	 */
	public static final int UNO_ATMEGA328_VALUE = 16;

	/**
	 * The '<em><b>LEONARDO ATMEGA32U4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LEONARDO ATMEGA32U4</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEONARDO_ATMEGA32U4
	 * @model literal="Leonardo ATMega 32U4"
	 * @generated
	 * @ordered
	 */
	public static final int LEONARDO_ATMEGA32U4_VALUE = 17;

	/**
	 * The '<em><b>PLACEHOLDER VOID BOARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLACEHOLDER VOID BOARD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLACEHOLDER_VOID_BOARD
	 * @model literal="Placeholder Void Board"
	 * @generated
	 * @ordered
	 */
	public static final int PLACEHOLDER_VOID_BOARD_VALUE = 0;

	/**
	 * An array of all the '<em><b>ARDUINO BOARD UID</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ARDUINO_BOARD_UID[] VALUES_ARRAY =
		new ARDUINO_BOARD_UID[] {
			DIECMILA_ATMEGA_168,
			DIECIMILA_ATMEGA328,
			DIECIMILA_ATMEGA_328P,
			MINI_ATMEGA_168,
			MEGA_ATMEGA_1280,
			LILIPAD_ATMEGA_328V,
			DUEMILANOVE_ATMEGA_328,
			DUEMILANOVE_ATMEGA_168,
			MINI_PRO_ATMEGA_168,
			NANO_30_ATMEGA328,
			NANO_23_ATMEGA168,
			FUNNEL_IO_ATMEGA328P,
			PRO_ATMEGA_168,
			PRO_ATMEGA_328,
			BT_ATMEGA_168,
			PRO_MINI_ATMEGA_168,
			UNO_ATMEGA328,
			LEONARDO_ATMEGA32U4,
			PLACEHOLDER_VOID_BOARD,
		};

	/**
	 * A public read-only list of all the '<em><b>ARDUINO BOARD UID</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ARDUINO_BOARD_UID> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ARDUINO BOARD UID</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_BOARD_UID get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_UID result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO BOARD UID</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_BOARD_UID getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_UID result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO BOARD UID</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_BOARD_UID get(int value) {
		switch (value) {
			case DIECMILA_ATMEGA_168_VALUE: return DIECMILA_ATMEGA_168;
			case DIECIMILA_ATMEGA328_VALUE: return DIECIMILA_ATMEGA328;
			case DIECIMILA_ATMEGA_328P_VALUE: return DIECIMILA_ATMEGA_328P;
			case MINI_ATMEGA_168_VALUE: return MINI_ATMEGA_168;
			case MEGA_ATMEGA_1280_VALUE: return MEGA_ATMEGA_1280;
			case LILIPAD_ATMEGA_328V_VALUE: return LILIPAD_ATMEGA_328V;
			case DUEMILANOVE_ATMEGA_328_VALUE: return DUEMILANOVE_ATMEGA_328;
			case DUEMILANOVE_ATMEGA_168_VALUE: return DUEMILANOVE_ATMEGA_168;
			case MINI_PRO_ATMEGA_168_VALUE: return MINI_PRO_ATMEGA_168;
			case NANO_30_ATMEGA328_VALUE: return NANO_30_ATMEGA328;
			case NANO_23_ATMEGA168_VALUE: return NANO_23_ATMEGA168;
			case FUNNEL_IO_ATMEGA328P_VALUE: return FUNNEL_IO_ATMEGA328P;
			case PRO_ATMEGA_168_VALUE: return PRO_ATMEGA_168;
			case PRO_ATMEGA_328_VALUE: return PRO_ATMEGA_328;
			case BT_ATMEGA_168_VALUE: return BT_ATMEGA_168;
			case PRO_MINI_ATMEGA_168_VALUE: return PRO_MINI_ATMEGA_168;
			case UNO_ATMEGA328_VALUE: return UNO_ATMEGA328;
			case LEONARDO_ATMEGA32U4_VALUE: return LEONARDO_ATMEGA32U4;
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
	private ARDUINO_BOARD_UID(int value, String name, String literal) {
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
	
} //ARDUINO_BOARD_UID
