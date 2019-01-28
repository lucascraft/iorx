/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveDeviceRangeAllQ extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	int getDeviceID();
	void setDeviceID(int value);

} // LiveDeviceRangeAllQ
