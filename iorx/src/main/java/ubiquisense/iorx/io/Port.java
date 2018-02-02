package ubiquisense.iorx.io;

import java.util.Set;

import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.OutputJob;
import ubiquisense.iorx.qx.CmdPipe;

public interface Port 
{
	Channel getChannel();
	void setChannel(Channel channel);
	Set<InputJob> getInputJobs();
	Set<OutputJob> getOutputJobs();
	void finalize();
	CmdPipe getEngine();
	void setEngine(CmdPipe engine);
}
