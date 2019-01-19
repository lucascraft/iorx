
package ubiquisense.iorx.comm.udp.io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Named;

import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.io.impl.TransportChannelImpl;
import ubiquisense.iorx.utils.Platform;

@TransportProtocol(type = "udp://")
@Named("udp://")
public class UdpTransportCommunicator extends TransportChannelImpl {
	public UdpTransportCommunicator() {
	}
	
	private volatile DatagramSocket socket;
	public UdpTransportCommunicator(String addr, int port) {
		try {
		    socket = new DatagramSocket();
		    socket.connect(InetAddress.getByName(addr), port);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	@Override
	public void receive(byte[]  bytes) {
		if (bytes != null && bytes.length > 0) {
			int packetLength = bytes.length;
			DatagramPacket packet = new DatagramPacket(bytes, packetLength);
			try {
				packet.setLength(packetLength);
				if (socket != null ) {
					if (!socket.isClosed() && socket.isBound()) {
						socket.receive(packet);
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
	public void send(byte[] bytes) {
		if (socket.isBound() && socket.isConnected()) {
			try {
				DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
				socket.send(packet);
			} catch (IOException e) {
				//e.printStackTrace();
			} catch (NullPointerException ee) {
				ee.printStackTrace();
			}
		}
	}
	@Override
	public void debug() {
		if (Platform.inDebugMode()) {
			if (socket != null && socket.getInetAddress() != null) {
				System.out.println("Connected to [" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "]");
			}
		}	
	}
	@Override
	public boolean connected() {
		return socket != null && !socket.isClosed();
	}
	public DatagramSocket getSocket() {
		return socket;
	}
}
