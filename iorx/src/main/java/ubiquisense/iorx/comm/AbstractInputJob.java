
package ubiquisense.iorx.comm;

import java.util.concurrent.ConcurrentLinkedQueue;

import ubiquisense.iorx.qx.Rx;


public abstract class AbstractInputJob extends Thread {
	protected volatile ConcurrentLinkedQueue<Rx> rxList;
	public AbstractInputJob(String id) {
		super(id);
		rxList = new ConcurrentLinkedQueue<Rx>();
	}
	public synchronized void addRx(final Rx rx) {
		rxList.add(rx);
	}
	public synchronized void removeRx(final Rx rx) {
		rxList.remove(rx);
	}
	public abstract void close();
}
