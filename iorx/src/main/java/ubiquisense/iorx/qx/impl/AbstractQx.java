package ubiquisense.iorx.qx.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.QxProcessingStrategy;

public class AbstractQx implements Qx {

	List<Cmd> commands;
	boolean deliver;
	
	@Inject
	CmdPipe pipe;
	
	Port port;
	
	long ttl;
	
	@Inject
	public AbstractQx(){
		commands = new ArrayList<>();
	}	
	
	@Override
	public List<Cmd> getCommands() {
		return commands;
	}
	
	@Override
	public CmdPipe getEngine() {
		return 	 pipe;
	}


	@Override
	public void eSetDeliver(boolean value) {
		 deliver = value;
	}

	@Override
	public int getMax() {
		return 25000;
	}
	
	@Override
	public long getTtl() {
		return ttl;
	}

	@Override
	public QxProcessingStrategy getStrategy() {
		return QxProcessingStrategy.NEWEST_MOST_URGENT;
	}

}
