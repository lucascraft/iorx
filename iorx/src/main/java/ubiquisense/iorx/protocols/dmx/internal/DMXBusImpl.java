/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

public class DMXBusImpl implements DMXBus {
	protected static final String ID_EDEFAULT = null;
	protected String id = ID_EDEFAULT;
	protected static final String NAME_EDEFAULT = null;
	protected String name = NAME_EDEFAULT;
	protected static final long TIME_EDEFAULT = 0L;
	protected long time = TIME_EDEFAULT;
	protected DMXBusImpl() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String newId) {
		String oldId = id;
		id = newId;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		String oldName = name;
		name = newName;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long newTime) {
		long oldTime = time;
		time = newTime;
	}

} //DMXBusImpl
