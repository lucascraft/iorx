/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveDeviceParam extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	int getDeviceID();
	void setDeviceID(int value);
	int getParam();
	void setParam(int value);
	Object getValue();
	void setValue(Object value);
	String getType();
	void setType(String value);
	String getName();
	void setName(String value);

} // LiveDeviceParam
