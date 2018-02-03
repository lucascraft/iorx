package ubiquisense.iorx.qx;

import java.util.List;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;


public interface Qx 
{
	CmdPipe getEngine();
	void eSetDeliver(boolean value);
	List<Cmd> getCommands();
	int getMax();
	long getTtl();
	QxProcessingStrategy getStrategy();
	void setStrategy(QxProcessingStrategy value);
	
	void setMax(int value);
	void setTtl(int value);
	void postCommand(Cmd cmd);
	Cmd consumeCommand();
}
