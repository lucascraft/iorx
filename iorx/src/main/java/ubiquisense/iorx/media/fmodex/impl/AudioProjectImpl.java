/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import ubiquisense.iorx.media.fmodex.AudioClip;
import ubiquisense.iorx.media.fmodex.AudioFile;
import ubiquisense.iorx.media.fmodex.AudioMixer;
import ubiquisense.iorx.media.fmodex.AudioProject;
import ubiquisense.iorx.media.fmodex.AudioScene;
import ubiquisense.iorx.media.fmodex.AudioSystem;
import ubiquisense.iorx.media.fmodex.AudioTrack;
import ubiquisense.iorx.media.fmodex.Device;
import ubiquisense.iorx.media.fmodex.FMDSP;
import ubiquisense.iorx.media.fmodex.IChannel;
import ubiquisense.iorx.media.fmodex.ISound;
import ubiquisense.iorx.media.fmodex.Input;
import ubiquisense.iorx.media.fmodex.Speaker;


public class AudioProjectImpl  implements AudioProject {

	protected List<AudioScene> scenes;


	protected List<AudioTrack> tracks;

	
	protected List<AudioClip> clips;

	protected List<AudioFile> audioResources;


	protected AudioSystem system;


	protected List<AudioMixer> effects;


	protected List<Speaker> speakers;


	protected List<Input> in;


	protected List<ISound> sounds;


	protected List<FMDSP> dspList;


	protected List<IChannel> channels;


	protected List<Device> devices;


	public List<AudioScene> getScenes() {
		return scenes;
	}

	public List<AudioTrack> getTracks() {
		return tracks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AudioClip> getClips() {
		return clips;
	}

	
	public List<AudioFile> getAudioResources() {
		return audioResources;
	}

	
	public AudioSystem getSystem() {
		return system;
	}

	public void setSystem(AudioSystem newSystem) {
		system =newSystem;
	}

	
	public List<AudioMixer> getEffects() {
		return effects;
	}

	
	public List<Speaker> getSpeakers() {
		return speakers;
	}

	
	public List<Input> getIn() {
		return in;
	}


	public List<ISound> getSounds() {
		return sounds;
	}

	
	public List<IChannel> getChannels() {
		return channels;
	}

	
	public List<Device> getDevices() {
		return devices;
	}


	public List<FMDSP> getDspList() {
		return dspList;
	}


} //AudioProjectImpl
