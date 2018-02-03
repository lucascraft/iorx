package ubiquisense.iorx.cmd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PRIORITY {
	LOWEST(0, "LOWEST", "LOWEST"),
	LOW(1, "LOW", "LOW"),
	MEDIUM(2, "MEDIUM", "MEDIUM"),
	HIGH(3, "HIGH", "HIGH"),
	HIGHEST(4, "HIGHEST", "HIGHEST"),
	NONE(-1, "NONE", "NONE"), 
	VITAL(5, "VITAL", "VITAL");

	public static final int LOWEST_VALUE = 0;

	public static final int LOW_VALUE = 1;

	public static final int MEDIUM_VALUE = 2;

	public static final int HIGH_VALUE = 3;

	public static final int HIGHEST_VALUE = 4;

	public static final int NONE_VALUE = -1;

	public static final int VITAL_VALUE = 5;

	private static final PRIORITY[] VALUES_ARRAY =
		new PRIORITY[] {
			LOWEST,
			LOW,
			MEDIUM,
			HIGH,
			HIGHEST,
			NONE,
			VITAL,
		};

	public static final List<PRIORITY> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static PRIORITY get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PRIORITY result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static PRIORITY getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PRIORITY result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static PRIORITY get(int value) {
		switch (value) {
			case LOWEST_VALUE: return LOWEST;
			case LOW_VALUE: return LOW;
			case MEDIUM_VALUE: return MEDIUM;
			case HIGH_VALUE: return HIGH;
			case HIGHEST_VALUE: return HIGHEST;
			case NONE_VALUE: return NONE;
			case VITAL_VALUE: return VITAL;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private PRIORITY(int value, String name, String literal) {
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
	
} //PRIORITY
