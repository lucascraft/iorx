/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum OpenDMXStates  {
	DISC_MUTE(0, "DISC_MUTE", "DISC_MUTE"),
	DISC_UN_MUTE(1, "DISC_UN_MUTE", "DISC_UN_MUTE"),
	ACK_TIMER(2, "ACK_TIMER", "ACK_TIMER"),
	NONE(3, "NONE", "NONE");
	public static final int DISC_MUTE_VALUE = 0;
	public static final int DISC_UN_MUTE_VALUE = 1;
	public static final int ACK_TIMER_VALUE = 2;
	public static final int NONE_VALUE = 3;
	private static final OpenDMXStates[] VALUES_ARRAY =
		new OpenDMXStates[] {
			DISC_MUTE,
			DISC_UN_MUTE,
			ACK_TIMER,
			NONE,
		};
	public static final List<OpenDMXStates> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static OpenDMXStates get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OpenDMXStates result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static OpenDMXStates getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OpenDMXStates result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static OpenDMXStates get(int value) {
		switch (value) {
			case DISC_MUTE_VALUE: return DISC_MUTE;
			case DISC_UN_MUTE_VALUE: return DISC_UN_MUTE;
			case ACK_TIMER_VALUE: return ACK_TIMER;
			case NONE_VALUE: return NONE;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private OpenDMXStates(int value, String name, String literal) {
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
	
} //OpenDMXStates
