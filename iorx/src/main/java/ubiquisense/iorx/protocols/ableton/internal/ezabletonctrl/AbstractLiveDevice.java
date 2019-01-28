/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.List;

public interface AbstractLiveDevice {
	String getDeviceName();
	void setDeviceName(String value);
	int getDeviceID();
	void setDeviceID(int value);
	long getLastSeen();
	void setLastSeen(long value);
	List<LiveParam> getParameters();

} // AbstractLiveDevice
