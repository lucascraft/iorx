/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

public class OpenDMXFadeFullImpl extends OpenDMXCmdImpl implements OpenDMXFadeFull {
	int r, g, b, fullColor, strobe, modi, ext;
	public OpenDMXFadeFullImpl() {
		super();
	}
	public int getR() {
		return r;
	}
	public void setR(int newR) {
		r = newR;
	}
	public int getG() {
		return g;
	}
	public void setG(int newG) {
		g = newG;
	}
	public int getB() {
		return b;
	}
	public void setB(int newB) {
		b = newB;
	}
	public int getFullColor() {
		return fullColor;
	}
	public void setFullColor(int newFullColor) {
		fullColor = newFullColor;
	}
	public int getStrobe() {
		return strobe;
	}
	public void setStrobe(int newStrobe) {
		strobe = newStrobe;
	}
	public int getModi() {
		return modi;
	}
	public void setModi(int newModi) {
		modi = newModi;
	}
	public int getExt() {
		return ext;
	}
	public void setExt(int newExt) {
		ext = newExt;
	}

} //OpenDMXFadeFullImpl
