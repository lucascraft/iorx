/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;


import ubiquisense.iorx.topology.ledger.XCPAddress;

public interface DMXProject  {
	List<DMXUniverseCtrl> getUniverses();
	List<DMXScene> getScenes();
	String getId();
	void setId(String value);
	String getName();
	void setName(String value);
	DMXLibrary getLibrary();
	void setLibrary(DMXLibrary value);
//	List<FixtureDefinition> getFixtureDefinitions();
	XCPAddress getLastAddress();
	void setLastAddress(XCPAddress value);
	Object getSelection();
	void setSelection(Object value);

} // DMXProject
