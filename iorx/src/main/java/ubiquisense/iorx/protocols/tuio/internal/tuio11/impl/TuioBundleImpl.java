/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11.impl;

import ubiquisense.iorx.cmd.impl.CompoundCmdImpl;
import ubiquisense.iorx.protocols.tuio.internal.tuio11.TuioBundle;

public class TuioBundleImpl extends CompoundCmdImpl implements TuioBundle {
	long time;
	public long getTime() {
		return time;
	}

	public void setTime(long newTime) {
		time = newTime;
	}

} //TuioBundleImpl
