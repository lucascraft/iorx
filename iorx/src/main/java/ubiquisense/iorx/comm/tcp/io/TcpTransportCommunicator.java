
package ubiquisense.iorx.comm.tcp.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.inject.Named;

import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.io.impl.TransportChannelImpl;
import ubiquisense.iorx.utils.Platform;

@TransportProtocol(type = "tcp://")
@Named("tcp://")
public class TcpTransportCommunicator extends TransportChannelImpl {
	public TcpTransportCommunicator() {
	}
	
	private Socket socket;
	public TcpTransportCommunicator(InetAddress addr, int port) {
		try {
			socket = new Socket(addr, port);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	public void debug() {
		if (Platform.inDebugMode()) {
			if (socket != null && socket.getInetAddress() != null) {
				System.out.println("Connected to [" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "]");
			}
		}	
	}
	@Override
	public void send(byte[] bytes) {
		try {
			socket.getOutputStream().write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
