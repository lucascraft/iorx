/*

Copyright (c) 2005 Christian Riekoff
			  2008 Manuel Odendahl

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General
Public License along with this library; if not, write to the
Free Software Foundation, Inc., 59 Temple Place, Suite 330,
Boston, MA  02111-1307  USA
*/

package ubiquisense.iorx.protocols.midi.internal.raw;

import javax.sound.midi.ShortMessage;

/**
 * Wrapper around Program Change messages. You can access the Program Change number by using the
 * {@Link ProgramChange-getNumber} method.
 *
 */
public class ProgramChange extends MidiEvent {
	/**
	 * Create a Program Change message
	 * @param number the program change number
	 */
	public ProgramChange(final int number){
		super(ShortMessage.PROGRAM_CHANGE, number,-1);
	}
	
	/**
	 * 
	 * @return the program change number of this message
	 */
	public int getNumber(){
		return getData1();
	}
	
	public String toString() {
		return "rwmidi.ProgramChange " + getNumber();
	}
}
