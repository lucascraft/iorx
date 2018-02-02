/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.bt.io.impl;

import ubiquisense.iorx.comm.bt.io.L2CAPInJob;
import ubiquisense.iorx.comm.impl.InputJobImpl;
import ubiquisense.iorx.utils.Job;

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
	protected L2CAPInJobImpl() {
		super();
	}

	
	@Override
	public void close() {
		Object o = getJob();
		if (o instanceof Job) {
			Job j = (Job) o;
			j.cancel();
			j.done(Job.ASYNC_FINISH);
		}
	}
	
	public void finalize()  {
		Object o = getJob();
		if (o instanceof Job) {
			Job j = (Job) o;
			j.cancel();
			j.done(Job.ASYNC_FINISH);
		}
	}
} //L2CAPInJobImpl
