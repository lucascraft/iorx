package ubiquisense.iorx.app;

import java.util.List;

import ubiquisense.iorx.cmd.CmdPipe;

public interface IConnectedUnit 
{
	List<CmdPipe> getEngines();

	
	CmdPipe getDefault();

	
	void setDefault(CmdPipe value);

} // IConnectedUnit
