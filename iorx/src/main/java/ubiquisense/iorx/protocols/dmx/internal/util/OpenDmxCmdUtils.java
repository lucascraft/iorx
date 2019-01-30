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

package ubiquisense.iorx.protocols.dmx.internal.util;

import java.util.Arrays;
import java.util.List;

import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXChangeOfStatePacketCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXChangeOfStatePacketCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXFade;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXFadeFullImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXFadeImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXFadeWithStrobeImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetParamRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetParamRequestCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetParamsReplyCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetParamsReplyCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetSerialNumberReplyCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetSerialNumberReplyCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetSerialNumberRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXGetWidgetSerialNumberRequestCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXOutputOnlySendDMXPacketsRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXOutputOnlySendDMXPacketsRequestCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXProgramFlashPageReply;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXProgramFlashPageReplyImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXProgramFlashPageRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXProgramFlashPageRequestCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXReceivedPacketsCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXReceivedPacketsCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXReprogramFirmwareRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXReprogramFirmwareRequestCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXSendRDMDiscoveryRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXSendRDMDiscoveryRequestCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXSendRDMPacketCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXSendRDMPacketCmdImpl;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXSetWidgetParamsRequestCmd;
import ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXSetWidgetParamsRequestCmdImpl;
import ubiquisense.iorx.utils.CmdUtil;

public class OpenDmxCmdUtils {
	public final static OpenDmxCmdUtils INSTANCE = new OpenDmxCmdUtils();
	
	private final static Byte BYTE_0X7E = (byte) 0x7e;
	private final static Byte BYTE_0XE7 = (byte) 0xe7;

	/*
	 * The Widget sends one or more instances of this message to the PC unsolicited, 
	 * whenever the Widget receives a changed DMX packet from the DMX port, 
	 * and the Receive DMX on Change mode is 'Send on data change only'.
	 */
	public ubiquisense.iorx.protocols.dmx.internal.model.OpenDMXChangeOfStatePacketCmd createOpenDMXChangeOfStatePacketRcvCmd(byte start, byte[] bits, byte[] data) {
		OpenDMXChangeOfStatePacketCmd dmxCmd = new OpenDMXChangeOfStatePacketCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(new Integer(9).byteValue());
		
		int length = 1 + bits.length + data.length;
		byte[] bytes = new byte[length];
		
		bytes[0] = start;
		
		System.arraycopy(bits, 0, bytes, 1, bits.length);
		System.arraycopy(data, 0, bytes, bits.length, data.length);

		dmxCmd.setData(bytes);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}

	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXGetWidgetParamRequestCmd createOpenDMXGetWidgetParamRequestCmd() {
		OpenDMXGetWidgetParamRequestCmd dmxCmd = new OpenDMXGetWidgetParamRequestCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXGetWidgetParamsReplyCmd createOpenDMXGetWidgetParamsReplyCmd() {
		OpenDMXGetWidgetParamsReplyCmd dmxCmd =new OpenDMXGetWidgetParamsReplyCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXGetWidgetSerialNumberReplyCmd createOpenDMXGetWidgetSerialNumberReplyCmd() {
		OpenDMXGetWidgetSerialNumberReplyCmd dmxCmd =  new OpenDMXGetWidgetSerialNumberReplyCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXGetWidgetSerialNumberRequestCmd createOpenDMXGetWidgetSerialNumberRequestCmd() {
		OpenDMXGetWidgetSerialNumberRequestCmd dmxCmd =  new OpenDMXGetWidgetSerialNumberRequestCmdImpl();
		dmxCmd.setStart((byte)0x7e);
		dmxCmd.setLabel(new Integer(10).byteValue());
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd((byte)0x7e);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXOutputOnlySendDMXPacketsRequestCmd createOpenDMXOutputOnlySendDMXPacketsRequestCmd() {
		OpenDMXOutputOnlySendDMXPacketsRequestCmd dmxCmd = new OpenDMXOutputOnlySendDMXPacketsRequestCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(new Integer(6).byteValue());
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	public OpenDMXProgramFlashPageReply createOpenDMXProgramFlashPageReply() {
		OpenDMXProgramFlashPageReply dmxCmd = new OpenDMXProgramFlashPageReplyImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	public OpenDMXProgramFlashPageRequestCmd createOpenDMXProgramFlashPageRequestCmd(byte[] pageData) {
		if (pageData == null || pageData.length!=64) {
			throw new UnsupportedOperationException("An OpenDMX program flash page should be exactly 64 byte long");
		}
		
		OpenDMXProgramFlashPageRequestCmd dmxCmd = new OpenDMXProgramFlashPageRequestCmdImpl();
		
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(pageData);
		dmxCmd.setEnd(BYTE_0XE7);
		
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXReceivedPacketsCmd createOpenDMXReceivedPacketsCmd() {
		OpenDMXReceivedPacketsCmd dmxCmd = new OpenDMXReceivedPacketsCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	/*
	 * OK
	 */
	public OpenDMXReprogramFirmwareRequestCmd createOpenDMXReprogramFirmwareRequestCmd() {
		OpenDMXReprogramFirmwareRequestCmd dmxCmd = new OpenDMXReprogramFirmwareRequestCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x01"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXSendRDMDiscoveryRequestCmd createOpenDMXSendRDMDiscoveryRequestCmd() {
		OpenDMXSendRDMDiscoveryRequestCmd dmxCmd = new OpenDMXSendRDMDiscoveryRequestCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(new Integer(11).byteValue());
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXSendRDMPacketCmd createOpenDMXSendRDMPacketCmd() {
		OpenDMXSendRDMPacketCmd dmxCmd = new OpenDMXSendRDMPacketCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXSetWidgetParamsRequestCmd createOpenDMXSetWidgetParamsRequestCmd() {
		OpenDMXSetWidgetParamsRequestCmd dmxCmd = new OpenDMXSetWidgetParamsRequestCmdImpl();
		dmxCmd.setStart(BYTE_0X7E);
		dmxCmd.setLabel(Byte.decode("0x02"));
		dmxCmd.setData(new byte[0]);
		dmxCmd.setEnd(BYTE_0XE7);
		return dmxCmd;
	}
	
	public OpenDMXCmd createOpenDMXFadeRGBCmd(int channel, int rValue, int gValue, int bValue) {
		OpenDMXFade dmxCmd =  new OpenDMXFadeImpl();
		dmxCmd.setStart((byte) 0x7e);
		dmxCmd.setLabel((byte) 0x06);
		dmxCmd.setData(new byte[] { (byte)channel, (byte)rValue, (byte)gValue, (byte)bValue});
		dmxCmd.setEnd((byte) 0xe7);
		return dmxCmd;
	}
	
	public OpenDMXCmd createOpenDMXFadeRGBWithStrobeCmd(int channel, int rValue, int gValue, int bValue, int strobe) {
		OpenDMXFade dmxCmd =  new OpenDMXFadeWithStrobeImpl();
		dmxCmd.setStart((byte) 0x7e);
		dmxCmd.setLabel((byte) 0x06);
		dmxCmd.setData(new byte[] { (byte)channel, (byte)strobe, (byte)rValue, (byte)gValue, (byte)bValue});
		dmxCmd.setEnd((byte) 0xe7);
		return dmxCmd;
	}
	
	public OpenDMXCmd createOpenDMXFadeRGBFullCmd(int rValue, int gValue, int bValue, int fullColor, int strobe, int modi, int ext) {
		OpenDMXFadeFullImpl dmxCmd = new OpenDMXFadeFullImpl();
		dmxCmd.setStart((byte) 0x7e);
		dmxCmd.setLabel((byte) 0x06);
		dmxCmd.setData(new byte[] { (byte)rValue, (byte)gValue, (byte)bValue, (byte)fullColor, (byte)strobe, (byte)modi, (byte)ext});
		dmxCmd.setEnd((byte) 0xe7);
		return dmxCmd;
	}
	
	public OpenDMXCmd createOpenDMXFadeLRGBFullCmd(int lValue, int rValue, int gValue, int bValue) {
		OpenDMXFadeFullImpl dmxCmd = new OpenDMXFadeFullImpl();
		dmxCmd.setStart((byte) 0x7e);
		dmxCmd.setLabel((byte) 0x06);
		dmxCmd.setData(new byte[] { (byte)lValue, (byte)rValue, (byte)gValue, (byte)bValue});
		dmxCmd.setEnd((byte) 0xe7);
		return dmxCmd;
	}
	public OpenDMXCmd createOpenDMXFadeRGBFullCmd(int rValue, int gValue, int bValue) {
		OpenDMXFadeFullImpl dmxCmd = new OpenDMXFadeFullImpl();
		dmxCmd.setStart((byte) 0x7e);
		dmxCmd.setLabel((byte) 0x06);
		dmxCmd.setData(new byte[] { (byte)rValue, (byte)gValue, (byte)bValue});
		dmxCmd.setEnd((byte) 0xe7);
		return dmxCmd;
	}
	public OpenDMXCmd createOpenDMXCmd(byte[] bytes) {
		OpenDMXFade dmxCmd =  new OpenDMXFadeImpl();
		dmxCmd.setStart((byte) 0x7e);
		dmxCmd.setLabel((byte) 0x06);
		dmxCmd.setData(bytes);
		dmxCmd.setEnd((byte) 0xe7);
		return dmxCmd;
	}
	
	//
	// Conversion
	//
	
	// FIXME : go deeper while understanding the OpenDMX spec 
	public OpenDMXCmd createDMXCommandFromFrame(byte[] frame) {
		if (frame == null || frame.length < 5) {
			throw new UnsupportedOperationException("OpenDMX frame is not supported yet. Frame was " + CmdUtil.INSTANCE.getFrameHexInfo(frame));
		}
		
		//
		// right frame first byte ???
		//
		if (!Byte.valueOf(frame[0]).equals(BYTE_0X7E)) {
			// Good news : bouncing bad frame ... 
			throw new UnsupportedOperationException("OpenDMX frame should have a first byte as 0x7e. Frame was " + CmdUtil.INSTANCE.getFrameHexInfo(frame));
		}
		
		// Lets look at the label 
		switch (Byte.valueOf(frame[1]).intValue()) {
			case 7:
				// Firmware Ver MSB 1 : Send RDM Not supported !!!
				break;
			case 11:
				// Firmware Ver MSB 1 : RDM Discovery request Not supported !!!
				break;
			case 8:
				// Firmware Ver MSB 2 : Receive DMX on change Not supported !!!
				break;
			case 9:
				// Firmware Ver MSB 2 : Change on state receive Not supported !!!
				break;
			default:
				break;
		}
		
		return null;
	}

	/**
	 * Dump as byte[] the current valuation of an OpenDMX command
	 * 
	 * @param dmxCmd an OpenDMX command
	 * 
	 * @return the byte[] form of the given OpenDMX command
	 */
	public byte[] dumpOpenDMXCmd(OpenDMXCmd dmxCmd) {
		return dumpOpenDMXCmd(dmxCmd, dmxCmd.getChannel());
	}
	
	public byte[] dumpOpenDMXCmd(List<OpenDMXCmd> dmxCmd) {
		byte[] frame = new byte[5 + 512 + 1];
		Arrays.fill(frame, (byte)0x00);
		for (OpenDMXCmd cmd : dmxCmd)
		{
			dumpOpenDMXCmd(cmd, cmd.getChannel(), false, frame);
		}
		return frame;
	}
	
	private byte[] dumpOpenDMXCmd(OpenDMXCmd dmxCmd, int channel) {
		return dumpOpenDMXCmd(dmxCmd, channel, true, new byte[5 + 512 + 1]);
	}
	
	/**
	 * Dump as byte[] the current valuation of an OpenDMX command
	 * 
	 * @param dmxCmd an OpenDMX command
	 * 
	 * @return the byte[] form of the given OpenDMX command
	 */
	private byte[] dumpOpenDMXCmd(OpenDMXCmd dmxCmd, int channel, boolean forceFillZero, byte[] frame) {
		if (dmxCmd !=null) {
			int dataLength = 512 + 1;
			if (forceFillZero)
			{
				Arrays.fill(frame, (byte) 0);
			}
			frame[0] = (byte) 0x7e; 
			frame[1] = dmxCmd.getLabel();
			frame[2] = (byte) (dataLength & 255);
			frame[3] = (byte) ((dataLength >> 8) & 255);
			frame[4] = (byte) 0; 
			frame[512+5] = (byte) 0xe7;
			System.arraycopy(dmxCmd.getData(), 0, frame, 4+channel, dmxCmd.getData().length);
			return frame;
		}
		return new byte[0];
	}
	
	//
	// Short hand
	//
	
	public OpenDMXCmd createFadeRGB(int channel, int rValue, int gValue, int bValue)
	{
		OpenDMXCmd dmxCmd = createOpenDMXFadeRGBFullCmd(rValue, gValue, bValue);
		dmxCmd.setChannel(channel);
		return dmxCmd;
	}
	
	public OpenDMXCmd createFadeBRG(int channel, int rValue, int gValue, int bValue)
	{
		OpenDMXCmd dmxCmd = createOpenDMXFadeRGBFullCmd(bValue, rValue, gValue);
		dmxCmd.setChannel(channel);
		return dmxCmd;
	}
	
	public OpenDMXCmd createFadeLRGB(int channel, int lValue, int rValue, int gValue, int bValue)
	{
		OpenDMXCmd dmxCmd = createOpenDMXFadeLRGBFullCmd(lValue, rValue, gValue, bValue);
		dmxCmd.setChannel(channel);
		return dmxCmd;
	}
}

