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

public enum TRACK_ARM_STATUS  {
	ARMED(1, "ARMED", "ARMED"),
	DISARMED(0, "DISARMED", "DISARMED");
	public static final int ARMED_VALUE = 1;
	public static final int DISARMED_VALUE = 0;
	private static final TRACK_ARM_STATUS[] VALUES_ARRAY =
		new TRACK_ARM_STATUS[] {
			ARMED,
			DISARMED,
		};
	public static final List<TRACK_ARM_STATUS> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static TRACK_ARM_STATUS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRACK_ARM_STATUS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static TRACK_ARM_STATUS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRACK_ARM_STATUS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static TRACK_ARM_STATUS get(int value) {
		switch (value) {
			case ARMED_VALUE: return ARMED;
			case DISARMED_VALUE: return DISARMED;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private TRACK_ARM_STATUS(int value, String name, String literal) {
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
	
} //TRACK_ARM_STATUS
