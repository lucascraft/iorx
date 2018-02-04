/***********************************************************************************
 * Ubiquisense - A smart ambient utilities framework 
 * 
 * Copyright (c) 2008 - 2010, Lucas Bigeardel
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

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FIRMATA_I2C_RW_MODE;

public class ThingM4FirmataCmdUtils {

	public static final ThingM4FirmataCmdUtils INSTANCE = new ThingM4FirmataCmdUtils();

    //
    //
    // I2C over Firmata utils
    //
    //
   
//	public Cmd createThingM4FimataStopScriptCmd(byte addr) {
//		StopScriptCmd blinkmCmd = BlinkMUtil.INSTANCE.createStopScriptCmd(Byte.toString(addr));
//		return FirmataCmdUtils.INSTANCE.createI2C_7BITS_FIRMATA_CMD (
//			addr, 
//			blinkmCmd.getCmdByte(), 
//			new int[]{}, 
//			FIRMATA_I2C_RW_MODE.WRITE
//		);
//	}
	
	public Cmd createThingM4FimataFadeToRGBCmd(String addr, int r, int g, int b) {
		return  FirmataCmdUtils.INSTANCE.createI2C_7BITS_FIRMATA_CMD (
			Byte.decode(addr), // Firmata I2C slave address
			new int[] {
				Byte.decode("0x63"),
				r,
				g,
				b,
			},
			FIRMATA_I2C_RW_MODE.WRITE
		);
	}
}
