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


public enum PIN_MODE{
	INPUT(0, "INPUT", "Input"),

	OUTPUT(1, "OUTPUT", "Output"),

	ANALOG(2, "ANALOG", "Analog"),

	PWM(3, "PWM", "PWM"),

	SERVO(4, "SERVO", "Servo"),

	SHIFT(5, "SHIFT", "Shift"),

	I2C(6, "I2C", "I2C"),

	UNKNOWN(0, "UNKNOWN", "UNKNOWN");

	public static final int INPUT_VALUE = 0;

	public static final int OUTPUT_VALUE = 1;

	public static final int ANALOG_VALUE = 2;

	public static final int PWM_VALUE = 3;

	public static final int SERVO_VALUE = 4;

	public static final int SHIFT_VALUE = 5;

	public static final int I2C_VALUE = 6;

	public static final int UNKNOWN_VALUE = 0;

	private static final PIN_MODE[] VALUES_ARRAY =
		new PIN_MODE[] {
			INPUT,
			OUTPUT,
			ANALOG,
			PWM,
			SERVO,
			SHIFT,
			I2C,
			UNKNOWN,
		};

	public static final List<PIN_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static PIN_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PIN_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static PIN_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PIN_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static PIN_MODE get(int value) {
		switch (value) {
			case INPUT_VALUE: return INPUT;
			case OUTPUT_VALUE: return OUTPUT;
			case ANALOG_VALUE: return ANALOG;
			case PWM_VALUE: return PWM;
			case SERVO_VALUE: return SERVO;
			case SHIFT_VALUE: return SHIFT;
			case I2C_VALUE: return I2C;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private PIN_MODE(int value, String name, String literal) {
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
	
} //PIN_MODE
