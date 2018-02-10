/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;


public interface AudioClip  {

	AudioFile getFile();


	void setFile(AudioFile value);


	AudioSound getSound();


	void setSound(AudioSound value);

	
	AudioTrack getTrack();


	void setTrack(AudioTrack value);


	String getLabel();

	
	void setLabel(String value);


	TimeTag getTimeTag();


	void setTimeTag(TimeTag value);

} // AudioClip
