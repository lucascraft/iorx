package ubiquisense.iorx.pipe;

import java.util.List;
import java.util.Set;

import ubiquisense.iorx.cmd.CmdEngine;

public interface EngineApplication {
	void setId(String id);
	void setName(String names);
	String getId();
	String getName();
	Set<CmdEngine> getClients();
	List<CmdPipe> getEngine();
}
