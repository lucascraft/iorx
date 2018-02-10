/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import org.jouvieje.fmodex.SoundGroup;

import ubiquisense.iorx.media.fmodex.AudioSoundGroup;
import ubiquisense.iorx.media.fmodex.ISound;


public class AudioSoundGroupImpl extends ISoundImpl implements AudioSoundGroup {

	protected List<ISound> children;

	
	protected static final SoundGroup FMODEX_EDEFAULT = null;

	
	protected SoundGroup fmodex = FMODEX_EDEFAULT;

	

	public List<ISound> getChildren() {
	
		return children;
	}

	
	public SoundGroup getFmodex() {
		return fmodex;
	}


	public void setFmodex(SoundGroup newFmodex) {
		fmodex = newFmodex;
		}

	
} //AudioSoundGroupImpl
