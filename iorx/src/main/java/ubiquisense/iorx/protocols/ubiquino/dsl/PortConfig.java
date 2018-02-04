/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ubiquino.dsl;

import ubiquisense.iorx.hardware.arduino.PIN_MODE;
import ubiquisense.iorx.hardware.arduino.PWM_MODE;
import ubiquisense.iorx.hardware.arduino.Port;

public interface PortConfig  {
	Port getTarget();
	void setTarget(Port value);
	PortConfigKind getKind();
	void setKind(PortConfigKind value);
	boolean isEnabled();
	void setEnabled(boolean value);
	PIN_MODE getMode();
	void setMode(PIN_MODE value);
	PWM_MODE getPwm();
	void setPwm(PWM_MODE value);
	int getChannel();
	void setChannel(int value);
	PortSampler getSampler();
	void setSampler(PortSampler value);

} // PortConfig
