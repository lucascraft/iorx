/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ubiquino.dsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PortConfigKind  {
	ANALOGIC(0, "ANALOGIC", "ANALOGIC"),
	PWM(1, "PWM", "PWM"),
	INPUT(2, "INPUT", "INPUT"),
	OUTPUT(3, "OUTPUT", "OUTPUT"),
	HIGH(4, "HIGH", "HIGH"),
	LOW(5, "LOW", "LOW"),
	SERVO(6, "SERVO", "SERVO"),
	DIGITAL(7, "DIGITAL", "DIGITAL"),
	UNKNOWN(0, "UNKNOWN", "UNKNOWN");

	public static final int ANALOGIC_VALUE = 0;
	public static final int PWM_VALUE = 1;
	public static final int INPUT_VALUE = 2;
	public static final int OUTPUT_VALUE = 3;
	public static final int HIGH_VALUE = 4;
	public static final int LOW_VALUE = 5;
	public static final int SERVO_VALUE = 6;
	public static final int DIGITAL_VALUE = 7;
	public static final int UNKNOWN_VALUE = 0;
	private static final PortConfigKind[] VALUES_ARRAY =
		new PortConfigKind[] {
			ANALOGIC,
			PWM,
			INPUT,
			OUTPUT,
			HIGH,
			LOW,
			SERVO,
			DIGITAL,
			UNKNOWN,
		};

	public static final List<PortConfigKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static PortConfigKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PortConfigKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static PortConfigKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PortConfigKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static PortConfigKind get(int value) {
		switch (value) {
			case ANALOGIC_VALUE: return ANALOGIC;
			case PWM_VALUE: return PWM;
			case INPUT_VALUE: return INPUT;
			case OUTPUT_VALUE: return OUTPUT;
			case HIGH_VALUE: return HIGH;
			case LOW_VALUE: return LOW;
			case SERVO_VALUE: return SERVO;
			case DIGITAL_VALUE: return DIGITAL;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private PortConfigKind(int value, String name, String literal) {
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
	
} //PortConfigKind
