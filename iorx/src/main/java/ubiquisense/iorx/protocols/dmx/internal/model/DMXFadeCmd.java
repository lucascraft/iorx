/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;


public interface DMXFadeCmd extends DMXSndCmd {
	int getChannel();
	void setChannel(int value);
	int getValue();
	void setValue(int value);
	float getPeriod();
	void setPeriod(float value);

} // DMXFadeCmd
