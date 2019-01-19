/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

import java.util.List;

import ubiquisense.iorx.cmd.CmdPipe;

public class DMXUniverseCtrlImpl implements DMXUniverseCtrl {
	protected List<CmdPipe> engines;
	protected CmdPipe default_;
	protected static final String VER_EDEFAULT = null;
	protected String ver = VER_EDEFAULT;
	protected List<DMXChannel> channels;
	protected List<DMXFixtureValuations> fixtures;
	protected static final int ID_EDEFAULT = 0;
	protected int id = ID_EDEFAULT;
	protected static final int ADDR_RANGE_MIN_EDEFAULT = 0;
	protected int addrRangeMin = ADDR_RANGE_MIN_EDEFAULT;
	protected static final int ADDR_RANGE_MAX_EDEFAULT = 0;
	protected int addrRangeMax = ADDR_RANGE_MAX_EDEFAULT;
	protected List<DMXFixtureValuations> cues;
	protected List<DMXCueSequence> steps;
	protected DMXUniverseCtrlImpl() {
		super();
	}
	public List<CmdPipe> getEngines() {
		
		return engines;
	}
	public CmdPipe getDefault() {
		
		return default_;
	}
	public void setDefault(CmdPipe newDefault) {
		CmdPipe oldDefault = default_;
		default_ = newDefault;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String newVer) {
		String oldVer = ver;
		ver = newVer;
	}
	public List<DMXChannel> getChannels() {
		return channels;
	}
	public List<DMXFixtureValuations> getFixtures() {
		return fixtures;
	}
	public int getId() {
		return id;
	}
	public void setId(int newId) {
		int oldId = id;
		id = newId;
	}
	public int getAddrRangeMin() {
		return addrRangeMin;
	}
	public void setAddrRangeMin(int newAddrRangeMin) {
		int oldAddrRangeMin = addrRangeMin;
		addrRangeMin = newAddrRangeMin;
	}
	public int getAddrRangeMax() {
		return addrRangeMax;
	}
	public void setAddrRangeMax(int newAddrRangeMax) {
		int oldAddrRangeMax = addrRangeMax;
		addrRangeMax = newAddrRangeMax;
	}
	public List<DMXFixtureValuations> getCues() {
		
		return cues;
	}
	public List<DMXCueSequence> getSteps() {
		
		return steps;
	}
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ver: ");
		result.append(ver);
		result.append(", id: ");
		result.append(id);
		result.append(", addrRangeMin: ");
		result.append(addrRangeMin);
		result.append(", addrRangeMax: ");
		result.append(addrRangeMax);
		result.append(')');
		return result.toString();
	}

	@Override
	public DMXProject getManager() {
		return null;
	}

	@Override
	public void setManager(DMXProject value) {
		
	}

} //DMXUniverseCtrlImpl
