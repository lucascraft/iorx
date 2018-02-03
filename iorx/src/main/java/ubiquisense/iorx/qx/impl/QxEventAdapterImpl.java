package ubiquisense.iorx.qx.impl;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.evt.IQxEventHandler;
import ubiquisense.iorx.qx.notif.Add;
import ubiquisense.iorx.qx.notif.Change;
import ubiquisense.iorx.qx.notif.Notification;
import ubiquisense.iorx.qx.notif.NotificationAdapter;
import ubiquisense.iorx.qx.notif.Remove;
import ubiquisense.iorx.utils.Platform;

public class QxEventAdapterImpl implements NotificationAdapter<Cmd> 
{
	private boolean activated;
	private QxMonitorJob job;
	private ConcurrentLinkedQueue<IQxEventHandler> evtHandlers;

	public QxEventAdapterImpl(QxMonitorJob j) {
		job = j;
		evtHandlers = new ConcurrentLinkedQueue<IQxEventHandler>();
		activated = true;
	}

	public synchronized boolean toggle() {
		return activated = activated ? false : true;
	}

	public synchronized boolean isActivated() {
		return activated;
	}

	public synchronized void activate() {
		activated = true;
	}

	public synchronized void deactivate() {
		activated = false;
	}

	@Override
	public void notifyManyChanged(Change<List<Cmd>> msg) {
		if (activated) {
			for (Cmd c : msg.getValue()) {
				for (IQxEventHandler h : evtHandlers) {
					if (h != null) {
						if (Platform.inDebugMode()) {
							System.out.println("Tx Handler To Process Event");
						}
						if (Notification.ADD_MANY.equals( msg.getNotification()))
						{
							h.handleQxEvent(new EventImpl(new Add<Cmd>(c) ));
						}
						else
						{
							h.handleQxEvent(new EventImpl(new Remove<Cmd>(c) ));
						}
					}
				}
				
//				job.start();
				for (IQxEventHandler h : evtHandlers) {
					if (h != null) {
						if (Platform.inDebugMode()) {
							System.out.println("Rx Handler To Process Event");
						}
						if (Notification.ADD_MANY.equals( msg.getNotification()))
						{
							h.handleQxEvent(new EventImpl(new Add<Cmd>(c) ));
						}
						else
						{
							h.handleQxEvent(new EventImpl(new Remove<Cmd>(c) ));
						}
					}
				}
//				job.start();
			}
		}
		
	}
	@Override
	public synchronized void notifyChanged(Change<Cmd> change) {
		if (activated) {
			for (IQxEventHandler h : evtHandlers) {
				if (h != null) {
					if (Platform.inDebugMode()) {
						System.out.println("Tx Handler To Process Event");
					}
					h.handleQxEvent(new EventImpl(change) );
				}
			}
//			job.start();
			for (IQxEventHandler h : evtHandlers) {
				if (h != null) {
					if (Platform.inDebugMode()) {
						System.out.println("Rx Handler To Process Event");
					}
					h.handleQxEvent(new EventImpl(change));
				}
			}
//			job.start();
		}
	}

	public synchronized ConcurrentLinkedQueue<IQxEventHandler> getEvtHandlers() {
		return evtHandlers;
	}
}
