package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.midi.internal.MidiCmdUtils;
import ubiquisense.iorx.protocols.midi.internal.MidiSystemUtils;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

public class OscMidiTest extends GuiceInjectionTest {
	
	private int pipeIo1Count;
	private int pipeOut1Count;
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
	public void testOscQxEventsHandling()
	{
		CmdPipe pipeOut1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost:4494", new int[] {}, -1, null, true);
		CmdPipe pipeIn1 = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), "localhost", new int[] {4494}, -1, null, true);
		CmdPipe midiPipe = Ubq.Reactor.openMidiPipe();

		pipeIn1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.RX_READY.equals(event.getKind()))
				{
					
					OscCmd oscCmd = (OscCmd) event.getCmd();
					OSCMessage msg = (OSCMessage) oscCmd.getMsg();
					String[] noteAtoms = msg.getAddress().split("/");
					String noteAsText = noteAtoms[5];
					String instrAsText = noteAtoms[3];
					MidiSystemUtils.INSTANCE.affectInstrumentToChannel(synth, synth.getAvailableInstruments()[Integer.valueOf(instrAsText).intValue()]);
					DSLMidiMessage msgON = MidiCmdUtils.INSTANCE.createMidiMessage(ShortMessage.NOTE_ON, (byte) Integer.valueOf(noteAsText).intValue(), (byte) 89);
					midiPipe.send(msgON);
					pipeIo1Count++;
				} 
			}
		});
		
		pipeOut1.addQxEventHandler(new OSCQxCmdHandler() {
			@Override
			public void handleQxEvent(Event event) {
				if (EVENT_KIND.TX_READY.equals(event.getKind()))
				{
					System.out.println(((OSCMessage)((OscCmd)event.getCmd()).getMsg()).getAddress());
					pipeOut1Count++;
				} 
			}
		});
		
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/12/notef/15"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/10/notef/25"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/2/notef/35"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/16/notef/45"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/22/notef/55"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/1/notef/65"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/14/notef/75"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/22/notef/85"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/19/notef/95"));
		pipeOut1.send(OscCmdUtils.INSTANCE.createOscCmd("/midi/synth/8/notef/105"));
		
		try {
			Thread.sleep(250l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Sent " + pipeIo1Count + "on localhost:4444");
		System.out.println("Rcv " + pipeIo1Count + "on 4444");
		

		assertEquals(10, pipeIo1Count);
		assertEquals(10, pipeOut1Count);
		
	}
}
