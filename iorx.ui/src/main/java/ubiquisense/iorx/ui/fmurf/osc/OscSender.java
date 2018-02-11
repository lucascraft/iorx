package ubiquisense.iorx.ui.fmurf.osc;

import java.util.UUID;

import com.illposed.osc.OSCMessage;

import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.TRANSPORT_PROTOCOL;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

public class OscSender {
	String outAddr;
	int outOscPort;
	CmdPipe oscPipe;
	public OscSender(String outAddr, int oscOutPort) {
		this.outAddr = outAddr;
		this.outOscPort = oscOutPort;
		
		oscPipe = Ubq.Reactor.createPipe(TRANSPORT_PROTOCOL.UDP.getLiteral(), "osc", "osc@" + UUID.randomUUID().toString(), outAddr+":"+outOscPort, new int[] {}, -1, null, true);
	
	}
	public void sendMessage(OSCMessage msg) {
		oscPipe.send(OscCmdUtils.INSTANCE.createOscCmd(msg));
	}
}
