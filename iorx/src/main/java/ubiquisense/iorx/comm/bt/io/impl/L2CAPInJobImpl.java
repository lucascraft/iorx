/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.bt.io.impl;

import ubiquisense.iorx.comm.bt.io.L2CAPInJob;
import ubiquisense.iorx.comm.impl.InputJobImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>L2CAP In Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class L2CAPInJobImpl extends InputJobImpl implements L2CAPInJob {

	
	@Override
	public void close() {
		Object o = getJob();
		if (o instanceof Thread) {
			Thread j = (Thread) o;
			j.stop();
		}
	}
	
	public void finalize()  {
		Object o = getJob();
		if (o instanceof Thread) {
			Thread j = (Thread) o;
			j.stop();
		}
	}
} //L2CAPInJobImpl
