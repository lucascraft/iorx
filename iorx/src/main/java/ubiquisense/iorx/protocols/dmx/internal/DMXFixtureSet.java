/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public interface DMXFixtureSet extends DMXFixtureValuations {
	List<DMXFixtureValuations> getChildren();
	String getLabel();
	void setLabel(String value);

} // DMXFixtureSet
