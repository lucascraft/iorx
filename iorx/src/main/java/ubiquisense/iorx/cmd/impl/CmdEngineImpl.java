package ubiquisense.iorx.cmd.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;

public class CmdEngineImpl implements CmdEngine {
	List<CmdPipe> engines;
	String id;
	String name;
	
	
	Object runner;
	
	@Inject
	public CmdEngineImpl() {
		engines = new ArrayList<>();
	}

	@Override
	public List<CmdPipe> getEngines() {
		return engines;
	}


	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String newId) {
		id = newId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String newName) {
		name = newName;
	}

	@Override
	public Object getRunner() {
		return runner;
	}

	@Override
	public void setRunner(Object newRunner) {
		runner = newRunner;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quicken() {
		// TODO Auto-generated method stub

	}

	@Override
	public void slow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

}
