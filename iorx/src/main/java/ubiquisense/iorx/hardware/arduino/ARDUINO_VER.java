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

public enum ARDUINO_VER  {

	ARDUINO_VER_DIECIMILA(0, "ARDUINO_VER_DIECIMILA", "ARDUINO_VER_DIECIMILA"),

	ARDUINO_VER_DUEMILANOVE(1, "ARDUINO_VER_DUEMILANOVE", "ARDUINO_VER_DUEMILANOVE"),

	ARDUINO_VER_NANO(2, "ARDUINO_VER_NANO", "ARDUINO_VER_NANO"),

	FUNNEL_IO(3, "FUNNEL_IO", "FUNNEL_IO"),


	LILIPAD(4, "LILIPAD", "LILIPAD"),


	ADUINO_MINI(5, "ADUINO_MINI", "ADUINO_MINI"),

	ARDUINO_NANO(6, "ARDUINO_NANO", "ARDUINO_NANO");

	public static final int ARDUINO_VER_DIECIMILA_VALUE = 0;

	public static final int ARDUINO_VER_DUEMILANOVE_VALUE = 1;

	public static final int ARDUINO_VER_NANO_VALUE = 2;

	public static final int FUNNEL_IO_VALUE = 3;

	public static final int LILIPAD_VALUE = 4;

	public static final int ADUINO_MINI_VALUE = 5;

	public static final int ARDUINO_NANO_VALUE = 6;

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

	public static final List<ARDUINO_VER> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ARDUINO_VER get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_VER getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_VER result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

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

	private final int value;

	private final String name;

	private final String literal;

	private ARDUINO_VER(int value, String name, String literal) {
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
	
} //ARDUINO_VER
