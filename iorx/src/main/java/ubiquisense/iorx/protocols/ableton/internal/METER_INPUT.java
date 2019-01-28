/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum METER_INPUT  {
	LEFT_METER(0, "LEFT_METER", "LEFT_METER"),
	RIGHT_METER(1, "RIGHT_METER", "RIGHT_METER");
	public static final int LEFT_METER_VALUE = 0;
	public static final int RIGHT_METER_VALUE = 1;
	private static final METER_INPUT[] VALUES_ARRAY =
		new METER_INPUT[] {
			LEFT_METER,
			RIGHT_METER,
		};
	public static final List<METER_INPUT> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static METER_INPUT get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			METER_INPUT result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static METER_INPUT getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			METER_INPUT result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static METER_INPUT get(int value) {
		switch (value) {
			case LEFT_METER_VALUE: return LEFT_METER;
			case RIGHT_METER_VALUE: return RIGHT_METER;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private METER_INPUT(int value, String name, String literal) {
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
	
} //METER_INPUT
