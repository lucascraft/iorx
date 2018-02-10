/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import ubiquisense.iorx.media.fmodex.AudioMixer;
import ubiquisense.iorx.media.fmodex.IChannel;
import ubiquisense.iorx.media.fmodex.Speaker;

public class AudioMixerImpl  implements AudioMixer {
	protected Speaker out;

	protected List<IChannel> channel;

	public Speaker getOut() {
		return out;
	}

	public Speaker basicGetOut() {
		return out;
	}

	public void setOut(Speaker newOut) {
		out = newOut;
	}

	public List<IChannel> getChannel() {
		return channel;
	}

	

} //AudioMixerImpl
