package ubiquisense.iorx.qx;

import java.util.List;
import java.util.Set;

public interface EngineApplication {
	void setId(String id);
	void setName(String names);
	String getId();
	String getName();
	Set<CmdEngine> getClients();
	List<CmdPipe> getEngine();
}
