package ubiquisense.iorx.protocols.osc;


import com.google.inject.Singleton;
import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.utility.OSCByteArrayToJavaConverter;

import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.protocols.osc.internal.OscCmd;
import ubiquisense.iorx.protocols.osc.internal.OscCmdUtils;
import ubiquisense.iorx.protocols.raw.internal.RawCmd;

@CommunicationProtocol(type = "osc")
@Singleton
public class OSCQxCmdHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter {
	
	private OSCByteArrayToJavaConverter converter;
	
	public OSCQxCmdHandler() {
		converter = new OSCByteArrayToJavaConverter();
	}
	
	@Override
	public Cmd byteArray2Cmd(byte[] stream) {
		if (stream != null && stream.length>1) {
			try {
				OSCPacket oscPacket = converter.convert(stream, stream.length-1);
				if (oscPacket instanceof OSCMessage)
				{
					return OscCmdUtils.INSTANCE.createOscCmd(oscPacket);
				} 
				else if (oscPacket instanceof OSCBundle)
				{
					return OscCmdUtils.INSTANCE.createOscBundleCmd((OSCBundle) oscPacket);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public byte[] cmd2ByteArray(Cmd cmd) {
		if (cmd instanceof OscCmd) 
		{
			return ((OscCmd)cmd).getMsg().getByteArray();
		} 
		else if (cmd instanceof RawCmd)
		{
			System.out.println("raw " + ((RawCmd)cmd).getBytes().length);
			return ((RawCmd)cmd).getBytes();
		}
		return new byte[0];
	}

	@Override
	public void handleQxEvent(Event event) {
		if (event.getKind()==EVENT_KIND.TX_DONE || event.getKind()==EVENT_KIND.TX_READY) 
		{
			System.out.println("tx osc cmd");
			TransportChannel obj = event.getQx().getEngine().getPort().getChannel();
			if (obj instanceof TransportChannel) {
				synchronized (event.getQx().getEngine().getOutputInterpreter()) {
					((TransportChannel)obj).send(cmd2ByteArray(event.getCmd()));
				}
			}
		}
	}

	@Override
	public String getID() {
		return "osc";
	}
}
