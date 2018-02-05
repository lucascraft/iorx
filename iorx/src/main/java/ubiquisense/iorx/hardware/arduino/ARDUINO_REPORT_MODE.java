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

public enum ARDUINO_REPORT_MODE  {

	ACTIVATE(1, "ACTIVATE", "Activate"),


	DEACTIVATE(0, "DEACTIVATE", "Deactivate");


	public static final int ACTIVATE_VALUE = 1;


	public static final int DEACTIVATE_VALUE = 0;

	private static final ARDUINO_REPORT_MODE[] VALUES_ARRAY =
		new ARDUINO_REPORT_MODE[] {
			ACTIVATE,
			DEACTIVATE,
		};


	public static final List<ARDUINO_REPORT_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));


	public static ARDUINO_REPORT_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_REPORT_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_REPORT_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_REPORT_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_REPORT_MODE get(int value) {
		switch (value) {
			case ACTIVATE_VALUE: return ACTIVATE;
			case DEACTIVATE_VALUE: return DEACTIVATE;
		}
		return null;
	}


	private final int value;

	private final String name;

	private final String literal;

	private ARDUINO_REPORT_MODE(int value, String name, String literal) {
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
	
} //ARDUINO_REPORT_MODE
