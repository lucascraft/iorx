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

package ubiquisense.iorx.hardware.arduino.utils;

import ubiquisense.iorx.hardware.arduino.AnalogPort;
import ubiquisense.iorx.hardware.arduino.DigitalPort;
import ubiquisense.iorx.hardware.arduino.PIN_MAPPING;

public interface IPortListener {
	/**
	 * Get monitored {@link PIN_MAPPING} port
	 * 
	 * @return monitored {@link PIN_MAPPING} port
	 */
	public PIN_MAPPING getMonitoredPort();
	
	/**
	 * Handle digital output message values
	 * 
	 * @param port {@link DigitalPort} port to monitor output values from
	 * @param oldValue old value
	 * @param newValue new value
	 */
	public void handleDigitalOutputMessage(DigitalPort port, int oldValue, int newValue);
	
	/**
	 * Handle analog output message values
	 * 
	 * @param port {@link AnalogPort} port to monitor output values from
	 * @param oldValue old value
	 * @param newValue new value
	 */
	public void handleAnalogicOutputMessage(AnalogPort port, float oldValue, float newValue);
	
	/**
	 * Handle digital input message values
	 * 
	 * @param port {@link DigitalPort} port to monitor input values from
	 * @param oldValue old value
	 * @param newValue new value
	 */
	public void handleDigitalInputMessage(DigitalPort port, int oldValue, int newValue);
	
	/**
	 * Handle digital input message values
	 * 
	 * @param port {@link AnalogPort} port to monitor input values from
	 * @param oldValue old value
	 * @param newValue new value
	 */
	public void handleAnalogicInputMessage(AnalogPort port, float oldValue, float newValue);
	
	/**
	 * Handle digital input port mode changes
	 * 
	 * @param port {@link DigitalPort} port to monitor mode from
	 * @param oldValue old value
	 * @param newValue new value
	 */
	public void handleDigitalPortModeChange(DigitalPort port, float oldValue, float newValue);
}
