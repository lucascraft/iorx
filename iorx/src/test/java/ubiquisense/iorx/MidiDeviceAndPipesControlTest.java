package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import ubiquisense.iorx.protocols.midi.internal.MidiCmdUtils;
import ubiquisense.iorx.protocols.midi.internal.MidiSystemUtils;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;

public class MidiDeviceAndPipesControlTest {

	static Sequencer seq;
	static Transmitter seqTrans;
	static Synthesizer synth;
	static Receiver synthRcvr;

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

		for (MidiDevice device : devices) {
			Info info = device.getDeviceInfo();

			String name = info.getName();
			String desc = info.getDescription();
			String vendor = info.getVendor();
			String ver = info.getVersion();

			desc = desc != null && !desc.contains("Unknown") ? " (" + desc + ") " : "";
			vendor = vendor != null && !vendor.contains("Unknown") ? vendor : "";
			ver = ver != null && !ver.contains("Unknown") ? " [" + ver + "]" : "";

			String kind = "[???] : ";

			boolean outDevice = device.getMaxReceivers() >= 0 && device.getMaxTransmitters() == -1;
			if (outDevice) {
				kind = "[INPUT] : ";
			}

			boolean inDevice = device.getMaxTransmitters() >= 0 && device.getMaxReceivers() == -1;
			if (inDevice) {
				kind = "[OUTPUT] : ";
			}

			System.out.println(kind + desc + " " + vendor + ver);
			
			List<String> k = Lists.newArrayList(MidiSystemUtils.INSTANCE.getNotesWithShiftMap().keySet());
			
			for (String keyCode : new String[] {k.get(0), k.get(4)}) {
				DSLMidiMessage msgON = MidiCmdUtils.INSTANCE.createMidiMessage(ShortMessage.NOTE_ON,
						(byte) MidiSystemUtils.INSTANCE.getNote(2, keyCode), (byte) 89);

				if (msgON != null) {
					byte[] stream = MidiCmdUtils.INSTANCE.dumpLegacyMidiMessageStream(msgON);
					if (true) {
						MidiChannel[] channels = synth.getChannels();
						if (channels != null && channels[msgON.getChannel()] != null) {
							channels[msgON.getChannel()].allNotesOff();
							// if (ShortMessage.NOTE_ON == command){
							channels[msgON.getChannel()].noteOn((int) msgON.getByte1(), (int) msgON.getByte1());
							// } else if (ShortMessage.NOTE_OFF == command){
							// channels[msg.getChannel()].noteOff((int)msg.getByte1(), (int)msg.getByte1());
							// }
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					synthRcvr.send(new MidiMessage(stream) {
						@Override
						public Object clone() {
							// who cares ...
							return null;
						}
					}, System.currentTimeMillis());
				}

			}
		}

	}

}
