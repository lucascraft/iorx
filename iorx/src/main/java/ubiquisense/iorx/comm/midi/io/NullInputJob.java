

package ubiquisense.iorx.comm.midi.io;

import ubiquisense.iorx.comm.IChannelCloser;

public class NullInputJob implements IChannelCloser, IMidiIn {

	public void close() {
		// do nothing
	}
}
