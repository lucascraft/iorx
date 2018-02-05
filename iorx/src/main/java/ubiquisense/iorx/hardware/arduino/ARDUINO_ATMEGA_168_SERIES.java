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

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ARDUINO ATMEGA 168 SERIES</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.mdl.arduino.ArduinoPackage#getARDUINO_ATMEGA_168_SERIES()
 * @model
 * @generated
 */
public enum ARDUINO_ATMEGA_168_SERIES  {

	_168_ATMEGA_1280(0, "_168_ATMEGA_1280", "168 ATMega 1280"),

	_168_ATMEGA_328_PRO_8M_HZ(1, "_168_ATMEGA_328_PRO_8MHz", "168 ATMega328 Pro 8MHz"),

	_168_ATMEGA_328(2, "_168_ATMEGA_328", "168 ATMega 328"),

	_168_ATMEGA_DIECIMILA(3, "_168_ATMEGA_DIECIMILA", "168 ATMega Diecimila"),

	_168_NG(4, "_168_NG", "168 NG"),

	_168_PRO(5, "_168_PRO", "168 Pro"),

	UNKNOWN(6, "UNKNOWN", "UNKNOWN"), 

	_168_ATMEGA_168(7, "_168_ATMEGA_168", "168 ATMega 168"), 

	_168_ATMEGA_32U4(8, "_168_ATMEGA_32U4", "168 ATMega 32U4");

	public static final int _168_ATMEGA_1280_VALUE = 0;

	public static final int _168_ATMEGA_328_PRO_8M_HZ_VALUE = 1;

	public static final int _168_ATMEGA_328_VALUE = 2;

	public static final int _168_ATMEGA_DIECIMILA_VALUE = 3;

	public static final int _168_NG_VALUE = 4;

	public static final int _168_PRO_VALUE = 5;

	public static final int UNKNOWN_VALUE = 6;

	public static final int _168_ATMEGA_168_VALUE = 7;

	public static final int _168_ATMEGA_32U4_VALUE = 8;

	private static final ARDUINO_ATMEGA_168_SERIES[] VALUES_ARRAY =
		new ARDUINO_ATMEGA_168_SERIES[] {
			_168_ATMEGA_1280,
			_168_ATMEGA_328_PRO_8M_HZ,
			_168_ATMEGA_328,
			_168_ATMEGA_DIECIMILA,
			_168_NG,
			_168_PRO,
			UNKNOWN,
			_168_ATMEGA_168,
			_168_ATMEGA_32U4,
		};

	public static final List<ARDUINO_ATMEGA_168_SERIES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ARDUINO_ATMEGA_168_SERIES get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_ATMEGA_168_SERIES result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_ATMEGA_168_SERIES getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_ATMEGA_168_SERIES result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_ATMEGA_168_SERIES get(int value) {
		switch (value) {
			case _168_ATMEGA_1280_VALUE: return _168_ATMEGA_1280;
			case _168_ATMEGA_328_PRO_8M_HZ_VALUE: return _168_ATMEGA_328_PRO_8M_HZ;
			case _168_ATMEGA_328_VALUE: return _168_ATMEGA_328;
			case _168_ATMEGA_DIECIMILA_VALUE: return _168_ATMEGA_DIECIMILA;
			case _168_NG_VALUE: return _168_NG;
			case _168_PRO_VALUE: return _168_PRO;
			case UNKNOWN_VALUE: return UNKNOWN;
			case _168_ATMEGA_168_VALUE: return _168_ATMEGA_168;
			case _168_ATMEGA_32U4_VALUE: return _168_ATMEGA_32U4;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;


	private ARDUINO_ATMEGA_168_SERIES(int value, String name, String literal) {
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
	
} //ARDUINO_ATMEGA_168_SERIES
