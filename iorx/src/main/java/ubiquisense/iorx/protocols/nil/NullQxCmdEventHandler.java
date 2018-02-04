/***********************************************************************************
 * Cross Queues - A Model driven I/O queues utilities framework 
 * 
 * Copyright (c) 2008 - 2010, Lucas Bigeardel
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

package ubiquisense.iorx.protocols.nil;

import javax.inject.Named;

import com.google.inject.Singleton;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.protocols.raw.internal.impl.ByteCmdImpl;
import ubiquisense.iorx.utils.CmdUtil;
import ubiquisense.iorx.utils.Platform;

@Named("void") @Singleton
public class NullQxCmdEventHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter {
	@Override
	public void handleQxEvent(Event event) {
		if (Platform.inDebugMode()) {
			System.out.println(event.getKind().getLiteral() + " @ " + event.getTime());
		}
	}
	public synchronized byte[] cmd2ByteArray(final Cmd cmd) {
		 if (cmd instanceof ByteCmd) {
			return ((ByteCmd)cmd).getMessage();
		 }
		 return new byte[0];
	}
	public synchronized Cmd byteArray2Cmd(final byte[] frame) {
		ByteCmd cmd = new ByteCmdImpl();
		cmd.setMessage(frame);
		return cmd;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "void";
	}
	
}
