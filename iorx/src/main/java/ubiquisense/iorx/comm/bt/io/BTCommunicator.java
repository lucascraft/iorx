/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2011, Lucas Bigeardel
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

package ubiquisense.iorx.comm.bt.io;

import java.io.IOException;

import javax.bluetooth.L2CAPConnection;
import javax.inject.Named;

import ubiquisense.iorx.io.impl.ChannelImpl;

@Named("bt://")
public class BTCommunicator extends ChannelImpl{
	public BTCommunicator() {
	}
	private L2CAPConnection connIN, connOUT;
	
	public void setIncoming(L2CAPConnection incoming) {
		connIN	= incoming;
	}
	public void setOutgoing(L2CAPConnection outgoing) {
		connOUT	= outgoing;
	}
	
	public void send(byte[] frame) {
		try {
			connOUT.send(frame);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connIN.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			connOUT.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void receive(byte[] bytes) {
		bytes = receive2();
	}
	
	public byte[] receive2() {
		try {
			byte[] buffer = new byte[connIN.getReceiveMTU()];
			connIN.receive(buffer);
			return buffer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
}
