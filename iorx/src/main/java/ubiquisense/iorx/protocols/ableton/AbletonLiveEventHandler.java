package ubiquisense.iorx.protocols.ableton;

import java.util.List;

import com.illposed.osc.OSCPacket;
import com.illposed.osc.utility.OSCByteArrayToJavaConverter;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.cmd.impl.CompoundCmdImpl;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.ableton.internal.AbletonLiveSndCmd;
import ubiquisense.iorx.protocols.ableton.internal.utils.AbletonLive8Utils;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;
import ubiquisense.iorx.utils.Platform;

public class AbletonLiveEventHandler extends OSCQxCmdHandler implements IXFrameInterpreter {
	
	private OSCByteArrayToJavaConverter oscByte2JavaConverter;
	
	public AbletonLiveEventHandler() {
		oscByte2JavaConverter = new OSCByteArrayToJavaConverter();
	}
	
	@Override
	public synchronized byte[] cmd2ByteArray(final Cmd cmd) {
		return AbletonLive8Utils.INSTANCE.dumpAbletonLiveCommand(cmd);
	}
	
	public synchronized Cmd byteArray2Cmd(final byte[] stream) {
		if (stream != null && stream.length>2) {
			try {
				OSCPacket packet = oscByte2JavaConverter.convert(stream, stream.length);
				if (Platform.inDebugMode()) {
					System.out.println(packet.toString());
				}
				CompoundCmd compoundCmd = new CompoundCmdImpl();
				List<AbletonLiveSndCmd> lst = AbletonLive8Utils.INSTANCE.handleAbletonLiveOSCPacket(packet);
				for (AbletonLiveSndCmd c : lst) {
					compoundCmd.add(c);
				}
				return compoundCmd;
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return null;
	}
	
	@Override
	public void handleQxEvent(Event evt) {
		if (evt.getCmd() instanceof AbletonLiveSndCmd) {
			try {
				super.handleQxEvent(evt);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(
					"It's very liekly that no OSC plugin is running on your Ableton Live 8+ ... \n" +
					"Please grab LiveControl OSC python addon from http://liine.net/livecontrol/" +
					""
				);
			}
		}
	}
	
	@Override
	public String getID() {
		return "ableton";
	}
}
