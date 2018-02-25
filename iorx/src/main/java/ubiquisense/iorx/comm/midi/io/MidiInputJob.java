

package ubiquisense.iorx.comm.midi.io;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.protocols.midi.internal.MidiReceiver;


public class MidiInputJob extends AbstarctMidiIO implements IMidiIn {
	private MidiDevice device;
	public MidiInputJob(MidiDevice device, CmdPipe pipe) {
		
		if (!device.isOpen()) {
			try {
				device.open();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}
		
		addPipe(pipe);
		
		Receiver r = new MidiReceiver(this, System.out);
		try {
			Transmitter	t = device.getTransmitter();
			t.setReceiver(r);
		} catch (MidiUnavailableException e) {
			System.out.println("wasn't able to connect the device's Transmitter to the Receiver:");
			System.out.println(e); 
			device.close();
		}
	}

	public void close() {
		if (device!=null && device.isOpen()) {
			device.close();
		}
	}
}
