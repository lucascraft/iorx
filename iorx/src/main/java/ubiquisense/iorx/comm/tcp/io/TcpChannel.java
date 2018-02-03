/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2010, Lucas Bigeardel
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

package ubiquisense.iorx.comm.tcp.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.inject.Named;

import ubiquisense.iorx.io.impl.ChannelImpl;
import ubiquisense.iorx.utils.Platform;

@Named("tcp://")
public class TcpChannel extends ChannelImpl {
	public TcpChannel() {
	}
	
	private Socket socket;
	public TcpChannel(InetAddress addr, int port) {
		try {
			socket = new Socket(addr, port);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	public void debug() {
		if (Platform.inDebugMode()) {
			if (socket != null && socket.getInetAddress() != null) {
				System.out.println("Connected to [" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "]");
			}
		}	
	}
	@Override
	public void send(byte[] bytes) {
		try {
			socket.getOutputStream().write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
