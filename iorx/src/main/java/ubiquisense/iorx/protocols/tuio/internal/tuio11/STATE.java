/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum STATE  {
	TUIO_ADDED(0, "TUIO_ADDED", "TUIO_ADDED"),
	TUIO_ACCELERATING(1, "TUIO_ACCELERATING", "TUIO_ACCELERATING"),
	TUIO_DECELERATING(2, "TUIO_DECELERATING", "TUIO_DECELERATING"),
	TUIO_STOPPED(3, "TUIO_STOPPED", "TUIO_STOPPED"),
	TUIO_REMOVED(4, "TUIO_REMOVED", "TUIO_REMOVED");
	public static final int TUIO_ADDED_VALUE = 0;
	public static final int TUIO_ACCELERATING_VALUE = 1;
	public static final int TUIO_DECELERATING_VALUE = 2;
	public static final int TUIO_STOPPED_VALUE = 3;
	public static final int TUIO_REMOVED_VALUE = 4;
	private static final STATE[] VALUES_ARRAY =
		new STATE[] {
			TUIO_ADDED,
			TUIO_ACCELERATING,
			TUIO_DECELERATING,
			TUIO_STOPPED,
			TUIO_REMOVED,
		};
	public static final List<STATE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static STATE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STATE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static STATE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STATE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static STATE get(int value) {
		switch (value) {
			case TUIO_ADDED_VALUE: return TUIO_ADDED;
			case TUIO_ACCELERATING_VALUE: return TUIO_ACCELERATING;
			case TUIO_DECELERATING_VALUE: return TUIO_DECELERATING;
			case TUIO_STOPPED_VALUE: return TUIO_STOPPED;
			case TUIO_REMOVED_VALUE: return TUIO_REMOVED;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private STATE(int value, String name, String literal) {
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
	
} //STATE
