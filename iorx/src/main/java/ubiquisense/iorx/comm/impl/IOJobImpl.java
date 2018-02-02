package ubiquisense.iorx.comm.impl;

import ubiquisense.iorx.comm.IOJob;

public class IOJobImpl implements IOJob {

	String id;
	Object job;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		id = value;
	}

	@Override
	public Object getJob() {
		return job;
	}

	@Override
	public void setJob(Object value) {
		job = value;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
