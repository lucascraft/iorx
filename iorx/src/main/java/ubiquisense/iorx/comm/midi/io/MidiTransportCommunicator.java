

package ubiquisense.iorx.comm.midi.io;

import javax.inject.Named;
import javax.sound.midi.MidiDevice;

import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.IChannelCloser;
import ubiquisense.iorx.io.impl.TransportChannelImpl;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;

@TransportProtocol(type = "midi://")
@Named("midi://")
public class MidiTransportCommunicator extends TransportChannelImpl implements IChannelCloser {
	private MidiDevice device;
	private IMidiIn in;
	private IMidiOut out;
	private CmdPipe engine;
	public MidiTransportCommunicator() {
	}
	public void setEngine(CmdPipe engine) {
		this.engine = engine;
	}
	public MidiDevice getDevice() {
		return device;
	}
	public boolean isInputOutputDevice() {
		return isInputDevice() && isOutputDevice();
	}
	public boolean isInputDevice() {
		return device != null && device.getMaxTransmitters() >=0 && device.getMaxReceivers() == -1;
	}
	public boolean isOutputDevice() {
		return device != null && device.getMaxReceivers() >=0 && device.getMaxTransmitters() == -1;
	}
	public void setDevice(MidiDevice device) {
		this.device	= device;
		if (isOutputDevice()) {
			out			= new NullOutputJob();
			in			= new MidiInputJob(device, engine);
		}
		if (isInputDevice()) {
			out			= new MidiOutputJob(device);
			in			= new NullInputJob();
		}
	}
	public void close() {
		if (device != null && device.isOpen()) {
			device.close();
		}
		if (in != null) {
			in.close();
		}
		if (out != null) {
			out.close();
		}
	}
	public void send(DSLMidiMessage msg) {
		if (out != null) {
			out.send(msg);
		}
	}
	@Override
	public void send(byte[] bytes) {
		Cmd cmd = engine.getInputInterpreter().byteArray2Cmd(bytes);
		if (cmd instanceof DSLMidiMessage) {
			send((DSLMidiMessage)cmd);
		}
	}
}
