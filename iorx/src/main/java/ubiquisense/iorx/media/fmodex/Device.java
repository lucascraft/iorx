/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;



public interface Device  {

	
	String getID();

	
	void setID(String value);

	
	AudioTrack getTrack();


	void setTrack(AudioTrack value);

	
	AudioChannel getChannel();

	void setChannel(AudioChannel value);
} // Device
