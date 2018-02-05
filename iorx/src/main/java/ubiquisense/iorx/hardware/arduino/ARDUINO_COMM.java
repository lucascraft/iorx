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

public enum ARDUINO_COMM {

	USB(0, "USB", "Usb"),

	NONE(1, "NONE", "None"),

	XBEE_SERIES_1(2, "XBEE_SERIES_1", "XBee Series 1"),

	XBEE_PRO(3, "XBEE_PRO", "XBee Series PRO"),

	ETHERNET(4, "ETHERNET", "Ethernet"),

	BLUETOOTH(5, "BLUETOOTH", "Bluetooth"),

	MINI_USB(6, "MINI_USB", "Mini USB"),

	UART(7, "UART", "Uart");

	public static final int USB_VALUE = 0;

	public static final int NONE_VALUE = 1;

	public static final int XBEE_SERIES_1_VALUE = 2;

	public static final int XBEE_PRO_VALUE = 3;

	public static final int ETHERNET_VALUE = 4;

	public static final int BLUETOOTH_VALUE = 5;

	public static final int MINI_USB_VALUE = 6;

	public static final int UART_VALUE = 7;

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

	public static final List<ARDUINO_COMM> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ARDUINO_COMM get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_COMM result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_COMM getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_COMM result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

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

	private final int value;

	private final String name;

	private final String literal;

		private ARDUINO_COMM(int value, String name, String literal) {
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
	
} //ARDUINO_COMM
