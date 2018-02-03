/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.osc.internal.impl;


import com.illposed.osc.OSCPacket;

import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.qx.impl.CmdImpl;
import ubiquisense.iorx.utils.CmdUtil;

public class OscCmdImpl extends CmdImpl implements OscCmd {
	OSCPacket packet;
	public OSCPacket getMsg() {
		return packet;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsg(OSCPacket newMsg) {
		packet = newMsg;
	}
	
	@Override
	public String toString() {
		return CmdUtil.INSTANCE.getFrameHexInfo(getMsg().getByteArray());
	}

} //OscCmdImpl
