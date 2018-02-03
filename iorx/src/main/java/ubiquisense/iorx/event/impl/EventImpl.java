package ubiquisense.iorx.event.impl;

import ubiquisense.iorx.changes.Change;
import ubiquisense.iorx.changes.Notification;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.Rx;

public class EventImpl implements Event 
{
	
	EVENT_KIND evtKind;
	
	Cmd cmd;
	
	Qx qx;
	
	long time;
	
	CmdPipe cmdPipe;
	
	String topic;
	
	public EventImpl() {
	}

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
	
	
	

	public EventImpl(Change<Cmd> cmdChange) {
		cmd = cmdChange.getValue();
		time = System.currentTimeMillis();
		qx = cmdChange.getValue().getQx();
		switch(cmdChange.getNotification())
		{
			case ADD: 
			case ADD_MANY: 
				evtKind = qx instanceof Rx ? EVENT_KIND.RX_READY : EVENT_KIND.TX_READY;
				break;
			case REMOVE: 
			case REMOVE_MANY: 
				evtKind = qx instanceof Rx ? EVENT_KIND.RX_DONE : EVENT_KIND.TX_DONE;
				break;
			default:
				evtKind = EVENT_KIND.UNKNOWN;
		}
		cmdPipe = qx.getEngine();
	}

}
