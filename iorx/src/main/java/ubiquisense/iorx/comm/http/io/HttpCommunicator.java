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

package ubiquisense.iorx.comm.http.io;

import java.util.Map;

import javax.inject.Named;

import ubiquisense.iorx.io.impl.TransportChannelImpl;

@Named("http://")
public abstract class HttpCommunicator extends TransportChannelImpl {
	public HttpCommunicator() {
	}
    protected String portID;
    protected int[] acceptedPorts;
    protected String method;
    protected String pipeID;
	public abstract void init(String pipeID, String portID, int[] ports);
    protected Map<String, String> properties;
	public void setPortID(String portID) {
		this.portID = portID;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMethod() {
		return method;
	}
	public String getPortID() {
		return portID;
	}
	public void setAcceptedPorts(int[] acceptedPorts) {
		this.acceptedPorts = acceptedPorts;
	}
	public int[] getAcceptedPorts() {
		return acceptedPorts;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	public String getPipeID() {
		return pipeID;
	}
	public void setParameters(String pipeID, String portID, int[] acceptedPorts) {
		this.pipeID = pipeID;
		this.portID = portID;
		this.acceptedPorts = acceptedPorts;
	}
}
