package ubiquisense.iorx.ui.fmurf.osc;

import com.illposed.osc.OSCMessage;

public class OscSender {
	String outAddr;
	int outOscPort;
	public OscSender(String outAddr, int oscOutPort) {
		this.outAddr = outAddr;
		this.outOscPort = oscOutPort;
		
		
	}
	public void sendMessage(OSCMessage msg) {
		System.out.println("implememnt this please");
	}
}
