/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.util.List;

public interface SessionManager  {
	List<UsbConnection> getUsbConnections();
	List<BluetoothConnection> getBluetoothConnections();
	List<UDPConnection> getUdpConnections();
	List<TcpConnection> getTcpConnections();
	List<XBeeConnection> getXbeeConnections();
	List<HTTPConnection> getHttpConnections();

} // SessionManager
