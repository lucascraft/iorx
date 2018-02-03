/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.tcp.io.impl;

import java.io.IOException;
import java.net.Socket;

import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.OutputJob;
import ubiquisense.iorx.comm.tcp.io.TcpPort;
import ubiquisense.iorx.io.impl.PortImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tcp Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TcpPortImpl extends PortImpl implements TcpPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TcpPortImpl() {
		super();
	}
	
	@Override
	public void finalize() {
		for (InputJob iJob : getInputJobs()) {
			TcpInputPortJob ij = (TcpInputPortJob) iJob.getJob();
			ij.stop();
			iJob.close();
		}
		for (OutputJob oJob : getOutputJobs()) {
			TcpInputPortJob oj = (TcpInputPortJob) oJob.getJob();
			oj.stop();
			oJob.close();
		}
		if (getChannel() instanceof Socket) {
			try {
				((Socket)getChannel()).close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

} //TcpPortImpl
