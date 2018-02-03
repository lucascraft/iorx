/***********************************************************************************
 * Smbt - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2012, Lucas Bigeardel
 * 
 * The library is released under:
 * 
 * A) LGPL
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA 02110-1301 USA
 * 
 * B) EPL
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Lucas Bigeardel <lucas.bigeardel@gmail.com> - Initial API and implementation
 ***********************************************************************************/

package ubiquisense.iorx.protocols.osc.internal;

import java.util.Random;
import java.util.UUID;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;

import ubiquisense.iorx.protocols.osc.internal.impl.OscCmdImpl;
import ubiquisense.iorx.protocols.osc.internal.impl.OscRcvCmdImpl;
import ubiquisense.iorx.protocols.osc.internal.impl.OscSndCmdImpl;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.CompoundCmd;
import ubiquisense.iorx.qx.impl.CompoundCmdImpl;
import ubiquisense.iorx.utils.CmdUtil;


public class OscCmdUtils {
	public final static OscCmdUtils INSTANCE = new OscCmdUtils();
	
	//
	// OSC receive
	//
	
	public OscRcvCmd createOscRcvCmd(String addr, Object... args) {
		OscRcvCmd cmd = new OscRcvCmdImpl();
		OSCMessage msg = new OSCMessage(addr);
		for (Object o : args) {
			msg.addArgument(o);
		}
		cmd.setMsg(msg);
		return cmd;
	}
	
	public OscRcvCmd createOscRcvCmd(String addr) {
		return createOscRcvCmd(addr, new Object[0]);
	}
	
	//
	// OSC send
	//
	
	public OscSndCmd createOscSndCmd(String addr, Object... args) {
		OscSndCmd cmd = new OscSndCmdImpl();
		OSCMessage msg = new OSCMessage(addr);
		for (Object o : args) {
			msg.addArgument(o);
		}
		cmd.setMsg(msg);
		return cmd;
	}
	
	public OscSndCmd createOscSndCmd(String addr) {
		return createOscSndCmd(addr, new Object[0]);
	}
	
	//
	// Generic
	//
	
	public OscCmd createOscCmd(String addr, Object... args) {
		OscCmd cmd = new OscCmdImpl();
		OSCMessage msg = new OSCMessage(addr == null ? "" : addr);
		for (Object o : args) {
			msg.addArgument(o);
		}
		cmd.setMsg(msg);
		return cmd;
	}

	public Cmd createOscCmd(OSCPacket packet) {
		if (packet instanceof OSCBundle) {
			CompoundCmd cmd = new CompoundCmdImpl();
			for (OSCPacket p : ((OSCBundle)packet).getPackets()) {
				cmd.getChildren().add(createOscCmd(p));
			}
			return cmd;
		} else if (packet instanceof OSCMessage) {
			return createOscCmd((OSCMessage)packet);
		}
		return null;
	}
	
	public Cmd createOscCmd(OSCMessage packet) {
		if (packet instanceof OSCMessage) {
			OscCmd cmd = new OscCmdImpl();
			cmd.setMsg((OSCMessage)packet);
			return cmd;
		}
		return null;
	}

	public OscCmd createOscCmd(String addr) {
		OscCmd cmd =new OscCmdImpl();
		cmd.setMsg(new OSCMessage(addr == null ? "" : addr));
		return cmd;
	}
	
	Random randomizer = new Random();
	String[] alphanum = new String[] {
		"A", "a",
		"B", "b",
		"C", "c",
		"D", "d",
		"E", "e",
		"F", "f",
		"G", "g",
		"H", "h",
		"I", "i",
		"J", "j",
		"K", "k",
		"L", "l",
		"M", "m",
		"N", "n",
		"O", "o",
		"P", "p",
		"Q", "q",
		"R", "r",
		"S", "s",
		"T", "t",
		"U", "u",
		"V", "v",
		"W", "w",
		"X", "x",
		"Y", "y",
		"Z", "z",
		"0", "1",
		"2", "3",
		"4", "5",
		"6", "7",
		"8", "9"
	};
	
	public String getRandomAlphaNumToken(int legnth) {
		Random ran = new Random(UUID.randomUUID().getMostSignificantBits());
		String token = "";
		for (int i=0; i<legnth; i++) {
			int idx = ran.nextInt(alphanum.length);
            token += alphanum[idx];
		}
		return token;
	}
	
	public Object getRandomlyTypedArgAndSetItUp() {
		Random ran = new Random();
		switch(ran.nextInt(3)) {
			case 0: // Integer
				return new Integer(ran.nextInt(Integer.MAX_VALUE));
			case 1: // Float
				return new Float(ran.nextFloat() * Float.MAX_VALUE);
			case 2: // String
				return getRandomAlphaNumToken(ran.nextInt(50));
		}
		return "ERROR";
	}
	
	public OSCMessage createRandomOSCMessage(int maxAddrLength, int maxNbArgs) {
		String addr = "";
		for (int i=0; i<randomizer.nextInt(maxAddrLength); i++) {
			addr += "/" + getRandomAlphaNumToken(randomizer.nextInt(10)+1);
		}
		
		OSCMessage message = new OSCMessage(addr);
		
		for (int a = 0; a < maxNbArgs; a++) {
			message.addArgument(getRandomlyTypedArgAndSetItUp());
		}
		
		return message;
	}
	
	public OscCmd sendRandomOSCCmd(CmdPipe engine) {
		OscCmd cmd = (OscCmd) createOscCmd(createRandomOSCMessage(7, 5));
		CmdUtil.INSTANCE.stampCmd(cmd);
		engine.getTx().postCommand(cmd);
		return cmd;
	}
}
