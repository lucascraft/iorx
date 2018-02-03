/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.osc.internal;


import com.illposed.osc.OSCPacket;

import ubiquisense.iorx.cmd.Cmd;

public interface OscCmd extends Cmd {

	OSCPacket getMsg();
	
	void setMsg(OSCPacket value);
} // OscCmd
