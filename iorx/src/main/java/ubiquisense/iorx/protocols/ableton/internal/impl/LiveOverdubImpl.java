/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveOverdub;

public class LiveOverdubImpl extends AbletonLiveSndCmdImpl implements LiveOverdub {
	boolean overdub;
	public LiveOverdubImpl() {
		super();
	}

	public boolean isState() {
		return overdub;
	}
	public void setState(boolean newState) {
		overdub = newState;
	}

} //LiveOverdubImpl
