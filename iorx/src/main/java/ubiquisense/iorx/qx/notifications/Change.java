package ubiquisense.iorx.qx.notifications;

public abstract class Change <T>{
	Notification notification;
	T value;
	public Change(Notification n, T value) {
		notification = n;
		this.value = value;
	}
	public T getValue()
	{
		return value;
	}
	public Notification getNotification() {
		return notification;
	}
}
