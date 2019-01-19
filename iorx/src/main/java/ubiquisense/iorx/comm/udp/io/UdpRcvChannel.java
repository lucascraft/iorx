

package ubiquisense.iorx.comm.udp.io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import ubiquisense.iorx.io.impl.TransportChannelImpl;

public class UdpRcvChannel extends TransportChannelImpl {
	private volatile DatagramSocket socket;
	private byte[] data;
	public byte[] getData() {
		return data;
	}
	public UdpRcvChannel() {
	}
	public UdpRcvChannel(int port) {
		try {
			socket = new DatagramSocket(port);
			if (socket != null) {
				socket.setReuseAddress(true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void receive(byte[]  bytes) {
		data = new byte[0];
		if (bytes != null && bytes.length > 0) {
			int packetLength = bytes.length;
					
			DatagramPacket packet = new DatagramPacket(bytes, packetLength);
			
			try {
				packet.setLength(packetLength);
				if (socket != null) {
					if (!socket.isClosed() && socket.isBound()) {
						socket.receive(packet);
						data = packet.getData();
					}
				}
			} catch (java.net.SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	@Override
	public boolean connected() {
		return socket != null && !socket.isClosed();
	}
	@Override
	public void close() {
		if (connected()) socket.close();
	}
}
