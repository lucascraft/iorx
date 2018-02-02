package ubiquisense.iorx.io;

import java.util.List;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.Event;
import ubiquisense.iorx.qx.IQxEventHandler;

public interface Channel {
	List<IXCmdInterpreter> getCmdInterpretrers();
	List<IXFrameInterpreter> getFrameInterpreters();
	List<IQxEventHandler> getEventListeners();
	void addFrameListener(IXFrameInterpreter frameListener);
	void removeFrameListener(IXFrameInterpreter frameListener);
	void addCmdListener(IXCmdInterpreter cmdListener);
	void removeCmdListener(IXCmdInterpreter cmdListener);
	void addQxEventListener(IQxEventHandler eventListener);
	void removeQxEventListener(IQxEventHandler eventListener);
	byte[] getLastFrame();
	void setLastFrame(byte[] value);
	void send(byte[] bytes);
	void receive(byte[] bytes);
	boolean inputReady();
	boolean outputReady();
	boolean connected();
	void close();
	void debug();
	void get(Event event);
	void send(Cmd cmd);
	void receive();
}
