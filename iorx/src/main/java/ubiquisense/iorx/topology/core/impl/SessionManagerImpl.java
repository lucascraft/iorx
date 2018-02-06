/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import java.util.ArrayList;
import java.util.List;

import ubiquisense.iorx.topology.core.BluetoothConnection;
import ubiquisense.iorx.topology.core.HTTPConnection;
import ubiquisense.iorx.topology.core.SessionManager;
import ubiquisense.iorx.topology.core.TcpConnection;
import ubiquisense.iorx.topology.core.UDPConnection;
import ubiquisense.iorx.topology.core.UsbConnection;

public class SessionManagerImpl implements SessionManager {
	List<UsbConnection> usbConnections;
	List<BluetoothConnection> bluetoothConnections;
	List<UDPConnection> udpConnections;
	List<TcpConnection> tcpConnections;
	List<HTTPConnection> httpConnections;

	public SessionManagerImpl() {
		usbConnections = new ArrayList<UsbConnection>();
		bluetoothConnections = new ArrayList<BluetoothConnection>();
		udpConnections = new ArrayList<UDPConnection>();
		tcpConnections = new ArrayList<TcpConnection>();
		httpConnections = new ArrayList<HTTPConnection>();

	}

	public List<UsbConnection> getUsbConnections() {
		return usbConnections;
	}

	public List<BluetoothConnection> getBluetoothConnections() {
		return bluetoothConnections;
	}

	public List<UDPConnection> getUdpConnections() {
		return udpConnections;
	}

	public List<TcpConnection> getTcpConnections() {
		return tcpConnections;
	}

	public List<HTTPConnection> getHttpConnections() {
		return httpConnections;
	}

} // SessionManagerImpl
