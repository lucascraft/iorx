/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum PROC_KIND  {
	_ATMEGA168(0, "_ATMEGA168", "_ATMEGA168"),

	ATMEGA8(3, "ATMEGA8", "ATMEGA8");

	public static final int _ATMEGA168_VALUE = 0;

	public static final int ATMEGA8_VALUE = 3;

	private static final PROC_KIND[] VALUES_ARRAY =
		new PROC_KIND[] {
			_ATMEGA168,
			ATMEGA8,
		};

	public static final List<PROC_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static PROC_KIND get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PROC_KIND result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static PROC_KIND getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PROC_KIND result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static PROC_KIND get(int value) {
		switch (value) {
			case _ATMEGA168_VALUE: return _ATMEGA168;
			case ATMEGA8_VALUE: return ATMEGA8;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private PROC_KIND(int value, String name, String literal) {
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
	
} //PROC_KIND
