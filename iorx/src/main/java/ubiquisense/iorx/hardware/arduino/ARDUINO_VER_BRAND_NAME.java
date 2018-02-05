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

public enum ARDUINO_VER_BRAND_NAME  {

	ARDUINO_DIECIMILA(0, "ARDUINO_DIECIMILA", "Arduino Diecimila"), 

	ARDUINO_DUEMILANOVE(1, "ARDUINO_DUEMILANOVE", "Arduino Duemilanove"), 

	ARDUINO_NANO(2, "ARDUINO_NANO", "Arduino Nano"),

	FUNNEL_IO(3, "FUNNEL_IO", "Funnel IO"), 

	LILYPAD(4, "LILYPAD", "Lilipad"),

	ARDUINO_MINI(5, "ARDUINO_MINI", "Arduino Mini"),

	ARDUINO_UNO(6, "ARDUINO_UNO", "Arduino Uno"), 

	ARDUINO_LEONARDO(7, "ARDUINO_LEONARDO", "Arduino Leonardo"),

	ARDUINO_PRO(8, "ARDUINO_PRO", "Arduino Pro"),

	UNKNOWN(0, "UNKNOWN", "Unknown");

	public static final int ARDUINO_DIECIMILA_VALUE = 0;

	public static final int ARDUINO_DUEMILANOVE_VALUE = 1;

	public static final int ARDUINO_NANO_VALUE = 2;

	public static final int FUNNEL_IO_VALUE = 3;
	public static final int LILYPAD_VALUE = 4;

	
	public static final int ARDUINO_MINI_VALUE = 5;

	public static final int ARDUINO_UNO_VALUE = 6;

	public static final int ARDUINO_LEONARDO_VALUE = 7;

	public static final int ARDUINO_PRO_VALUE = 8;

	public static final int UNKNOWN_VALUE = 0;


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
	public static final List<ARDUINO_VER_BRAND_NAME> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ARDUINO_VER_BRAND_NAME get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER_BRAND_NAME result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_VER_BRAND_NAME getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER_BRAND_NAME result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

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

	private final int value;

	private final String name;

	private final String literal;

	private ARDUINO_VER_BRAND_NAME(int value, String name, String literal) {
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
	
} //ARDUINO_VER_BRAND_NAME
