/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveDeviceRange extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	int getDeviceID();
	void setDeviceID(int value);

} // LiveDeviceRange
