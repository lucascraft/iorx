package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import ubiquisense.iorx.comm.midi.io.MidiCommunicator;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.xp.QuanticMojo;

public class QuanticMojoBasicTest extends GuiceInjectionTest
{
	
	@Test
	public void testPipeCreations()
	{
		CmdPipe udpOscIoPipe = QuanticMojo.INSTANCE.createPipe("udp://", "osc", "osc_pipe_1", "127.0.0.0:1234", new int[] {9056}, -1, new HashMap<Object, Object>(), false);

		assertNotNull(udpOscIoPipe);
		assertNotNull(udpOscIoPipe.getAddr());
		assertNotNull(udpOscIoPipe.getPort());
		assertNotNull(udpOscIoPipe.getPorts());
		
		CmdPipe udpMidiIoPipe = QuanticMojo.INSTANCE.createPipe("udp://", "midi", "midi_pipe_1", "127.0.0.0:5534", new int[] {9032}, -1, new HashMap<Object, Object>(), false);

		assertNotNull(udpMidiIoPipe);
		assertNotNull(udpMidiIoPipe.getAddr());
		assertNotNull(udpMidiIoPipe.getPort());
		assertNotNull(udpMidiIoPipe.getPorts());
		
		CmdPipe midiIoPipe = QuanticMojo.INSTANCE.createPipe("midi://", "midi", "midi_pipe_1", "", new int[] {}, -1, new HashMap<Object, Object>(), false);

		assertNotNull(midiIoPipe);
		assertNotNull(midiIoPipe.getAddr());
		assertNotNull(midiIoPipe.getPort());
		assertNotNull(midiIoPipe.getPorts());
		assertNotNull(midiIoPipe.getPort());
		assertNotNull(midiIoPipe.getPort().getChannel());
		assertTrue(midiIoPipe.getPort().getChannel() instanceof MidiCommunicator);

	}

}
