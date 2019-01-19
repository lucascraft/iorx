/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import java.net.DatagramSocket;

import ubiquisense.iorx.topology.core.UDPConnection;

public class UDPConnectionImpl implements UDPConnection {
	private DatagramSocket dataSocket;
	public DatagramSocket getDatagramSocket() {
		return dataSocket;
	}

	public void setDatagramSocket(DatagramSocket newDatagramSocket) {
		dataSocket = newDatagramSocket;
	}

} //UDPConnectionImpl
