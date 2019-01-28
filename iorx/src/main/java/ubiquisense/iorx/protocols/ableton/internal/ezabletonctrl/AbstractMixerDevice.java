/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.List;

public interface AbstractMixerDevice  {
	LiveParam getVolume();
	void setVolume(LiveParam value);
	LiveParam getPanning();
	void setPanning(LiveParam value);
	List<LiveParam> getSends();

} // AbstractMixerDevice
