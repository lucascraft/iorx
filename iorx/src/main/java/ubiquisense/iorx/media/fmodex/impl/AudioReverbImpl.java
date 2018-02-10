/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import org.jouvieje.fmodex.Reverb;

import ubiquisense.iorx.media.fmodex.AudioReverb;


public class AudioReverbImpl  implements AudioReverb {
	
	protected static final Reverb FMODEX_EDEFAULT = null;

	
	protected Reverb fmodex = FMODEX_EDEFAULT;

	
	public Reverb getFmodex() {
		return fmodex;
	}

	
	public void setFmodex(Reverb newFmodex) {
		fmodex = newFmodex;
	}


} //AudioReverbImpl
