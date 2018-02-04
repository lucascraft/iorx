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

package ubiquisense.iorx.protocols.firmata.internal;

import javax.sound.midi.ShortMessage;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FIRMATA_I2C_ADDR_MODE;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FIRMATA_I2C_RW_MODE;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataCmd;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataPinStateResponse;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataProtocolVersionCmd;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataSysexMessage;
import ubiquisense.iorx.protocols.firmata.internal.model.impl.FirmataPinStateResponseImpl;
import ubiquisense.iorx.protocols.firmata.internal.model.impl.FirmataProtocolVersionCmdImpl;
import ubiquisense.iorx.protocols.firmata.internal.model.impl.FirmataSysexMessageImpl;
import ubiquisense.iorx.protocols.midi.internal.MidiCmdUtils;
import ubiquisense.iorx.protocols.midi.internal.dsl.AbstractMidiCmd;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.protocols.midi.internal.dsl.SysexMessage;
import ubiquisense.iorx.protocols.midi.internal.dsl.impl.NoteONImpl;
import ubiquisense.iorx.protocols.midi.internal.dsl.impl.SysexMessageImpl;
import ubiquisense.iorx.protocols.midi.internal.dsl.impl.SystemResetImpl;
import ubiquisense.iorx.utils.CmdUtil;
import ubiquisense.iorx.utils.Platform;

public class FirmataCmdUtils {
	
	public final static FirmataCmdUtils INSTANCE = new FirmataCmdUtils();
	
	
	public byte[] dumpSysexMessage(SysexMessage message) {
		byte[] sysexMessage = new byte[2 + (message.getMessage()==null?0:message.getMessage().length)];
		sysexMessage[0] = (byte) 0xf0;
		// copy short message 1st
		if (message.getMessage()!= null &&  message.getMessage().length > 0) {
			// copy sysex data if any
			System.arraycopy(message.getMessage(), 0, sysexMessage, 1, message.getMessage().length);
		}
		sysexMessage[sysexMessage.length-1] = (byte) 0xf7;
		if (ubiquisense.iorx.utils.Platform.inDebugMode()) {
			System.out.println(CmdUtil.INSTANCE.getFrameHexInfo(sysexMessage));
		}

		return sysexMessage;
	}

	/**
	 * Taking advantage of its Midi nature we can reuse the UBQT/SMNT infrastructure
	 * for dump purposes.
	 * 
	 * @param cmd a {@link FirmataCmd} command inheriting from {@link DSLMidiMessage}
	 * @return a stream represention according to the Midi protocol standard
	 */
	public byte[] dumpFirmataCustomMidiMessage(AbstractMidiCmd cmd) {
		return MidiCmdUtils.INSTANCE.dumpMidiMessage(cmd);
	}
	
	// FIXME : verify that twice
	public SysexMessage createSysex(){
		SysexMessage message =  new SysexMessageImpl();
		message.setAddr(Integer.decode("0x0f").byteValue());
		return message;
	};
	
	/* 
	 * Analog 14-bit data format
	 * 0  analog pin, 0xE0-0xEF, (MIDI Pitch Wheel)
	 * 1  analog least significant 7 bits
	 * 2  analog most significant 7 bits
	 */
	public DSLMidiMessage createAnalogIO(int port, float value){
		DSLMidiMessage message =  new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0xe0") | port);
		message.setChannel(port);
		
		int v = new Float(value).intValue();
		
		byte b1 = (byte)(v>>8);
		byte b2 = (byte)(v & 0xff);

		message.setByte1(b1); // LSB
		message.setByte2(b2); // MSB
		
		return message;
	};
	
	/* pin state response
	 * -------------------------------
	 * 0  START_SYSEX (0xF0) (MIDI System Exclusive)
	 * 1  pin state response (0x6E)
	 * 2  pin (0 to 127)
	 * 3  pin mode (the currently configured mode)
	 * 4  pin state, bits 0-6
	 * 5  (optional) pin state, bits 7-13
	 * 6  (optional) pin state, bits 14-20
	 ...  additional optional bytes, as many as needed
	 * N  END_SYSEX (0xF7)
	 */
	public FirmataPinStateResponse createPinStateResponse(byte[] bytes) {
		byte pinNumber = bytes[2];
		byte mode = bytes[3];
		 
		byte value = bytes.length>5?bytes[4]:0;
		
		if (bytes.length>6) {
			byte[] pinState = new byte[7];
			System.arraycopy(bytes, 3, pinState, 0, 7);
		
			value |= (bytes[5] << 7);
			if (bytes.length>7) {
				value |= (bytes[6] << 14);
			}
		}
		
		FirmataPinStateResponse response = new FirmataPinStateResponseImpl();
		response.setAddr((byte)0xf0);
		response.setCmd(0x6e);
		response.setMessage(bytes);
		response.setValue(value);
		response.setModel(mode);
		response.setPin(pinNumber);
		
		return response;
	}
	
	/* 
	 * Analog 14-bit data format
	 * 0  analog pin, 0xE0-0xEF, (MIDI Pitch Wheel)
	 * 1  analog least significant 7 bits
	 * 2  analog most significant 7 bits
	 */
	public DSLMidiMessage createAnalogIO(int port, byte b1, byte b2){
		DSLMidiMessage message =   new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0xe0"));
		message.setChannel(port);
		
		message.setByte1(b1); // LSB
		message.setByte2(b2); // MSB
		
		message.setMessage(new byte[] {(byte)0xf0, (byte)ShortMessage.NOTE_ON, b1, b2, (byte)port});
		
		return message;
	};
	
	public DSLMidiMessage createReportAnalogPin(int port, int mode){
		DSLMidiMessage message =  new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0xc0") | port);
		message.setChannel(port);
		
		message.setByte1((byte)(mode == 1 ? 0x01 : 0x00)); // LSB
		message.setByte2((byte)port); // MSB
		
		return message;
	};
	
	/* 
	 * Two byte digital data format
	 * 0  digital data, 0x90-0x9F, (MIDI NoteOn, but different data format)
	 * 1  digital pins 0-6 bitmask
	 * 2  digital pins 7-13 bitmask 
	 */
	public DSLMidiMessage createDigitalIO(int port, int value){
		DSLMidiMessage message = new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0x90") | port);
		message.setChannel(port);
		
		message.setByte1((byte)(value & 0xff)); // LSB
		message.setByte2((byte)((value>> 8) & 0xff)); // MSB

		return message;
	};
	
	/* 
	 * Two byte digital data format
	 * 0  digital data, 0x90-0x9F, (MIDI NoteOn, but different data format)
	 * 1  digital pins 0-6 bitmask
	 * 2  digital pins 7-13 bitmask 
	 */
	public DSLMidiMessage createDigitalIO(int port, byte b1, byte b2){
		DSLMidiMessage message =  new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0x90"));
		message.setChannel(port);
		
		message.setByte1(b1); // LSB
		message.setByte2(b2); // MSB

		return message;
	};
	
	public DSLMidiMessage createReportDigitalPin(int port, int mode){
		DSLMidiMessage message = new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0xd0") | port);
		message.setChannel(port);

		message.setByte1((byte)(mode == 1 ? 0x01 : 0x00)); // LSB
		message.setByte2((byte)port); // MSB
		
		message.setMessage(new byte[]{message.getAddr(), message.getByte1(), message.getByte2(), (byte) message.getChannel()});

		return message;
	};
	
	public DSLMidiMessage createPinModeResponse(int port, int mode){
		DSLMidiMessage message = new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0x73"));
		message.setChannel(port);

		message.setByte1((byte)mode); // LSB
		message.setByte2((byte)port); // MSB
		
		message.setMessage(new byte[]{message.getAddr(), message.getByte1(), message.getByte2(), (byte) message.getChannel()});

		return message;
	};
	
	/* 
	 * Query Capabilities 
	 * 0  START_SYSEX (0xF0)
	 * 1  queryAnalogMapping (0x6b)
	 * 2  END_SYSEX (0xF7)
	 */
	public Cmd createCapabiltiesQueryOld() {
		SysexMessage sysexMessage =new FirmataSysexMessageImpl();
		sysexMessage.setAddr((byte)0xf0);
		sysexMessage.setCmd((byte)0x6b);
		sysexMessage.setMessage(new byte[]{(byte) 0x6b});
		return sysexMessage;
	}
	
	
	
	/* 
	 * Query Capabilities 
	 * 0  START_SYSEX (0xF0)
	 * 1  queryAnalogMapping (0x6d)
	 * 2  pin
	 * 3  END_SYSEX (0xF7)
	 */
	public Cmd createPinStateQuery(int pin) {
		SysexMessage sysexMessage = new FirmataSysexMessageImpl();
		sysexMessage.setAddr((byte)0xf0);
		sysexMessage.setCmd((byte)0x6d);
		sysexMessage.setMessage(new byte[]{(byte) 0x6d, (byte) pin});
		return sysexMessage;
	}

	/* 
	 * Query Capabilities 
	 * 0  START_SYSEX;
	 * 1  ANALOG_MAPPING_QUERY (0x69); // read analog to pin # info
	 * 2  END_SYSEX;
	 * 3  START_SYSEX (0xF0)
	 * 4  queryAnalogMapping (0x6b)
	 * 4  END_SYSEX (0xF7)
	 */
	public Cmd createCapabiltiesQuery() {
		SysexMessage sysexMessage = new FirmataSysexMessageImpl();
		sysexMessage.setAddr((byte)0xf0);
		sysexMessage.setCmd((byte)0x69);
		
		int len = 0;
		byte[] buf = new byte[70];
		buf[len++] = (byte) 0xf0;
		buf[len++] = (byte) 0x69;
		buf[len++] = (byte) 0xf7;
		buf[len++] = (byte) 0xf0;
		buf[len++] = (byte) 0x6b;
		buf[len++] = (byte) 0xf7;
		
		int zeroXCZ = 0xc0;
		int zeroXDZ = 0xd0;
		for (int i=0; i<16; i++) {
			buf[len++] = (byte) ( zeroXCZ | i);  // report analog
			buf[len++] = 1;
			
			buf[len++] = (byte) (zeroXDZ | i);  // report digital
			buf[len++] = 1;
			
			if (Platform.inDebugMode()) {
				System.out.println("Query digital capabilities for Port " + i + " : [" + zeroXCZ + "|" + i + "] --> " +   ( zeroXCZ | i));
				System.out.println("Query analog  capabilities for Port " + i + " : [" + zeroXDZ + "|" + i + "] --> " +   ( zeroXDZ | i));
			}
		}

		sysexMessage.setMessage(buf);

		return sysexMessage;
	}
		
	public DSLMidiMessage createAnalogMappingResponse(byte[] mapping){
		SysexMessage message =  new FirmataSysexMessageImpl();
		message.setAddr((byte)0xf0);
		message.setCmd(Integer.decode("0x6a"));
		message.setMessage(mapping);
		return message;
	};

	
	public DSLMidiMessage createCapabilityResponse(byte[] mapping){
		SysexMessage message =  new FirmataSysexMessageImpl();
		message.setAddr((byte)0xf0);
		message.setCmd(Integer.decode("0x6c"));
		message.setMessage(mapping);
		return message;
	};
	
	public DSLMidiMessage createProtocolVersionResponse(byte major, byte minor){
		FirmataProtocolVersionCmd message =  new FirmataProtocolVersionCmdImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0xf9"));
		message.setByte1(major);
		message.setByte2(minor);
		return message;
	};
	
	public DSLMidiMessage createSystemReset(){
		 return new SystemResetImpl();
	};
	
	/* Set pin mode
	 * 1  set digital pin mode (0xF4) (MIDI Undefined)
	 * 2  pin number (0-127)
	 * 3  state (INPUT/OUTPUT/ANALOG/PWM/SERVO/SHIFT/I2C, 0/1/2/3/4/5/6)
	 */
	public DSLMidiMessage createSetPinMode(int port, int state){
		DSLMidiMessage message = new NoteONImpl();
		message.setAddr(new Integer(ShortMessage.NOTE_ON).byteValue());
		message.setCmd(Integer.decode("0xf4"));
		message.setByte2((byte)state); // LSB
		message.setByte1((byte)port); // MSB
		return message;
	};
	
	/* 
	 * Query Pin Mapping 
	 * 0  START_SYSEX (0xF0)
	 * 1  queryAnalogMapping (0x69)
	 * 2  END_SYSEX (0xF7)
	 */
	public Cmd createAnalogMappingQuery() {
		return CmdUtil.INSTANCE.createByteCmd(new byte[] { 
			Integer.decode("0xf0").byteValue(),
			Integer.decode("0x69").byteValue(),
			Integer.decode("0xf7").byteValue(),
		});
	}
	
	
	//
	//
	// Sampling interval
	//
	//
	/* 
	 * Set sampling interval
	 * -------------------------------
	 * 0  START_SYSEX (0xF0) (MIDI System Exclusive)
	 * 1  SAMPLING_INTERVAL (0x7A)
	 * 2  sampling interval on the millisecond time scale (LSB)
	 * 3  sampling interval on the millisecond time scale (MSB)
	 * 4  END_SYSEX (0xF7)
	 */
	public Cmd createSetSamplingInterval(int msecInterval) {
		SysexMessage qCmd = createSysex();
		
		qCmd.setAddr(Integer.decode("0xf0").byteValue());
		qCmd.setCmd(Integer.decode("0x7a"));

		byte lsb = (byte)(msecInterval & 0xff);
		byte msb = (byte)((msecInterval>> 8) & 0xff);
		
		qCmd.setMessage(new byte[]{(byte) 0xf0, 0x7a, lsb, msb, (byte) 0xf7});
		
		return qCmd;
	}

	
	//
	//
	// I2C Utils : compound commands for I2C ...
	//
	//
	
	
	//
	//
	// Servo Utils : compound commands for servo piloting ...
	//
	//
	/* 
	 * Servo config
	 * --------------------
	 * 0  START_SYSEX (0xF0)
	 * 1  SERVO_CONFIG (0x70)
	 * 2  pin number (0-127)
	 * 3  minPulse LSB (0-6)
	 * 4  minPulse MSB (7-13)
	 * 5  maxPulse LSB (0-6)
	 * 6  maxPulse MSB (7-13)
	 * 7  angle LSB (0-6)
	 * 8  angle MSB (7-13)
	 * 9  END_SYSEX (0xF7)
	 */
	public Cmd createSetServo(int pinNumber, int minPulse, int maxPulse, int angle) {
		SysexMessage qCmd = createSysex();
		
		qCmd.setAddr(Integer.decode("0xf0").byteValue());
		qCmd.setCmd(Integer.decode("0x70"));

		byte pin = (byte)(pinNumber & 0xff);
		
		byte minPulseLSB = (byte)(minPulse & 0xff);
		byte minPulseMSB = (byte)((minPulse>> 8) & 0xff);
		
		byte maxPulseLSB = (byte)(maxPulse & 0xff);
		byte maxPulseMSB = (byte)((maxPulse>> 8) & 0xff);
		
		byte angleLSB = (byte)(angle & 0xff);
		byte angleMSB = (byte)((angle>> 8) & 0xff);
		
		qCmd.setMessage(
			new byte[] {
				(byte) 0xf0, 
				(byte) 0x70, 
				pin, 
				minPulseLSB, minPulseMSB, 
				maxPulseLSB, maxPulseMSB, 
				angleLSB, angleMSB, 
				(byte) 0xf7
			}
		);
		
		return qCmd;
	}
	
	
	/* extended analog
	 * -------------------------------
	 * 0  START_SYSEX (0xF0) (MIDI System Exclusive)
	 * 1  extended analog message (0x6F)
	 * 2  pin (0 to 127)
	 * 3  bits 0-6 (least significant byte)
	 * 4  bits 7-13
	 * ... additional bytes may be sent if more bits needed
	 * N  END_SYSEX (0xF7) (MIDI End of SysEx - EOX)
	 */
	public Cmd createExtendedAnalog(int pinNumber, int val) {
		SysexMessage qCmd = createSysex();
		
		qCmd.setAddr(Integer.decode("0xf0").byteValue());
		qCmd.setCmd(Integer.decode("0x6f"));

		byte pin = (byte)(pinNumber & 0xff);
		
		byte valLSB = (byte)(val & 0xff);
		byte valMSB = (byte)((val>> 8) & 0xff);
		
		int len=5;
		byte[] buf = new byte[12];
		
		buf[0] = Integer.decode("0xf0").byteValue();
		buf[1] = Integer.decode("0x6f").byteValue();
		buf[2] = pin;
		buf[3] = valLSB;
		buf[4] = valMSB;
		if (val > 0x00000080) buf[len++] = (byte)((val >> 8)  & 0xFF);
		if (val > 0x00004000) buf[len++] = (byte)((val >> 16) & 0xFF);
		if (val > 0x00200000) buf[len++] = (byte)((val >> 24) & 0xFF);
		if (val > 0x10000000) buf[len++] = (byte)((val >> 32) & 0xFF);
		
		buf[len++] = Integer.decode("0xf7").byteValue();
				
		byte[] bytes = new byte[len];
		
		System.arraycopy(buf, 0, bytes, 0, len);
		
		qCmd.setMessage(
			bytes
		);
		
		return qCmd;
	}
	

	//
	//
	// Generic Firmata I2C cmd dump
	//
	//
	/* 
	 * I2C read/write request
	 * -------------------------------
	 * 0  START_SYSEX (0xF0) (MIDI System Exclusive)
	 * 1  I2C_REQUEST (0x76)
	 * 2  slave address (LSB)
	 * 3  slave address (MSB) + read/write and address mode bits
	      {7: always 0} + {6: reserved} + {5: address mode, 1 means 10-bit mode} +
	      {4-3: read/write, 00 => write, 01 => read once, 10 => read continuously, 11 => stop reading} +
	      {2-0: slave address MSB in 10-bit mode, not used in 7-bit mode}
	 * 4  data 0 (LSB)
	 * 5  data 0 (MSB)
	 * 6  data 1 (LSB)
	 * 7  data 1 (MSB)
	 * ...
	 * n  END_SYSEX (0xF7)
	 */
	public Cmd createSETTING_FIRMATA_I2C_CMD(byte lsbSlaveAddr, FIRMATA_I2C_ADDR_MODE addrMode, FIRMATA_I2C_RW_MODE rwMode, byte i2c10bitsMsbSlaveAddr, int[] data) {
		if (data == null || data.length<=0) {
			throw new UnsupportedOperationException(
				"An I2C firmata command should embbed a non zero length byte[] message to be valid"
			);
		}
		FirmataSysexMessage qCmd = new FirmataSysexMessageImpl();
		qCmd.setAddr(Integer.decode("0xf0").byteValue());
		qCmd.setCmd(Integer.decode("0x76"));
		
		
		//
		// byte2 (msb)
		// 
		int b2Val = 0;
		
		// bit 7 : always 0
		// bit 6 : reserved
		
		// bit 5 : address mode, 1 means 10-bit mode
		switch (addrMode) {
			case I2C_ADDR_MODE_7BITS:
				// 0 means 7 bits addr mod : +0
				break;
			case I2C_ADDR_MODE_10_BITS:
				b2Val = b2Val | 16 ;
				// 1 means 10 bits addr mode : +16
				break;
		}
		
		// bits 4-3 : RW mode
		switch(rwMode) {
			case READ_CONTINUOUSLY: // 10 (+16)
				b2Val = b2Val | 8 ;
				break;
			case READ_ONCE: // 01 (+8)
				b2Val = b2Val | 4 ;
				break;
			case STOP_READING: // 11 (+24)
				b2Val = b2Val | 24 ;
				break;
			case WRITE: // 00
				b2Val = b2Val | 0 ;
				break;
		}
		
		// bits 2-0 : 10 bits byte addr MSB (2nd part)
		switch (addrMode) {
			case I2C_ADDR_MODE_7BITS:
				// 0 means 7 bits addr mod : +0
				break;
			case I2C_ADDR_MODE_10_BITS:
				// FIXME : Dig in ! 
				b2Val = (b2Val | (i2c10bitsMsbSlaveAddr & 196));  //0x11000000 ? or 0x00001100 ???
				break;
		}

		//
		// byte1 (lsb)
		//
		qCmd.setByte1(lsbSlaveAddr);
		//
		// byte2 (msb)
		//
		qCmd.setByte2((byte)b2Val);		
		
		byte[] bytes = new byte[data.length*2];
		
		for (int i=0; i<data.length; i++) {
			bytes[(2*i)] = (byte)(data[i] & 0xff); // lsb
			bytes[(2*i)+1] = (byte)((data[i] & 0x00) >> 8); // msb
		}
		
		qCmd.setMessage(bytes);
		qCmd.setMsgSize(bytes.length);
		
		return qCmd;
	}

	
	public Cmd createI2C_7BITS_FIRMATA_CMD(byte addr, int[] data, FIRMATA_I2C_RW_MODE mode) {
		return FirmataCmdUtils.INSTANCE.createSETTING_FIRMATA_I2C_CMD( 
				addr, 
				FIRMATA_I2C_ADDR_MODE.I2C_ADDR_MODE_7BITS, 
				mode, 
				Byte.decode("0x00"),
				data
		);	
	}
}
