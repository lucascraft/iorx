
package ubiquisense.iorx.discovery;

import java.util.List;

import javax.sound.midi.MidiDevice;

public interface IXMidiDeviceManager extends IDeviceManager {
	List<MidiDevice> getMidiDevices();
	boolean connectMidiDevice(MidiDevice device);
	boolean reconnectMidiDevice(MidiDevice device);
	boolean disconnectMidiDevice(MidiDevice device);
}
