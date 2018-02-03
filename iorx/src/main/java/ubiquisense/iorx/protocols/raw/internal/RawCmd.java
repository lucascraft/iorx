/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.raw.internal;

import ubiquisense.iorx.qx.Cmd;

public interface RawCmd extends Cmd {
	byte[] getBytes();

	void setBytes(byte[] value);

} // RawCmd
