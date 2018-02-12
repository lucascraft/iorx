package ubiquisense.iorx.ui.fmurf.osc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.illposed.osc.OSCMessage;

public class OscSender {
	String outAddr;
	int outOscPort;
	DatagramSocket socket;
	public OscSender(String outAddr, int oscOutPort) {
		this.outAddr = outAddr;
		this.outOscPort = oscOutPort;
	    try {
	    	socket= new DatagramSocket();
			socket.connect(InetAddress.getByName(outAddr), oscOutPort);
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace();
		}
	}
	public void sendMessage(OSCMessage msg) {
		if (socket.isBound() && socket.isConnected()) {
			try {
				DatagramPacket packet = new DatagramPacket(msg.getByteArray(), msg.getByteArray().length);
				socket.send(packet);
			} catch (IOException e) {
				//e.printStackTrace();
			} catch (NullPointerException ee) {
				ee.printStackTrace();
			}
		}

	}
}
