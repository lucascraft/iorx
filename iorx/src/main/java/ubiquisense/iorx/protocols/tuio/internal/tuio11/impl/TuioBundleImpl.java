/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11.impl;

import ubiquisense.iorx.cmd.impl.CompoundCmdImpl;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.TuioBundle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuio Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.smbt.osc.eztuio.impl.TuioBundleImpl#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TuioBundleImpl extends CompoundCmdImpl implements TuioBundle {
	long time;
	public long getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(long newTime) {
		time = newTime;
	}

} //TuioBundleImpl
