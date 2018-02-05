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


public enum PWM_MODE {

	HIGH(1, "HIGH", "High"),


	LOW(0, "LOW", "Low"),

	NONE(2, "NONE", "None"),

	UNKNOWN(0, "UNKNOWN", "Unknown");


	public static final int HIGH_VALUE = 1;


	public static final int LOW_VALUE = 0;


	public static final int NONE_VALUE = 2;

	public static final int UNKNOWN_VALUE = 0;

	private static final PWM_MODE[] VALUES_ARRAY =
		new PWM_MODE[] {
			HIGH,
			LOW,
			NONE,
			UNKNOWN,
		};

	public static final List<PWM_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static PWM_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PWM_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static PWM_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PWM_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static PWM_MODE get(int value) {
		switch (value) {
			case HIGH_VALUE: return HIGH;
			case LOW_VALUE: return LOW;
			case NONE_VALUE: return NONE;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private PWM_MODE(int value, String name, String literal) {
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
	
} //PWM_MODE
