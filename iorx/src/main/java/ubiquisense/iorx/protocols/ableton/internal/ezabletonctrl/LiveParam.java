/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

public interface LiveParam  {
	String getKey();
	void setKey(String value);
	String getValue();
	void setValue(String value);
	String getMin();
	void setMin(String value);
	String getMax();
	void setMax(String value);
	String getType();
	void setType(String value);
	String getName();
	void setName(String value);

} // LiveParam
