package ubiquisense.iorx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import ubiquisense.iorx.comm.bt.io.BTTransportCommunicator;
import ubiquisense.iorx.comm.midi.io.MidiTransportCommunicator;
import ubiquisense.iorx.comm.tcp.io.TcpTransportCommunicator;
import ubiquisense.iorx.comm.udp.io.UdpTransportCommunicator;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.raw.RawQxCmdHandler;
import ubiquisense.iorx.protocols.tuio.tuio11.Tuio11QxCmdHandler;
import ubiquisense.iorx.registry.CommProtocolConfig;

public class ProtocolRegistryMatchingTest {

	@Test
	public void testCommunicationProtocolReactorRegistryMatching() {
		CommProtocolConfig oscConfigs = Ubq.Protocol.getCommunicationProtocol("osc");

		assertNotNull(oscConfigs);

		assertTrue(oscConfigs.getCmdInterpreter() instanceof OSCQxCmdHandler
				&& oscConfigs.getFrameInterpreter() instanceof OSCQxCmdHandler
				&& oscConfigs.getEventHandler() instanceof OSCQxCmdHandler);

		CommProtocolConfig midiConfigs = Ubq.Protocol.getCommunicationProtocol("midi");

		assertNotNull(midiConfigs);

		assertTrue(midiConfigs.getCmdInterpreter() instanceof MidiQxCmdHandler
				&& midiConfigs.getFrameInterpreter() instanceof MidiQxCmdHandler
				&& midiConfigs.getEventHandler() instanceof MidiQxCmdHandler);

		CommProtocolConfig tuio11Configs = Ubq.Protocol.getCommunicationProtocol("tuio11");

		assertNotNull(tuio11Configs);

		assertTrue(tuio11Configs.getCmdInterpreter() instanceof Tuio11QxCmdHandler
				&& tuio11Configs.getFrameInterpreter() instanceof Tuio11QxCmdHandler
				&& tuio11Configs.getEventHandler() instanceof Tuio11QxCmdHandler);
		
		CommProtocolConfig rawConfigs = Ubq.Protocol.getCommunicationProtocol("raw");

		assertNotNull(rawConfigs);

		assertTrue(rawConfigs.getCmdInterpreter() instanceof RawQxCmdHandler
				&& rawConfigs.getFrameInterpreter() instanceof RawQxCmdHandler
				&& rawConfigs.getEventHandler() instanceof RawQxCmdHandler);

		Set<CommProtocolConfig> allConfigs = Ubq.Protocol.getCommunictionProtocols();

		assertTrue(allConfigs.size() >= 2);

	}
	
	
	@Test
	public void testTansportProtocolReactorRegistryMatching() {
	
		TransportChannel udp = Ubq.Protocol.getTransportCommunicator("udp");

		assertNotNull(udp);

		assertTrue(udp instanceof UdpTransportCommunicator);

		TransportChannel tcp = Ubq.Protocol.getTransportCommunicator("tcp");

		assertNotNull(tcp);

		assertTrue(tcp instanceof TcpTransportCommunicator);

		TransportChannel midi = Ubq.Protocol.getTransportCommunicator("midi");

		assertNotNull(midi);

		assertTrue(midi instanceof MidiTransportCommunicator);
		
		TransportChannel bt = Ubq.Protocol.getTransportCommunicator("bt");

		assertNotNull(bt);

		assertTrue(bt instanceof BTTransportCommunicator);
		
		TransportChannel usb = Ubq.Protocol.getTransportCommunicator("usb");

		assertNotNull(usb);

		assertTrue(usb instanceof UsbSerialTransportCommunicator);

	}
}
