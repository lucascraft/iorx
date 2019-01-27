package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

import org.junit.Before;
import org.junit.Test;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.protocols.midi.internal.MidiCmdUtils;
import ubiquisense.iorx.protocols.midi.internal.MidiSystemUtils;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;

public class MidiDeviceAndPipesControlTest {

	static Sequencer seq;
	static Transmitter seqTrans;
	static Synthesizer synth;
	static Receiver synthRcvr;
	String[] keys1 = new String[] { "C", "C#", "D", "D#",  "C", "C#", "D", "D#", "C", "C#", "D", "D#",  "C", "C#", "D", "D#" };

	@Before
	public void initSequencer() {
		try {
			seq = MidiSystem.getSequencer();
			seqTrans = seq.getTransmitter();
			synth = MidiSystem.getSynthesizer();
			synth.open();
			synthRcvr = synth.getReceiver();
			seqTrans.setReceiver(synthRcvr);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMidiDeviceInit() {

		List<MidiDevice> devices = MidiSystemUtils.INSTANCE.getMidiDevices();

		assertNotNull(devices);
		assertTrue(!devices.isEmpty());

		MidiSystemUtils.INSTANCE.affectInstrumentToChannel(synth, synth.getAvailableInstruments()[10]);
		for (Integer keyCode : MidiSystemUtils.INSTANCE.getNotes(3, keys1)) {
			DSLMidiMessage msgON = MidiCmdUtils.INSTANCE.createMidiMessage(ShortMessage.NOTE_ON,
					(byte) keyCode.intValue(), (byte) 89);
			if (msgON != null) {
				MidiChannel[] channels = synth.getChannels();
				if (channels != null && channels[msgON.getChannel()] != null) {
					channels[msgON.getChannel()].allNotesOff();
					channels[msgON.getChannel()].noteOn((int) msgON.getByte1(), (int) msgON.getByte2());
					try {
						Thread.sleep(75);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Test
	public void testMidiCmdPipe() {
		CmdPipe midiPipe = Ubq.Reactor.openMidiPipe();
		for (int octave : new int[] { 3, 4, 3, 3, 4, 3, 3, 4, 3, 3, 4, 3, 3, 4, 3 }) {
			for (Integer keyCode : MidiSystemUtils.INSTANCE.getNotes(octave, keys1)) {
				DSLMidiMessage msgON = MidiCmdUtils.INSTANCE.createMidiMessage(ShortMessage.NOTE_ON, (byte) keyCode.intValue(), (byte) 89);
				midiPipe.send(msgON);
			}
		}
	}
}
