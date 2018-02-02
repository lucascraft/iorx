/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.comm.midi.ez.impl;

import ubiquisense.iorx.comm.midi.ez.DSLMidiMessage;

public class DSLMidiMessageImpl extends AbstractMidiCmdImpl implements DSLMidiMessage {

	int channel;
	int cmd;
	

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int value) {
		channel = value;		
	}

	@Override
	public int getCmd() {
		// TODO Auto-generated method stub
		return cmd;
	}

	@Override
	public void setCmd(int value) {
		cmd = value;		
	}


} //DSLMidiMessageImpl
