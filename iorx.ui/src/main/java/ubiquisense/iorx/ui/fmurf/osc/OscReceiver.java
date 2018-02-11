package ubiquisense.iorx.ui.fmurf.osc;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.illposed.osc.OSCMessage;

public class OscReceiver {
	private ConcurrentLinkedQueue<OSCMessage> messages;
	public OscReceiver(int rcvPort) {
		messages = new ConcurrentLinkedQueue<OSCMessage>();
	}
	
	public synchronized boolean hasWaitingMessages()
	{
		return !messages.isEmpty();
	}
	
	public synchronized OSCMessage getNextMessage()
	{
		return messages.poll();
	}
}
