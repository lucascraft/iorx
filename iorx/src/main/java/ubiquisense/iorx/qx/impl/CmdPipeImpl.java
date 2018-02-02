package ubiquisense.iorx.qx.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.EngineApplication;
import ubiquisense.iorx.qx.Event;
import ubiquisense.iorx.qx.PRIORITY;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;

public class CmdPipeImpl implements CmdPipe
{
	@Inject
	private Tx tx;
	
	@Inject
	private Rx rx;
	
	List<Event> txEvents;
	List<Event> rxEvents;
	
	String id;
	
	String name;
	
	EngineApplication engineApplication;
	
	CmdEngine cmdEngine;
	
	PRIORITY priority;
	
	Port port;
	
	IXFrameInterpreter inputInterpreter;

	IXCmdInterpreter ouutputInterpreter;
	
	public Tx getTx()
	{
		return tx;
	}
	
	public Rx getRx()
	{
		return rx;
	}
	
	@Inject
	public CmdPipeImpl() {
		txEvents = new ArrayList<>();
		rxEvents = new ArrayList<>();
	}
	
	@Override
	public List<Event> getTxEvents() {
		return txEvents;
	}
	
	@Override
	public List<Event> getRxEvents() {
		return rxEvents;
	}

	@Override
	public List<Qx> getQueues() {
		List<Qx> queues = new ArrayList<>();
		queues.add(tx);
		queues.add(rx);
		return queues;
	}

	@Override
	public CmdEngine getClient() {
		return cmdEngine;
	}

	@Override
	public void setClient(CmdEngine value) {
		cmdEngine = value;
	}

	@Override
	public EngineApplication getApplication() {
		return engineApplication;
	}

	@Override
	public void setApplication(EngineApplication value) {
		engineApplication = value;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		id = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public PRIORITY getPriority() {
		return priority;
	}

	@Override
	public void setPriority(PRIORITY value) {
		priority = value;
	}


	@Override
	public Port getPort() {
		return port;
	}

	@Override
	public IXFrameInterpreter getInputInterpreter() {
		return inputInterpreter;
	}

	@Override
	public IXCmdInterpreter getOuutputInterpreter() {
		return ouutputInterpreter;
	}

	@Override
	public void send(Cmd cmd) {
		
	}
}
