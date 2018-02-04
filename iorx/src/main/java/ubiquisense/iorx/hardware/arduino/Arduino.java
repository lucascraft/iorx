/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;

import java.util.List;

import ubiquisense.iorx.hardware.arduino.utils.IPortListener;

public interface Arduino {
	void addPortIOMessagListner(IPortListener listener);

	void removePortIOMessagListner(IPortListener listener);

	List<IPortListener> getPortsToListen();

	ARDUINO_VER_BRAND_NAME getVer();

	void setVer(ARDUINO_VER_BRAND_NAME value);

	List<Port> getCommPorts();

	DigitalPort getDigitalPortFromChannel(int channel);

	AnalogPort getAnalogicPortFromChannel(int channel);

	ARDUINO_BOARD_KIND getBoard();

	void setBoard(ARDUINO_BOARD_KIND value);

	ARDUINO_ATMEGA_168_SERIES getSeries();

	void setSeries(ARDUINO_ATMEGA_168_SERIES value);

	List<DigitalPort> getDigitalPorts();

	List<AnalogPort> getAnalogPorts();

	TxPort getTx();

	void setTx(TxPort value);

	List<GndPort> getGroundPorts();

	RxPort getRx();

	void setRx(RxPort value);

	Port3V3 getPwm3V3();

	void setPwm3V3(Port3V3 value);

	String getLabel();

	void setLabel(String value);

	ARDUINO_COMM getComm();

	void setComm(ARDUINO_COMM value);

	RstPort getResetPort();

	void setResetPort(RstPort value);

	Port9V getPwm9V();

	void setPwm9V(Port9V value);

	Port5V getPwm5V();

	void setPwm5V(Port5V value);

	PortIO7 getIo7();

	void setIo7(PortIO7 value);

	PortVIN getVin();

	void setVin(PortVIN value);

	AREFPort getAref();

	void setAref(AREFPort value);

	ARDUINO_FIRMWARE_MODE getFirmataMode();

	void setFirmataMode(ARDUINO_FIRMWARE_MODE value);

	PIN_MAPPING getLockedPin();

	void setLockedPin(PIN_MAPPING value);

	boolean isSynchronizing();

	void setSynchronizing(boolean value);

	ARDUINO_STATUS_MODE getStatus();

	void setStatus(ARDUINO_STATUS_MODE value);

	ARDUINO_BOARD_UID getKind();

	void setKind(ARDUINO_BOARD_UID value);

	String getName();

	void setName(String value);

	void digitalIOMessage(float data, PIN_MAPPING pin);

	void analogIOMessage(float data, PIN_MAPPING pin);

	void reportAnalogPin(ARDUINO_REPORT_MODE mode, PIN_MAPPING pin);

	void reportDigitalPin(ARDUINO_REPORT_MODE mode, PIN_MAPPING pin);

	boolean synchronizingArduinoModel(PIN_MAPPING pin);

	boolean synchronizingArduinoHardware(PIN_MAPPING pin);

	AnalogPort getAnalogicPort(PIN_MAPPING pin);

	DigitalPort getDigitalPort(PIN_MAPPING pin);

	AnalogPort getAnalogicPort(int pin);

	DigitalPort getDigitalPort(int pin);

	List<Port> getPorts();

} // Arduino
