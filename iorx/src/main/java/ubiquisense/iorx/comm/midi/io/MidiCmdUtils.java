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

package ubiquisense.iorx.comm.midi.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;

import ubiquisense.iorx.comm.midi.ez.AbstractMidiCmd;
import ubiquisense.iorx.comm.midi.ez.ActiveSensing;
import ubiquisense.iorx.comm.midi.ez.ChannelPressure;
import ubiquisense.iorx.comm.midi.ez.ContinueSong;
import ubiquisense.iorx.comm.midi.ez.ControllerChange;
import ubiquisense.iorx.comm.midi.ez.DSLMidiMessage;
import ubiquisense.iorx.comm.midi.ez.EndOfExclusive;
import ubiquisense.iorx.comm.midi.ez.KeyPressure;
import ubiquisense.iorx.comm.midi.ez.NoteOFF;
import ubiquisense.iorx.comm.midi.ez.NoteON;
import ubiquisense.iorx.comm.midi.ez.PitchBend;
import ubiquisense.iorx.comm.midi.ez.PolyPressure;
import ubiquisense.iorx.comm.midi.ez.ProgramChange;
import ubiquisense.iorx.comm.midi.ez.SongPosition;
import ubiquisense.iorx.comm.midi.ez.SongSelect;
import ubiquisense.iorx.comm.midi.ez.StartSong;
import ubiquisense.iorx.comm.midi.ez.StopSong;
import ubiquisense.iorx.comm.midi.ez.SysexMessage;
import ubiquisense.iorx.comm.midi.ez.SystemExclusive;
import ubiquisense.iorx.comm.midi.ez.SystemReset;
import ubiquisense.iorx.comm.midi.ez.TimeCode;
import ubiquisense.iorx.comm.midi.ez.TimingClock;
import ubiquisense.iorx.comm.midi.ez.TimingTick;
import ubiquisense.iorx.comm.midi.ez.TuneRequest;
import ubiquisense.iorx.comm.midi.ez.UnofficialBusSelect;
import ubiquisense.iorx.comm.midi.ez.impl.ActiveSensingImpl;
import ubiquisense.iorx.comm.midi.ez.impl.ChannelPressureImpl;
import ubiquisense.iorx.comm.midi.ez.impl.ContinueSongImpl;
import ubiquisense.iorx.comm.midi.ez.impl.ControllerChangeImpl;
import ubiquisense.iorx.comm.midi.ez.impl.DSLMidiMessageImpl;
import ubiquisense.iorx.comm.midi.ez.impl.EndOfExclusiveImpl;
import ubiquisense.iorx.comm.midi.ez.impl.KeyPressureImpl;
import ubiquisense.iorx.comm.midi.ez.impl.NoteOFFImpl;
import ubiquisense.iorx.comm.midi.ez.impl.NoteONImpl;
import ubiquisense.iorx.comm.midi.ez.impl.PitchBendImpl;
import ubiquisense.iorx.comm.midi.ez.impl.PolyPressureImpl;
import ubiquisense.iorx.comm.midi.ez.impl.ProgramChangeImpl;
import ubiquisense.iorx.comm.midi.ez.impl.SongPositionImpl;
import ubiquisense.iorx.comm.midi.ez.impl.SongSelectImpl;
import ubiquisense.iorx.comm.midi.ez.impl.StartSongImpl;
import ubiquisense.iorx.comm.midi.ez.impl.StopSongImpl;
import ubiquisense.iorx.comm.midi.ez.impl.SysexMessageImpl;
import ubiquisense.iorx.comm.midi.ez.impl.SystemExclusiveImpl;
import ubiquisense.iorx.comm.midi.ez.impl.SystemResetImpl;
import ubiquisense.iorx.comm.midi.ez.impl.TimeCodeImpl;
import ubiquisense.iorx.comm.midi.ez.impl.TimingClockImpl;
import ubiquisense.iorx.comm.midi.ez.impl.TimingTickImpl;
import ubiquisense.iorx.comm.midi.ez.impl.TuneRequestImpl;
import ubiquisense.iorx.comm.midi.ez.impl.UnofficialBusSelectImpl;
import ubiquisense.iorx.qx.Cmd;

public class MidiCmdUtils<possibleCommands> {
	public final static MidiCmdUtils INSTANCE = new MidiCmdUtils();
	
	private static Map<Object, Cmd> possibleCommands;
	
	public MidiCmdUtils() {
		possibleCommands = new HashMap<Object, Cmd>();
		possibleCommands.put(MidiCmdEnum.NOTE_ON, new NoteONImpl());
		possibleCommands.put(MidiCmdEnum.NOTE_OFF, new NoteOFFImpl());
		possibleCommands.put(MidiCmdEnum.ACTIVE_SENSING,		new ActiveSensingImpl());
		possibleCommands.put(MidiCmdEnum.CHANNEL_PRESSURE,	new ChannelPressureImpl());
		possibleCommands.put(MidiCmdEnum.CONTINUE_SONG,		new ContinueSongImpl());
		possibleCommands.put(MidiCmdEnum.CONTROLLER_CHANGE,	new ControllerChangeImpl());
		possibleCommands.put(MidiCmdEnum.END_OF_EXCLUSIVE,	new EndOfExclusiveImpl());
		possibleCommands.put(MidiCmdEnum.KEY_PRESSURE,		new KeyPressureImpl());
		possibleCommands.put(MidiCmdEnum.MIDI_MESSAGE,		new DSLMidiMessageImpl());
		possibleCommands.put(MidiCmdEnum.PITCH_BEND, new PitchBendImpl());
		possibleCommands.put(MidiCmdEnum.PROGRAM_CHANGE,		new ProgramChangeImpl());
		possibleCommands.put(MidiCmdEnum.SONG_POSITION,		new SongPositionImpl());
		possibleCommands.put(MidiCmdEnum.SONG_SELECT,		new SongSelectImpl());
		possibleCommands.put(MidiCmdEnum.START_SONG,new StartSongImpl());
		possibleCommands.put(MidiCmdEnum.STOP_SONG,new StopSongImpl());
		possibleCommands.put(MidiCmdEnum.SYSTEM_EXCLUSIVE,	new SystemExclusiveImpl());
		possibleCommands.put(MidiCmdEnum.SYSTEM_RESET,		new SystemResetImpl());
	}
	
	public Cmd createRandomMidiCommand() {
		return new ArrayList<Cmd>(possibleCommands.values()).get(new Random().nextInt(possibleCommands.values().size()-1));
	}
	
	public DSLMidiMessage createMidiMessage(javax.sound.midi.MidiMessage midiMessage) {
		if (midiMessage instanceof ShortMessage) {
			ShortMessage shortMessage = (ShortMessage) midiMessage;
			switch(shortMessage.getCommand()) {
				case ShortMessage.NOTE_ON:
					return createNoteON(midiMessage);
				case ShortMessage.NOTE_OFF:
					return createNoteOFF(midiMessage);
				case ShortMessage.ACTIVE_SENSING:
					return createActiveSensing(midiMessage);
				case ShortMessage.CHANNEL_PRESSURE:
					return createChannelPressure(midiMessage);
				case ShortMessage.CONTROL_CHANGE:
					return createControllerChange(midiMessage);
				case ShortMessage.END_OF_EXCLUSIVE:
					return createEndOfExclusive(midiMessage);
				case ShortMessage.MIDI_TIME_CODE:
					return createTimeCode(midiMessage);
				case ShortMessage.PITCH_BEND:
					return createPitchBend(midiMessage);
				case ShortMessage.POLY_PRESSURE:
					return createPolyPressure(midiMessage);
				case ShortMessage.PROGRAM_CHANGE:
					return createProgramChange(midiMessage);
				case ShortMessage.SONG_POSITION_POINTER:
					return createSongPosition(midiMessage);
				case ShortMessage.SONG_SELECT:
					return createSongSelect(midiMessage);
				case ShortMessage.START:
					return createStartSong(midiMessage);
				case ShortMessage.CONTINUE:
					return createContinueSong(midiMessage);
				case ShortMessage.STOP:
					return createStopSong(midiMessage);
				case ShortMessage.SYSTEM_RESET:
					return createSystemReset(midiMessage);
				case ShortMessage.TIMING_CLOCK:
					return createTimingClock(midiMessage);
				case ShortMessage.TUNE_REQUEST:
					return createTuneRequest(midiMessage);
			};
		} else if (midiMessage instanceof MetaMessage ) {
			// to consider later
		} else if (midiMessage instanceof SysexMessage) {
			return createSystemExclusive(midiMessage);
		}
		return null;
	}
	
	public DSLMidiMessage createMidiMessage(int id, byte b1, byte b2) {
		return createMidiMessage(id, 1, b1, b2);
	}
	
	public DSLMidiMessage createMidiMessage(int cmd, int channel, byte b1, byte b2) {
			int msgCmdId = (int)cmd & 0xff;

			if (msgCmdId == javax.sound.midi.SysexMessage.SYSTEM_EXCLUSIVE) {
				javax.sound.midi.SysexMessage msg = new javax.sound.midi.SysexMessage();
				//msg.setMessage(msgCmdId, channel, b1, b2);
				return createSystemExclusive(msg);
			} else {
				ShortMessage msg = new ShortMessage();
				try {
					msg.setMessage(msgCmdId, channel, b1, b2);
				} catch (InvalidMidiDataException e) {
					e.printStackTrace();
				}
				switch(msgCmdId) {
					case ShortMessage.NOTE_ON:
						return createNoteON(msg);
					case ShortMessage.NOTE_OFF:
						return createNoteOFF(msg);
					case ShortMessage.ACTIVE_SENSING:
						return createActiveSensing(msg);
					case ShortMessage.CHANNEL_PRESSURE:
						return createChannelPressure(msg);
					case ShortMessage.CONTROL_CHANGE:
						return createControlChange(msg, b1, b2);
					case ShortMessage.END_OF_EXCLUSIVE:
						return createEndOfExclusive(msg);
					case ShortMessage.MIDI_TIME_CODE:
						return createTimeCode(msg);
					case ShortMessage.PITCH_BEND:
						return createPitchBend(msg);
					case ShortMessage.POLY_PRESSURE:
						return createPolyPressure(msg);
					case ShortMessage.PROGRAM_CHANGE:
						return createProgramChange(msg);
					case ShortMessage.SONG_POSITION_POINTER:
						return createSongPosition(msg);
					case ShortMessage.SONG_SELECT:
						return createSongSelect(msg);
					case ShortMessage.START:
						return createStartSong(msg);
					case ShortMessage.CONTINUE:
						return createContinueSong(msg);
					case ShortMessage.STOP:
						return createStopSong(msg);
					case ShortMessage.SYSTEM_RESET:
						return createSystemReset(msg);
					case ShortMessage.TIMING_CLOCK:
						return createTimingClock(msg);
					case ShortMessage.TUNE_REQUEST:
						return createTuneRequest(msg);
				};
			}
		/*} else if (midiMessage instanceof MetaMessage) {
			// to consider later
		} else if (midiMessage instanceof SysexMessage) {
			return createSystemExclusive(midiMessage);
		}*/
		return null;
	}
	
	public byte[] dumpLegacyMidiMessageStream(DSLMidiMessage message) {
		return new byte[] {(byte)message.getCmd(), message.getByte1(), message.getByte2(), (byte)message.getChannel()};
	}
	
	public byte[] dumpSysexMessage(SysexMessage message) {
		byte[] shortMessage = dumpLegacyMidiMessageStream((DSLMidiMessage) message);
		byte[] sysexMessage = new byte[shortMessage.length + (message.getMessage()==null?0:message.getMessage().length)];
		// copy short message 1st
		System.arraycopy(shortMessage, 0, sysexMessage, 0, 4);
		if (message.getMessage()!= null &&  message.getMessage().length > 0) {
			// copy sysex data if any
			System.arraycopy(message.getMessage(), 0, sysexMessage, 4, message.getMessage().length);
		}
		return sysexMessage;
	}
	
	public byte[] dumpMidiMessage(AbstractMidiCmd message) {
		if (message instanceof SysexMessage) {
			return dumpSysexMessage((SysexMessage) message);
		} else if (message instanceof DSLMidiMessage) {
			return dumpLegacyMidiMessageStream((DSLMidiMessage) message);
		} else if (message instanceof MetaMessage) {
		} 
		return new byte[0];
	}
	
	private void initDSLMessage(DSLMidiMessage dslMsg, MidiMessage midiMsg) {
		if (midiMsg instanceof ShortMessage) {
			dslMsg.setCmd(midiMsg.getMessage()[0]);
			dslMsg.setByte1(midiMsg.getMessage()[1]);
			dslMsg.setByte2(midiMsg.getMessage()[2]);
			dslMsg.setMessage(midiMsg.getMessage());
		}
	}
	
	public NoteON createNoteON(javax.sound.midi.MidiMessage midiMessage){
		NoteON message =  new NoteONImpl();
		initDSLMessage(message, midiMessage);
		message.setChannel(midiMessage.getMessage()[0]&0x0f);
		message.setNote(midiMessage.getMessage()[1]);
		message.setVelocity(midiMessage.getMessage()[2]);
		return message;
	};
	
	public NoteOFF createNoteOFF(javax.sound.midi.MidiMessage midiMessage){
		NoteOFF message =  new NoteOFFImpl();
		initDSLMessage(message, midiMessage);
		message.setChannel(midiMessage.getMessage()[0]&0x0f);
		message.setNote(midiMessage.getMessage()[1]);
		message.setVelocity(midiMessage.getMessage()[2]);
		return message;
	};
	
	public ActiveSensing createActiveSensing(javax.sound.midi.MidiMessage midiMessage){
		ActiveSensing message = new ActiveSensingImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public ChannelPressure createChannelPressure(javax.sound.midi.MidiMessage midiMessage){
		ChannelPressure message = new ChannelPressureImpl();  
		initDSLMessage(message, midiMessage);
		message.setPressure(midiMessage.getMessage()[1]);
		return message;
	};
	
	public ContinueSong createContinueSong(javax.sound.midi.MidiMessage midiMessage){	
		ContinueSong message = new ContinueSongImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	public ControllerChange createControllerChange(javax.sound.midi.MidiMessage midiMessage){
		return createControlChange(midiMessage, ((ShortMessage)midiMessage).getData1(), ((ShortMessage)midiMessage).getData2());
	}
	
	public ControllerChange createControlChange(javax.sound.midi.MidiMessage midiMessage, int controller, int value){
		ControllerChange message = new ControllerChangeImpl();  
		initDSLMessage(message, midiMessage);
		message.setController(controller);
		message.setValue(value);
		return message;
	};
	
	public EndOfExclusive createEndOfExclusive(javax.sound.midi.MidiMessage midiMessage){
		EndOfExclusive message = new EndOfExclusiveImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public KeyPressure createKeyPressure(javax.sound.midi.MidiMessage midiMessage){
		KeyPressure message = new KeyPressureImpl();  
		initDSLMessage(message, midiMessage);
		message.setPressure(midiMessage.getMessage()[1]);
		return message;
	};
	
	public PitchBend createPitchBend(javax.sound.midi.MidiMessage midiMessage){
		PitchBend message = new PitchBendImpl();  
		initDSLMessage(message, midiMessage);
		byte lsb = midiMessage.getMessage()[1];
		byte msb = midiMessage.getMessage()[2];
		message.setBend(lsb<<8 + msb);
		return message;
	};
	
	public ProgramChange createProgramChange(javax.sound.midi.MidiMessage midiMessage){
		ProgramChange message = new ProgramChangeImpl();  
		initDSLMessage(message, midiMessage);
		message.setPreset(midiMessage.getMessage()[1]);
		return message;
	};
	
	public SongPosition createSongPosition(javax.sound.midi.MidiMessage midiMessage){
		SongPosition message = new SongPositionImpl();  
		initDSLMessage(message, midiMessage);
		byte lsb = midiMessage.getMessage()[1];
		byte msb = midiMessage.getMessage()[2];
		message.setPosition(lsb<<8 + msb);
		return message;
	};
	
	public SongSelect createSongSelect(javax.sound.midi.MidiMessage midiMessage){
		SongSelect message = new SongSelectImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public StartSong createStartSong(javax.sound.midi.MidiMessage midiMessage){
		StartSong message = new StartSongImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public StopSong	createStopSong(javax.sound.midi.MidiMessage midiMessage){
		StopSong message = new StopSongImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public PolyPressure	createPolyPressure(javax.sound.midi.MidiMessage midiMessage){
		PolyPressure message = new PolyPressureImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public SystemExclusive createSystemExclusive(javax.sound.midi.MidiMessage midiMessage){
		SystemExclusive message = new SystemExclusiveImpl();  
		if (midiMessage instanceof javax.sound.midi.SysexMessage) {
			javax.sound.midi.SysexMessage sysexMessage = (javax.sound.midi.SysexMessage) midiMessage;
			message.setMessage(sysexMessage.getMessage());
			message.setMsgSize(sysexMessage.getLength());
		}
		return message;
	};
	
	public SystemReset	createSystemReset(javax.sound.midi.MidiMessage midiMessage){
		SystemReset message = new SystemResetImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public TimeCode	createTimeCode(javax.sound.midi.MidiMessage midiMessage){
		TimeCode message = new TimeCodeImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public TimingTick createMidiTimingTick(javax.sound.midi.MidiMessage midiMessage){
		TimingTick message = new TimingTickImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public TimingClock	createTimingClock(javax.sound.midi.MidiMessage midiMessage){
		TimingClock message = new TimingClockImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public TuneRequest	createTuneRequest(javax.sound.midi.MidiMessage midiMessage){
		TuneRequest message = new TuneRequestImpl();  
		initDSLMessage(message, midiMessage);
		return message;
	};
	
	public UnofficialBusSelect	createUnoficialBusSelect(javax.sound.midi.MidiMessage midiMessage){
		UnofficialBusSelect message = new UnofficialBusSelectImpl();  
		initDSLMessage(message, midiMessage);
		message.setBusNumber(midiMessage.getMessage()[1]);
		return message;
	};
	
	public SysexMessage createSysexMessage(byte[] value) {
		SysexMessage message = new SysexMessageImpl();
		message.setMessage(value == null ? value = new byte[0] : value);
		message.setMsgSize(value.length);
		return message;
	}
	
	//
	// byte -> Midi
	//
	
	public MidiMessage translateMidiMessage(DSLMidiMessage msg) {
		return createMidiMessage(dumpMidiMessage(msg));
	}
	
	public MidiMessage createMidiMessage(byte[] frame) {
		MidiMessage msg = null;
		if (frame != null) {
			int id = (int) frame[0] & 0xFF;
			if (frame.length >= 3) {
				switch(id) {
					case ShortMessage.NOTE_ON:
					case ShortMessage.NOTE_OFF:
					case ShortMessage.ACTIVE_SENSING:
					case ShortMessage.CHANNEL_PRESSURE:
					case ShortMessage.CONTROL_CHANGE:
					case ShortMessage.END_OF_EXCLUSIVE:
					case ShortMessage.MIDI_TIME_CODE:
					case ShortMessage.PITCH_BEND:
					case ShortMessage.POLY_PRESSURE:
					case ShortMessage.PROGRAM_CHANGE:
					case ShortMessage.SONG_POSITION_POINTER:
					case ShortMessage.SONG_SELECT:
					case ShortMessage.START:
					case ShortMessage.CONTINUE:
					case ShortMessage.STOP:
					case ShortMessage.SYSTEM_RESET:
					case ShortMessage.TIMING_CLOCK:
					case ShortMessage.TUNE_REQUEST:
						ShortMessage sm = new ShortMessage();
						try {
							if (frame.length == 3) {
								sm.setMessage(id, 1, (int)frame[1], (int)frame[2]);
							} else {
								sm.setMessage(id, 1, (int)frame[1], (int)frame[2] /*, (int)frame[3]*/);
							}
						} catch (InvalidMidiDataException e) {
							e.printStackTrace();
						}
						msg = sm;
						break;
						//
					case javax.sound.midi.SysexMessage.SYSTEM_EXCLUSIVE:
						javax.sound.midi.SysexMessage ssx = new javax.sound.midi.SysexMessage();
						try {
							ssx.setMessage(frame, frame.length);
						} catch (InvalidMidiDataException e) {
							e.printStackTrace();
						}
						msg = ssx;
						break;
				};
			} 
		}
		return msg;
	}
	
}
