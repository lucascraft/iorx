/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TRACK_CONTROL {
	PLAY(0, "PLAY", "PLAY"),
	STOP(1, "STOP", "STOP");
	public static final int PLAY_VALUE = 0;
	public static final int STOP_VALUE = 1;
	private static final TRACK_CONTROL[] VALUES_ARRAY =
		new TRACK_CONTROL[] {
			PLAY,
			STOP,
		};
	public static final List<TRACK_CONTROL> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static TRACK_CONTROL get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRACK_CONTROL result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static TRACK_CONTROL getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRACK_CONTROL result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static TRACK_CONTROL get(int value) {
		switch (value) {
			case PLAY_VALUE: return PLAY;
			case STOP_VALUE: return STOP;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private TRACK_CONTROL(int value, String name, String literal) {
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
	
} //TRACK_CONTROL
