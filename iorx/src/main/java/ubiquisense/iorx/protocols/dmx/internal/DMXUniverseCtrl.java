/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

import ubiquisense.iorx.app.IConnectedUnit;


public interface DMXUniverseCtrl extends IConnectedUnit {
	String getVer();
	void setVer(String value);
	List<DMXChannel> getChannels();
	List<DMXFixtureValuations> getFixtures();
	int getId();
	void setId(int value);
	int getAddrRangeMin();
	void setAddrRangeMin(int value);
	int getAddrRangeMax();
	void setAddrRangeMax(int value);
	DMXProject getManager();
	void setManager(DMXProject value);
	List<DMXFixtureValuations> getCues();
	List<DMXCueSequence> getSteps();
} // DMXUniverseCtrl
