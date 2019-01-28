/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveParam;

public class LiveParamImpl  implements LiveParam {
	String key;
	String value;
	String min;
	String max;
	String type;
	String name;
	
	public LiveParamImpl() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String newKey) {
		key = newKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String newValue) {
		value = newValue;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String newMin) {
		min = newMin;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String newMax) {
		max = newMax;
	}

	public String getType() {
		return type;
	}

	public void setType(String newType) {
		type = newType;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

} //LiveParamImpl
