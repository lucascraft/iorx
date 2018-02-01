package ubiquisense.iorx.qx.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.EngineApplication;

public class CmdEngineImpl implements CmdEngine {
	List<CmdPipe> engines;
	String id;
	String name;
	
	EngineApplication engineApplication;
	
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

	@Override
	public EngineApplication getApplication() {
		return engineApplication;
	}

	@Override
	public void setApplication(EngineApplication value) {
		engineApplication	= value;
	}

}
