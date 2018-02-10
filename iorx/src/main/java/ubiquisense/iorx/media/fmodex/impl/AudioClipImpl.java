/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import ubiquisense.iorx.media.fmodex.AudioClip;
import ubiquisense.iorx.media.fmodex.AudioFile;
import ubiquisense.iorx.media.fmodex.AudioSound;
import ubiquisense.iorx.media.fmodex.AudioTrack;
import ubiquisense.iorx.media.fmodex.TimeTag;


public class AudioClipImpl implements AudioClip {

	protected AudioFile file;

	
	protected AudioSound sound;


	protected AudioTrack track;


	protected static final String LABEL_EDEFAULT = null;


	protected String label = LABEL_EDEFAULT;


	protected TimeTag timeTag;

	


	public AudioFile getFile() {
			return file;
	}

	
	public AudioFile basicGetFile() {
		return file;
	}

	
	public void setFile(AudioFile newFile) {
		file = newFile;
	}

	
	public AudioSound getSound() {
			return sound;
	}

	
	public AudioSound basicGetSound() {
		return sound;
	}

	
	public void setSound(AudioSound newSound) {
		sound = newSound;
	}

	public AudioTrack getTrack() {
			return track;
	}


	public AudioTrack basicGetTrack() {
		return track;
	}

	
	public void setTrack(AudioTrack newTrack) {
		track = newTrack;
	}

	
	public String getLabel() {
		return label;
	}

	
	public void setLabel(String newLabel) {
		label = newLabel;
	}

	
	public TimeTag getTimeTag() {
		return timeTag;
	}

	

	public void setTimeTag(TimeTag newTimeTag) {
		timeTag = newTimeTag;
	}

	

} //AudioClipImpl
