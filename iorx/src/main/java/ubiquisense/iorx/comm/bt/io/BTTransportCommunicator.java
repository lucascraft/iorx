

package ubiquisense.iorx.comm.bt.io;

import java.io.IOException;

import javax.bluetooth.L2CAPConnection;
import javax.inject.Named;

import ubiquisense.iorx.annotations.TransportProtocol;
import ubiquisense.iorx.io.impl.TransportChannelImpl;

@TransportProtocol(type = "bt://")
@Named("bt://")
public class BTTransportCommunicator extends TransportChannelImpl{
	public BTTransportCommunicator() {
	}
	private L2CAPConnection connIN, connOUT;
	
	public void setIncoming(L2CAPConnection incoming) {
		connIN	= incoming;
	}
	public void setOutgoing(L2CAPConnection outgoing) {
		connOUT	= outgoing;
	}
	
	public void send(byte[] frame) {
		try {
			connOUT.send(frame);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connIN.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			connOUT.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void receive(byte[] bytes) {
		bytes = receive2();
	}
	
	public byte[] receive2() {
		try {
			byte[] buffer = new byte[connIN.getReceiveMTU()];
			connIN.receive(buffer);
			return buffer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
}
