/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;


public interface OpenDMXFadeFull extends OpenDMXCmd {
	int getR();
	void setR(int value);
	int getG();
	void setG(int value);
	int getB();
	void setB(int value);
	int getFullColor();
	void setFullColor(int value);
	int getStrobe();
	void setStrobe(int value);
	int getModi();
	void setModi(int value);
	int getExt();
	void setExt(int value);

} // OpenDMXFadeFull
