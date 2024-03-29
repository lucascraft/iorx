package ubiquisense.iorx.io;

import java.util.Set;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.OutputJob;

public interface Port 
{
	TransportChannel getChannel();
	void setChannel(TransportChannel channel);
	Set<InputJob> getInputJobs();
	Set<OutputJob> getOutputJobs();
	void finalize();
	CmdPipe getEngine();
	void setEngine(CmdPipe engine);
}
