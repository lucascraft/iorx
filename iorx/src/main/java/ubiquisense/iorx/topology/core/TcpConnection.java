/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core;

import java.net.Socket;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tcp Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.TcpConnection#getSocket <em>Socket</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTcpConnection()
 * @model
 * @generated
 */
public interface TcpConnection {
	/**
	 * Returns the value of the '<em><b>Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Socket</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Socket</em>' attribute.
	 * @see #setSocket(Socket)
	 * @see net.sf.smbt.comm.ezxtopology.EzxtopologyPackage#getTcpConnection_Socket()
	 * @model dataType="net.sf.smbt.comm.ezxtopology.Socket"
	 * @generated
	 */
	Socket getSocket();

	/**
	 * Sets the value of the '{@link net.sf.smbt.comm.ezxtopology.TcpConnection#getSocket <em>Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Socket</em>' attribute.
	 * @see #getSocket()
	 * @generated
	 */
	void setSocket(Socket value);

} // TcpConnection
