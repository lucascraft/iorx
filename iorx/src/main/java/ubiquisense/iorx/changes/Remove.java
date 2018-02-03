package ubiquisense.iorx.changes;

public class Remove<T> extends Change<T> {
	public Remove(T value) {
		super(Notification.REMOVE, value);
	}
}
