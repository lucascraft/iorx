
package ubiquisense.iorx.comm.tcp.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import ubiquisense.iorx.comm.AbstractInputJob;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.utils.Platform;

/**
 * Handling TCP inputs
 * 
 * @author lucas
 *
 */
public class TcpInputPortJob extends AbstractInputJob {
	private ServerSocket serverSocket;
	private BufferedReader reader;
	private InputStream in;
	private Socket socket;
	private int portID;
	public TcpInputPortJob(int port) {
		super("tcp_" + port);
		this.portID = port;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(5000);
			socket = serverSocket.accept();
			in = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
		} catch (SocketTimeoutException e) {
			System.err.println("Server socket timemout on port " + port + " : please, initialize a connection to remove this message");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getPortID() {
		return portID;
	}
	@Override
	public void run() {
		try {
			if (socket==null || !socket.isConnected()) {
				socket = serverSocket.accept();
				in = socket.getInputStream();
				reader = new BufferedReader(new InputStreamReader(in));
			}
			while (in.available()>0) {
				String line = reader.readLine();
				if (Platform.inDebugMode()) {
					System.out.println("TCP input from " + portID + " : " + line);
				}
				for (Rx rx : rxList) {
					synchronized (rx.getEngine().getInputInterpreter()) {
						IXFrameInterpreter frameInterpreter = rx.getEngine().getInputInterpreter();
						if (frameInterpreter != null) {
							rx.postCommand(
								frameInterpreter.byteArray2Cmd(line.getBytes())
							);
						} else {
							System.err.println("IXFrameInterpreter is null : impossible to process TCP input !!!");
						}
					}
				}
			}
		} catch (SocketTimeoutException e) {
			System.err.println("Server socket timemout on port " + portID + " : please, initialize a connection to remove this message");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!serverSocket.isClosed()) {
			start();
		}
	}
	@Override
	public synchronized void close() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
