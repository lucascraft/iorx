/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;


public interface OpenDMXFade extends OpenDMXCmd {
	int getChannel();
	void setChannel(int value);
	int getR();
	void setR(int value);
	int getG();
	void setG(int value);
	int getB();
	void setB(int value);

} // OpenDMXFade
