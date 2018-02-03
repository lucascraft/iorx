package ubiquisense.iorx.app;

import java.util.List;
import java.util.Set;

import ubiquisense.iorx.cmd.CmdEngine;
import ubiquisense.iorx.cmd.CmdPipe;

public interface EngineApplication {
	void setId(String id);
	void setName(String names);
	String getId();
	String getName();
	Set<CmdEngine> getClients();
	List<CmdPipe> getEngine();
}
