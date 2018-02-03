/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl;


public interface ChannelPressure extends DSLMidiMessage {

	int getPressure();

	void setPressure(int value);
} // ChannelPressure
