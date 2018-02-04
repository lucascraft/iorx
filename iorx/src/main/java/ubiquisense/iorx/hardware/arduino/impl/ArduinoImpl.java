/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino.impl;

import java.util.ArrayList;
import java.util.List;

import ubiquisense.iorx.hardware.arduino.ARDUINO_ATMEGA_168_SERIES;
import ubiquisense.iorx.hardware.arduino.ARDUINO_BOARD_KIND;
import ubiquisense.iorx.hardware.arduino.ARDUINO_BOARD_UID;
import ubiquisense.iorx.hardware.arduino.ARDUINO_COMM;
import ubiquisense.iorx.hardware.arduino.ARDUINO_FIRMWARE_MODE;
import ubiquisense.iorx.hardware.arduino.ARDUINO_REPORT_MODE;
import ubiquisense.iorx.hardware.arduino.ARDUINO_STATUS_MODE;
import ubiquisense.iorx.hardware.arduino.ARDUINO_VER_BRAND_NAME;
import ubiquisense.iorx.hardware.arduino.AREFPort;
import ubiquisense.iorx.hardware.arduino.AnalogPort;
import ubiquisense.iorx.hardware.arduino.Arduino;
import ubiquisense.iorx.hardware.arduino.DigitalPort;
import ubiquisense.iorx.hardware.arduino.GndPort;
import ubiquisense.iorx.hardware.arduino.PIN_MAPPING;
import ubiquisense.iorx.hardware.arduino.Port;
import ubiquisense.iorx.hardware.arduino.Port3V3;
import ubiquisense.iorx.hardware.arduino.Port5V;
import ubiquisense.iorx.hardware.arduino.Port9V;
import ubiquisense.iorx.hardware.arduino.PortIO7;
import ubiquisense.iorx.hardware.arduino.PortVIN;
import ubiquisense.iorx.hardware.arduino.RstPort;
import ubiquisense.iorx.hardware.arduino.RxPort;
import ubiquisense.iorx.hardware.arduino.TxPort;
import ubiquisense.iorx.hardware.arduino.utils.IPortListener;

public class ArduinoImpl  implements Arduino {
	ARDUINO_BOARD_KIND board;
	ARDUINO_VER_BRAND_NAME brandName; 
	ARDUINO_ATMEGA_168_SERIES series;
	 List<DigitalPort> digitalPorts;
	 List<AnalogPort> analogPorts;
	 List<GndPort> gndPorts;
	 TxPort txPort;
	 RxPort rxPort;
	 Port3V3 port3V3;
	 ARDUINO_COMM comm;
	 String label;
	 RstPort rstPort;
	 Port9V port9V;
	 Port5V port5V;
	 PortIO7 portIO7;
	 PortVIN portVIN;
	 AREFPort aREFPort;
	 ARDUINO_FIRMWARE_MODE firmware;
	 PIN_MAPPING lockedPin;
	 ARDUINO_STATUS_MODE status;
	 boolean synchronizing;
	 ARDUINO_BOARD_UID kind;
	 String name;
	 
	 public ArduinoImpl() {
		 digitalPorts = new ArrayList<DigitalPort>();
		 analogPorts = new ArrayList<AnalogPort>();
		 gndPorts = new ArrayList<GndPort>();
	 }
	private List<IPortListener> portListeners;
	
	public void addPortIOMessagListner(IPortListener listener) {
		if (!portListeners.contains(listener)) {
			portListeners.add(listener);
		}
	}
	
	public void removePortIOMessagListner(IPortListener listener) {
		if (portListeners.contains(listener)) {
			portListeners.remove(portListeners.indexOf(listener));
		}
	}
	
	public List<IPortListener> getPortsToListen() {
		return portListeners;
	}
	
	


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_VER_BRAND_NAME getVer() {
		return brandName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVer(ARDUINO_VER_BRAND_NAME newVer) {
		brandName = newVer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<Port> getCommPorts() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DigitalPort getDigitalPortFromChannel(int channel) {
		for (DigitalPort p : getDigitalPorts()) {
			if (p.getChannel() == channel) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AnalogPort getAnalogicPortFromChannel(int channel) {
		for (AnalogPort p : getAnalogPorts()) {
			if (p.getChannel() == channel) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_BOARD_KIND getBoard() {
		return board;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoard(ARDUINO_BOARD_KIND newBoard) {
		board = newBoard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_ATMEGA_168_SERIES getSeries() {
		return series;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeries(ARDUINO_ATMEGA_168_SERIES newSeries) {
		series = newSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<DigitalPort> getDigitalPorts() {
		return digitalPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<AnalogPort> getAnalogPorts() {
		return analogPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxPort getTx() {
		return txPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTx(TxPort newTx) {
		txPort = newTx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<GndPort> getGroundPorts() {
		return gndPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RxPort getRx() {
		return rxPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRx(RxPort newRx) {
		rxPort = newRx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port3V3 getPwm3V3() {
		return port3V3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPwm3V3(Port3V3 newPwm3V3) {
		port3V3 = newPwm3V3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		label = newLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_COMM getComm() {
		return comm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComm(ARDUINO_COMM newComm) {
		comm = newComm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RstPort getResetPort() {
		return rstPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetPort(RstPort newResetPort) {
		rstPort = newResetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port9V getPwm9V() {
		return port9V;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPwm9V(Port9V newPwm9V) {
		port9V = newPwm9V;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port5V getPwm5V() {
		return port5V;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPwm5V(Port5V newPwm5V) {
		port5V = newPwm5V;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortIO7 getIo7() {
		return portIO7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIo7(PortIO7 newIo7) {
		portIO7 = newIo7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortVIN getVin() {
		return portVIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVin(PortVIN newVin) {
		portVIN = newVin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AREFPort getAref() {
		return aREFPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAref(AREFPort newAref) {
		aREFPort = newAref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_FIRMWARE_MODE getFirmataMode() {
		return firmware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirmataMode(ARDUINO_FIRMWARE_MODE newFirmataMode) {
		firmware = newFirmataMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PIN_MAPPING getLockedPin() {
		return lockedPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLockedPin(PIN_MAPPING newLockedPin) {
		lockedPin = newLockedPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSynchronizing() {
		return synchronizing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronizing(boolean newSynchronizing) {
		synchronizing = newSynchronizing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_STATUS_MODE getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(ARDUINO_STATUS_MODE newStatus) {
		status = newStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARDUINO_BOARD_UID getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ARDUINO_BOARD_UID newKind) {
		kind = newKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void digitalIOMessage(float data, PIN_MAPPING pin) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void digitalIOMessage(int data, PIN_MAPPING pin) {
		for (Port p : getPorts()) {
			if (p.getMap().equals(pin)) {
				((DigitalPort)p).setValue(data);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void analogIOMessage(float data, PIN_MAPPING pin) {
		for (Port p : getPorts()) {
			if (p.getMap().equals(pin)) {
				((AnalogPort)p).setValue(data);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reportAnalogPin(ARDUINO_REPORT_MODE mode, final PIN_MAPPING pin) {
		for (Port p : getPorts()) {
			if (p.getMap().equals(pin)) {
				p.setReport(
					mode == ARDUINO_REPORT_MODE.ACTIVATE ? 
						ARDUINO_REPORT_MODE.DEACTIVATE : 
						ARDUINO_REPORT_MODE.ACTIVATE
				);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reportDigitalPin(ARDUINO_REPORT_MODE mode, PIN_MAPPING pin) {
		for (Port p : getPorts()) {
			if (p.getMap().equals(pin)) {
				p.setReport(
					mode == ARDUINO_REPORT_MODE.ACTIVATE ? 
					ARDUINO_REPORT_MODE.DEACTIVATE : 
					ARDUINO_REPORT_MODE.ACTIVATE
				);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean synchronizingArduinoModel(PIN_MAPPING pin) {
		return pin.equals(getLockedPin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean synchronizingArduinoHardware(PIN_MAPPING pin) {
		return pin.equals(getLockedPin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AnalogPort getAnalogicPort(PIN_MAPPING pin) {
		for (AnalogPort p : getAnalogPorts()) {
			if (p.getMap().equals(pin)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DigitalPort getDigitalPort(PIN_MAPPING pin) {
		for (DigitalPort p : getDigitalPorts()) {
			if (p.getMap().equals(pin)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AnalogPort getAnalogicPort(int pin) {
		for (AnalogPort p : getAnalogPorts()) {
			if (p.getMap().getValue() == pin) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DigitalPort getDigitalPort(int pin) {
		for (DigitalPort p : getDigitalPorts()) {
			if (p.getMap().getValue() == pin) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Port> getPorts() {
		List<Port> lst = new ArrayList<Port>();
		lst.addAll(digitalPorts);
		lst.addAll(analogPorts);
		lst.addAll(gndPorts);
		lst.add(txPort);
		lst.add(rxPort);
		lst.add(port3V3);
		lst.add(rstPort);
		lst.add(port9V);
		lst.add(port5V);
		lst.add(portIO7);
		lst.add(portVIN);
		lst.add(aREFPort);
		return lst;
	}

} //ArduinoImpl
