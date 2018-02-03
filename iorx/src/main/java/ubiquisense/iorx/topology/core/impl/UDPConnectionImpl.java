/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import java.net.DatagramSocket;

import ubiquisense.iorx.topology.core.UDPConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UDP Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.impl.UDPConnectionImpl#getDatagramSocket <em>Datagram Socket</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UDPConnectionImpl implements UDPConnection {
	DatagramSocket dataSocket;
	public DatagramSocket getDatagramSocket() {
		return dataSocket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatagramSocket(DatagramSocket newDatagramSocket) {
		dataSocket = newDatagramSocket;
	}

} //UDPConnectionImpl
