/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.udp.io.impl;

import java.net.DatagramSocket;

import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.OutputJob;
import ubiquisense.iorx.comm.udp.UdpPort;
import ubiquisense.iorx.comm.udp.io.UdpInputPortJob;
import ubiquisense.iorx.io.impl.PortImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Udp Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UdpPortImpl extends PortImpl implements UdpPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UdpPortImpl() {
		super();
	}


	
	@Override
	public void finalize() {
		for (InputJob iJob : getInputJobs()) {
			UdpInputPortJob ij = (UdpInputPortJob) iJob.getJob();
			ij.stop();;
			ij.close();
		}
		for (OutputJob oJob : getOutputJobs()) {
			UdpInputPortJob oj = (UdpInputPortJob) oJob.getJob();
			oj.stop();
			oj.close();
		}
		if (getChannel() instanceof DatagramSocket) {
			((DatagramSocket)getChannel()).close();
		}
	}

} //UdpPortImpl
