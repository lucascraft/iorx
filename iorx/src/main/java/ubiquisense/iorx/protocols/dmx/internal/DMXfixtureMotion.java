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

public enum DMXfixtureMotion 	 {
	CIRCLE(0, "CIRCLE", "CIRCLE"),
	EIGHT(1, "EIGHT", "EIGHT"),
	LISSAJOUX(2, "LISSAJOUX", "LISSAJOUX"),
	STAR(3, "STAR", "STAR"),
	RAMP_UP(4, "RAMP_UP", "RAMP_UP"),
	RAMP_DOWN(5, "RAMP_DOWN", "RAMP_DOWN");
	public static final int CIRCLE_VALUE = 0;
	public static final int EIGHT_VALUE = 1;
	public static final int LISSAJOUX_VALUE = 2;
	public static final int STAR_VALUE = 3;
	public static final int RAMP_UP_VALUE = 4;
	public static final int RAMP_DOWN_VALUE = 5;
	private static final DMXfixtureMotion[] VALUES_ARRAY =
		new DMXfixtureMotion[] {
			CIRCLE,
			EIGHT,
			LISSAJOUX,
			STAR,
			RAMP_UP,
			RAMP_DOWN,
		};
	public static final List<DMXfixtureMotion> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static DMXfixtureMotion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DMXfixtureMotion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static DMXfixtureMotion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DMXfixtureMotion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static DMXfixtureMotion get(int value) {
		switch (value) {
			case CIRCLE_VALUE: return CIRCLE;
			case EIGHT_VALUE: return EIGHT;
			case LISSAJOUX_VALUE: return LISSAJOUX;
			case STAR_VALUE: return STAR;
			case RAMP_UP_VALUE: return RAMP_UP;
			case RAMP_DOWN_VALUE: return RAMP_DOWN;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private DMXfixtureMotion(int value, String name, String literal) {
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
	
} //DMXfixtureMotion
