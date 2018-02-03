package ubiquisense.iorx.qx.notifications;

public class Add<T> extends Change<T> {
	public Add(T value) {
		super(Notification.ADD, value);
	}
}
