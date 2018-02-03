package ubiquisense.iorx.io.impl;

import java.util.HashSet;
import java.util.Set;

import com.google.inject.Inject;

import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.OutputJob;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.pipe.CmdPipe;

public class PortImpl implements Port {
	@Inject
	Channel channel;
	
	CmdPipe engine;
	
	Set<InputJob> inputJobs;
	Set<OutputJob> outputJobs;
	
	@Inject
	public PortImpl() {
		inputJobs = new HashSet<>();
		outputJobs = new HashSet<>();
	}
	
	public Channel getChannel()
	{
		return channel;
	}
	
	@Override
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void finalize()  {
		channel.close();
	}
	@Override
	public Set<InputJob> getInputJobs() {
		return inputJobs;
	}
	@Override
	public Set<OutputJob> getOutputJobs() {
		return outputJobs;
	}

	@Override
	public CmdPipe getEngine() {
		return engine;
	}

	@Override
	public void setEngine(CmdPipe engine) {
		this.engine = engine;
	}
}
