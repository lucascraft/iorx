/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Mime  {
	BLUETOOTH_MIME(0, "BLUETOOTH_MIME", "btserial://"),
	UDP_MIME(1, "UDP_MIME", "udpsocket://"),
	TCP_MIME(2, "TCP_MIME", "tcpsocket://"),
	USB_MIME(3, "USB_MIME", "usbsp://"),
	XBEE_MIME(4, "XBEE_MIME", "xbsp://");
	public static final int BLUETOOTH_MIME_VALUE = 0;
	public static final int UDP_MIME_VALUE = 1;
	public static final int TCP_MIME_VALUE = 2;
	public static final int USB_MIME_VALUE = 3;
	public static final int XBEE_MIME_VALUE = 4;
	private static final Mime[] VALUES_ARRAY =
		new Mime[] {
			BLUETOOTH_MIME,
			UDP_MIME,
			TCP_MIME,
			USB_MIME,
			XBEE_MIME,
		};
	public static final List<Mime> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static Mime get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Mime result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static Mime getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Mime result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static Mime get(int value) {
		switch (value) {
			case BLUETOOTH_MIME_VALUE: return BLUETOOTH_MIME;
			case UDP_MIME_VALUE: return UDP_MIME;
			case TCP_MIME_VALUE: return TCP_MIME;
			case USB_MIME_VALUE: return USB_MIME;
			case XBEE_MIME_VALUE: return XBEE_MIME;
		}
		return null;
	}

	private final int value;
	private final String name;
	private final String literal;
	private Mime(int value, String name, String literal) {
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
	
} //Mime
