

package ubiquisense.iorx.comm.midi.io;

import java.util.concurrent.ConcurrentLinkedQueue;

import ubiquisense.iorx.cmd.CmdPipe;

public abstract class AbstarctMidiIO {
	public volatile ConcurrentLinkedQueue<CmdPipe> rxList;

	public AbstarctMidiIO() {
		rxList = new ConcurrentLinkedQueue<CmdPipe>();
	}
	
	public synchronized void addPipe(final CmdPipe rx) {
		rxList.add(rx);
	}
	
	public synchronized void removePipe(final CmdPipe rx) {
		rxList.remove(rx);
	}
	
	public abstract void close();

}
