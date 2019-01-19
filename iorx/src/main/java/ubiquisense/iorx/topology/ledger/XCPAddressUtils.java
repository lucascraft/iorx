/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2011 - 2012, Lucas Bigeardel
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

package ubiquisense.iorx.topology.ledger;

import java.util.HashMap;
import java.util.UUID;

import javax.jmdns.ServiceInfo;

import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.topology.ledger.impl.XCPAddressImpl;

public class XCPAddressUtils {

	public final static XCPAddressUtils INSTANCE = new XCPAddressUtils();
	public XCPAddress createXCPAddress(ServiceInfo serviceInfo) {
			XCPAddress addr = new XCPAddressImpl();
			addr.setAddr(serviceInfo.getHostAddress());
			addr.setPort(serviceInfo.getPort());
			addr.setProtocolID(serviceInfo.getProtocol());
			addr.setTransportID(serviceInfo.getType());
			return addr;
	}
	
	public XCPAddress createXCPAddress(CmdPipe pipe) {
		XCPAddress target = new XCPAddressImpl();
		if (pipe!=null) {
			target.setAddr(pipe.getAddr());
			target.setProtocolID(pipe.getCommunicationProtocolOut());
			target.setTransportID(TRANSPORT_PROTOCOL.get(pipe.getTransportProtocol()).getLiteral());
			target.getPorts().addAll(pipe.getPorts());
			target.setSpeed(pipe.getSpeed());
		}
		return target;
	}
	
	public CmdPipe getCmdPipe(XCPAddress target, boolean createIfMissing) {
		CmdPipe pipe = null;
		try {
			int[] ports = new int[0];
			if (!target.getPorts().isEmpty()) {
				ports = new int[target.getPorts().size()];
				int i = 0;
				for (Integer p : target.getPorts()) {
					ports[i] = p.intValue();
					i++;
				}
			}
			pipe = Ubq.Reactor.getPipe(
					target.getTransportID(), 
					target.getProtocolID(), 
					target.getAddr(), 
					ports,
					target.getSpeed()
				);
			if (createIfMissing && pipe == null) {
				pipe = Ubq.Reactor.openPipe(
					target.getTransportID(), 
					target.getProtocolID(), 
					UUID.randomUUID().toString(), 
					target.getAddr(), 
					ports, 
					target.getSpeed(),
					new HashMap<Object, Object>()
				);
			} 
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return pipe;
	}
	
}
