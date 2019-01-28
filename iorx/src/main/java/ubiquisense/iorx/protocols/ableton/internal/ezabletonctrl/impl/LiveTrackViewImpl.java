/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbstractLiveDevice;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveTrackView;

public class LiveTrackViewImpl  implements LiveTrackView {
	AbstractLiveDevice device;
	public LiveTrackViewImpl() {
		super();
	}

	public AbstractLiveDevice getDevice() {
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevice(AbstractLiveDevice newDevice) {
		device = newDevice;
	}

} //LiveTrackViewImpl
