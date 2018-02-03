package ubiquisense.iorx.registry;

import java.util.ArrayList;
import java.util.List;

public class OrchestrorUtil 
{
	public final static OrchestrorUtil INSTANCE = new OrchestrorUtil();
	
	List<Orchestror> orchestrors;
	
	public OrchestrorUtil() {
		orchestrors = new ArrayList<>();
	}
	
	public List<Orchestror> getOrchestrorRegistry()
	{
		return orchestrors;
	}
}
