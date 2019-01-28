/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LivePlay;
import ubiquisense.iorx.protocols.ableton.internal.PLAY_STATUS;

public class LivePlayImpl extends AbletonLiveSndCmdImpl implements LivePlay {
	PLAY_STATUS status;
	
	public LivePlayImpl() {
		super();
	}

	public PLAY_STATUS getStatus() {
		return status;
	}

	public void setStatus(PLAY_STATUS newStatus) {
		status = newStatus;
	}

} //LivePlayImpl
