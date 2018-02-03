/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2012, Lucas Bigeardel
 * 
 * The library is released under:
 * 
 * A) LGPL
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA 02110-1301 USA
 * 
 * B) EPL
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Lucas Bigeardel <lucas.bigeardel@gmail.com> - Initial API and implementation
 ***********************************************************************************/

package ubiquisense.iorx.protocols.midi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.inject.Named;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;

import com.google.inject.Singleton;

import ubiquisense.iorx.comm.midi.io.MidiCommunicator;
import ubiquisense.iorx.comm.rxtx.Serial;
import ubiquisense.iorx.io.Channel;
import ubiquisense.iorx.io.IXCmdInterpreter;
import ubiquisense.iorx.io.IXFrameInterpreter;
import ubiquisense.iorx.protocols.midi.internal.MidiCmdUtils;
import ubiquisense.iorx.protocols.midi.internal.dsl.AbstractMidiCmd;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.qx.ByteCmd;
import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.CompoundCmd;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.evt.EVENT_KIND;
import ubiquisense.iorx.qx.evt.Event;
import ubiquisense.iorx.qx.evt.IQxEventHandler;

@Named("midi") @Singleton
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
			if (event.getKind() == EVENT_KIND.TX_DONE) {
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
				if (obj instanceof MidiCommunicator) {
					((MidiCommunicator) obj).send(cmd);
				} else if (obj instanceof Channel) {
					byte[] bytes = _qx.getEngine().getOutputInterpreter().cmd2ByteArray(cmd);
					((Channel)obj).send(bytes);
				} else if (obj instanceof Serial) {
					byte[] frame = _qx.getEngine().getOutputInterpreter().cmd2ByteArray(cmd);
					if (frame!=null && frame.length>0) {
						((Serial) obj).write(frame);
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
