package ubiquisense.iorx.registry;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.bluetooth.L2CAPConnection;
import javax.microedition.io.Connector;

import ubiquisense.iorx.app.EngineApplication;
import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.InputJobImpl;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.comm.bt.BluetoothPortImpl;
import ubiquisense.iorx.comm.bt.io.BTCommunicator;
import ubiquisense.iorx.comm.bt.io.L2CAPInJob;
import ubiquisense.iorx.comm.bt.io.L2CAPInputJob;
import ubiquisense.iorx.comm.bt.io.impl.L2CAPInJobImpl;
import ubiquisense.iorx.comm.http.HttpCommPortImpl;
import ubiquisense.iorx.comm.http.io.BasicHttpCommunicator;
import ubiquisense.iorx.comm.http.io.HttpCommunicator;
import ubiquisense.iorx.comm.midi.UbiPortImpl;
import ubiquisense.iorx.comm.midi.io.MidiCommunicator;
import ubiquisense.iorx.comm.tcp.TcpPortImpl;
import ubiquisense.iorx.comm.tcp.io.TcpChannel;
import ubiquisense.iorx.comm.tcp.io.impl.TcpInputPortJob;
import ubiquisense.iorx.comm.udp.UdpPortImpl;
import ubiquisense.iorx.comm.udp.io.UdpChannel;
import ubiquisense.iorx.comm.udp.io.UdpInputPortJob;
import ubiquisense.iorx.comm.usb.USBPortImpl;
import ubiquisense.iorx.comm.usb.io.ISerialCommunicator;
import ubiquisense.iorx.comm.usb.rxtx.RXTXSerialUtil;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.utils.Platform;

public final class PortsRegistry {

	private Map<Integer, TcpInputPortJob> tcpInputJobs;
	private Map<Integer, UdpInputPortJob> udpInputJobs;
	private Map<String, L2CAPInputJob> l2capInputJobs;

	public PortsRegistry() {
		tcpInputJobs = new HashMap<Integer, TcpInputPortJob>();
		udpInputJobs = new HashMap<Integer, UdpInputPortJob>();
		l2capInputJobs = new HashMap<String, L2CAPInputJob>();
	}

//
//	/**
//	 * Open ports according to a given configuration.
//	 * 
//	 * - USB - TCP - UDP - HTTP - XBee - Bluetooth - Ubiquitous (later ...)
//	 * 
//	 * with respective address:port scheme
//	 * 
//	 * @param bind
//	 *            binding definition according to NetConf DSL
//	 * @param engine
//	 *            {@link CmdPipe} reference
//	 * 
//	 * @return the newly resolved/bind address w/ given protocol
//	 */
//	public Port resolvePort(final NetBind bind, final CmdPipe engine,
//			Map<Object, Object> options, boolean locked) {
//		if (bind == null || engine == null) {
//			return null;
//		}
//		List<Integer> acceptedPortsList = bind.getPort().getPorts();
//		int[] acceptedPorts = acceptedPortsList == null ? null
//				: new int[acceptedPortsList.size()];
//		int idx = 0;
//		for (Integer port : acceptedPortsList) {
//			acceptedPorts[idx] = port;
//			idx++;
//		}
//		return resolvePort(bind.getPort().getKind().getLiteral(), bind
//				.getPort().getPortID(), acceptedPorts, bind.getPort()
//				.getSpeed(), engine, options, locked);
//	}

	/**
	 * Open ports according to a given configuration.
	 * 
	 * - USB - TCP - UDP - HTTP - XBee - Bluetooth - Ubiquitous (later ...)
	 * 
	 * with respective address:port scheme
	 * 
	 * @param kind
	 * @param portID
	 * @param acceptedPorts
	 * @param speed
	 * @param engine
	 *            {@link CmdPipe} reference
	 * 
	 * @return the newly resolved/bind address w/ given protocol
	 */
	public Port resolvePort(String kind, String portID, int[] acceptedPorts,
			int speed, final CmdPipe engine, Map<Object, Object> options,
			boolean locked) {

		switch (TRANSPORT_PROTOCOL.get(kind)) {
		case HTTP:
			if (Platform.inDebugMode()) {
				System.out.println("Connect to HTTP URL : " + portID);
			}
			HttpCommPortImpl httpPort = new HttpCommPortImpl();
			HttpCommunicator c = new BasicHttpCommunicator();
			c.setPortID(portID);
			c.setAcceptedPorts(acceptedPorts);
			httpPort.setChannel(c);
			httpPort.setEngine(engine);
			return httpPort;
		case BLUETOOTH:
			if (Platform.inDebugMode()) {
				System.out.println("Connect to  BT Device w/ L2CAP " + portID);
			}
			BluetoothPortImpl btPort = new BluetoothPortImpl();
			String addrOut = "btl2cap://" + portID
					+ ":11;authenticate=false;encrypt=false;master=false";
			String addrIn = "btl2cap://" + portID
					+ ":13;authenticate=false;encrypt=false;master=false";
			try {
				L2CAPConnection outgoing = (L2CAPConnection) Connector.open(
						addrOut, Connector.WRITE, true);
				L2CAPConnection incoming = (L2CAPConnection) Connector.open(
						addrIn, Connector.READ, true);
				L2CAPInJob in = new L2CAPInJobImpl();
				if (!l2capInputJobs.containsKey(portID)) {
					L2CAPInputJob btInputJob = new L2CAPInputJob(engine,
							incoming, portID);
					l2capInputJobs.put(portID, btInputJob);
					in.setJob(btInputJob);
					btInputJob.start();
				} else {
					in.setJob(l2capInputJobs.get(portID));
				}
				in.setId("BT_L2CAP_input_" + portID);
				btPort.getInputJobs().add(in);
				BTCommunicator btComm = new BTCommunicator();
				btComm.setIncoming(incoming);
				btComm.setOutgoing(outgoing);
				btPort.setChannel(btComm);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (InterruptedException ite) {
				ite.printStackTrace();
			}
			btPort.setEngine(engine);
			return btPort;
		case MIDI:
			UbiPortImpl ubiPort = new UbiPortImpl();
			MidiCommunicator midiComm = new MidiCommunicator();
			midiComm.setEngine(engine); 
			ubiPort.setChannel(midiComm);
			ubiPort.setEngine(engine);
			return ubiPort;
//		case XBEE:
//			XBeeCommunicator comm = new XBeeCommunicator(engine, portID, speed);
//			XbeePort xbeePort = (XbeePort) EcoreUtil
//					.create(XbeecommPackage.Literals.XBEE_PORT);
//			xbeePort.setChannel(comm);
//			xbeePort.setEngine(engine);
//			return xbeePort;
		case USB:
			if (RXTXSerialUtil.INSTANCE.isAlreadyOpen(portID)) {
				return null;
			}
			USBPortImpl usbPort =new USBPortImpl();
			if (speed > 0) {
				ISerialCommunicator serialCommunicator = RXTXSerialUtil.INSTANCE
						.openPort(usbPort, portID, speed, options);
				if (serialCommunicator == null
						|| serialCommunicator.getSerialPort() == null) {
					return null;
				}
				usbPort.setEngine(engine);
				usbPort.setChannel(serialCommunicator);
				return usbPort;
			}
			return null;
		case TCP:
			TcpPortImpl ipPort = new TcpPortImpl();
			String[] parts = portID.split(":");
			String tag = parts == null ? "_incoming_" : "_" + parts[0] + "_";
			if (acceptedPorts != null) {
				for (int inPort : acceptedPorts) {
					if (!tcpInputJobs.containsKey(inPort)) {
						TcpInputPortJob tcpInputPortJob = new TcpInputPortJob(
								inPort);
						tcpInputPortJob.start();
						tcpInputJobs.put(inPort, tcpInputPortJob);
					}
					tcpInputJobs.get(inPort).addRx(engine.getRx());

					InputJob inputJob = new InputJobImpl();
					inputJob.setId("TCP" + tag + inPort);
					inputJob.setJob(tcpInputJobs.get(inPort));

					ipPort.getInputJobs().add(inputJob);
					if (Platform.inDebugMode()) {
						System.out.println("Listen to " + inPort + " port");
					}
				}
			}
			if (parts != null && parts.length > 0 && !parts[0].equals("")) {
				InetAddress address = null;
				try {
					address = InetAddress.getByName(parts[0]);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				int port = Integer.valueOf(parts[1]);
				Channel channel = new TcpChannel(address, port);
				ipPort.setChannel(channel);
				channel.debug();
			}
			ipPort.setEngine(engine);
			return ipPort;
		case UDP:
			UdpPortImpl udpPort = new UdpPortImpl();
			String[] parts2 = portID.split(":");
			String tag2 = parts2 == null ? "_incoming_" : "_" + parts2[0] + "_";
			if (acceptedPorts != null) {
				for (int inPort : acceptedPorts) {
					if (!udpInputJobs.containsKey(inPort)) {
						UdpInputPortJob udpInputPortJob = new UdpInputPortJob(inPort);
						udpInputPortJob.start();
						udpInputJobs.put(inPort, udpInputPortJob);
					}
					udpInputJobs.get(inPort).addRx(engine.getRx());

					InputJob inputJob = new InputJobImpl();
					inputJob.setId("UDP" + tag2 + inPort);
					inputJob.setJob(udpInputJobs.get(inPort));

					udpPort.getInputJobs().add(inputJob);
					if (Platform.inDebugMode()) {
						System.out.println("Listen to " + inPort + " port");
					}
				}
			}
			if (!portID.contains(":") && acceptedPorts.length > 0) {
				udpPort.setChannel(new UdpChannel(parts2[0], Integer
						.valueOf(acceptedPorts[0])));
			} else if (parts2 != null && parts2.length > 1
					&& !parts2[0].equals("")) {
				udpPort.setChannel(new UdpChannel(parts2[0], Integer
						.valueOf(parts2[1])));
			}
			if (udpPort.getChannel() != null) {
				udpPort.getChannel().debug();
			}
			udpPort.setEngine(engine);
			return udpPort;
		default: {
			throw new UnsupportedOperationException(
				"Transport Protocol should be one of : [UDP, TCP, HTTP, XBEE, USB, BLUETOOTH, MIDI] !");
			}
		}
	}
	
	public CmdEngine getCmdEngineByIDFromApp(EngineApplication app, String clientID)
	{
		for (CmdEngine e : app.getClients())
		{
			if (e.getId().equals(clientID))
			{
				return e;
			}
		}
		return null;
	}

	public synchronized void closePipe(CmdPipe... pipes) {
		for (CmdPipe pipe : pipes) {
			if (!pipe.isLocked()) {
				try {
					Port port = pipe.getPort();
					if (port != null) {
						if (pipe.getTransportProtocol().equals(
								TRANSPORT_PROTOCOL.UDP.getLiteral())) { // UDP
							for (InputJob jUdp : port.getInputJobs()) {
								udpInputJobs.remove(((UdpInputPortJob) jUdp
										.getJob()).getPortID());
							}
						} else if (pipe.getTransportProtocol().equals(
								TRANSPORT_PROTOCOL.TCP.getLiteral())) { // TCP
							for (InputJob jTcp : port.getInputJobs()) {
								tcpInputJobs.remove(((TcpInputPortJob) jTcp
										.getJob()).getPortID());
							}
						} else if (pipe.getTransportProtocol().equals(
								TRANSPORT_PROTOCOL.BLUETOOTH.getLiteral())) { // Bluetooth
							for (final InputJob jL2Cap : port.getInputJobs()) {
								if (jL2Cap != null
										&& (jL2Cap.getJob() instanceof L2CAPInputJob)) {
									L2CAPInputJob btInputJob = (L2CAPInputJob) jL2Cap
											.getJob();
									l2capInputJobs.remove(btInputJob
											.getPortId());
									jL2Cap.close();
								}
							}
						} else if (pipe.getTransportProtocol().equals(
								TRANSPORT_PROTOCOL.HTTP.getLiteral())) { // HTTP
							// NONE
						} else if (pipe.getTransportProtocol().equals(
								TRANSPORT_PROTOCOL.XBEE.getLiteral())) { // USB
																			// over
																			// Serial
							// NONE
						} else if (pipe.getTransportProtocol().equals(
								TRANSPORT_PROTOCOL.USB.getLiteral())) {
							RXTXSerialUtil.INSTANCE.closePort(pipe.getAddr());
						}
					}
					port.finalize();

				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}

//	/*
//	 * build a map from netconf resource and its associated orchestrors
//	 */
//	private Map<NetCfg, List<Orchestror>> buildNetCfg(NetCfg cfg, boolean locked) {
//		Map<NetCfg, List<Orchestror>> cfgOrchestrorsMap = new HashMap<NetCfg, List<Orchestror>>();
//		List<Orchestror> orchestrors = new ArrayList<Orchestror>();
//		for (NetOrchestrorScope scope : cfg.getOrchestrorScopes()) {
//			Orchestror orchestror = OrchestrorUtil.INSTANCE
//					.buildOrchestror(scope.getDslOrchestror());
//			for (NetBind b : scope.getBinds()) {
//				CmdPipe engine = getCmdEngineByCmdID(orchestror
//						.getApplication().getEngine(), b.getEngine().getName());
//				if (engine != null) {
//					if (Platform.isRunning()) {
//						IXCmdInterpreter interpreter = resolveCmdInterpreterInOSGiContext(b
//								.getInterpreter());
//						engine.setOutputInterpreter(interpreter);
//					} else {
//						engine.setOutputInterpreter(new NullXCmdInterpreter());
//					}
//					if (Platform.isRunning()) {
//						IXFrameInterpreter decoder = resolveFrameInterpreterInOSGiContext(b
//								.getDecoder());
//						engine.setInputInterpreter(decoder);
//					} else {
//						engine.setInputInterpreter(new NullXFrameInterpreter());
//					}
//					Port port = resolvePort(b, engine,
//							new HashMap<Object, Object>(), locked);
//					if (port != null) {
//						engine.setPort(port);
//						port.setEngine(engine);
//					}
//					for (NetListener l : b.getListeners()) {
//						IQxEventHandler eventHandler = null;
//
//						if (Platform.isRunning()) {
//							eventHandler = resolveListenerInOSGiContext(l);
//						} else {
//							eventHandler = resolveListenerInRuntimeContext(l);
//						}
//						if (engine instanceof CmdPipe) {
//							for (Adapter adapter : ((CmdPipe) engine)
//									.eAdapters()) {
//								if (adapter instanceof QxEventAdapterImpl) {
//									if (!((QxEventAdapterImpl) adapter)
//											.getEvtHandlers().contains(
//													eventHandler)) {
//										((QxEventAdapterImpl) adapter)
//												.getEvtHandlers().add(
//														eventHandler);
//									}
//								}
//							}
//						}
//					}
//				}
//				orchestrors.add(orchestror);
//			}
//		}
//		cfgOrchestrorsMap.put(cfg, orchestrors);
//		netCfgRegistry.put(cfg, orchestrors);
//
//		//
//		//
//		//
//		for (Orchestror orchestror : orchestrors) {
//			if (!OrchestrorUtil.INSTANCE.getOrchestrorRegistry().contains(
//					orchestror)) {
//				OrchestrorUtil.INSTANCE.getOrchestrorRegistry().add(orchestror);
//			}
//		}
//
//		return cfgOrchestrorsMap;
//	}

}
