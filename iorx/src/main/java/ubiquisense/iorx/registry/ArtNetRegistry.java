package ubiquisense.iorx.registry;

import java.net.SocketException;

import artnet4j.iorx.ArtNet;
import artnet4j.iorx.ArtNetException;
import artnet4j.iorx.ArtNetNode;
import artnet4j.iorx.packets.ArtDmxPacket;
import ubiquisense.iorx.discovery.TopologyManager;

public class ArtNetRegistry {

	public final static ArtNetRegistry INSTANCE = new ArtNetRegistry();
	
	private int sequenceID;

	private ArtNetNode netLynx;

	public ArtNetRegistry() {
		init();
	}

	private void init() {
		ArtNet artnet = new ArtNet();
		try {
			artnet.start();
			artnet.getNodeDiscovery().addListener(TopologyManager.INSTANCE);
			artnet.startNodeDiscovery();
			while (true) {
				if (netLynx != null) {
					ArtDmxPacket dmx = new ArtDmxPacket();
					dmx.setUniverse(netLynx.getSubNet(), netLynx.getDmxOuts()[0]);
					dmx.setSequenceID(sequenceID % 255);
					byte[] buffer = new byte[510];
					for (int i = 0; i < buffer.length; i++) {
						buffer[i] = (byte) (Math.sin(sequenceID * 0.05 + i * 0.8) * 127 + 128);
					}
					dmx.setDMX(buffer, buffer.length);
					artnet.unicastPacket(dmx, netLynx.getIPAddress());
					dmx.setUniverse(netLynx.getSubNet(), netLynx.getDmxOuts()[1]);
					artnet.unicastPacket(dmx, netLynx.getIPAddress());
					sequenceID++;
				}
				Thread.sleep(30);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (ArtNetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
