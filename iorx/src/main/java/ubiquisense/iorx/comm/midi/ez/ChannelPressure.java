/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez;


public interface ChannelPressure extends DSLMidiMessage {

	int getPressure();

	void setPressure(int value);
} // ChannelPressure
