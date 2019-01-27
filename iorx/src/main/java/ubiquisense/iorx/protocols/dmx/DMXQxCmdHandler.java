package ubiquisense.iorx.protocols.dmx;

import com.google.inject.Singleton;

import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.protocols.dmx.internal.model.DMXSetCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.DMXSndCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXFade;
import ubiquisense.iorx.protocols.dmx.internal.util.OpenDmxCmdUtils;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;

@CommunicationProtocol(type = "dmx")
@Singleton
public class DMXQxCmdHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter{
	@Override
	public synchronized byte[] cmd2ByteArray(final Cmd cmd) {
		if (cmd instanceof OpenDMXCmd) {
			return OpenDmxCmdUtils.INSTANCE.dumpOpenDMXCmd((OpenDMXCmd)cmd);
		} if (cmd instanceof ByteCmd) {
			return ((ByteCmd)cmd).getMessage();
		}
		return new byte[0];
	}

	@Override
	public synchronized void handleQxEvent(Event event) {
		if (isAValidOpenDMXCmd(event.getCmd())) {
			if (event.getKind() == EVENT_KIND.TX_DONE) {
				handleQxEvent(event, event.getCmd());
			}
		}
	}
	
	private synchronized void handleQxEvent(Event evt, Cmd c) {
		if (c instanceof CompoundCmd) {
			for (Cmd cc : ((CompoundCmd)c).getChildren()) {
				handleQxEvent(evt, cc);
			}
		}
		
		if (evt.getQx().getEngine().getPort() != null) {
			TransportChannel obj = evt.getQx().getEngine().getPort().getChannel();
			IXCmdInterpreter outputInterpreter = evt.getQx().getEngine().getOutputInterpreter();
		
			if (outputInterpreter != null) {
				synchronized (evt.getQx().getEngine().getOutputInterpreter()) {
					if (obj instanceof TransportChannel) { // Serial
						byte[] frame = outputInterpreter.cmd2ByteArray(evt.getCmd());
						if (frame != null && frame.length > 0) {
							((TransportChannel) obj).send(frame);
						}
					}
				}
			}
		}
	}
	
	//
	// think compound !!!
	//
	boolean isAValidOpenDMXCmd(Cmd cmd) {
		if (cmd instanceof DMXSndCmd || cmd instanceof OpenDMXFade || cmd instanceof DMXSetCmd) {
			return true;
		} else if (cmd instanceof CompoundCmd) {
			for (Cmd c : ((CompoundCmd)cmd).getChildren()) {
				if (!isAValidOpenDMXCmd(c)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public synchronized Cmd byteArray2Cmd(final byte[] stream) {
		return OpenDmxCmdUtils.INSTANCE.createDMXCommandFromFrame(stream);
	}

	@Override
	public String getID() {
		return "dmx";
	}
}
