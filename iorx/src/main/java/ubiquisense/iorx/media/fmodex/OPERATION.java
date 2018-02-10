/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum OPERATION {
	
	OPEN_STATE(0, "OPEN_STATE", "OPEN_STATE"),


	OUTPUT_TYPE(1, "OUTPUT_TYPE", "OUTPUT_TYPE"),


	PLUGIN_TYPE(2, "PLUGIN_TYPE", "PLUGIN_TYPE"),

	
	RESULT(3, "RESULT", "RESULT"),


	SOUND_FORMAT(4, "SOUND_FORMAT", "SOUND_FORMAT"),


	SOUND_TYPE(5, "SOUND_TYPE", "SOUND_TYPE"),


	SOUNDGROUP_BEHAVIOR(6, "SOUNDGROUP_BEHAVIOR", "SOUNDGROUP_BEHAVIOR"),

	SPEAKER(7, "SPEAKER", "SPEAKER"),

	
	SPEAKER_MAP_TYPE(8, "SPEAKER_MAP_TYPE", "SPEAKER_MAP_TYPE"),

	SPEAKER_MODE(9, "SPEAKER_MODE", "SPEAKER_MODE"),

	
	SYSTEM_CALLBACK_TYPE(10, "SYSTEM_CALLBACK_TYPE", "SYSTEM_CALLBACK_TYPE"),

	
	TAG_DATA_TYPE(11, "TAG_DATA_TYPE", "TAG_DATA_TYPE"),


	TAG_TYPE(12, "TAG_TYPE", "TAG_TYPE");

	
	public static final int OPEN_STATE_VALUE = 0;

	
	public static final int OUTPUT_TYPE_VALUE = 1;

	
	public static final int PLUGIN_TYPE_VALUE = 2;

	
	public static final int RESULT_VALUE = 3;

	
	public static final int SOUND_FORMAT_VALUE = 4;

	
	public static final int SOUND_TYPE_VALUE = 5;

	
	public static final int SOUNDGROUP_BEHAVIOR_VALUE = 6;

	
	public static final int SPEAKER_VALUE = 7;

	
	public static final int SPEAKER_MAP_TYPE_VALUE = 8;

	public static final int SPEAKER_MODE_VALUE = 9;


	public static final int SYSTEM_CALLBACK_TYPE_VALUE = 10;


	public static final int TAG_DATA_TYPE_VALUE = 11;


	public static final int TAG_TYPE_VALUE = 12;

	
	private static final OPERATION[] VALUES_ARRAY =
		new OPERATION[] {
			OPEN_STATE,
			OUTPUT_TYPE,
			PLUGIN_TYPE,
			RESULT,
			SOUND_FORMAT,
			SOUND_TYPE,
			SOUNDGROUP_BEHAVIOR,
			SPEAKER,
			SPEAKER_MAP_TYPE,
			SPEAKER_MODE,
			SYSTEM_CALLBACK_TYPE,
			TAG_DATA_TYPE,
			TAG_TYPE,
		};

	
	public static final List<OPERATION> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));


	public static OPERATION get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OPERATION result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static OPERATION getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OPERATION result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static OPERATION get(int value) {
		switch (value) {
			case OPEN_STATE_VALUE: return OPEN_STATE;
			case OUTPUT_TYPE_VALUE: return OUTPUT_TYPE;
			case PLUGIN_TYPE_VALUE: return PLUGIN_TYPE;
			case RESULT_VALUE: return RESULT;
			case SOUND_FORMAT_VALUE: return SOUND_FORMAT;
			case SOUND_TYPE_VALUE: return SOUND_TYPE;
			case SOUNDGROUP_BEHAVIOR_VALUE: return SOUNDGROUP_BEHAVIOR;
			case SPEAKER_VALUE: return SPEAKER;
			case SPEAKER_MAP_TYPE_VALUE: return SPEAKER_MAP_TYPE;
			case SPEAKER_MODE_VALUE: return SPEAKER_MODE;
			case SYSTEM_CALLBACK_TYPE_VALUE: return SYSTEM_CALLBACK_TYPE;
			case TAG_DATA_TYPE_VALUE: return TAG_DATA_TYPE;
			case TAG_TYPE_VALUE: return TAG_TYPE;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private OPERATION(int value, String name, String literal) {
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
	
} //OPERATION
