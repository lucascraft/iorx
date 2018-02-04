/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.firmata.internal.dsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum FIRMATA_I2C_ADDR_MODE  {
	I2C_ADDR_MODE_7BITS(0, "I2C_ADDR_MODE_7_BITS", "I2C_ADDR_MODE_7_BITS"),
	I2C_ADDR_MODE_10_BITS(1, "I2C_ADDR_MODE_10_BITS", "I2C_ADDR_MODE_10_BITS");
	public static final int I2C_ADDR_MODE_7BITS_VALUE = 0;
	public static final int I2C_ADDR_MODE_10_BITS_VALUE = 1;
	private static final FIRMATA_I2C_ADDR_MODE[] VALUES_ARRAY =
		new FIRMATA_I2C_ADDR_MODE[] {
			I2C_ADDR_MODE_7BITS,
			I2C_ADDR_MODE_10_BITS,
		};
	public static final List<FIRMATA_I2C_ADDR_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static FIRMATA_I2C_ADDR_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FIRMATA_I2C_ADDR_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static FIRMATA_I2C_ADDR_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FIRMATA_I2C_ADDR_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static FIRMATA_I2C_ADDR_MODE get(int value) {
		switch (value) {
			case I2C_ADDR_MODE_7BITS_VALUE: return I2C_ADDR_MODE_7BITS;
			case I2C_ADDR_MODE_10_BITS_VALUE: return I2C_ADDR_MODE_10_BITS;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;

	private FIRMATA_I2C_ADDR_MODE(int value, String name, String literal) {
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
	
} //FIRMATA_I2C_ADDR_MODE
