
package ubiquisense.iorx.comm.udp.io;

import ubiquisense.iorx.comm.AbstractInputJob;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.qx.Rx;

public class UdpInputPortJob extends AbstractInputJob {
	private volatile UdpRcvChannel channel;
	private int portID;

	public UdpInputPortJob(int port) {
		super("udp_" + port);
		this.portID = port;
		channel = new UdpRcvChannel(port);
	}

	public int getPortID() {
		return portID;
	}

	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		while (channel.connected()) {
			synchronized (channel) {
				channel.receive(new byte[15360]);
				for (Rx rx : rxList) {
					synchronized (rx.getEngine().getInputInterpreter()) {
						IXFrameInterpreter frameInterpreter = rx.getEngine().getInputInterpreter();
						if (frameInterpreter != null) {
							try {
								rx.postCommand(frameInterpreter.byteArray2Cmd(channel.getData()));
							} catch (Throwable t) {
								t.printStackTrace();
							}
						} else {
							System.err.println("IXFrameInterpreter is null : impossible to process UDP input !!!");
						}
					}
				}
			}
		}
	}

	@Override
	public synchronized void close() {
		channel.close();
	}
}
