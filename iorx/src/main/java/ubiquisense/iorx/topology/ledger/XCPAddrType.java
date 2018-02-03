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

public enum XCPAddrType 
{
	XCP_ADDR_BLUETOOTH(0, "XCP_ADDR_BLUETOOTH", "BT"),
	XCP_ADDR_UDP(1, "XCP_ADDR_UDP", "UDP"), 
	XCP_ADDR_TCP(2, "XCP_ADDR_TCP", "TCP"),
	XCP_ADDR_USB(3, "XCP_ADDR_USB", "USB"),
	XCP_ADDR_HTTP(4, "XCP_ADDR_HTTP", "XCP_ADDR_HTTP"), 
	XCP_ADDR_MIDI(5, "XCP_ADDR_MIDI", "XCP_ADDR_MIDI"), 
	XCP_ADDR_XBEE(6, "XCP_ADDR_XBEE", "XCP_ADDR_XBEE");

	public static final int XCP_ADDR_BLUETOOTH_VALUE = 0;

	public static final int XCP_ADDR_UDP_VALUE = 1;

	public static final int XCP_ADDR_TCP_VALUE = 2;

	public static final int XCP_ADDR_USB_VALUE = 3;

	public static final int XCP_ADDR_HTTP_VALUE = 4;

	public static final int XCP_ADDR_MIDI_VALUE = 5;

	public static final int XCP_ADDR_XBEE_VALUE = 6;

	private static final XCPAddrType[] VALUES_ARRAY =
		new XCPAddrType[] {
			XCP_ADDR_BLUETOOTH,
			XCP_ADDR_UDP,
			XCP_ADDR_TCP,
			XCP_ADDR_USB,
			XCP_ADDR_HTTP,
			XCP_ADDR_MIDI,
			XCP_ADDR_XBEE,
		};

	public static final List<XCPAddrType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static XCPAddrType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			XCPAddrType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static XCPAddrType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			XCPAddrType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static XCPAddrType get(int value) {
		switch (value) {
			case XCP_ADDR_BLUETOOTH_VALUE: return XCP_ADDR_BLUETOOTH;
			case XCP_ADDR_UDP_VALUE: return XCP_ADDR_UDP;
			case XCP_ADDR_TCP_VALUE: return XCP_ADDR_TCP;
			case XCP_ADDR_USB_VALUE: return XCP_ADDR_USB;
			case XCP_ADDR_HTTP_VALUE: return XCP_ADDR_HTTP;
			case XCP_ADDR_MIDI_VALUE: return XCP_ADDR_MIDI;
			case XCP_ADDR_XBEE_VALUE: return XCP_ADDR_XBEE;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private XCPAddrType(int value, String name, String literal) {
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
	
} //XCPAddrType
