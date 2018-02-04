/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
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

package ubiquisense.iorx.protocols.raw;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.inject.Named;

import com.google.inject.Singleton;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.protocols.raw.internal.RawCmd;
import ubiquisense.iorx.protocols.raw.internal.impl.RawCmdImpl;
import ubiquisense.iorx.qx.Qx;

@Named("raw") @Singleton
public class RawQxCmdHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter {
	
	@Override
	public synchronized Cmd byteArray2Cmd(final byte[] stream) {
		RawCmd cmd = new RawCmdImpl();
		if (stream != null && stream.length>0) {
			cmd.setBytes(stream);
		}
		return cmd;
	}
	@Override
	public void handleQxEvent(Event event) {
		if (event.getCmd() instanceof RawCmd) {
			if (event.getKind() == EVENT_KIND.TX_DONE) {
				if (event.getCmd() instanceof CompoundCmd) {
					for (Cmd c : ((CompoundCmd)event.getCmd()).getChildren()) {
						handleCmd(event.getQx(), c);
					}
				} else {
					handleCmd(event.getQx(), event.getCmd());
				}
			}
		}
	}

	private synchronized void handleCmd(Qx _qx, Cmd _cmd) {
		if (_cmd instanceof RawCmd) {
			Object obj = _qx.getEngine().getPort().getChannel();
			synchronized (_qx.getEngine().getOutputInterpreter()) {
				 if (obj instanceof DatagramSocket) {
					DatagramSocket socket = (DatagramSocket) obj;
					try {
						byte[] frame = _qx.getEngine().getOutputInterpreter().cmd2ByteArray(_cmd);
						DatagramPacket packet = new DatagramPacket(frame, frame.length);
						socket.send(packet);
					} catch (IOException e) {
						System.err.println("UDP problem ...");
					} catch (NullPointerException ee) {
						ee.printStackTrace();
					}
				 }
			}
		}
	}

	@Override
	public byte[] cmd2ByteArray(Cmd cmd) {
		if (cmd instanceof RawCmd) {
			return ((RawCmd) cmd).getBytes();
		} if (cmd instanceof ByteCmd) {
			return ((ByteCmd)cmd).getMessage();
		}
		return new byte[0];
	}

	@Override
	public String getID() {
		return "raw";
	}
}
