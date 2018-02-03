package ubiquisense.iorx.registry;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import ubiquisense.iorx.comm.bt.io.BTCommunicator;
import ubiquisense.iorx.comm.midi.io.MidiCommunicator;
import ubiquisense.iorx.comm.tcp.io.TcpChannel;
import ubiquisense.iorx.comm.udp.io.UdpChannel;
import ubiquisense.iorx.comm.usb.io.Serial;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.midi.MidiQxCmdHandler;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.qx.ByteCmd;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.EngineApplication;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.qx.evt.Event;
import ubiquisense.iorx.qx.evt.IQxEventHandler;
import ubiquisense.iorx.qx.impl.ByteCmdImpl;
import ubiquisense.iorx.qx.impl.CmdEngineImpl;
import ubiquisense.iorx.qx.impl.CmdImpl;
import ubiquisense.iorx.qx.impl.CmdPipeImpl;
import ubiquisense.iorx.qx.impl.EngineApplicationImpl;
import ubiquisense.iorx.qx.impl.EventImpl;
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
		bind(EngineApplication.class).to(EngineApplicationImpl.class);
		bind(Event.class).to(EventImpl.class);
		
		//
		// protocols
		//
		
		// -- midi --
		
		
		
		bind(IXFrameInterpreter.class).annotatedWith(Names.named("midi")).to(MidiQxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Names.named("midi")).to(MidiQxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Names.named("midi")).to(MidiQxCmdHandler.class);
		
		// -- osc --
		
		bind(IXFrameInterpreter.class).annotatedWith(Names.named("osc")).to(OSCQxCmdHandler.class);
		bind(IXCmdInterpreter.class).annotatedWith(Names.named("osc")).to(OSCQxCmdHandler.class);
		bind(IQxEventHandler.class).annotatedWith(Names.named("osc")).to(OSCQxCmdHandler.class);
		
		//
		// Comunications
		//
		
		
		// --- udp:// ---
		
		bind(Channel.class).annotatedWith(Names.named("udp://")).to(UdpChannel.class);
		
		// --- tcp:// ---
		
		bind(Channel.class).annotatedWith(Names.named("tcp://")).to(TcpChannel.class);
		
		// --- usb:// ---
		
		bind(Channel.class).annotatedWith(Names.named("usb://")).to(Serial.class);
		
		// --- midi:// ---
		
		bind(Channel.class).annotatedWith(Names.named("midi://")).to(MidiCommunicator.class);
		
		// --- bt:// ---
		
		bind(Channel.class).annotatedWith(Names.named("bt://")).to(BTCommunicator.class);
		
		// --- http:// ---
		
		bind(Channel.class).annotatedWith(Names.named("bt://")).to(BTCommunicator.class);
		
		
		
		
	}
}