/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveTempoRcv;

public class LiveTempoRcvImpl extends AbletonLiveSndCmdImpl implements LiveTempoRcv {
	float tempo;
	
	public LiveTempoRcvImpl() {
		super();
	}


	public float getTempo() {
		return tempo;
	}

	public void setTempo(float newTempo) {
		tempo = newTempo;
	}

} //LiveTempoRcvImpl
