package ubiquisense.iorx.qx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum EVENT_KIND {


	RX_READY(0, "RX_READY", "RX_READY"),
	TX_DONE(3, "TX_DONE", "TX_DONE"),
	UNKNOWN(-1, "UNKNOWN", "UNKNOWN"),
	RX_FRAME(4, "RX_FRAME", "RX_FRAME"),
	RX_DONE(2, "RX_DONE", "RX_DONE"),
	TX_READY(1, "TX_READY", "TX_READY"), 
	TX_FRAME(5, "TX_FRAME", "TX_FRAME");

	public static final int RX_READY_VALUE = 0;
	public static final int TX_READY_VALUE = 1;
	public static final int RX_DONE_VALUE = 2;
	public static final int TX_DONE_VALUE = 3;
	public static final int RX_FRAME_VALUE = 4;
	public static final int TX_FRAME_VALUE = 5;
	public static final int UNKNOWN_VALUE = -1;

	private static final EVENT_KIND[] VALUES_ARRAY =
		new EVENT_KIND[] {
			RX_READY,
			TX_DONE,
			UNKNOWN,
			RX_FRAME,
			RX_DONE,
			TX_READY,
			TX_FRAME,
		};

	public static final List<EVENT_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static EVENT_KIND get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EVENT_KIND result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static EVENT_KIND getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EVENT_KIND result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static EVENT_KIND get(int value) {
		switch (value) {
			case RX_READY_VALUE: return RX_READY;
			case TX_DONE_VALUE: return TX_DONE;
			case UNKNOWN_VALUE: return UNKNOWN;
			case RX_FRAME_VALUE: return RX_FRAME;
			case RX_DONE_VALUE: return RX_DONE;
			case TX_READY_VALUE: return TX_READY;
			case TX_FRAME_VALUE: return TX_FRAME;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private EVENT_KIND(int value, String name, String literal) {
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
}
