/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.impl;

import java.util.List;

import com.google.common.collect.Lists;

import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.AbstractLiveDevice;
import ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl.LiveMaster;

public class LiveMasterImpl extends LiveTrackImpl implements LiveMaster {
	List<AbstractLiveDevice> masterDevices;
	public LiveMasterImpl() {
		super();
		masterDevices = Lists.newArrayList();
	}

	@SuppressWarnings("unchecked")
	public List<AbstractLiveDevice> getMasterDevices() {
		return masterDevices;
	}

} //LiveMasterImpl
