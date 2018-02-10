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


public enum STRUCTURES  {
	
	ADVANCED_SETTINGS(0, "ADVANCED_SETTINGS", "ADVANCED_SETTINGS"),

	
	ASYNC_READ_INFO(1, "ASYNC_READ_INFO", "ASYNC_READ_INFO"),

	
	CD_TOC(2, "CD_TOC", "CD_TOC"),

	CODEC_DESCRIPTION(3, "CODEC_DESCRIPTION", "CODEC_DESCRIPTION"),


	CODEC_STATE(4, "CODEC_STATE", "CODEC_STATE"),


	CODEC_WAVE_FORMAT(5, "CODEC_WAVE_FORMAT", "CODEC_WAVE_FORMAT"),

	
	CREATE_SOUND_INFO(6, "CREATE_SOUND_INFO", "CREATE_SOUND_INFO"),

	
	DSP_DESCRIPTION(7, "DSP_DESCRIPTION", "DSP_DESCRIPTION"),

	DSP_PARAMETER_DESC(8, "DSP_PARAMETER_DESC", "DSP_PARAMETER_DESC"),


	DSP_STATE(9, "DSP_STATE", "DSP_STATE"),

	
	GUID(10, "GUID", "GUID"),

	
	MEMORY_USAGE_DETAILS(11, "MEMORY_USAGE_DETAILS", "MEMORY_USAGE_DETAILS"),

	REVERB_CHANNEL_PROPERTIES(12, "REVERB_CHANNEL_PROPERTIES", "REVERB_CHANNEL_PROPERTIES"),

	
	REVERB_PROPERTIES(13, "REVERB_PROPERTIES", "REVERB_PROPERTIES"),


	SYNC_POINT(14, "SYNC_POINT", "SYNC_POINT"),

	TAG(15, "TAG", "TAG"),

	VECTOR(16, "VECTOR", "VECTOR");

	public static final int ADVANCED_SETTINGS_VALUE = 0;

	public static final int ASYNC_READ_INFO_VALUE = 1;


	public static final int CD_TOC_VALUE = 2;


	public static final int CODEC_DESCRIPTION_VALUE = 3;


	public static final int CODEC_STATE_VALUE = 4;

	
	public static final int CODEC_WAVE_FORMAT_VALUE = 5;

	
	public static final int CREATE_SOUND_INFO_VALUE = 6;


	public static final int DSP_DESCRIPTION_VALUE = 7;

	public static final int DSP_PARAMETER_DESC_VALUE = 8;


	public static final int DSP_STATE_VALUE = 9;


	public static final int GUID_VALUE = 10;

	public static final int MEMORY_USAGE_DETAILS_VALUE = 11;


	public static final int REVERB_CHANNEL_PROPERTIES_VALUE = 12;


	public static final int REVERB_PROPERTIES_VALUE = 13;

	
	public static final int SYNC_POINT_VALUE = 14;

	public static final int TAG_VALUE = 15;


	public static final int VECTOR_VALUE = 16;


	private static final STRUCTURES[] VALUES_ARRAY =
		new STRUCTURES[] {
			ADVANCED_SETTINGS,
			ASYNC_READ_INFO,
			CD_TOC,
			CODEC_DESCRIPTION,
			CODEC_STATE,
			CODEC_WAVE_FORMAT,
			CREATE_SOUND_INFO,
			DSP_DESCRIPTION,
			DSP_PARAMETER_DESC,
			DSP_STATE,
			GUID,
			MEMORY_USAGE_DETAILS,
			REVERB_CHANNEL_PROPERTIES,
			REVERB_PROPERTIES,
			SYNC_POINT,
			TAG,
			VECTOR,
		};

	
	public static final List<STRUCTURES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	
	public static STRUCTURES get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STRUCTURES result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}


	public static STRUCTURES getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STRUCTURES result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}


	public static STRUCTURES get(int value) {
		switch (value) {
			case ADVANCED_SETTINGS_VALUE: return ADVANCED_SETTINGS;
			case ASYNC_READ_INFO_VALUE: return ASYNC_READ_INFO;
			case CD_TOC_VALUE: return CD_TOC;
			case CODEC_DESCRIPTION_VALUE: return CODEC_DESCRIPTION;
			case CODEC_STATE_VALUE: return CODEC_STATE;
			case CODEC_WAVE_FORMAT_VALUE: return CODEC_WAVE_FORMAT;
			case CREATE_SOUND_INFO_VALUE: return CREATE_SOUND_INFO;
			case DSP_DESCRIPTION_VALUE: return DSP_DESCRIPTION;
			case DSP_PARAMETER_DESC_VALUE: return DSP_PARAMETER_DESC;
			case DSP_STATE_VALUE: return DSP_STATE;
			case GUID_VALUE: return GUID;
			case MEMORY_USAGE_DETAILS_VALUE: return MEMORY_USAGE_DETAILS;
			case REVERB_CHANNEL_PROPERTIES_VALUE: return REVERB_CHANNEL_PROPERTIES;
			case REVERB_PROPERTIES_VALUE: return REVERB_PROPERTIES;
			case SYNC_POINT_VALUE: return SYNC_POINT;
			case TAG_VALUE: return TAG;
			case VECTOR_VALUE: return VECTOR;
		}
		return null;
	}

	
	private final int value;

	
	private final String name;

	
	private final String literal;

	
	private STRUCTURES(int value, String name, String literal) {
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
	
} //STRUCTURES
