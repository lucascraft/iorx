package ubiquisense.iorx.qx.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.inject.Inject;

import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdEngine;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.EngineApplication;
import ubiquisense.iorx.qx.PRIORITY;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.QxProcessingStrategy;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;
import ubiquisense.iorx.qx.evt.Event;
import ubiquisense.iorx.qx.evt.IQxEventHandler;
import ubiquisense.iorx.qx.notif.NotificationAdapter;
import ubiquisense.iorx.utils.EngineUtil;

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
	QxProcessingStrategy strategy;
	
	Port port;
	
	IXFrameInterpreter inputInterpreter;
	IXCmdInterpreter ouutputInterpreter;
	Set<IQxEventHandler> qxEventHandlers;
	
	Set<NotificationAdapter<Cmd>> adapters;
	
	String transportProtocol;
	String communicationProtocol;
	
	boolean locked;
	String address;
	int speed;
	
	boolean activated;
	
	Set<Integer> ports;
	
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
		ports = new HashSet<>();
		qxEventHandlers = new HashSet<>();
		adapters = new HashSet<>();
		activated = true;
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
	public IXCmdInterpreter getOutputInterpreter() {
		return ouutputInterpreter;
	}

	@Override
	public void send(Cmd cmd) {
		EngineUtil.INSTANCE.sendCmd(tx, cmd);
	}
	
	@Override
	public boolean isActivated()
	{
		return activated;
	}

	@Override
	public void receive(byte[] frame)
	{
		EngineUtil.INSTANCE.sendCmd(rx, getInputInterpreter().byteArray2Cmd(frame));
	}

	@Override
	public Set<Integer> getPorts() {
		return null;
	}

	@Override
	public String getTransportProtocol() {
		return transportProtocol;
	}

	@Override
	public String getCommunicationProtocol() {
		return communicationProtocol;
	}

	@Override
	public void setTransportProtocol(String value) {
		transportProtocol = value;
	}

	@Override
	public void setCommunicationProtocol(String value) {
		communicationProtocol = value;
	}
	
	@Override
	public boolean isLocked() {
		return locked;
	}
	
	@Override
	public void setLocked(boolean value) {
		locked = value;
	}
	
	@Override
	public String getAddr() {
		return address;
	}
	
	@Override
	public void setAddr(String addr) {
		address = addr;
	}

	@Override
	public void deactivateAll() {
		for(CmdPipe e : cmdEngine.getEngines())
		{
			e.deactivateAll();
		}
	}
	
	public void finalize()  {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public void setPort(Port value) {
		port = value;
	}

	@Override
	public void setOutputInterpreter(IXCmdInterpreter interpreter) {
		ouutputInterpreter = interpreter;		
	}

	@Override
	public void setInputInterpreter(IXFrameInterpreter interpreter) {
		inputInterpreter = interpreter;		
	}

	@Override
	public void removeQxEventHandler(IQxEventHandler evtHandler) {
		qxEventHandlers.remove(evtHandler);
	}

	@Override
	public void addQxEventHandler(IQxEventHandler evtHandler) {
		qxEventHandlers.add(evtHandler);
	}
	@Override
	public Set<NotificationAdapter<Cmd>> eAdapters() {
		return adapters;
	}
}
