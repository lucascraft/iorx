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

public enum TRACK_SOLO_STATUS  {
	SOLO(1, "SOLO", "SOLO"),
	UNSOLO(0, "UNSOLO", "UNSOLO");
	public static final int SOLO_VALUE = 1;
	public static final int UNSOLO_VALUE = 0;
	private static final TRACK_SOLO_STATUS[] VALUES_ARRAY =
		new TRACK_SOLO_STATUS[] {
			SOLO,
			UNSOLO,
		};
	public static final List<TRACK_SOLO_STATUS> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static TRACK_SOLO_STATUS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRACK_SOLO_STATUS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static TRACK_SOLO_STATUS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRACK_SOLO_STATUS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static TRACK_SOLO_STATUS get(int value) {
		switch (value) {
			case SOLO_VALUE: return SOLO;
			case UNSOLO_VALUE: return UNSOLO;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private TRACK_SOLO_STATUS(int value, String name, String literal) {
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
	
} //TRACK_SOLO_STATUS
