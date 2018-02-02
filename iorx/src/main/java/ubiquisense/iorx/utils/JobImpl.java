package ubiquisense.iorx.utils;

public class JobImpl implements Job {

	String id;
	boolean system;
	int priority;
	
	public JobImpl(String id) {
		setId(id);
	}
	
	@Override
	public void setSystem(boolean value) {
		system = value;
	}

	@Override
	public void setPriority(int value) {
		priority = value;
	}

	@Override
	public void setId(String value) {
		id = value;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void cancel() {
		
	}

	@Override
	public void done(int value) {
		
	}
	@Override
	public int run() {
		return 0;
	}
	@Override
	public int schedule() {
		return 0;
	}

	@Override
	public void sleep() {
		
	}

}
