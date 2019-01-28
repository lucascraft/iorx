/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveScenesQ;

public class LiveScenesQImpl extends AbletonLiveSndCmdImpl implements LiveScenesQ {
	int numScenes;
	
	public LiveScenesQImpl() {
		super();
	}

	public int getNumScenes() {
		return numScenes;
	}

	public void setNumScenes(int newNumScenes) {
		numScenes = newNumScenes;
	}

} //LiveScenesQImpl
