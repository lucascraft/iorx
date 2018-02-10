/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import ubiquisense.iorx.media.fmodex.AudioClip;
import ubiquisense.iorx.media.fmodex.AudioTrack;
import ubiquisense.iorx.media.fmodex.Device;
import ubiquisense.iorx.media.fmodex.IChannel;


public class AudioTrackImpl implements AudioTrack {
	
	protected IChannel channel;

	
	protected List<AudioClip> clips;

	
	protected static final String LABEL_EDEFAULT = null;

	
	protected String label = LABEL_EDEFAULT;

	
	protected List<Device> devices;

	

	
	public IChannel getChannel() {
		
		return channel;
	}

	public IChannel basicGetChannel() {
		return channel;
	}

	public void setChannel(IChannel newChannel) {
		channel = newChannel;
	}

	
	public List<AudioClip> getClips() {
	
		return clips;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String newLabel) {
		label = newLabel;
	}

	
	public List<Device> getDevices() {
		return devices;
	}


} //AudioTrackImpl
