package ubiquisense.iorx.qx;

import java.util.List;

import ubiquisense.iorx.io.Port;

public interface Qx 
{
	CmdPipe getEngine();
	
	void eSetDeliver(boolean value);
	
	List<Cmd> getCommands();
	
	int getMax();
	
	long getTtl();
	
	QxProcessingStrategy getStrategy();
	
}
