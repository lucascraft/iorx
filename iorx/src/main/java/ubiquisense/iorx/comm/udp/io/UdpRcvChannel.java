/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2010 - 2012, Lucas Bigeardel
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

package ubiquisense.iorx.comm.udp.io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import ubiquisense.iorx.io.impl.ChannelImpl;

public class UdpRcvChannel extends ChannelImpl {
	private volatile DatagramSocket socket;
	private byte[] data;
	public byte[] getData() {
		return data;
	}
	public UdpRcvChannel() {
	}
	public UdpRcvChannel(int port) {
		try {
			socket = new DatagramSocket(port);
			if (socket != null) {
				socket.setReuseAddress(true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void receive(byte[]  bytes) {
		data = new byte[0];
		if (bytes != null && bytes.length > 0) {
			int packetLength = bytes.length;
					
			DatagramPacket packet = new DatagramPacket(bytes, packetLength);
			
			try {
				packet.setLength(packetLength);
				if (socket != null) {
					if (!socket.isClosed() && socket.isBound()) {
						socket.receive(packet);
						data = packet.getData();
					}
				}
			} catch (java.net.SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	@Override
	public boolean connected() {
		return socket != null && !socket.isClosed();
	}
	@Override
	public void close() {
		if (connected()) socket.close();
	}
}
