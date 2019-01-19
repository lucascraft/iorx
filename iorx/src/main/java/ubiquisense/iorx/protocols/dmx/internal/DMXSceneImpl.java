/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

public class DMXSceneImpl  implements DMXScene {
	protected List<DMXFixture> fixtures;
	protected List<DMXFx> fx;
	protected List<DMXBus> bus;
	public DMXSceneImpl() {
		super();
	}
	public List<DMXFixture> getFixtures() {
		return fixtures;
	}
	public List<DMXFx> getFx() {
		return fx;
	}
	public List<DMXBus> getBus() {
		return bus;
	}
	@Override
	public DMXProject getManager() {
		return null;
	}
	@Override
	public void setManager(DMXProject value) {
		
	}



} //DMXSceneImpl
