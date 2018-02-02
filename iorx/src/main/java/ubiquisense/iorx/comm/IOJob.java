package ubiquisense.iorx.comm;

public interface IOJob  {
	String getId();
	void setId(String value);
	Object getJob();
	void setJob(Object value);
	void close();
	void start();
	void stop();
}
