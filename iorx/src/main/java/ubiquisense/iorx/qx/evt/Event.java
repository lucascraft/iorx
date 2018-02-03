package ubiquisense.iorx.qx.evt;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CmdPipe;
import ubiquisense.iorx.qx.Qx;

public interface Event {
	EVENT_KIND getKind();
	void setKind(EVENT_KIND value);
	Cmd getCmd();
	void setCmd(Cmd value);
	Qx getQx();
	void setQx(Qx value);
	long getTime();
	void setTime(long value);
	byte[] getBytes();
	void setBytes(byte[] value);
	String getTopic();
	void setTopic(String value);
	public CmdPipe getCmdPipe();
	public void getCmdPipe(CmdPipe pipe);

} // Event