/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;



public interface AudioSound extends ISound {


	Sound getFmodex();


	void setFmodex(Sound value);

	

	FMOD_CREATESOUNDEXINFO getExinfo();



	void setExinfo(FMOD_CREATESOUNDEXINFO value);

} // AudioSound
