/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveSceneReq;

public class LiveSceneReqImpl extends AbletonLiveSndCmdImpl implements LiveSceneReq {
	String mode;
	int sceneID;
	
	public LiveSceneReqImpl() {
		super();
	}

	public String getMode() {
		return mode;
	}
	public void setMode(String newMode) {
		mode = newMode;
	}
	public int getSceneID() {
		return sceneID;
	}
	public void setSceneID(int newSceneID) {
		sceneID = newSceneID;
	}

} //LiveSceneReqImpl
