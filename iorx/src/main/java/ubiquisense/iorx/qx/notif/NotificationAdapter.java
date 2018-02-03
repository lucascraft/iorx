package ubiquisense.iorx.qx.notif;

import java.util.List;

public interface NotificationAdapter<T> {
	void notifyChanged(Change<T> msg);
	void notifyManyChanged(Change<List<T>> msg);
}
