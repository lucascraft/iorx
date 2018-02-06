/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2012, Lucas Bigeardel
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import ubiquisense.iorx.utils.Platform;

public class MidiSystemUtils {

	public final static MidiSystemUtils INSTANCE = new MidiSystemUtils();

	private Map<String, Integer> notesWithShiftMap;
	private Map<Integer, Map<String, Integer>> notesByOctavesMap;

	private final static int NB_KEYS = 12;

	public Map<String, Integer> getNotesWithShiftMap() {
		return notesWithShiftMap;
	}
	
	public MidiSystemUtils() {
		notesWithShiftMap = new TreeMap<String, Integer>();
		notesWithShiftMap.put("C", 0);
		notesWithShiftMap.put("C#", 1);
		notesWithShiftMap.put("Db", 1); // avoid
		notesWithShiftMap.put("D", 2);
		notesWithShiftMap.put("D#", 3);
		notesWithShiftMap.put("Eb", 3); // avoid
		notesWithShiftMap.put("E", 4);
		notesWithShiftMap.put("F", 5);
		notesWithShiftMap.put("F#", 6);
		notesWithShiftMap.put("Gb", 6); // avoid
		notesWithShiftMap.put("G", 7);
		notesWithShiftMap.put("G#", 8);
		notesWithShiftMap.put("Ab", 8); // avoid
		notesWithShiftMap.put("A", 9);
		notesWithShiftMap.put("A#", 10);
		notesWithShiftMap.put("Bb", 10); // avoid
		notesWithShiftMap.put("B", 11);

		notesByOctavesMap = new TreeMap<Integer, Map<String, Integer>>();

		// note : [0..132] (11 x 12)
		int note = 0;
		for (int octave = 0; octave <= 10; octave++) {
			Map<String, Integer> octaveMap = new TreeMap<String, Integer>();
			notesByOctavesMap.put(octave, octaveMap);
			for (String k : notesWithShiftMap.keySet()) {
				octaveMap.put(k, new Integer(note) + notesWithShiftMap.get(k));
			}
			note += NB_KEYS;
		}
	}

	public int getNote(int octave, String code) {
		Integer octaveID = new Integer(octave);
		if (notesByOctavesMap.containsKey(octaveID)) {
			Map<String, Integer> notesMap = notesByOctavesMap.get(octaveID);
			if (notesMap.containsKey(code)) {
				return notesMap.get(code);
			}
		}
		return -1;
	}

	public String getCode(int octave, int note) {
		Integer octaveID = new Integer(octave);
		Integer noteID = new Integer(note);
		if (notesByOctavesMap.containsKey(octaveID)) {
			Map<String, Integer> notesMap = notesByOctavesMap.get(octaveID);
			for (String code : notesMap.keySet()) {
				Integer midiCode = notesMap.get(code);
				if (midiCode.equals(noteID)) {
					return code;
				}
			}
		}
		return null;
	}

	public void affectInstrumentToChannel(Synthesizer synth, Instrument instr) {
		if (synth.isOpen()) {
			MidiChannel[] channels = synth.getChannels();
			int program = instr.getPatch().getProgram();
			if (channels != null && channels.length > 0) {
				int idx = instr.getPatch().getBank();
				synth.loadInstrument(instr);
				channels[0].programChange(idx, program);
				channels[1].programChange(idx, program);
				channels[2].programChange(idx, program);
				channels[3].programChange(idx, program);
				channels[4].programChange(idx, program);
				channels[5].programChange(idx, program);
				channels[6].programChange(idx, program);
				channels[7].programChange(idx, program);
				channels[8].programChange(idx, program);
			}
		}

	}

	public HashMap<String, List<Instrument>> instrumentsByBanks(Synthesizer synth) {
		HashMap<String, List<Instrument>> instrMap = new HashMap<String, List<Instrument>>();
		if (synth != null && synth.isOpen()) {
			for (Instrument instr : synth.getAvailableInstruments()) {
				String sBank = instr.getSoundbank().getName();
				if (sBank instanceof String) {
					if (!instrMap.containsKey(sBank)) {
						instrMap.put(sBank, new ArrayList<Instrument>());
					}
					instrMap.get(sBank).add(instr);
				}
			}
		}
		return instrMap;
	}

	public List<MidiDevice> getMidiDevices() {
		List<MidiDevice> devices = new ArrayList<MidiDevice>();

		for (MidiDevice.Info info : MidiSystem.getMidiDeviceInfo()) {
			String txt = "Description : " + info.getDescription() + "\n" + "Vendor : " + info.getVendor() + "\n"
					+ "Version : " + info.getVersion();

			if (Platform.inDebugMode()) {
				System.out.println("Device : " + info.getName() + "\n" + txt + "\n");
			}

			try {
				MidiDevice device = MidiSystem.getMidiDevice(info);
				if (!devices.contains(device)) {
					devices.add(device);
				}
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}

		return devices;
	}

	public Object[] getElements(Object inputElement) {
		List<MidiDevice> devices = new ArrayList<MidiDevice>();
		for (MidiDevice device : getMidiDevices()) {
			boolean outDevice = device.getMaxReceivers() >= 0 && device.getMaxTransmitters() == -1;
			if (outDevice) {
				devices.add(device);
			}
			boolean inDevice = device.getMaxTransmitters() >= 0 && device.getMaxReceivers() == -1;
			if (inDevice) {
				devices.add(device);
			}
		}
		return devices.toArray();
	}

}
