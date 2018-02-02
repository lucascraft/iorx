package ubiquisense.iorx.qx;

import java.util.List;

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
	IXCmdInterpreter getOuutputInterpreter();
	void send(Cmd cmd);
}
