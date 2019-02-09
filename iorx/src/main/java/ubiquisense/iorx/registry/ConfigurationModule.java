package ubiquisense.iorx.registry;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import ubiquisense.iorx.annotations.Binder;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.cmd.impl.CmdEngineImpl;
import ubiquisense.iorx.cmd.impl.CmdImpl;
import ubiquisense.iorx.cmd.impl.CmdPipeImpl;
import ubiquisense.iorx.comm.bt.io.BTTransportCommunicator;
import ubiquisense.iorx.comm.midi.io.MidiTransportCommunicator;
import ubiquisense.iorx.comm.tcp.io.TcpTransportCommunicator;
import ubiquisense.iorx.comm.udp.io.UdpTransportCommunicator;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.dndns.services.DaapService;
import ubiquisense.iorx.dndns.services.DnDnsService;
import ubiquisense.iorx.dndns.services.IorxService;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.event.impl.EventImpl;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.protocols.dmx.DMXQxCmdHandler;
import ubiquisense.iorx.protocols.firmata.FirmataCmdQxEventHandler;
import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.protocols.raw.RawQxCmdHandler;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.protocols.raw.internal.impl.ByteCmdImpl;
import ubiquisense.iorx.protocols.tuio.tuio11.Tuio11QxCmdHandler;
import ubiquisense.iorx.protocols.ubiquino.UbiquinoQxCmdEventHandler;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.qx.impl.RxImpl;
import ubiquisense.iorx.qx.impl.TxImpl;

public class ConfigurationModule extends AbstractModule 
{
	@Override
	protected void configure() 
	{
		
		//
		// Commands
		//
		
		bind(CmdPipe.class).to(CmdPipeImpl.class);
		bind(Cmd.class).to(CmdImpl.class);
		bind(ByteCmd.class).to(ByteCmdImpl.class);
		
		//
		// Queues
		//
		
		bind(Rx.class).to(RxImpl.class);
		bind(Tx.class).to(TxImpl.class);
		
		//
		// Engines
		//
		
		bind(CmdEngine.class).to(CmdEngineImpl.class);
		bind(Event.class).to(EventImpl.class);
		
		//
		// protocols
		//
		
		// -- midi --
		
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("midi")).to(MidiQxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("midi")).to(MidiQxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("midi")).to(MidiQxCmdHandler.class);
		
		// -- osc --
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("osc")).to(OSCQxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("osc")).to(OSCQxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("osc")).to(OSCQxCmdHandler.class);
		
		// -- tuio11 --
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("tuio11")).to(Tuio11QxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("tuio11")).to(Tuio11QxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("tuio11")).to(Tuio11QxCmdHandler.class);
		
		// -- firmata --
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("firmata")).to(FirmataCmdQxEventHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("firmata")).to(FirmataCmdQxEventHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("firmata")).to(FirmataCmdQxEventHandler.class);
		
		// -- ubiquino --
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("ubiquino")).to(UbiquinoQxCmdEventHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("ubiquino")).to(UbiquinoQxCmdEventHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("ubiquino")).to(UbiquinoQxCmdEventHandler.class);
		
		// -- raw --
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("raw")).to(RawQxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("raw")).to(RawQxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("raw")).to(RawQxCmdHandler.class);
		
		// -- dmx --
		
		bind(IXFrameInterpreter.class).annotatedWith(Binder.communication("dmx")).to(DMXQxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Binder.communication("dmx")).to(DMXQxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Binder.communication("dmx")).to(DMXQxCmdHandler.class);
		
	
		
		//
		// Comunications
		//
		
		bind(TransportChannel.class).annotatedWith(Binder.transport("udp://")).to(UdpTransportCommunicator.class);
		bind(TransportChannel.class).annotatedWith(Binder.transport("tcp://")).to(TcpTransportCommunicator.class);
		bind(TransportChannel.class).annotatedWith(Binder.transport("usb://")).to(UsbSerialTransportCommunicator.class);
		bind(TransportChannel.class).annotatedWith(Binder.transport("midi://")).to(MidiTransportCommunicator.class);
		bind(TransportChannel.class).annotatedWith(Binder.transport("bt://")).to(BTTransportCommunicator.class);
		
		//
		// Dn Dns Services
		//
		
		bind(DnDnsService.class).annotatedWith(Names.named("daap")).to(DaapService.class);
		bind(DnDnsService.class).annotatedWith(Names.named("iorx")).to(IorxService.class);

	}
}