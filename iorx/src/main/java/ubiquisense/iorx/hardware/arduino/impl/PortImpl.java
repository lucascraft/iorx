/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino.impl;

import ubiquisense.iorx.hardware.arduino.ARDUINO_REPORT_MODE;
import ubiquisense.iorx.hardware.arduino.PIN_MAPPING;
import ubiquisense.iorx.hardware.arduino.Port;


public class PortImpl  implements Port {
	PIN_MAPPING map;
	ARDUINO_REPORT_MODE report;
	String name;
	int channel;
	
	public PIN_MAPPING getMap() {
		return map;
	}

	public void setMap(PIN_MAPPING newMap) {
		map = newMap;
	}

	public ARDUINO_REPORT_MODE getReport() {
		return report;
	}

	public void setReport(ARDUINO_REPORT_MODE newReport) {
		report = newReport;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int newChannel) {
		channel = newChannel;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

} //PortImpl
