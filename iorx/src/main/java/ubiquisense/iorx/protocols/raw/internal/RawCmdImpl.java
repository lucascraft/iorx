package ubiquisense.iorx.protocols.raw.internal;

import ubiquisense.iorx.qx.impl.CmdImpl;
import ubiquisense.iorx.utils.CmdUtil;

public class RawCmdImpl extends CmdImpl implements RawCmd {
	protected static final byte[] BYTES_EDEFAULT = new byte[0];

	protected byte[] bytes = BYTES_EDEFAULT;


	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] newBytes) {
		bytes = newBytes;
	}

	@Override
	public String toString() {
		return CmdUtil.INSTANCE.getFrameHexInfo(bytes);
	}

} //RawCmdImpl
