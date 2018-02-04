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

public class ArduinoPinEventAdapter {/*implements Adapter {
	
	@Override
	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.SET ||
				notification.getEventType() == Notification.UNSET) {
			if (notification.getFeature().equals(ArduinoPackage.Literals.ANALOG_PORT__VALUE) ||
					notification.getFeature().equals(ArduinoPackage.Literals.DIGITAL_PORT__VALUE)) {
				Arduino arduinoBoard = (Arduino) ((Port)notification.getNotifier()).eContainer();
				synchronized (arduinoBoard) {
					if (arduinoBoard != null) {
						if (notification.getNotifier() instanceof DigitalPort) {
							for (IPortListener listener : arduinoBoard.getPortsToListen()) {
								if (listener.getMonitoredPort().equals(((DigitalPort)notification.getNotifier()).getMap())) {
									Object oldObjVal = notification.getOldValue();
									Object newObjVal = notification.getNewValue();
									if (oldObjVal instanceof Integer && newObjVal instanceof Integer) {
										listener.handleDigitalOutputMessage(
											(DigitalPort)notification.getNotifier(), 
											(Integer)oldObjVal, 
											(Integer)newObjVal
										);
									}
								}
							}
						} else if (notification.getNotifier() instanceof AnalogPort) {
							for (IPortListener listner : arduinoBoard.getPortsToListen()) {
								if (listner.getMonitoredPort().equals(((AnalogPort)notification.getNotifier()).getMap())) {
									Object oldObjVal = notification.getOldValue();
									Object newObjVal = notification.getNewValue();
									if (oldObjVal instanceof Float && newObjVal instanceof Float) {
										listner.handleAnalogicOutputMessage(
											(AnalogPort)notification.getNotifier(), 
											(Float)oldObjVal, 
											(Float)newObjVal
										);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {

	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}
	*/
}
