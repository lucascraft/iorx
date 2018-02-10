/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import org.jouvieje.fmodex.Channel;

import ubiquisense.iorx.media.fmodex.AudioChannel;

public class AudioChannelImpl extends IChannelImpl implements AudioChannel {

	protected static final Channel FMODEX_EDEFAULT = null;

	protected Channel fmodex = FMODEX_EDEFAULT;

	public Channel getFmodex() {
		return fmodex;
	}

	public void setFmodex(Channel newFmodex) {
		fmodex = newFmodex;
	}

} // AudioChannelImpl
