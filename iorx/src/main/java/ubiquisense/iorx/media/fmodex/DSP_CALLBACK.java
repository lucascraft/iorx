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

public enum DSP_CALLBACK {

	CREATE(0, "CREATE", "CREATE"),


	DIALOG(1, "DIALOG", "DIALOG"),


	GET_PARAM(2, "GET_PARAM", "GET_PARAM"),

	
	READ(3, "READ", "READ"),


	RELEASE(4, "RELEASE", "RELEASE"),


	RESET(5, "RESET", "RESET"),

	
	SET_PARAM(6, "SET_PARAM", "SET_PARAM"),

	
	SET_POSITION(7, "SET_POSITION", "SET_POSITION");

	
	public static final int CREATE_VALUE = 0;

	
	public static final int DIALOG_VALUE = 1;


	public static final int GET_PARAM_VALUE = 2;

	
	public static final int READ_VALUE = 3;

	
	public static final int RELEASE_VALUE = 4;

	
	public static final int RESET_VALUE = 5;

	
	public static final int SET_PARAM_VALUE = 6;

	
	public static final int SET_POSITION_VALUE = 7;

	
	private static final DSP_CALLBACK[] VALUES_ARRAY =
		new DSP_CALLBACK[] {
			CREATE,
			DIALOG,
			GET_PARAM,
			READ,
			RELEASE,
			RESET,
			SET_PARAM,
			SET_POSITION,
		};

	
	public static final List<DSP_CALLBACK> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	
	public static DSP_CALLBACK get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DSP_CALLBACK result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}


	public static DSP_CALLBACK getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DSP_CALLBACK result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	
	public static DSP_CALLBACK get(int value) {
		switch (value) {
			case CREATE_VALUE: return CREATE;
			case DIALOG_VALUE: return DIALOG;
			case GET_PARAM_VALUE: return GET_PARAM;
			case READ_VALUE: return READ;
			case RELEASE_VALUE: return RELEASE;
			case RESET_VALUE: return RESET;
			case SET_PARAM_VALUE: return SET_PARAM;
			case SET_POSITION_VALUE: return SET_POSITION;
		}
		return null;
	}


	private final int value;

	
	private final String name;

	
	private final String literal;

	
	private DSP_CALLBACK(int value, String name, String literal) {
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
	
} //DSP_CALLBACK
