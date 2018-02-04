/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.net.Socket;

public interface TcpConnection {
	Socket getSocket();

	void setSocket(Socket value);

} // TcpConnection
