package ubiquisense.iorx.qx.impl;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.EVENT_KIND;
import ubiquisense.iorx.qx.Event;
import ubiquisense.iorx.qx.Qx;

public class EventImpl implements Event 
{
	
	EVENT_KIND evtKind;
	
	Cmd cmd;
	
	Qx qx;
	
	long time;
	
	CmdPipe cmdPipe;
	
	String topic;

	@Override
	public EVENT_KIND getKind() {
		return evtKind;
	}

	@Override
	public void setKind(EVENT_KIND value) {
		evtKind = value;
	}

	@Override
	public Cmd getCmd() {
		return cmd;
	}

	@Override
	public void setCmd(Cmd value) {
		cmd = value;
	}

	@Override
	public Qx getQx() {
		return qx;
	}

	@Override
	public void setQx(Qx value) {
		qx = value;
	}

	@Override
	public long getTime() {
		return time;
	}

	@Override
	public void setTime(long value) {
		time = value;
	}

	@Override
	public byte[] getBytes() {
		return null;
	}

	@Override
	public void setBytes(byte[] value) {

	}

	@Override
	public String getTopic() {
		return topic;
	}

	@Override
	public void setTopic(String value) {
		topic = value;
	}

	@Override
	public CmdPipe getCmdPipe() {
		return cmdPipe;
	}

	@Override
	public void getCmdPipe(CmdPipe pipe) {
		cmdPipe = pipe;
	}

}
