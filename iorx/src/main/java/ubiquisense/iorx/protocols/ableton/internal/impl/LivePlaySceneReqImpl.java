/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LivePlaySceneReq;

public class LivePlaySceneReqImpl extends AbletonLiveSndCmdImpl implements LivePlaySceneReq {
	int sceneID;
	
	public LivePlaySceneReqImpl() {
		super();
	}

	public int getSceneID() {
		return sceneID;
	}
	public void setSceneID(int newSceneID) {
		sceneID = newSceneID;
	}

} //LivePlaySceneReqImpl
