/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;


public interface DMXSetCmd extends DMXSndCmd {
	int getChannel();
	void setChannel(int value);
	int getValue();
	void setValue(int value);

} // DMXSetCmd
