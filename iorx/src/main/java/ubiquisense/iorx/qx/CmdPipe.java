package ubiquisense.iorx.qx;

import java.util.List;


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

}
