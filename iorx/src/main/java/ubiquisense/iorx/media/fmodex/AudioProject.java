/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.List;

public interface AudioProject  {

	List<AudioScene> getScenes();

	List<AudioTrack> getTracks();

	List<AudioClip> getClips();

	List<AudioFile> getAudioResources();

	AudioSystem getSystem();

	void setSystem(AudioSystem value);

	List<AudioMixer> getEffects();
	
	List<Speaker> getSpeakers();
	
	List<Input> getIn();

	List<ISound> getSounds();
	
	List<IChannel> getChannels();

	List<Device> getDevices();

	
	List<FMDSP> getDspList();

} // AudioProject
