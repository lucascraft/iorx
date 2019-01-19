/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DMXFixtureBehavior{
	LOOP(0, "LOOP", "LOOP"),
	ONCE(1, "ONCE", "ONCE"), 
	PING_PONG(2, "PING_PONG", "PING_PONG");
	public static final int LOOP_VALUE = 0;
	public static final int ONCE_VALUE = 1;
	public static final int PING_PONG_VALUE = 2;
	private static final DMXFixtureBehavior[] VALUES_ARRAY =
		new DMXFixtureBehavior[] {
			LOOP,
			ONCE,
			PING_PONG,
		};
	public static final List<DMXFixtureBehavior> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static DMXFixtureBehavior get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DMXFixtureBehavior result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static DMXFixtureBehavior getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DMXFixtureBehavior result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static DMXFixtureBehavior get(int value) {
		switch (value) {
			case LOOP_VALUE: return LOOP;
			case ONCE_VALUE: return ONCE;
			case PING_PONG_VALUE: return PING_PONG;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private DMXFixtureBehavior(int value, String name, String literal) {
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
	
} //DMXFixtureBehavior
