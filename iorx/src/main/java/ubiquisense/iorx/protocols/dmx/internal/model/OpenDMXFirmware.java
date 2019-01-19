/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum OpenDMXFirmware {
	NORMAL(1, "NORMAL", "NORMAL"),
	RDM(2, "RDM", "RDM"),
	RDM_SNIFFER(3, "RDM_SNIFFER", "RDM_SNIFFER");
	public static final int NORMAL_VALUE = 1;
	public static final int RDM_VALUE = 2;
	public static final int RDM_SNIFFER_VALUE = 3;
	private static final OpenDMXFirmware[] VALUES_ARRAY =
		new OpenDMXFirmware[] {
			NORMAL,
			RDM,
			RDM_SNIFFER,
		};
	public static final List<OpenDMXFirmware> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static OpenDMXFirmware get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OpenDMXFirmware result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}
	public static OpenDMXFirmware getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OpenDMXFirmware result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}
	public static OpenDMXFirmware get(int value) {
		switch (value) {
			case NORMAL_VALUE: return NORMAL;
			case RDM_VALUE: return RDM;
			case RDM_SNIFFER_VALUE: return RDM_SNIFFER;
		}
		return null;
	}
	private final int value;
	private final String name;
	private final String literal;
	private OpenDMXFirmware(int value, String name, String literal) {
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
	
} //OpenDMXFirmware
