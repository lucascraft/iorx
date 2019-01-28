/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal;


public interface LiveDeviceParamSet extends AbletonLiveSndCmd {
	int getTrackID();
	void setTrackID(int value);
	int getDeviceID();
	void setDeviceID(int value);
	Object getValue();
	void setValue(Object value);
	int getPIndex();
	void setPIndex(int value);
	float getMin();
	void setMin(float value);
	float getMax();
	void setMax(float value);
	boolean isStatus();
	void setStatus(boolean value);
	int getType();
	void setType(int value);

} // LiveDeviceParamSet
