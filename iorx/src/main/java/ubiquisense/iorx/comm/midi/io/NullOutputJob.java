

package ubiquisense.iorx.comm.midi.io;

import ubiquisense.iorx.comm.IChannelCloser;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;

public class NullOutputJob implements IChannelCloser, IMidiOut {

	public void close() {
		// do nothing
	}

	public void send(DSLMidiMessage cmd) {
		// do nothing
	}
}
