package ubiquisense.iorx.qx;

import java.util.List;
import java.util.Set;

import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.Port;


public interface CmdPipe {
	Tx getTx();
	Rx getRx();
	List<Event> getTxEvents();
	List<Event> getRxEvents();
	List<Qx> getQueues();
	CmdEngine getClient();
	void setClient(CmdEngine value);
	EngineApplication getApplication();
	void setApplication(EngineApplication value);
	String getId();
	void setId(String value);
	String getName();
	void setName(String value);
	PRIORITY getPriority();
	void setPriority(PRIORITY value);
	Port getPort();
	IXFrameInterpreter getInputInterpreter();
	IXCmdInterpreter getOutputInterpreter();
	void setOutputInterpreter(IXCmdInterpreter interpreter);
	void setInputInterpreter(IXFrameInterpreter interpreter);
	void removeQxEventHandler(IQxEventHandler evtHandler);
	void addQxEventHandler(IQxEventHandler evtHandler);
	void send(Cmd cmd);
	boolean isActivated();
	void receive(byte[] frame);	
	Set<Integer> getPorts();
	String getTransportProtocol();
	String getCommunicationProtocol();
	void setTransportProtocol(String value);
	void setCommunicationProtocol(String value);
	boolean isLocked();
	void setLocked(boolean value);
	String getAddr();
	void setAddr(String addr);
	void deactivateAll();
	void finalize();
	int getSpeed();
	void setSpeed(int value);
	void setPort(Port value);
}
