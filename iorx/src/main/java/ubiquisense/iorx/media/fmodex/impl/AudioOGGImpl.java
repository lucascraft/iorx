/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex.impl;

import ubiquisense.iorx.media.fmodex.AudioOGG;

public class AudioOGGImpl extends AudioFileImpl implements AudioOGG {
	protected static final float SAMPLING_RATE_EDEFAULT = 0.0F;

	protected float samplingRate = SAMPLING_RATE_EDEFAULT;

	public float getSamplingRate() {
		return samplingRate;
	}

	public void setSamplingRate(float newSamplingRate) {
		samplingRate = newSamplingRate;
	}

} // AudioOGGImpl
