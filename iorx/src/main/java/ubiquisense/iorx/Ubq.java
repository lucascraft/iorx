package ubiquisense.iorx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.sound.midi.MidiDevice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ubiquisense.iorx.app.EngineApplication;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.comm.http.io.HttpCommunicator;
import ubiquisense.iorx.comm.midi.io.MidiTransportCommunicator;
import ubiquisense.iorx.discovery.ICmdPipeLifecycleListener;
import ubiquisense.iorx.discovery.Supervisor;
import ubiquisense.iorx.discovery.TopologyManager;
import ubiquisense.iorx.event.IQxEventHandler;
//import net.sf.smbt.comm.extensions.protocol.ProtocolReactor;
//import net.sf.smbt.comm.extensions.protocol.ProtocolWithSpecificTransportConfig;
//import net.sf.smbt.comm.http.io.HttpCommunicator;
//import net.sf.smbt.comm.script.netConf.TRANSPORT_PROTOCOL;
//import net.sf.smbt.midi.utils.MidiCommunicator;
//import net.sf.smbt.quantic.services.EzTargetConfig;
//import net.sf.smbt.quantic.services.QuanticComm;
//import net.sf.smbt.quantic.warp.AbstractQxEventHandlerImpl;
//import net.sf.smbt.quantic.warp.CmdEngine;
//import net.sf.smbt.quantic.warp.EngineFactory;
//import net.sf.smbt.quantic.warp.IChannel;
//import net.sf.smbt.quantic.warp.ICmdPipeLifecycleListener;
//import net.sf.smbt.quantic.warp.IDxxpManager;
//import net.sf.smbt.quantic.warp.IPipeBuilder;
//import net.sf.smbt.quantic.warp.IQxEventHandler;
//import net.sf.smbt.quantic.warp.IWarpManager;
//import net.sf.smbt.quantic.warp.Orchestror;
//import net.sf.xqz.script.utils.OrchestrorUtil;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.qx.QxProcessingStrategy;
import ubiquisense.iorx.registry.CommProtocolConfig;
import ubiquisense.iorx.registry.ConfigurationModule;
import ubiquisense.iorx.registry.DnsSdRegistry;
import ubiquisense.iorx.registry.ProtocolRegistry;
import ubiquisense.iorx.registry.PortsRegistry;
import ubiquisense.iorx.topology.core.TopologyCache;
import ubiquisense.iorx.topology.core.impl.TopologyCacheImpl;

public final class Ubq 
{
	private Supervisor supervisor;
	private TopologyCache topology;
	private ConcurrentLinkedQueue<ICmdPipeLifecycleListener> lifecycleListeners;
	private Set<CmdPipe> localPipes;
	public final static Ubq Reactor = new Ubq();
	public final static ProtocolRegistry Protocol = new ProtocolRegistry();
	public final static PortsRegistry Ports = new PortsRegistry();
	
	public Ubq() {
		lifecycleListeners = new ConcurrentLinkedQueue<ICmdPipeLifecycleListener>();
		localPipes = new HashSet<CmdPipe>();
		genesis();
	}
	
	public ConcurrentLinkedQueue<ICmdPipeLifecycleListener> getLifecycleListeners() {
		return lifecycleListeners;
	}
	
	public void addLifecycleListener(ICmdPipeLifecycleListener listener) {
		lifecycleListeners.add(listener);
	}
	
	public void removeLifecycleListener(ICmdPipeLifecycleListener listener) {
		lifecycleListeners.remove(listener);
	}
	
	void genesis() {	
		topology = new TopologyCacheImpl();
		
		TopologyManager.INSTANCE.startContinuousDiscovery();
		
		initTopologyAgentAndSupervisor();
	}
	
	void initTopologyAgentAndSupervisor() {
		supervisor = new Supervisor(topology);
		DnsSdRegistry dsnSD = DnsSdRegistry.INSTANCE;
		dsnSD.addDeviceListener(supervisor);
	}
	
	public CmdPipe getCmdPipe(String transportID, String protocoleID, int port) {
		for (CmdPipe pipe : getPipes()) {
			if (pipe.getPorts().contains(port)) {
				if (pipe.getTransportProtocol() != null && pipe.getTransportProtocol().equals(transportID)) {
					if (pipe.getCommunicationProtocol() != null && pipe.getCommunicationProtocol().equals(protocoleID)) {
						return pipe;
					}
				}
			}
		}
		return null;
	}
	
	public CmdPipe getCmdEngine2(String transportID, String protocoleID, String address) {
		for (CmdPipe pipe : getPipes()) {
			if (pipe.getAddr() != null && pipe.getAddr().equals(address)) {
				if (pipe.getTransportProtocol() != null && pipe.getTransportProtocol().equals(transportID)) {
					if (pipe.getCommunicationProtocol() != null && pipe.getCommunicationProtocol().equals(protocoleID)) {
						return pipe;
					}
				}
			}
		}
		return null;
	}

	public synchronized Set<CmdPipe> getPipes() {
		return localPipes;
	}
	
	public synchronized CmdPipe getPipe(String pipeID) {
		for (CmdPipe p : getPipes()) {
			if (pipeID.equals(p.getId())) {
				return p;
			}
		}
		return null;
	}
	
	public synchronized CmdPipe getPipe(String transportID, String protocoleID,
			String address, Integer port) {
		return getPipe(transportID, protocoleID, address, port.intValue());
	}	
	
	public synchronized CmdPipe getAgentPipe() {
		return openUdpPipe(
			"ezmojo", 
			"localhost:4445", 4443
		);
	}

	public synchronized CmdPipe getPipe(String transportID, String protocoleID,
			String address, int port) {
		for (CmdPipe pipe : getPipes()) {
			if (pipe.getPorts().contains(port)) {
				if (pipe.getAddr() != null && pipe.getAddr().equals(address)) {
					if (pipe.getTransportProtocol() != null && 
							pipe.getTransportProtocol().equals(transportID)) {
						if (pipe.getCommunicationProtocol() != null && 
								pipe.getCommunicationProtocol().equals(protocoleID)) {
							return pipe;
						}
					}
				}
			}
		}
		return null;
	}
	
	public synchronized CmdPipe getPipe(String transportID,
			String address, int[] ports) {
		for (CmdPipe pipe : getPipes()) {
			boolean valid = true;
			if (ports != null) {
				for (int port : ports) {
					if (!pipe.getPorts().contains(port)) {
						valid = false;
					}
				}
			}
			if (valid) {
				String localhostImplicitAddr = address.startsWith(":") ? "localhost"+address : "";
				if (pipe.getAddr() != null ) {
					if(pipe.getAddr().equals(address) || pipe.getAddr().equals(localhostImplicitAddr)) {
						if (pipe.getTransportProtocol() != null && 
								pipe.getTransportProtocol().equals(transportID)) {
							return pipe;
						}
					}
				}
			}
		}
		return null;
	}

	public synchronized CmdPipe getPipe(String transportID, int[] ports) {
		for (CmdPipe pipe : getPipes()) {
			boolean continuing = false;
			if (ports != null) {
				for (int port : ports) {
					if (pipe.getPorts().contains(port)) {
						continuing = true;
						break;
					}
				}
			}
			if (	continuing &&
					pipe.getTransportProtocol() != null && 
					pipe.getTransportProtocol().equals(transportID)
			) {
				return pipe;
			}
		}
		return null;
	}

	public synchronized CmdPipe getUSBPipe(String protocoleID, String address, int speed) {
		for (CmdPipe pipe : getPipes()) {
			if (pipe.getTransportProtocol() != null && 
						pipe.getTransportProtocol().equals(TRANSPORT_PROTOCOL.USB.getLiteral())) {
				if (pipe.getAddr() != null && pipe.getAddr().equals(address)) {
					if (pipe.getCommunicationProtocol() != null && 
							pipe.getCommunicationProtocol().equals(protocoleID)) {
						if (pipe.getSpeed() > 0 && pipe.getSpeed() == speed) {
							return pipe;
						}
					}
				}
			}
		}
		return null;
	}

	public synchronized CmdPipe getPipe(String transportID, String protocoleID,
			String address, int[] ports, int speed) {
		for (CmdPipe pipe : getPipes()) {
			if (ports != null && ports.length > 0) {
				for (int port : ports) {
					if (!pipe.getPorts().contains(port)) {
						return null;
					}
				}
			}
			if (pipe.getAddr() != null && pipe.getAddr().equals(address)) {
				if (pipe.getTransportProtocol() != null && 
						pipe.getTransportProtocol().equals(transportID)) {
					if (pipe.getCommunicationProtocol() != null && 
							pipe.getCommunicationProtocol().equals(protocoleID)) {
						if (TRANSPORT_PROTOCOL.USB.getLiteral().equals(transportID)) {
							return pipe.getSpeed() > 0 && speed == pipe.getSpeed() ? pipe : null;
						}
						return pipe;
					}
				}
			}
		}
		return null;
	}


	
	//
	//
	// Here should comes the TopologyUtils for manual/programatic configuration madness
	//
	//
	
	
	public CmdPipe createPipe(String transportID, String commProtocolID, String pipeID, String address, int acceptedPorts[], int speed, Map<Object, Object> options, boolean locked) {
		EngineApplication app = buildEngineApp(pipeID, commProtocolID);
		CmdPipe pipe = app.getEngine().size() == 1 ? app.getEngine().get(0) : null;

		if (pipe == null) {
			return null;
		}
		
		Port port = Ports.resolvePort(transportID, address, acceptedPorts, speed, pipe, options == null ? options = new HashMap<Object, Object>() : options, locked);
			
		if (port == null) 
		{
			return null;
		}
			
		//
		// check for custom communication channel
		//
			
		CommProtocolConfig protocolConfig = Protocol.getCommunicationProtocol(commProtocolID);
			
		if (protocolConfig == null) return null;
			
		if (port.getChannel() instanceof HttpCommunicator) {
			HttpCommunicator communicator = (HttpCommunicator) port.getChannel();
			communicator.init(pipeID, address, acceptedPorts==null?new int[0]:acceptedPorts);
		}
		pipe.setPort(port);

		pipe.setTransportProtocol(transportID);
		pipe.setCommunicationProtocol(commProtocolID);
		pipe.setId(pipeID);
		pipe.setSpeed(speed);
		pipe.setLocked(locked);

		//pipe.addQxEventHandler(pubsubEventHandler);
		
		if (acceptedPorts != null && acceptedPorts.length > 0) {
			for (int p : acceptedPorts) {
				pipe.getPorts().add(p);
			}
		}
		
		String commTag2 = transportID.replace("://", "");
	
		boolean in	= pipe.getPort().getInputJobs().size() > 0;
		boolean out = pipe.getPort().getOutputJobs().size() > 0;;

		String direction = "";
		if(in && out){
			direction = "[<->]";
		} else if (in) {
			direction = "[<--]";
		} else if (out) {
			direction = "[-->]";
		} else {
			direction = "[-?-]";
		}
		
		String name = direction + "[" + commTag2 + "][" + Protocol.getCommunicationProtocol(commProtocolID).getAlias() + "]" + " " + address;
		if (acceptedPorts != null) {
			for (int aPort : acceptedPorts) {
				name += "/" + aPort;
			}
		}
		
		if ( (pipe.getPort().getChannel() instanceof MidiTransportCommunicator)) {
			MidiTransportCommunicator midi = (MidiTransportCommunicator) pipe.getPort().getChannel();
			if(midi.isInputDevice() && midi.isOutputDevice()){
				direction = "[<->]";
			} else if (midi.isInputDevice()) {
				direction = "[<--]";
			} else if (midi.isOutputDevice()) {
				direction = "[-->]";
			} else {
				direction = "[...]";
			}
		}
		
		pipe.setName(name);
		pipe.getRx().setStrategy(QxProcessingStrategy.PICK_NFLUSH);
		pipe.getRx().setMax(32);
		pipe.getRx().setTtl(24);
		pipe.getTx().setStrategy(QxProcessingStrategy.PICK_NFLUSH);
		pipe.getTx().setMax(32);
		pipe.getTx().setTtl(24);
		pipe.setAddr(address);
		
		if (acceptedPorts != null && acceptedPorts.length > 0) {
			for (int p : acceptedPorts) {
				pipe.getPorts().add(Integer.valueOf(p));
			}
		}
		return notifyPipe(true, pipe);

	}

	public CmdPipe openPipe(String comm, String protocolID, String pipeID, String portID, int acceptedPorts[], int speed, Map<Object, Object> options) {
		// get possibly cached pipe from ID
		CmdPipe pipe = getPipe(pipeID);
		if (pipe != null) {
			return pipe;
		}

		if (comm.equals(TRANSPORT_PROTOCOL.USB.getLiteral())) {
			if ( speed == 0) {
				return null;
			} else {
				// get already cached pipe if any
				pipe = getUSBPipe(protocolID, portID, speed);
				if (pipe != null) {
					return notifyPipe(true, pipe);
				}
			}
		}

		// get already cached pipe if any
		pipe = getPipe(comm, protocolID, portID, acceptedPorts, speed);
		if (pipe != null) {
			return notifyPipe(true, pipe);
		}
		// get already cached pipe if any
		pipe = getPipe(comm, portID, acceptedPorts);
		if (pipe != null) {
			return notifyPipe(true, pipe);
		}
		
		return createPipe(comm, protocolID, pipeID, portID, acceptedPorts, speed, options, false);
	}

	private CmdPipe notifyPipe(boolean created, CmdPipe pipe) {
		for (ICmdPipeLifecycleListener l : lifecycleListeners) {
			if (created) {
				l.open(pipe);
			} else {
				l.remove(pipe);
			}
		}
		return pipe;
	}
	
	//
	// Named Pipes
	//
	
	public CmdPipe openUsbPipe(String protocolID, String pipeID, String portConfig, int speed, Map<Object, Object> options) {
		return openPipe(TRANSPORT_PROTOCOL.USB.getLiteral(), protocolID, pipeID, portConfig, null, speed, options);
	}
	
	public CmdPipe openUsbPipe(String protocolID, String pipeID, String portConfig, int speed) {
		return openPipe(TRANSPORT_PROTOCOL.USB.getLiteral(), protocolID, pipeID, portConfig, null, speed, new HashMap<Object, Object>());
	}

	public CmdPipe openUdpPipe(String protocolID, String pipeID, String portConfig, int acceptedPort) {
		return openPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), protocolID, pipeID, portConfig,  new int[] { acceptedPort }, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openUdpPipe(String protocolID, String pipeID, String portConfig, int[] acceptedPorts) {
		return openPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), protocolID, pipeID, portConfig, acceptedPorts, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openTcpPipe(String protocolID, String pipeID, String portConfig, int acceptedPort) {
		return openPipe(TRANSPORT_PROTOCOL.TCP.getLiteral(), protocolID, pipeID, portConfig, new int[] { acceptedPort }, 0, new HashMap<Object, Object>());
	}
	
	public CmdPipe openTcpPipe(String protocolID, String pipeID, String portConfig, int[] acceptedPorts) {
		return openPipe(TRANSPORT_PROTOCOL.TCP.getLiteral(), protocolID, pipeID, portConfig, acceptedPorts, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openBluetoothPipe(String protocolID, String pipeID, String portConfig, int speed) {
		return openPipe(TRANSPORT_PROTOCOL.BLUETOOTH.getLiteral(), protocolID, pipeID, portConfig, null, speed, new HashMap<Object, Object>());
	}

	public CmdPipe openUdpPipe(String protocolID, String pipeID, String portConfig) {
		return openPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), protocolID, pipeID, portConfig, null, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openTcpPipe(String protocolID, String pipeID, String portConfig) {
		return openPipe(TRANSPORT_PROTOCOL.TCP.getLiteral(), protocolID, pipeID, portConfig, null, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openHttpPipe(String protocolID, String pipeID, String portConfig, int[] acceptedPorts) {
		return openPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, pipeID, portConfig, acceptedPorts, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openHttpPipe(String protocolID, String pipeID, String portConfig, int acceptedPort) {
		return openPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, pipeID, portConfig, new int[] { acceptedPort }, 0, new HashMap<Object, Object>());
	}

	public CmdPipe openHttpPipe(String protocolID, String pipeID, String portConfig) {
		return openPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, pipeID, portConfig, null, 0, new HashMap<Object, Object>());
	}

	public CmdPipe createHttpPipe(String protocolID, String pipeID, String portConfig, int[] acceptedPorts) {
		return createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, pipeID, portConfig, acceptedPorts, 0, new HashMap<Object, Object>(), false);
	}

	public CmdPipe createHttpPipe(String protocolID, String pipeID, String portConfig, int acceptedPort) {
		return createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, pipeID, portConfig, new int[] { acceptedPort }, 0, new HashMap<Object, Object>(), false);
	}

	public CmdPipe createHttpPipe(String protocolID, String pipeID, String portConfig) {
		return createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, pipeID, portConfig, null, 0, new HashMap<Object, Object>(), false);
	}
	
	public CmdPipe createHttpPipe(String protocolID, String portConfig, int[] acceptedPorts) {
		return createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, "HttpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPorts, 0, new HashMap<Object, Object>(), false);
	}

	public CmdPipe createHttpPipe(String protocolID, String portConfig, int acceptedPort) {
		return createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, "HttpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, new int[]{acceptedPort}, 0, new HashMap<Object, Object>(), false);
	}

	public CmdPipe createHttpPipe(String protocolID, String portConfig) {
		return createPipe(TRANSPORT_PROTOCOL.HTTP.getLiteral(), protocolID, "HttpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, null, 0, new HashMap<Object, Object>(), false);
	}

	
	//
	// Unamed Pipes
	//

	public CmdPipe openUsbPipe(String protocolID, String portConfig, int speed, Map<Object, Object> options) {
		return openPipe(TRANSPORT_PROTOCOL.USB.getLiteral(), protocolID, "UsbPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, null, speed, options);
	}

	public CmdPipe openUsbPipe(String protocolID, String portConfig, int speed) {
		return openUsbPipe(protocolID, "UsbPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, speed);
	}

	public CmdPipe openUdpPipe(String protocolID, String portConfig, int acceptedPort) {
		return openUdpPipe(protocolID, "UdpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPort);
	}

	public CmdPipe openUdpPipe(String protocolID, String portConfig, int[] acceptedPorts) {
		return openUdpPipe(protocolID, "UdpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPorts);
	}

	public CmdPipe openTcpPipe(String protocolID, String portConfig, int[] acceptedPorts) {
		return openTcpPipe(protocolID, "TcpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPorts);
	}

	public CmdPipe openTcpPipe(String protocolID, String portConfig, int acceptedPort) {
		return openTcpPipe(protocolID, "TcpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPort);
	}

	public CmdPipe openHttpPipe(String protocolID, String portConfig, int[] acceptedPorts) {
		return openHttpPipe(protocolID, "HttpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPorts);
	}

	public CmdPipe openHttpPipe(String protocolID, String portConfig, int acceptedPort) {
		return openHttpPipe(protocolID, "HttpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, acceptedPort);
	}

	public CmdPipe openBluetoothPipe(String protocolID, String portConfig, int speed) {
		return openBluetoothPipe(protocolID, "BluetoothPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, speed);
	}

	public CmdPipe openBluetoothPipe(String protocolID, String portConfig) {
		return openBluetoothPipe(protocolID, "BluetoothPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig, -1);
	}

	public CmdPipe openUdpPipe(String protocolID, String portConfig) {
		return openUdpPipe(protocolID, "UdpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig);
	}

	public CmdPipe openUdpPipe(String protocolID, int port) {
		return openUdpPipe(protocolID, "UdpPipe_localhost_"+UUID.randomUUID().toString(), "", port);
	}

	public CmdPipe openUdpPipe(String protocolID, int[] ports) {
		return openUdpPipe(protocolID, "UdpPipe_localhost_"+UUID.randomUUID().toString(), "", ports);
	}

	public CmdPipe openTcpPipe(String protocolID, String portConfig) {
		return openTcpPipe(protocolID, "TcpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig);
	}

	public CmdPipe openTcpPipe(String protocolID, int port) {
		return openTcpPipe(protocolID, "UdpPipe_localhost_"+UUID.randomUUID().toString(), "", port);
	}

	public CmdPipe openTcpPipe(String protocolID, int[] ports) {
		return openTcpPipe(protocolID, "UdpPipe_localhost_"+UUID.randomUUID().toString(), "", ports);
	}

	public CmdPipe openHttpPipe(String protocolID, String portConfig) {
		return openHttpPipe(protocolID, "HttpPipe_"+portConfig+"_"+UUID.randomUUID().toString(), portConfig);
	}
	
	public synchronized void terminate() {
		for (CmdPipe p : getPipes()) {
			p.deactivateAll();
			p.finalize();
		}
	}
	
	public synchronized void closeAll() {
		for (CmdPipe p : getPipes()) {
			closePipe(p, true);
		}
	}
	
	public List<CmdPipe> getEnginesByCommunication(String commID) {
		String ID = "";
		for (CommProtocolConfig protocolCfg : Protocol.getCommunictionProtocols()) {
			if (protocolCfg.getAlias().equals(commID)) {
				ID = protocolCfg.getID();
				break;
			}
		}
		List<CmdPipe> lst = new ArrayList<CmdPipe>();
		for (CmdPipe pipe : getPipes()) {
			if (	
				pipe.getCommunicationProtocol() != null && 
				pipe.getCommunicationProtocol().equals(ID)
			) {
				lst.add(pipe);
			}
		}
		return lst;
	}
	
	public List<CmdPipe> getEnginesByTransport(String transportID) {
		List<CmdPipe> lst = new ArrayList<CmdPipe>();
		for (CmdPipe pipe : getPipes()) {
			if (	
				pipe.getTransportProtocol() != null && 
				pipe.getTransportProtocol().equals(transportID)
			) {
				lst.add(pipe);
			}
		}
		return lst;
	}
	
	public List<CmdPipe> getEnginesByTansportAndCommunication(String transportID, String commID) {
		List<CmdPipe> lst = new ArrayList<CmdPipe>();
		for (CmdPipe pipe : getPipes()) {
			if (	
				pipe.getCommunicationProtocol() != null && 
				pipe.getCommunicationProtocol().equals(commID) &&
				pipe.getTransportProtocol() != null && 
				pipe.getTransportProtocol().equals(transportID)
			) {
				lst.add(pipe);
			}
		}
		return lst;
	}

	public CmdPipe getPipe2(String transportID, String protocoleID, String addr, List<Integer> ports, int speed) {
		int[] _ports = new int[ports.size()];
		int idx = 0;
		for(int p : ports) {
			_ports[idx] = p;
			idx++;
		}
		return getPipe(transportID, protocoleID, addr, _ports, speed);
	}

	public CmdPipe getPipe2(String transportID, String address, List<Integer> ports) {
		int[] _ports = new int[ports.size()];
		int idx = 0;
		for(int p : ports) {
			_ports[idx] = p;
			idx++;
		}
		return getPipe(transportID, address, _ports);
	}

	public CmdPipe getPipe2(String transportID, List<Integer> ports) {
		int[] _ports = new int[ports.size()];
		int idx = 0;
		for(int p : ports) {
			_ports[idx] = p;
			idx++;
		}
		return getPipe(transportID, _ports);
	}
	
	public void closePipe(String pipeID, boolean force) {
		CmdPipe pipe = getPipe(pipeID);
		Ports.closePipe(pipe);
		getPipes().remove(notifyPipe(false, pipe));
	}
	
	public void closePipe(String transportID, String portConfig, boolean force) {
		closePipe(force, getPipe(transportID, portConfig, new int[]{}));
	}

	public void closePipe(String transportID, String portConfig, int[] ports, boolean force) {
		closePipe(force, getPipe(transportID, portConfig, ports));
	}
	
	public void closePipe(String transportID, String portConfig, List<Integer> ports, boolean force) {
		closePipe(force, getPipe2(transportID, portConfig, ports));
	}
	
	public void closePipe(boolean force, CmdPipe... pipes) {
		for (CmdPipe pipe : pipes) {
			if (pipe != null) {
				pipe.setLocked(!force);
				Ports.closePipe(notifyPipe(false, pipe));
			}
		}
	}
	
	public void closePipe(CmdPipe pipe, boolean force) {
		if (pipe != null) {
			Ports.closePipe(notifyPipe(false, pipe));
		}
	}
	
	//
	// Helpers
	//

	public List<String> getLiveOutgoingPorts() {
		List<String> outPorts = new ArrayList<String>();
		for (CmdPipe p : getPipes()) {
			if (!p.getTransportProtocol().equals("udp://") || !p.getTransportProtocol().equals("udp://")) {
				continue;
			}
			String addr = p.getAddr();
			if (addr != null && addr.contains(":")) {
				String outPort = addr.substring(addr.indexOf(":")+1);
				outPorts.add(outPort);
			}
		}
		return outPorts;
	}
	
	public CmdPipe openMidiPipe(MidiDevice device) {
		CmdPipe pipe = openPipe(
			TRANSPORT_PROTOCOL.MIDI.getLiteral(), 
			"midi", 
			UUID.randomUUID().toString(), 
			device.getDeviceInfo().getName(), 
			new int[]{}, 
			-1, 
			new HashMap<Object, Object>()
		);
		if (pipe != null) {
			if (pipe.getPort() != null) {
				if (pipe.getPort().getChannel() instanceof MidiTransportCommunicator) {
					MidiTransportCommunicator c = (MidiTransportCommunicator) pipe.getPort().getChannel();
					c.setDevice(device);
					/*
					String name = ""+pipe.getName();
					if (c.isInputOutputDevice()) {
						name += " (IN/OUT)";
					} else if (c.isInputDevice()) {
						name += " (IN/..)";
					} else if (c.isInputDevice()) {
						name += " (../OUT)";
					} else {
						name += " (../..)";
					}
					pipe.setName(name);
					*/
				}
			}
		}
		return pipe;
	}
	
	/**
	 * Build a minimalistic application engine dedicated to a given protocol commands handling
	 * 
	 * @param appID application ID
	 * @param protocolID protocol ID
	 * 
	 * @return newly created {@link EngineApplication} application
	 */
	public EngineApplication buildEngineApp(String appID, String protocolID) {
		Injector injector = Guice.createInjector(new ConfigurationModule());

		EngineApplication app = injector.getInstance(EngineApplication.class);
        
        CommProtocolConfig protocol = Protocol.getCommunicationProtocol(protocolID);
        
        if (protocol != null) {
	        IXCmdInterpreter cmdInterpreter		= protocol.getCmdInterpreter();
	        IXFrameInterpreter frameInterpreter = protocol.getFrameInterpreter();
	        IQxEventHandler eventHandler		= protocol.getEventHandler();
	        
	        CmdPipe cmdEngine = injector.getInstance(CmdPipe.class);
	
	        if (cmdInterpreter != null) {
	        	cmdEngine.setOutputInterpreter(cmdInterpreter);
	        }
	        if (frameInterpreter != null) {
	        	cmdEngine.setInputInterpreter(frameInterpreter);
	        }
	        if (eventHandler != null) {
	        	cmdEngine.addQxEventHandler(eventHandler);
	        }
	        cmdEngine.setCommunicationProtocol(protocolID);
        
	        app.getEngine().add(cmdEngine);
	        
	        app.setId(appID);
	        app.setName("Application Engine " + appID);
        }
        else
        {
        	throw new RuntimeException("protocol " + protocolID + " unknown");
        }
        
        return app;
	}

}