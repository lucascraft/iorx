package ubiquisense.iorx.changes;

import java.util.List;

public class RemoveMany<T> extends ChangeMany<T>{
	public RemoveMany(List<T> values) {
		super(Notification.REMOVE_MANY, values);
	}
}