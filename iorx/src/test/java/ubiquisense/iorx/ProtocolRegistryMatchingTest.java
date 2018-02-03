package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.raw.RawQxCmdHandler;
import ubiquisense.iorx.protocols.tuio.tuio11.Tuio11QxCmdHandler;
import ubiquisense.iorx.registry.CommProtocolConfig;
import ubiquisense.iorx.registry.ProtocolReactor;

public class ProtocolRegistryMatchingTest {

	@Test
	public void testProtocolReactorRegistryMatching() {
		CommProtocolConfig oscConfigs = ProtocolReactor.INSTANCE.getCommunicationProtocol("osc");

		assertNotNull(oscConfigs);

		assertTrue(oscConfigs.getCmdInterpreter() instanceof OSCQxCmdHandler
				&& oscConfigs.getFrameInterpreter() instanceof OSCQxCmdHandler
				&& oscConfigs.getEventHandler() instanceof OSCQxCmdHandler);

		CommProtocolConfig midiConfigs = ProtocolReactor.INSTANCE.getCommunicationProtocol("midi");

		assertNotNull(midiConfigs);

		assertTrue(midiConfigs.getCmdInterpreter() instanceof MidiQxCmdHandler
				&& midiConfigs.getFrameInterpreter() instanceof MidiQxCmdHandler
				&& midiConfigs.getEventHandler() instanceof MidiQxCmdHandler);

		CommProtocolConfig tuio11Configs = ProtocolReactor.INSTANCE.getCommunicationProtocol("tuio11");

		assertNotNull(tuio11Configs);

		assertTrue(tuio11Configs.getCmdInterpreter() instanceof Tuio11QxCmdHandler
				&& tuio11Configs.getFrameInterpreter() instanceof Tuio11QxCmdHandler
				&& tuio11Configs.getEventHandler() instanceof Tuio11QxCmdHandler);
		
		CommProtocolConfig rawConfigs = ProtocolReactor.INSTANCE.getCommunicationProtocol("raw");

		assertNotNull(rawConfigs);

		assertTrue(rawConfigs.getCmdInterpreter() instanceof RawQxCmdHandler
				&& rawConfigs.getFrameInterpreter() instanceof RawQxCmdHandler
				&& rawConfigs.getEventHandler() instanceof RawQxCmdHandler);

		Set<CommProtocolConfig> allConfigs = ProtocolReactor.INSTANCE.getProtocols();

		assertTrue(allConfigs.size() >= 2);

	}
}
