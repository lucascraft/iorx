/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.bt.io.impl;

import ubiquisense.iorx.comm.OutputJobImpl;
import ubiquisense.iorx.comm.bt.io.L2CAPoutJob;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>L2CA Pout Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class L2CAPoutJobImpl extends OutputJobImpl implements L2CAPoutJob {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected L2CAPoutJobImpl() {
		super();
	}


	@Override
	public void close() {
		super.close();
		Object o = getJob();
		if (o instanceof Thread) {
			Thread j = (Thread) o;
			j.interrupt();
		}
	}
	
	@Override
	public void finalize()  {
		Object o = getJob();
		if (o instanceof Thread) {
			Thread j = (Thread) o;
			j.interrupt();
		}
	}

} //L2CAPoutJobImpl
