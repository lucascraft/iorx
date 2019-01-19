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

public enum ChannelKind  {
	COLOUR(0, "COLOUR", "Colour"),
	GOBO(1, "GOBO", "Gobo"),
	MAINTENANCE(2, "MAINTENANCE", "Maintenance"),
	FX(3, "FX", "Effect"),
	SPEED(4, "SPEED", "Speed"),
	BEAM(5, "BEAM", "Beam"),
	INTENSITY(6, "INTENSITY", "Intensity"),
	SHUTTER(7, "SHUTTER", "Shutter"),
	TILT(8, "TILT", "Tilt"),
	PAN(9, "PAN", "Pan"),
	PRISM(10, "PRISM", "Prism"),
	NOTHING(11, "NOTHING", "Nothing");
	public static final int COLOUR_VALUE = 0;
	public static final int GOBO_VALUE = 1;
	public static final int MAINTENANCE_VALUE = 2;
	public static final int FX_VALUE = 3;
	public static final int SPEED_VALUE = 4;
	public static final int BEAM_VALUE = 5;
	public static final int INTENSITY_VALUE = 6;
	public static final int SHUTTER_VALUE = 7;
	public static final int TILT_VALUE = 8;
	public static final int PAN_VALUE = 9;
	public static final int PRISM_VALUE = 10;
	public static final int NOTHING_VALUE = 11;

	private static final ChannelKind[] VALUES_ARRAY =
		new ChannelKind[] {
			COLOUR,
			GOBO,
			MAINTENANCE,
			FX,
			SPEED,
			BEAM,
			INTENSITY,
			SHUTTER,
			TILT,
			PAN,
			PRISM,
			NOTHING,
		};

	public static final List<ChannelKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static ChannelKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ChannelKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static ChannelKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ChannelKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static ChannelKind get(int value) {
		switch (value) {
			case COLOUR_VALUE: return COLOUR;
			case GOBO_VALUE: return GOBO;
			case MAINTENANCE_VALUE: return MAINTENANCE;
			case FX_VALUE: return FX;
			case SPEED_VALUE: return SPEED;
			case BEAM_VALUE: return BEAM;
			case INTENSITY_VALUE: return INTENSITY;
			case SHUTTER_VALUE: return SHUTTER;
			case TILT_VALUE: return TILT;
			case PAN_VALUE: return PAN;
			case PRISM_VALUE: return PRISM;
			case NOTHING_VALUE: return NOTHING;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;

	private ChannelKind(int value, String name, String literal) {
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
	
} //ChannelKind
