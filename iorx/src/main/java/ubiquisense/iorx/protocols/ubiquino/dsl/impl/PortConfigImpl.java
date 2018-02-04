/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ubiquino.dsl.impl;

import ubiquisense.iorx.hardware.arduino.PIN_MODE;
import ubiquisense.iorx.hardware.arduino.PWM_MODE;
import ubiquisense.iorx.hardware.arduino.Port;
import ubiquisense.iorx.protocols.ubiquino.dsl.PortConfig;
import ubiquisense.iorx.protocols.ubiquino.dsl.PortConfigKind;
import ubiquisense.iorx.protocols.ubiquino.dsl.PortSampler;

public class PortConfigImpl  implements PortConfig {

	protected Port target;

	protected static final PortConfigKind KIND_EDEFAULT = PortConfigKind.ANALOGIC;

	protected PortConfigKind kind = KIND_EDEFAULT;

	protected static final boolean ENABLED_EDEFAULT = false;

	protected boolean enabled = ENABLED_EDEFAULT;

	protected static final PIN_MODE MODE_EDEFAULT = PIN_MODE.INPUT;

	protected PIN_MODE mode = MODE_EDEFAULT;

	protected static final PWM_MODE PWM_EDEFAULT = PWM_MODE.HIGH;

	protected PWM_MODE pwm = PWM_EDEFAULT;

	protected static final int CHANNEL_EDEFAULT = 0;

	protected int channel = CHANNEL_EDEFAULT;

	protected PortSampler sampler;

	public Port getTarget() {
		return target;
	}

	public Port basicGetTarget() {
		return target;
	}

	public void setTarget(Port newTarget) {
		target = newTarget;
	}

	public PortConfigKind getKind() {
		return kind;
	}

	public void setKind(PortConfigKind newKind) {
		kind = newKind;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean newEnabled) {
		enabled = newEnabled;
	}

	public PIN_MODE getMode() {
		return mode;
	}

	public void setMode(PIN_MODE newMode) {
		mode = newMode;
	}

	public PWM_MODE getPwm() {
		return pwm;
	}

	public void setPwm(PWM_MODE newPwm) {
		pwm = newPwm ;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int newChannel) {
		channel = newChannel;
	}

	public PortSampler getSampler() {
		return sampler;
	}


	public void setSampler(PortSampler newSampler) {
		sampler = newSampler;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", mode: ");
		result.append(mode);
		result.append(", pwm: ");
		result.append(pwm);
		result.append(", channel: ");
		result.append(channel);
		result.append(')');
		return result.toString();
	}

} //PortConfigImpl
