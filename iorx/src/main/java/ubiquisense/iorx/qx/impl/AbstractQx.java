package ubiquisense.iorx.qx.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.QxProcessingStrategy;
import ubiquisense.iorx.utils.EngineUtil;

public class AbstractQx implements Qx {

	List<Cmd> commands;
	boolean deliver;
	QxProcessingStrategy strategy;
	
	@Inject
	CmdPipe pipe;
	
	Port port;
	
	long ttl;
	int max;
	
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
		return max;
	}
	
	@Override
	public long getTtl() {
		return ttl;
	}

	@Override
	public QxProcessingStrategy getStrategy() {
		return QxProcessingStrategy.NEWEST_MOST_URGENT;
	}
	
	@Override
	public void setStrategy(QxProcessingStrategy value) {
		strategy = value;
	}
	
	@Override
	public void setMax(int value) {
		max = value;
	}
	@Override
	public void setTtl(int value) {
		ttl = value;
	}

	@Override
	public void postCommand(Cmd cmd) {
		EngineUtil.INSTANCE.sendCmd(this, cmd);
	}

}
