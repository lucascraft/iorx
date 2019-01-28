/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveScene2;

public class LiveScene2Impl extends AbletonLiveSndCmdImpl implements LiveScene2 {
	int sceneID;
	
	public LiveScene2Impl() {
		super();
	}

	public int getSceneID() {
		return sceneID;
	}

	public void setSceneID(int newSceneID) {
		sceneID = newSceneID;
	}

} //LiveScene2Impl
