/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl.impl;

import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;

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
