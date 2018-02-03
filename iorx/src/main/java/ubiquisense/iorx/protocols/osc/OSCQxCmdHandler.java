package ubiquisense.iorx.protocols.osc;


import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.utility.OSCByteArrayToJavaConverter;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;

@javax.inject.Named("osc")  @Singleton
public class OSCQxCmdHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter{
	private OSCByteArrayToJavaConverter converter;
	public OSCQxCmdHandler() {
		converter = new OSCByteArrayToJavaConverter();
	}

	@Override
	public Cmd byteArray2Cmd(byte[] stream) {
		if (stream != null && stream.length>1) {
			try {
				OSCPacket packet = converter.convert(stream, stream.length-1);
				return OscCmdUtils.INSTANCE.createOscCmd(packet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public byte[] cmd2ByteArray(Cmd cmd) {
		if (cmd instanceof OscCmd) {
			return ((OscCmd)cmd).getMsg().getByteArray();
		}
		return new byte[0];
	}

	@Override
	public void handleQxEvent(Event event) {
		if (event.getKind()==EVENT_KIND.TX_DONE || event.getKind()==EVENT_KIND.TX_READY) {
			Channel obj = event.getQx().getEngine().getPort().getChannel();
			if (obj instanceof Channel) {
				synchronized (event.getQx().getEngine().getOutputInterpreter()) {
					byte[] frame = event.getQx().getEngine().getOutputInterpreter().cmd2ByteArray(event.getCmd());
					((Channel)obj).send(frame);
				}
			}
		}
	}

	@Override
	public String getID() {
		return "osc";
	}

}
