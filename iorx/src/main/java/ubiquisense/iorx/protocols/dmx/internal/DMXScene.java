/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public interface DMXScene  {

	DMXProject getManager();
	void setManager(DMXProject value);
	List<DMXFixture> getFixtures();
	List<DMXFx> getFx();
	List<DMXBus> getBus();

} // DMXScene
