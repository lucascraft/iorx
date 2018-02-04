/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.tuio.internal.tuio11;

import ubiquisense.iorx.cmd.CompoundCmd;

public interface TuioBundle extends CompoundCmd {
	long getTime();
	void setTime(long value);

} // TuioBundle
