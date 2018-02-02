package ubiquisense.iorx.utils;

public interface Job  
{
	int INTERACTIVE = 1;
	int ASYNC_FINISH = 2;
	
	void setSystem(boolean value);
	void setPriority(int value);
	
	void setId(String value);
	String getId();
	
	void cancel();
	void done(int value);
	
	int run();
	int schedule();
	
	void sleep();
}
