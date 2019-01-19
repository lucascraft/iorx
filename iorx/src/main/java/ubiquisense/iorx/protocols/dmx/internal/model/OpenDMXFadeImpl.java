/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

public class OpenDMXFadeImpl extends OpenDMXCmdImpl implements OpenDMXFade {
	
	int r, g, b, fullColor, strobe, channel;
	public OpenDMXFadeImpl() {
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

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int newChannel) {
		channel = newChannel;
		
	}
} //OpenDMXFadeImpl
