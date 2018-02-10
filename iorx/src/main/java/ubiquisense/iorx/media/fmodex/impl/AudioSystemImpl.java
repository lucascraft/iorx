/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import ubiquisense.iorx.media.fmodex.AudioSystem;


public class AudioSystemImpl  implements AudioSystem {

	protected static final org.jouvieje.fmodex.System FMODEX_EDEFAULT = null;
	
	protected org.jouvieje.fmodex.System fmodex = FMODEX_EDEFAULT;



	
	public org.jouvieje.fmodex.System getFmodex() {
		return fmodex;
	}

	
	public void setFmodex(org.jouvieje.fmodex.System newFmodex) {
		fmodex = newFmodex;
	}



} //AudioSystemImpl
