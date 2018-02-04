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

public enum FIRMATA_I2C_RW_MODE  {
	WRITE(0, "WRITE", "WRITE"),
	READ_ONCE(1, "READ_ONCE", "READ_ONCE"),
	READ_CONTINUOUSLY(2, "READ_CONTINUOUSLY", "READ_CONTINUOUSLY"),
	STOP_READING(3, "STOP_READING", "STOP_READING");
	public static final int WRITE_VALUE = 0;
	public static final int READ_ONCE_VALUE = 1;
	public static final int READ_CONTINUOUSLY_VALUE = 2;
	public static final int STOP_READING_VALUE = 3;
	private static final FIRMATA_I2C_RW_MODE[] VALUES_ARRAY =
		new FIRMATA_I2C_RW_MODE[] {
			WRITE,
			READ_ONCE,
			READ_CONTINUOUSLY,
			STOP_READING,
		};

	public static final List<FIRMATA_I2C_RW_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static FIRMATA_I2C_RW_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FIRMATA_I2C_RW_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static FIRMATA_I2C_RW_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FIRMATA_I2C_RW_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static FIRMATA_I2C_RW_MODE get(int value) {
		switch (value) {
			case WRITE_VALUE: return WRITE;
			case READ_ONCE_VALUE: return READ_ONCE;
			case READ_CONTINUOUSLY_VALUE: return READ_CONTINUOUSLY;
			case STOP_READING_VALUE: return STOP_READING;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private FIRMATA_I2C_RW_MODE(int value, String name, String literal) {
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
	
} //FIRMATA_I2C_RW_MODE
