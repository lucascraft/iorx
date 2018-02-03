package ubiquisense.iorx.registry;

import java.util.HashMap;
import java.util.Map;

import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;

public class CommProtocolConfig 
{
    IXCmdInterpreter cmdInterpreter;
    IXFrameInterpreter frameInterpreter;
    IQxEventHandler eventHandler;
    String alias;
    String ID;
 
    public CommProtocolConfig(String ID, String alias, IXCmdInterpreter cmdInterpreter, IXFrameInterpreter frameInterpreter, IQxEventHandler eventHandler) 
    {
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
