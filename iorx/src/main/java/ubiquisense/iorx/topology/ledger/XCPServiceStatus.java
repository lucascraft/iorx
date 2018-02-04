/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.ledger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum XCPServiceStatus  {
	
	PROBING(0, "PROBING", "PROBING"),
	DISCOVERED(1, "DISCOVERED", "DISCOVERED"),
	RESOLVED(2, "RESOLVED", "RESOLVED"),
	READY(3, "READY", "READY"),
	UNAVAILABLE(4, "UNAVAILABLE", "UNAVAILABLE"),
	STARTING(5, "STARTING", "STARTING"),
	STOP(6, "STOP", "STOP"),
	CONNECTED(7, "CONNECTED", "CONNECTED");

	public static final int PROBING_VALUE = 0;
	public static final int DISCOVERED_VALUE = 1;
	public static final int RESOLVED_VALUE = 2;
	public static final int READY_VALUE = 3;
	public static final int UNAVAILABLE_VALUE = 4;
	public static final int STARTING_VALUE = 5;
	public static final int STOP_VALUE = 6;
	public static final int CONNECTED_VALUE = 7;

	private static final XCPServiceStatus[] VALUES_ARRAY =
		new XCPServiceStatus[] {
			PROBING,
			DISCOVERED,
			RESOLVED,
			READY,
			UNAVAILABLE,
			STARTING,
			STOP,
			CONNECTED,
		};

	public static final List<XCPServiceStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static XCPServiceStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			XCPServiceStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static XCPServiceStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			XCPServiceStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static XCPServiceStatus get(int value) {
		switch (value) {
			case PROBING_VALUE: return PROBING;
			case DISCOVERED_VALUE: return DISCOVERED;
			case RESOLVED_VALUE: return RESOLVED;
			case READY_VALUE: return READY;
			case UNAVAILABLE_VALUE: return UNAVAILABLE;
			case STARTING_VALUE: return STARTING;
			case STOP_VALUE: return STOP;
			case CONNECTED_VALUE: return CONNECTED;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private XCPServiceStatus(int value, String name, String literal) {
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
	
} //XCPServiceStatus
