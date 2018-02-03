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

package ubiquisense.iorx.comm.midi.io;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;


public class MidiOutputJob implements /*ChannelCloser,*/ IMidiOut {
	
	
	private MidiDevice device;
	public MidiOutputJob(MidiDevice device) {
		this.device	= device;
		if (!device.isOpen()) {
			try {
				device.open();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() {
		if (device != null && device.isOpen()) {
			device.close();
		}
	}

	public void send(DSLMidiMessage cmd) 
	{
		if (device != null && !device.isOpen()) {
			try {
				device.open();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}
		if (device.isOpen()) {
			Receiver r = null;
			try {
				r = device.getReceiver();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
			if (r != null) {
				r.send(
					null , //MidiCmdUtils.INSTANCE.translateMidiMessage(cmd), 
					System.currentTimeMillis()
				);
			}
		}
	}
}
