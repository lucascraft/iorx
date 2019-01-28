package ubiquisense.iorx.protocols.ableton.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum CLIP_STATE  {
	NO_CLIP(4, "NO_CLIP", "NO_CLIP"),
	HAS_CLIP(1, "HAS_CLIP", "HAS_CLIP"),
	PLAYING(2, "PLAYING", "PLAYING"),
	TRIGGERED(3, "TRIGGERED", "TRIGGERED"),
	STOP(0, "STOP", "STOP");

	public static final int NO_CLIP_VALUE = 4;
	public static final int HAS_CLIP_VALUE = 1;
	public static final int PLAYING_VALUE = 2;
	public static final int TRIGGERED_VALUE = 3;
	public static final int STOP_VALUE = 0;
	private static final CLIP_STATE[] VALUES_ARRAY =
		new CLIP_STATE[] {
			NO_CLIP,
			HAS_CLIP,
			PLAYING,
			TRIGGERED,
			STOP,
		};
	public static final List<CLIP_STATE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static CLIP_STATE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CLIP_STATE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static CLIP_STATE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CLIP_STATE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static CLIP_STATE get(int value) {
		switch (value) {
			case NO_CLIP_VALUE: return NO_CLIP;
			case HAS_CLIP_VALUE: return HAS_CLIP;
			case PLAYING_VALUE: return PLAYING;
			case TRIGGERED_VALUE: return TRIGGERED;
			case STOP_VALUE: return STOP;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private CLIP_STATE(int value, String name, String literal) {
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
	
} //CLIP_STATE
