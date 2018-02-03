/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.net.DatagramSocket;

public interface UDPConnection   {
	DatagramSocket getDatagramSocket();

	void setDatagramSocket(DatagramSocket value);

} // UDPConnection
