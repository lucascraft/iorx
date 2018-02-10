/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import org.jouvieje.fmodex.ChannelGroup;

import ubiquisense.iorx.media.fmodex.AudioChannelGroup;
import ubiquisense.iorx.media.fmodex.IChannel;

public class AudioChannelGroupImpl extends IChannelImpl implements AudioChannelGroup {

	protected List<IChannel> children;

	protected static final ChannelGroup FMODEX_EDEFAULT = null;

	protected ChannelGroup fmodex = FMODEX_EDEFAULT;

	public List<IChannel> getChildren() {
		return children;
	}

	public ChannelGroup getFmodex() {
		return fmodex;
	}

	public void setFmodex(ChannelGroup newFmodex) {
		fmodex = newFmodex;
	}

} // AudioChannelGroupImpl
