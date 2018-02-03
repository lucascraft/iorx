package ubiquisense.iorx.qx.notif;

public class Add<T> extends Change<T> {
	public Add(T value) {
		super(Notification.ADD, value);
	}
}
