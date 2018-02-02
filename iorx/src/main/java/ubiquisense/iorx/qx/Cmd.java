package ubiquisense.iorx.qx;

public interface Cmd {
	void setStamp(long time);
	long getStamp();
	PRIORITY getPriority();
	void setPriority(PRIORITY value);
}
