package ubiquisense.iorx.io.impl;

import java.util.HashSet;
import java.util.Set;

import com.google.inject.Inject;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.comm.InputJob;
import ubiquisense.iorx.comm.OutputJob;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.io.Port;

public class PortImpl implements Port {
	@Inject
	TransportChannel channel;
	
	CmdPipe engine;
	
	Set<InputJob> inputJobs;
	Set<OutputJob> outputJobs;
	
	@Inject
	public PortImpl() {
		inputJobs = new HashSet<>();
		outputJobs = new HashSet<>();
	}
	
	public TransportChannel getChannel()
	{
		return channel;
	}
	
	@Override
	public void setChannel(TransportChannel channel) {
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
