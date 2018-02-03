package ubiquisense.iorx.event;

public interface IQxEventHandler {
	void handleQxEvent(Event event);
	String getID();
}
