/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.List;

public interface LiveMaster extends LiveTrack {
	List<AbstractLiveDevice> getMasterDevices();

} // LiveMaster
