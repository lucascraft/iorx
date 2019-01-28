/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.impl;

import ubiquisense.iorx.protocols.ableton.internal.LiveDetailView;

public class LiveDetailViewImpl extends AbletonLiveSndCmdImpl implements LiveDetailView {
	int value;
	public LiveDetailViewImpl() {
		super();
	}
	public int getValue() {
		return value;
	}
	public void setValue(int newValue) {
		value = newValue;
	}

} //LiveDetailViewImpl
