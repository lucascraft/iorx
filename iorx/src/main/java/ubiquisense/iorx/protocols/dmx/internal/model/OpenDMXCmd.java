/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal.model;

import ubiquisense.iorx.cmd.Cmd;

public interface OpenDMXCmd extends Cmd {
	byte getStart();
	void setStart(byte value);
	byte getLabel();
	void setLabel(byte value);
	byte[] getData();
	void setData(byte[] value);
	byte getEnd();
	void setEnd(byte value);

} // OpenDMXCmd
