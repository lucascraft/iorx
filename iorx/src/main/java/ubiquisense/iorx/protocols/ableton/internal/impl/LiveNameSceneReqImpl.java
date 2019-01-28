/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveNameSceneReq;

public class LiveNameSceneReqImpl extends AbletonLiveSndCmdImpl implements LiveNameSceneReq {
	int sceneID;
	String sceneName;
	public LiveNameSceneReqImpl() {
		super();
	}

	public int getSceneID() {
		return sceneID;
	}

	public void setSceneID(int newSceneID) {
		sceneID = newSceneID;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String newSceneName) {
		sceneName = newSceneName;
	}

} //LiveNameSceneReqImpl
