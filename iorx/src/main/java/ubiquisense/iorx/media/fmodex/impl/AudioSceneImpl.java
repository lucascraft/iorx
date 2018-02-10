/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import java.util.List;

import ubiquisense.iorx.media.fmodex.AudioClip;
import ubiquisense.iorx.media.fmodex.AudioScene;


public class AudioSceneImpl implements AudioScene {

	protected List<AudioClip> clips;


	protected static final String LABEL_EDEFAULT = null;

	protected String label = LABEL_EDEFAULT;

	
	public List<AudioClip> getClips() {
		
		return clips;
	}


	public String getLabel() {
		return label;
	}

	

	public void setLabel(String newLabel) {
		label = newLabel;
	}

	
} //AudioSceneImpl
