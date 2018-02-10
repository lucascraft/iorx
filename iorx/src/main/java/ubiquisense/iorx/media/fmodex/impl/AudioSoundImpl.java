/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;

import ubiquisense.iorx.media.fmodex.AudioSound;


public class AudioSoundImpl extends ISoundImpl implements AudioSound {
	
	protected static final Sound FMODEX_EDEFAULT = null;


	protected Sound fmodex = FMODEX_EDEFAULT;


	protected static final FMOD_CREATESOUNDEXINFO EXINFO_EDEFAULT = null;


	protected FMOD_CREATESOUNDEXINFO exinfo = EXINFO_EDEFAULT;

	

	public Sound getFmodex() {
		return fmodex;
	}


	public void setFmodex(Sound newFmodex) {
		fmodex = newFmodex;
	}

	
	public FMOD_CREATESOUNDEXINFO getExinfo() {
		return exinfo;
	}

	
	public void setExinfo(FMOD_CREATESOUNDEXINFO newExinfo) {
		exinfo = newExinfo;
	}


} //AudioSoundImpl
