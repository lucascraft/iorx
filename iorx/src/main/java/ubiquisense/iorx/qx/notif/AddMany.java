package ubiquisense.iorx.qx.notif;

import java.util.List;

public class AddMany<T> extends ChangeMany<T>{
	public AddMany(List<T> values) {
		super(Notification.ADD_MANY, values);
	}
}
