/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import java.net.Socket;

import ubiquisense.iorx.topology.core.TcpConnection;


public class TcpConnectionImpl implements TcpConnection {
	Socket socket;
	public Socket getSocket() {
		return socket;

	}

	public void setSocket(Socket newSocket) {
		socket = newSocket;
	}

} //TcpConnectionImpl
