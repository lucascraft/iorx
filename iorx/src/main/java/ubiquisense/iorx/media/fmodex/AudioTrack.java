/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.List;

public interface AudioTrack  {


	IChannel getChannel();

	

	void setChannel(IChannel value);



	List<AudioClip> getClips();

	

	String getLabel();



	void setLabel(String value);



	List<Device> getDevices();

} // AudioTrack
