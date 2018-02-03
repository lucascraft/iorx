/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import java.net.Socket;

import ubiquisense.iorx.topology.core.TcpConnection;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tcp Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.impl.TcpConnectionImpl#getSocket <em>Socket</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TcpConnectionImpl implements TcpConnection {
	Socket socket;
	public Socket getSocket() {
		return socket;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSocket(Socket newSocket) {
		socket = newSocket;
	}

} //TcpConnectionImpl
