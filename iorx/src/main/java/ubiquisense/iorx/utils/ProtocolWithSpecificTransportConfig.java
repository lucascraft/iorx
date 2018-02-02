package ubiquisense.iorx.utils;

import java.util.HashMap;
import java.util.Map;

import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.qx.IQxEventHandler;

public class ProtocolWithSpecificTransportConfig 
{
    IXCmdInterpreter cmdInterpreter;
    IXFrameInterpreter frameInterpreter;
    IQxEventHandler eventHandler;
    String alias;
    String ID;
    Map<String, Channel> chanelsMap;
    
    public Map<String, Channel>  getSpecificChannelsMap()
    {
    	return chanelsMap;
    }
    
    public ProtocolWithSpecificTransportConfig(String ID, String alias, IXCmdInterpreter cmdInterpreter, IXFrameInterpreter frameInterpreter, IQxEventHandler eventHandler) 
    {
    	chanelsMap = new HashMap<>();
    	this.cmdInterpreter = cmdInterpreter;
    	this.frameInterpreter = frameInterpreter;
    	this.eventHandler = eventHandler;
    	this.alias = alias;
    	this.ID = ID;
    }
    
    public IXCmdInterpreter getCmdInterpreter()
    {
    	return cmdInterpreter;
    }
    
    public IXFrameInterpreter getFrameInterpreter()
    {
    	return frameInterpreter;
    }
    
    public  IQxEventHandler getEventHandler()
    {
    	return eventHandler;
    }
    
    public String getAlias() 
    {
		return alias;
	}
    public String getID() 
    {
		return ID;
	}
}
