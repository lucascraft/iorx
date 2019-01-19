/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

public class OpenDMXWidgetImpl implements OpenDMXWidget {
	
	 byte[] uuid;
	 public OpenDMXWidgetImpl() {
		super();
	}
	public byte[] getUid() {
		return uuid;
	}
	public void setUid(byte[] newUid) {
		uuid = newUid;
	}

} //OpenDMXWidgetImpl
