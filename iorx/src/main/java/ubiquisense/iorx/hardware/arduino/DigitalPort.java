/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;


public interface DigitalPort extends Port {

	int getValue();

	void setValue(int value);
} // DigitalPort
