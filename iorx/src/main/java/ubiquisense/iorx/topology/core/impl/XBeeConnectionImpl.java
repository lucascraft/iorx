/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.topology.core.impl;

import com.rapplogic.xbee.api.XBee;

import ubiquisense.iorx.topology.core.XBeeConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XBee Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.ezxtopology.impl.XBeeConnectionImpl#getXbee <em>Xbee</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XBeeConnectionImpl  implements XBeeConnection {
	XBee xbee;
	public XBee getXbee() {
		return xbee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXbee(XBee newXbee) {
		xbee = newXbee;
	}

} //XBeeConnectionImpl
