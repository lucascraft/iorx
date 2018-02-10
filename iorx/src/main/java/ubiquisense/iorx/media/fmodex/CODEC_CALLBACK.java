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



public enum CODEC_CALLBACK  {
	

	CLOSE(0, "CLOSE", "CLOSE"),

	

	GET_LENGTH(1, "GET_LENGTH", "GET_LENGTH"),

	

	GET_POSITION(2, "GET_POSITION", "GET_POSITION"),


	GET_WAVE_FORMAT(3, "GET_WAVE_FORMAT", "GET_WAVE_FORMAT"),


	META_DATA(4, "META_DATA", "META_DATA"),

	
	OPEN(5, "OPEN", "OPEN"),

	READ(6, "READ", "READ"),

	
	SET_POSITION(7, "SET_POSITION", "SET_POSITION"),

	
	SOUND_CREATE(8, "SOUND_CREATE", "SOUND_CREATE");

	
	public static final int CLOSE_VALUE = 0;

	
	public static final int GET_LENGTH_VALUE = 1;

	
	public static final int GET_POSITION_VALUE = 2;

	
	public static final int GET_WAVE_FORMAT_VALUE = 3;

	
	public static final int META_DATA_VALUE = 4;

	
	public static final int OPEN_VALUE = 5;


	public static final int READ_VALUE = 6;


	public static final int SET_POSITION_VALUE = 7;

	
	public static final int SOUND_CREATE_VALUE = 8;

	
	private static final CODEC_CALLBACK[] VALUES_ARRAY =
		new CODEC_CALLBACK[] {
			CLOSE,
			GET_LENGTH,
			GET_POSITION,
			GET_WAVE_FORMAT,
			META_DATA,
			OPEN,
			READ,
			SET_POSITION,
			SOUND_CREATE,
		};

	
	public static final List<CODEC_CALLBACK> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	
	public static CODEC_CALLBACK get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CODEC_CALLBACK result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}


	public static CODEC_CALLBACK getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CODEC_CALLBACK result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	
	public static CODEC_CALLBACK get(int value) {
		switch (value) {
			case CLOSE_VALUE: return CLOSE;
			case GET_LENGTH_VALUE: return GET_LENGTH;
			case GET_POSITION_VALUE: return GET_POSITION;
			case GET_WAVE_FORMAT_VALUE: return GET_WAVE_FORMAT;
			case META_DATA_VALUE: return META_DATA;
			case OPEN_VALUE: return OPEN;
			case READ_VALUE: return READ;
			case SET_POSITION_VALUE: return SET_POSITION;
			case SOUND_CREATE_VALUE: return SOUND_CREATE;
		}
		return null;
	}

	private final int value;

	
	private final String name;

	private final String literal;

	
	private CODEC_CALLBACK(int value, String name, String literal) {
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
	
} //CODEC_CALLBACK
