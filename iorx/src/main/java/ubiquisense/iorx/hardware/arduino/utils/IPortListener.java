
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
