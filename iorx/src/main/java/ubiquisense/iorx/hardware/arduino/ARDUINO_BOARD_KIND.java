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

public enum ARDUINO_BOARD_KIND  {
	ATMEGA_168(0, "ATMEGA_168", "ATMega 168"),
	ATMEGA_8(3, "ATMEGA_8", "ATMega 8"),
	BT_ATMEGA_168(1, "BT_ATMEGA_168", "Bluetooth ATMega 168"),
	LILYPAD_168(2, "LILYPAD_168", "Lilipad 168"),
	MINI_328P(4, "MINI_328P", "Mini 328P"),
	MINI_168(5, "MINI_168", "Mini 168"), 
	UNKNOWN(0, "UNKNOWN", "Unknown");

	public static final int ATMEGA_168_VALUE = 0;

	public static final int ATMEGA_8_VALUE = 3;

	public static final int BT_ATMEGA_168_VALUE = 1;

	public static final int LILYPAD_168_VALUE = 2;

	public static final int MINI_328P_VALUE = 4;

	public static final int MINI_168_VALUE = 5;

	public static final int UNKNOWN_VALUE = 0;

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

	public static final List<ARDUINO_BOARD_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ARDUINO_BOARD_KIND get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_KIND result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_BOARD_KIND getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_KIND result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

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

	private final int value;

	private final String name;

	private final String literal;

	private ARDUINO_BOARD_KIND(int value, String name, String literal) {
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
	
} //ARDUINO_BOARD_KIND
