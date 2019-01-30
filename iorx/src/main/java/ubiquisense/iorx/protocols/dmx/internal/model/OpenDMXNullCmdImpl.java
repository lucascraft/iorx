package ubiquisense.iorx.protocols.dmx.internal.model;

import ubiquisense.iorx.protocols.dmx.internal.util.OpenDmxCmdUtils;

public class OpenDMXNullCmdImpl extends OpenDMXCmdImpl {
	public OpenDMXNullCmdImpl() {
		setLabel((byte)0x06);
		setData(new byte[0]);
	}
}
