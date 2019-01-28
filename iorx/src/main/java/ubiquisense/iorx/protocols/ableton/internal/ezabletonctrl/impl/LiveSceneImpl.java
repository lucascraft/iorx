/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveScene;

public class LiveSceneImpl  implements LiveScene {
	int sceneID;
	String mode;
	String sceneName;
	long lastSeen;
	
	public LiveSceneImpl() {
		super();
	}

	public int getSceneID() {
		return sceneID;
	}

	public void setSceneID(int newSceneID) {
		sceneID = newSceneID;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String newMode) {
		mode = newMode;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String newSceneName) {
		sceneName = newSceneName;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(long newLastSeen) {
		lastSeen = newLastSeen;
	}

} //LiveSceneImpl
