/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ColourKind  {
	RED(0, "RED", "Red"),
	GREEN(1, "GREEN", "Green"),
	BLUE(2, "BLUE", "Blue"),
	CYAN(3, "CYAN", "Cyan"),
	MAGENTA(4, "MAGENTA", "Magenta"),
	YELLOW(5, "YELLOW", "Yellow");

	public static final int RED_VALUE = 0;
	public static final int GREEN_VALUE = 1;
	public static final int BLUE_VALUE = 2;
	public static final int CYAN_VALUE = 3;
	public static final int MAGENTA_VALUE = 4;
	public static final int YELLOW_VALUE = 5;

	private static final ColourKind[] VALUES_ARRAY =
		new ColourKind[] {
			RED,
			GREEN,
			BLUE,
			CYAN,
			MAGENTA,
			YELLOW,
		};

	public static final List<ColourKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ColourKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColourKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ColourKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColourKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static ColourKind get(int value) {
		switch (value) {
			case RED_VALUE: return RED;
			case GREEN_VALUE: return GREEN;
			case BLUE_VALUE: return BLUE;
			case CYAN_VALUE: return CYAN;
			case MAGENTA_VALUE: return MAGENTA;
			case YELLOW_VALUE: return YELLOW;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private ColourKind(int value, String name, String literal) {
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
	
} //ColourKind
