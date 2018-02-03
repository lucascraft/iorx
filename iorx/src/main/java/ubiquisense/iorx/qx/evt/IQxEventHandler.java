package ubiquisense.iorx.qx.evt;

public interface IQxEventHandler {
	void handleQxEvent(Event...events);
	String getId();
}
