
package ubiquisense.iorx.protocols.firmata;

import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.protocols.firmata.internal.FirmataCmdUtils;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataCmd;
import ubiquisense.iorx.protocols.midi.internal.dsl.AbstractMidiCmd;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.protocols.midi.internal.dsl.SysexMessage;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.utils.CmdUtil;
import ubiquisense.iorx.utils.Platform;

/**
 * The handler listen to queue event and send a byte[] form of the compatible firmata command
 */
@CommunicationProtocol(type = "firmata")
public class FirmataCmdQxEventHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter {
	
	public synchronized byte[] cmd2ByteArray(final Cmd cmd) {
		if (Platform.inDebugMode() && cmd != null) {
			System.out.println("!!! FirmataCmdInterpreter to send cmd !!!");
			CmdUtil.INSTANCE.dumpCmdInfo(cmd);
		}
		if (cmd instanceof SysexMessage) {
			SysexMessage msg = (SysexMessage) cmd;
			
/*			if (Integer.decode("0x76") == msg.getCmd()) {
				// I2C Command
				System.out.println("SND : Firmata I2C over sysex " + CmdUtil.INSTANCE.getFrameHexInfo(msg.getMessage()));
				byte[] i2cSysex = new byte[13];
				int idx = 0;
				i2cSysex[idx++] = (byte)0xf0; // Sysex start
				i2cSysex[idx++] = (byte)0x76; // I2C mode
				i2cSysex[idx++] = (byte)0x00; // lsb
				i2cSysex[idx++] = (byte)0x00; // msb
				i2cSysex[idx++] = (byte)0x63; // cmd lsb
				i2cSysex[idx++] = (byte)0x00; // cmd msb
				i2cSysex[idx++] = (byte)0xFF; // R1 lsb
				i2cSysex[idx++] = (byte)0x00; // R2 msb
				i2cSysex[idx++] = (byte)0x00; // G1 lsb
				i2cSysex[idx++] = (byte)0x00; // G2 msb
				i2cSysex[idx++] = (byte)0x00; // B1 lsb
				i2cSysex[idx++] = (byte)0x00; // B2 msb
				i2cSysex[idx++] = (byte)0xf7; // Sysex end
				
				return i2cSysex;
			}
*/			return FirmataCmdUtils.INSTANCE.dumpSysexMessage(msg);
		} else if (cmd instanceof FirmataCmd || cmd instanceof AbstractMidiCmd) {
			byte[] bytes = FirmataCmdUtils.INSTANCE.dumpFirmataCustomMidiMessage((AbstractMidiCmd)cmd);
			if (Platform.inDebugMode() && bytes != null) {
				System.out.println("SND : " + CmdUtil.INSTANCE.getFrameHexInfo(bytes));
			}
			return bytes;
		} if (cmd instanceof ByteCmd) {
			byte[] bytes = ((ByteCmd)cmd).getMessage();
			return bytes;
		}
		return new byte[0]; 
	}
	@Override
	public synchronized void handleQxEvent(Event event) {
		if (isAValidFirmataCmd(event.getCmd())) {
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
			Object channel = evt.getQx().getEngine().getPort().getChannel();
			synchronized (evt.getQx().getEngine().getOutputInterpreter()) {
				IXCmdInterpreter outputInterpreter = evt.getQx().getEngine().getOutputInterpreter();
				if (outputInterpreter != null) {
					if (channel instanceof TransportChannel) { // Serial
						byte[] frame = outputInterpreter.cmd2ByteArray(evt.getCmd());
						if (frame != null && frame.length > 0) {
							((TransportChannel) channel).send(frame);
						}
					}
				}
			}
		}
	}
	
	//
	// think compound !!!
	//
	boolean isAValidFirmataCmd(Cmd cmd) {
		if (cmd instanceof DSLMidiMessage || cmd instanceof FirmataCmd || cmd instanceof SysexMessage || cmd instanceof ByteCmd) {
			return true;
		} else if (cmd instanceof CompoundCmd) {
			for (Cmd c : ((CompoundCmd)cmd).getChildren()) {
				if (!isAValidFirmataCmd(c)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	@Override
	public Cmd byteArray2Cmd(byte[] stream) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "firmata";
	}
}
