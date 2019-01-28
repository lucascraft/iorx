/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveDevice extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	int getDeviceID();
	void setDeviceID(int value);
	int getParam();
	void setParam(int value);
	int getS();
	void setS(int value);

} // LiveDevice
