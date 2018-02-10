/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.List;

import org.jouvieje.fmodex.SoundGroup;



public interface AudioSoundGroup extends ISound {
	

	List<ISound> getChildren();

	

	SoundGroup getFmodex();


	void setFmodex(SoundGroup value);

} // AudioSoundGroup
