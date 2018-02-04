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
 * A representation of the literals of the enumeration '<em><b>ARDUINO COMM</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_COMM()
 * @model
 * @generated
 */
public enum ARDUINO_COMM {
	/**
	 * The '<em><b>USB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USB_VALUE
	 * @generated
	 * @ordered
	 */
	USB(0, "USB", "Usb"),

	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(1, "NONE", "None"),

	/**
	 * The '<em><b>XBEE SERIES 1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XBEE_SERIES_1_VALUE
	 * @generated
	 * @ordered
	 */
	XBEE_SERIES_1(2, "XBEE_SERIES_1", "XBee Series 1"),

	/**
	 * The '<em><b>XBEE PRO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XBEE_PRO_VALUE
	 * @generated
	 * @ordered
	 */
	XBEE_PRO(3, "XBEE_PRO", "XBee Series PRO"),

	/**
	 * The '<em><b>ETHERNET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETHERNET_VALUE
	 * @generated
	 * @ordered
	 */
	ETHERNET(4, "ETHERNET", "Ethernet"),

	/**
	 * The '<em><b>BLUETOOTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLUETOOTH_VALUE
	 * @generated
	 * @ordered
	 */
	BLUETOOTH(5, "BLUETOOTH", "Bluetooth"), /**
	 * The '<em><b>MINI USB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_USB_VALUE
	 * @generated
	 * @ordered
	 */
	MINI_USB(6, "MINI_USB", "Mini USB"), /**
	 * The '<em><b>UART</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UART_VALUE
	 * @generated
	 * @ordered
	 */
	UART(7, "UART", "Uart");

	/**
	 * The '<em><b>USB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USB
	 * @model literal="Usb"
	 * @generated
	 * @ordered
	 */
	public static final int USB_VALUE = 0;

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model literal="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 1;

	/**
	 * The '<em><b>XBEE SERIES 1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XBEE SERIES 1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XBEE_SERIES_1
	 * @model literal="XBee Series 1"
	 * @generated
	 * @ordered
	 */
	public static final int XBEE_SERIES_1_VALUE = 2;

	/**
	 * The '<em><b>XBEE PRO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XBEE PRO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XBEE_PRO
	 * @model literal="XBee Series PRO"
	 * @generated
	 * @ordered
	 */
	public static final int XBEE_PRO_VALUE = 3;

	/**
	 * The '<em><b>ETHERNET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ETHERNET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ETHERNET
	 * @model literal="Ethernet"
	 * @generated
	 * @ordered
	 */
	public static final int ETHERNET_VALUE = 4;

	/**
	 * The '<em><b>BLUETOOTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLUETOOTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLUETOOTH
	 * @model literal="Bluetooth"
	 * @generated
	 * @ordered
	 */
	public static final int BLUETOOTH_VALUE = 5;

	/**
	 * The '<em><b>MINI USB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINI USB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINI_USB
	 * @model literal="Mini USB"
	 * @generated
	 * @ordered
	 */
	public static final int MINI_USB_VALUE = 6;

	/**
	 * The '<em><b>UART</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UART</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UART
	 * @model literal="Uart"
	 * @generated
	 * @ordered
	 */
	public static final int UART_VALUE = 7;

	/**
	 * An array of all the '<em><b>ARDUINO COMM</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ARDUINO_COMM[] VALUES_ARRAY =
		new ARDUINO_COMM[] {
			USB,
			NONE,
			XBEE_SERIES_1,
			XBEE_PRO,
			ETHERNET,
			BLUETOOTH,
			MINI_USB,
			UART,
		};

	/**
	 * A public read-only list of all the '<em><b>ARDUINO COMM</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ARDUINO_COMM> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ARDUINO COMM</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_COMM get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_COMM result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO COMM</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_COMM getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_COMM result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ARDUINO COMM</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ARDUINO_COMM get(int value) {
		switch (value) {
			case USB_VALUE: return USB;
			case NONE_VALUE: return NONE;
			case XBEE_SERIES_1_VALUE: return XBEE_SERIES_1;
			case XBEE_PRO_VALUE: return XBEE_PRO;
			case ETHERNET_VALUE: return ETHERNET;
			case BLUETOOTH_VALUE: return BLUETOOTH;
			case MINI_USB_VALUE: return MINI_USB;
			case UART_VALUE: return UART;
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
	private ARDUINO_COMM(int value, String name, String literal) {
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
	
} //ARDUINO_COMM
