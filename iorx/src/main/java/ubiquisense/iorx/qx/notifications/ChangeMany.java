package ubiquisense.iorx.qx.notifications;

import java.util.List;

public abstract class ChangeMany <T> extends Change<List<T>> {
	public ChangeMany(Notification n, List<T> values) {
		super(n, values);
	}
}
