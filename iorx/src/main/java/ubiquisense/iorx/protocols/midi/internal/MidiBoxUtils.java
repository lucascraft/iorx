package ubiquisense.iorx.protocols.midi.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.protocols.midi.internal.dsl.NoteON;


public class MidiBoxUtils {


	private HashMap<String, List<Instrument>> instrumentsMap;

	private Sequencer seq;
	private Transmitter seqTrans;
	private Synthesizer synth;
	private Receiver synthRcvr;


	private CmdPipe midiPipe;

	

//	class EzMidiCmdDumper extends AbstractQxEventHandlerImpl {
//		@Override
//		public synchronized void handleQxEvent(Event event) {
//			if (event.getKind() == EVENT_KIND.TX_DONE) {
//				if (event.getCmd() instanceof DSLMidiMessage) {
//					QuanticMojo.INSTANCE
//							.acceptLocalAgentCmd(Midi2OscMapping.INSTANCE.midi2osc(((DSLMidiMessage) event.getCmd())));
//				}
//			}
//		}
//	}

	private void initSequencer() {
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


	boolean useSynthetizer = true;

	public void createPartControl() {

		initSequencer();

		instrumentsMap = MidiSystemUtils.INSTANCE.instrumentsByBanks(synth);
		List<Instrument> instruments = new ArrayList<Instrument>();
		for (String k : instrumentsMap.keySet()) {
			for (Instrument in : instrumentsMap.get(k)) {
				int bankID = in.getPatch().getBank();
				if (bankID == 0) {
					instruments.add(in);
				}
			}
		}
	
//		MidiSystemUtils.INSTANCE.affectInstrumentToChannel(synth, instruments.get(0));
//		
//		NoteON noteOn = MidiCmdUtils.INSTANCE.createNoteON(ShortMessage.NOTE_ON, 1, 20);
//				DSLMidiMessage msg = MidiCmdUtils.INSTANCE.createMidiMessage(command, (byte) MidiSystemUtils.INSTANCE.getNote(octave, keyCode), (byte) attack);
//				if (msg != null) {
//					byte[] stream = MidiCmdUtils.INSTANCE.dumpLegacyMidiMessageStream(msg);
//					if (useSynthetizer) {
//						MidiChannel[] channels = synth.getChannels();
//						if (channels != null && channels[msg.getChannel()] != null) {
//							channels[msg.getChannel()].allNotesOff();
//							if (ShortMessage.NOTE_ON == command) {
//								channels[msg.getChannel()].noteOn((int) msg.getByte1(), (int) msg.getByte1());
//							} else if (ShortMessage.NOTE_OFF == command) {
//								channels[msg.getChannel()].noteOff((int) msg.getByte1(), (int) msg.getByte1());
//							}
//						}
//					}
//					synthRcvr.send(new MidiMessage(stream) {
//						
//						@Override
//						public Object clone() {
//							// TODO Auto-generated method stub
//							return null;
//						}
//					}, System.currentTimeMillis());
//				}
//
//	private void hookMidiPipe(CmdPipe pipe) {
//		midiPipe = pipe;
//		midiPipe.addQxEventHandler(new AbstractQxEventHandlerImpl() {
//			public synchronized void handleQxEvent(net.sf.xqz.model.engine.Event event) {
//				if (event.getKind() == EVENT_KIND.RX_DONE && event.getCmd() instanceof DSLMidiMessage) {
//					if (!synth.isOpen()) {
//						try {
//							synth.open();
//						} catch (MidiUnavailableException e) {
//							e.printStackTrace();
//							return;
//						}
//					}
//					if (synthRcvr != null) {
//						DSLMidiMessage msg = (DSLMidiMessage) event.getCmd();
//						if (liveNotification) {
//							QuanticMojo.INSTANCE.acceptLocalAgentCmd(Midi2OscMapping.INSTANCE.midi2osc(msg));
//						}
//						byte[] stream = MidiCmdUtils.INSTANCE.dumpLegacyMidiMessageStream(msg);
//						synthRcvr.send(new MidiMessage(stream) {
//							@Override
//							public Object clone() {
//								// who cares ...
//								return null;
//							}
//						}, System.currentTimeMillis());
//					}
//				}
//			};
//		});
//	}

	}

}
