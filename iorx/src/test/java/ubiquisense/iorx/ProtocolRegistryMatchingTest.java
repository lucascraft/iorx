package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.registry.ProtocolReactor;
import ubiquisense.iorx.registry.CommProtocolConfig;

public class ProtocolRegistryMatchingTest {

	@Test
	public void testProtocolReactorRegistryMatching()
	{
		CommProtocolConfig oscConfigs = ProtocolReactor.INSTANCE.getCommunicationProtocol("osc");
		
		assertNotNull(oscConfigs);
		
		assertTrue(
			oscConfigs.getCmdInterpreter() instanceof OSCQxCmdHandler && 
			oscConfigs.getFrameInterpreter() instanceof OSCQxCmdHandler &&
			oscConfigs.getEventHandler() instanceof OSCQxCmdHandler
		);
		
		CommProtocolConfig midiConfigs = ProtocolReactor.INSTANCE.getCommunicationProtocol("midi");

		assertNotNull(midiConfigs);
		
		assertTrue(
			midiConfigs.getCmdInterpreter() instanceof MidiQxCmdHandler && 
			midiConfigs.getFrameInterpreter() instanceof MidiQxCmdHandler &&
			midiConfigs.getEventHandler() instanceof MidiQxCmdHandler
		);
		
		
		Set<CommProtocolConfig> allConfigs = ProtocolReactor.INSTANCE.getProtocols();
		
		assertTrue(allConfigs.size()>=2);
		


	}
}
