/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import ubiquisense.iorx.media.fmodex.AudioChannel;
import ubiquisense.iorx.media.fmodex.AudioTrack;
import ubiquisense.iorx.media.fmodex.Device;

public class DeviceImpl  implements Device {
	protected static final String ID_EDEFAULT = null;
	protected String id = ID_EDEFAULT;
	protected AudioTrack track;
	protected AudioChannel channel;



	public String getID() {
		return id;
	}

	public void setID(String newID) {
		id = newID;
	}

	public AudioTrack getTrack() {
		return track;
	}

	
	
	public void setTrack(AudioTrack newTrack) {
		track = newTrack;
	}
	public AudioChannel getChannel() {
		return channel;
	}

	public void setChannel(AudioChannel newChannel) {
		channel = newChannel;
	}


} //DeviceImpl
