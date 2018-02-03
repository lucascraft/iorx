package ubiquisense.iorx.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.inject.Inject;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;

public class EngineApplicationImpl implements EngineApplication {
	List<CmdPipe> engines;
	Set<CmdEngine> clients;
	
	String id;
	String name;
	
	
	@Inject
	public EngineApplicationImpl() {
		engines = new ArrayList<>();
		clients = new HashSet<>();
	}
	
	public List<CmdPipe> getEngine()
	{
		return engines;
	}
	
	public Set<CmdEngine> getClients()
	{
		return clients;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setName(String names) {
		this.name = names;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

}
