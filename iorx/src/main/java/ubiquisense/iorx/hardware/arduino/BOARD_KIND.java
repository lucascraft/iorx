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

public enum BOARD_KIND {
	ATMEGA_168(0, "ATMEGA_168", "ATMEGA_168"),
	ATMEGA_8(3, "ATMEGA_8", "ATMEGA_8"),
	BT_ATMEGA_168(1, "BT_ATMEGA_168", "BT_ATMEGA_168"),
	LILYPAD_168(2, "LILYPAD_168", "LILYPAD_168");

	public static final int ATMEGA_168_VALUE = 0;

	public static final int ATMEGA_8_VALUE = 3;

	public static final int BT_ATMEGA_168_VALUE = 1;

	public static final int LILYPAD_168_VALUE = 2;

	private static final BOARD_KIND[] VALUES_ARRAY =
		new BOARD_KIND[] {
			ATMEGA_168,
			ATMEGA_8,
			BT_ATMEGA_168,
			LILYPAD_168,
		};

	public static final List<BOARD_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static BOARD_KIND get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BOARD_KIND result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static BOARD_KIND getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BOARD_KIND result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static BOARD_KIND get(int value) {
		switch (value) {
			case ATMEGA_168_VALUE: return ATMEGA_168;
			case ATMEGA_8_VALUE: return ATMEGA_8;
			case BT_ATMEGA_168_VALUE: return BT_ATMEGA_168;
			case LILYPAD_168_VALUE: return LILYPAD_168;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private BOARD_KIND(int value, String name, String literal) {
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
	
} //BOARD_KIND
