
package ubiquisense.iorx.comm.bt.io;

import java.io.IOException;

import javax.bluetooth.L2CAPConnection;

import ubiquisense.iorx.qx.CmdPipe;


public class L2CAPInputJob extends Thread {
	private L2CAPConnection incoming;
	private CmdPipe btPipe;
	private String portId;
	
	public L2CAPInputJob(ubiquisense.iorx.qx.CmdPipe pipe, L2CAPConnection connection, String btAddr) throws IOException, InterruptedException {
		super("bt input " + btAddr);
		incoming	= connection;
		btPipe		= pipe;
		portId = btAddr;
	}
	
	public String getPortId() {
		return portId;
	}

	@Override
	public void run() {
		try {
			if (incoming != null) {
				byte[] buf = new byte[incoming.getReceiveMTU()];
				if (buf !=null && buf.length>0) {
					incoming.receive(buf);		// L2CAP chunk receive
					if (btPipe != null) {
						btPipe.receive(buf);	// UBQT processing for the newly received frame
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			stop();
		}
		start();
	}

}
