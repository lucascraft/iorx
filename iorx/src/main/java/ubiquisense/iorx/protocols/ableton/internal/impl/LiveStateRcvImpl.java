/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveStateRcv;

public class LiveStateRcvImpl extends AbletonLiveSndCmdImpl implements LiveStateRcv {
	float tempo;
	boolean overdub;
	public LiveStateRcvImpl() {
		super();
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float newTempo) {
		tempo = newTempo;
	}

	public boolean isOverdub() {
		return overdub;
	}

	public void setOverdub(boolean newOverdub) {
		overdub = newOverdub;
	}

} //LiveStateRcvImpl
