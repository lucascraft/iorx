

package ubiquisense.iorx.comm.midi.io;

import ubiquisense.iorx.comm.IChannelCloser;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;

public interface IMidiOut extends IChannelCloser {

	void send(DSLMidiMessage cmd);
}
