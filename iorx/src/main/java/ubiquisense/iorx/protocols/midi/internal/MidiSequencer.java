/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2011, Lucas Bigeardel
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

package ubiquisense.iorx.protocols.midi.internal;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

public class MidiSequencer {
	public final static MidiSequencer INSTANCE = new MidiSequencer();

	private static Sequencer sequencer = null;
	private static Synthesizer synthesizer = null;

	private DatagramSocket udpSocket;

	public MidiSequencer() {
		udpSocket = null;
	}
	
	public static void main(String[] args) {
		INSTANCE.playItNow(new File(args[0]), "localhost", 6060);
	}

	/**
	 * Play a given Midi file w/ sequencer and send Midi message to given
	 * address:port/UDP
	 * 
	 * @param midiFile a given Midi file
	 * @param addr an address as in the {@link InetAddress} specification
	 * @param port a port as in the {@link InetAddress} specification
	 */
	public void playItNow(final File midiFile, String addr, int port) {
		try {
			udpSocket = new DatagramSocket();
			udpSocket.connect(InetAddress.getByName(addr),
					Integer.valueOf(port));
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		Sequence sequence = null;
		try {
			sequence = MidiSystem.getSequence(midiFile);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		}
		if (sequencer == null) {
			System.err.println("Sequencer broken");
			System.exit(1);
		}

		sequencer.addMetaEventListener(new MetaEventListener() {
			public void meta(MetaMessage event) {
				if (event.getType() == 47) {
					sequencer.close();
					if (synthesizer != null) {
						synthesizer.close();
					}
					System.exit(0);
				}
			}
		});

		try {
			sequencer.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			System.exit(1);
		}

		if (!(sequencer instanceof Synthesizer)) {
			try {
				synthesizer = MidiSystem.getSynthesizer();
				synthesizer.open();
				Receiver dumpReceiver = new Receiver() {
					public void send(MidiMessage message, long lTimeStamp) {
						try {
							udpSocket.send(new DatagramPacket(message
									.getMessage(), message.getLength()));
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (message instanceof ShortMessage) {
							System.out
									.println(decodeMessage((ShortMessage) message));
						}
					}

					public void close() {

					}

					public String decodeMessage(ShortMessage message) {
						String strMessage = null;
						switch (message.getCommand()) {
						case 0x80:
							strMessage = "note Off "
									+ getKeyName(message
											.getData1()) + " velocity: "
									+ message.getData2();
							break;
						case 0x90:
							strMessage = "note On "
									+ getKeyName(message
											.getData1()) + " velocity: "
									+ message.getData2();
							break;
						case 0xa0:
							strMessage = "polyphonic key pressure "
									+ getKeyName(message
											.getData1()) + " pressure: "
									+ message.getData2();
							break;
						case 0xb0:
							strMessage = "control change " + message.getData1()
									+ " value: " + message.getData2();
							break;
						case 0xc0:
							strMessage = "program change " + message.getData1();
							break;
						case 0xd0:
							strMessage = "key pressure "
									+ getKeyName(message
											.getData1()) + " pressure: "
									+ message.getData2();
							break;
						case 0xe0:
							strMessage = "pitch wheel change "
									+ get14bitValue(
											message.getData1(),
											message.getData2());
							break;
						default:
							strMessage = "unknown message: status = "
									+ message.getStatus() + ", byte1 = "
									+ message.getData1() + ", byte2 = "
									+ message.getData2();
							break;
						}
						if (message.getCommand() != 0xF0) {
							int nChannel = message.getChannel() + 1;
							String strChannel = "channel " + nChannel + ": ";
							strMessage = strChannel + strMessage;
						}
						return "[" + getHexString(message) + "] "
								+ strMessage;
					}
				};
				Transmitter seqTransmitter = sequencer.getTransmitter();
				seqTransmitter.setReceiver(dumpReceiver);
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}
		sequencer.start();
	}
	
	private static final String[] sm_astrKeyNames = {
		"C", "C#", "D", "D#", "E", "F", 
		"F#", "G", "G#", "A", "A#", "B"
	};

	
	public static String getKeyName(int nKeyNumber)
	{
		if (nKeyNumber > 127)
		{
			return "illegal value";
		}
		else
		{
			int	nNote = nKeyNumber % 12;
			int	nOctave = nKeyNumber / 12;
			return sm_astrKeyNames[nNote] + (nOctave - 1);
		}
	}


	public static int get14bitValue(int nLowerPart, int nHigherPart)
	{
		return (nLowerPart & 0x7F) | ((nHigherPart & 0x7F) << 7);
	}

	private static char hexDigits[] = 
	   {'0', '1', '2', '3', 
	    '4', '5', '6', '7', 
	    '8', '9', 'A', 'B', 
	    'C', 'D', 'E', 'F'};

	public static String getHexString(byte[] aByte)
	{
		StringBuffer	sbuf = new StringBuffer(aByte.length * 3 + 2);
		for (int i = 0; i < aByte.length; i++)
		{
			sbuf.append(' ');
			sbuf.append(hexDigits[(aByte[i] & 0xF0) >> 4]);
			sbuf.append(hexDigits[aByte[i] & 0x0F]);
		/*
			byte bhigh = (byte) ((aByte[i] &  0xf0) >> 4);
			sbuf.append((char) (bhigh > 9 ? bhigh + 'A' - 10: bhigh + '0'));
			byte	blow = (byte) (aByte[i] & 0x0f);
			sbuf.append((char) (blow > 9 ? blow + 'A' - 10: blow + '0'));
		*/
		}
		return new String(sbuf);
	}
	
	private static String intToHex(int i) {
		return ""+hexDigits[(i & 0xF0) >> 4]
		         +hexDigits[i & 0x0F];
	}

	public static String getHexString(ShortMessage sm)
	{
		// bug in J2SDK 1.4.1
		// return getHexString(sm.getMessage());
		int status = sm.getStatus();
		String res = intToHex(sm.getStatus());
		// if one-byte message, return
		switch (status) {
			case 0xF6:			// Tune Request
			case 0xF7:			// EOX
	    		// System real-time messages
			case 0xF8:			// Timing Clock
			case 0xF9:			// Undefined
			case 0xFA:			// Start
			case 0xFB:			// Continue
			case 0xFC:			// Stop
			case 0xFD:			// Undefined
			case 0xFE:			// Active Sensing
			case 0xFF: 
				return res;
		}
		res += ' '+intToHex(sm.getData1());
		// if 2-byte message, return
		switch (status) {
			case 0xF1:			// MTC Quarter Frame
			case 0xF3:			// Song Select
				return res;
		}
		switch (sm.getCommand()) {
			case 0xC0:
			case 0xD0:
				return res;
		}
		// 3-byte messages left
		res += ' '+intToHex(sm.getData2());
		return res;
	}

}
