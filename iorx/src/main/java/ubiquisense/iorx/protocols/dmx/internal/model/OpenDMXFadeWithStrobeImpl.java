/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

public class OpenDMXFadeWithStrobeImpl extends OpenDMXFadeImpl implements OpenDMXFadeWithStrobe {

	int r, g, b, fullColor, strobe, channel;
	public OpenDMXFadeWithStrobeImpl() {
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

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int value) {
		channel = value;		
	}

} //OpenDMXFadeWithStrobeImpl
