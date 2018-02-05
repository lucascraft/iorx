/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;


public interface AnalogPort extends Port {
	float getValue();

	void setValue(float value);
} // AnalogPort
