
package ubiquisense.iorx.protocols.midi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;

import com.google.inject.Singleton;

import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.comm.midi.io.MidiTransportCommunicator;
import ubiquisense.iorx.comm.usb.io.UsbSerialTransportCommunicator;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.io.TransportChannel;
import ubiquisense.iorx.protocols.midi.internal.MidiCmdUtils;
import ubiquisense.iorx.protocols.midi.internal.dsl.AbstractMidiCmd;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.qx.Qx;

@CommunicationProtocol(type = "midi")
@Singleton
public class MidiQxCmdHandler implements IQxEventHandler, IXCmdInterpreter, IXFrameInterpreter {
	
	private ShortMessage message;
	public MidiQxCmdHandler() {
		message = new ShortMessage();
	}
	@Override
	public synchronized Cmd byteArray2Cmd(final byte[] stream) {
		if (stream != null && stream.length>0) {
			try {
				if ( stream != null) {
					if (stream.length==3) {
						return MidiCmdUtils.INSTANCE.createMidiMessage(
							(int)stream[0], 
							stream[1], 
							stream[2]
						);
					} else if(stream.length>3) {
						message.setMessage(Byte.toUnsignedInt(stream[0]), Byte.toUnsignedInt(stream[2]), Byte.toUnsignedInt(stream[3]));
						DSLMidiMessage msg = MidiCmdUtils.INSTANCE.createMidiMessage(message);
						return msg;
					} else {
					}
				}
			} catch (InvalidMidiDataException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public void handleQxEvent(Event event) {
		if (event.getCmd() instanceof AbstractMidiCmd) {
			if (event.getKind() == EVENT_KIND.TX_READY) {
				if (event.getCmd() instanceof CompoundCmd) {
					for (Cmd c : ((CompoundCmd)event.getCmd()).getChildren()) {
						handleCmd(event.getQx(), c);
					}
				} else {
					handleCmd(event.getQx(), event.getCmd());
				}
			}
		}
	}

	private synchronized void handleCmd(Qx _qx, Cmd _cmd) {
		if (_cmd instanceof DSLMidiMessage) {
			DSLMidiMessage cmd = (DSLMidiMessage) _cmd;
			Object obj = _qx.getEngine().getPort().getChannel();
			synchronized (_qx.getEngine().getOutputInterpreter()) {
				if (obj instanceof MidiTransportCommunicator) {
					((MidiTransportCommunicator) obj).send(cmd);
				} else if (obj instanceof TransportChannel) {
					byte[] bytes = _qx.getEngine().getOutputInterpreter().cmd2ByteArray(cmd);
					((TransportChannel)obj).send(bytes);
				} else if (obj instanceof UsbSerialTransportCommunicator) {
					byte[] frame = _qx.getEngine().getOutputInterpreter().cmd2ByteArray(cmd);
					if (frame!=null && frame.length>0) {
						((UsbSerialTransportCommunicator) obj).write(frame);
					}
				} else if (obj instanceof DatagramSocket) {
					DatagramSocket socket = (DatagramSocket) obj;
					try {
						byte[] frame = _qx.getEngine().getOutputInterpreter().cmd2ByteArray(_cmd);
						DatagramPacket packet = new DatagramPacket(frame, frame.length);
						socket.send(packet);
					} catch (IOException e) {
						System.err.println("Midi over UDP problem ...");
					} catch (NullPointerException ee) {
						ee.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public byte[] cmd2ByteArray(Cmd cmd) {
		if (cmd instanceof AbstractMidiCmd) {
			return MidiCmdUtils.INSTANCE.dumpMidiMessage((AbstractMidiCmd) cmd);
		} if (cmd instanceof ByteCmd) {
			return ((ByteCmd)cmd).getMessage();
		}
		return new byte[0];
	}

	@Override
	public String getID() {
		return "midi";
	}
}
