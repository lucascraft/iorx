package ubiquisense.iorx.pipe;

import java.util.List;

import ubiquisense.iorx.changes.Add;
import ubiquisense.iorx.changes.Change;
import ubiquisense.iorx.changes.Notification;
import ubiquisense.iorx.changes.NotificationAdapter;
import ubiquisense.iorx.changes.Remove;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.event.EventImpl;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.utils.Platform;

public class QxEventAdapterImpl implements NotificationAdapter<Cmd> 
{
	private boolean activated;

	public QxEventAdapterImpl() {
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
				for (IQxEventHandler h : c.getQx().getEngine().getQxEventHandlers()) {
					if (h != null) {
						if (Platform.inDebugMode()) {
							System.out.println("Qx Handler To Process Event");
						}
						if (Notification.ADD_MANY.equals(msg.getNotification()))
						{
							h.handleQxEvent(new EventImpl(new Add<Cmd>(c)));
						}
						else
						{
							h.handleQxEvent(new EventImpl(new Remove<Cmd>(c) ));
						}
					}
				}
			}
		}
	}
	
	@Override
	public synchronized void notifyChanged(Change<Cmd> change) {
		if (activated) {
			for (IQxEventHandler h : change.getValue().getQx().getEngine().getQxEventHandlers()) {
				if (h != null) {
					if (Platform.inDebugMode()) {
						System.out.println("Qx Handler To Process Event");
					}
					h.handleQxEvent(new EventImpl(change) );
				}
			}
		}
	}
}
