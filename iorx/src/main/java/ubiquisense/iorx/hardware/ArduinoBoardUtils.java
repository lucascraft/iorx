
package ubiquisense.iorx.hardware;

import java.util.HashMap;
import java.util.Map;

import ubiquisense.iorx.hardware.arduino.ARDUINO_ATMEGA_168_SERIES;
import ubiquisense.iorx.hardware.arduino.ARDUINO_BOARD_KIND;
import ubiquisense.iorx.hardware.arduino.ARDUINO_BOARD_UID;
import ubiquisense.iorx.hardware.arduino.ARDUINO_COMM;
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
import ubiquisense.iorx.hardware.arduino.RstPort;
import ubiquisense.iorx.hardware.arduino.RxPort;
import ubiquisense.iorx.hardware.arduino.TxPort;
import ubiquisense.iorx.hardware.arduino.impl.AREFPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.AnalogPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.ArduinoImpl;
import ubiquisense.iorx.hardware.arduino.impl.DigitalPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.GndPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.Port3V3Impl;
import ubiquisense.iorx.hardware.arduino.impl.Port5VImpl;
import ubiquisense.iorx.hardware.arduino.impl.Port9VImpl;
import ubiquisense.iorx.hardware.arduino.impl.PortIO7Impl;
import ubiquisense.iorx.hardware.arduino.impl.PortImpl;
import ubiquisense.iorx.hardware.arduino.impl.PortVINImpl;
import ubiquisense.iorx.hardware.arduino.impl.RstPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.RxPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.TxPortImpl;


public class ArduinoBoardUtils {
	public final static ArduinoBoardUtils INSTANCE = new ArduinoBoardUtils();
	
	private Map<ARDUINO_BOARD_UID, Arduino> commonArduinoDevices;
	
	public ArduinoBoardUtils() {
		initSupportedDevices();
	}
	
	/**
	 * So far only Diecimila168, Mini168, Mini328, Duemilanove ATmega328, 
	 * Duemilanove ATmega168, FunnelIO ATmega328P, Leonardo ATMega32U4, 
	 * Uno ATMega328
	 * 
	 * @return Map of supported Arduino boards, to be continued ...
	 */
	public Map<ARDUINO_BOARD_UID, Arduino> getSupportedArduinoDevices() {
		return commonArduinoDevices;
	}
	
	void initSupportedDevices() {
		commonArduinoDevices = new HashMap<ARDUINO_BOARD_UID, Arduino>();
		
		//
		// Unknown board
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.PLACEHOLDER_VOID_BOARD,
			initArduinoBoardDefinition(
				"Unknown Arduino", 
				ARDUINO_BOARD_KIND.UNKNOWN, 
				ARDUINO_ATMEGA_168_SERIES.UNKNOWN, 
				ARDUINO_COMM.USB, 
				ARDUINO_VER_BRAND_NAME.UNKNOWN
			)
		);
		
		//
		// Diecimila 168
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.DIECMILA_ATMEGA_168,
			initPortsDiecimilaOrDuemilanoveOrUnoOrLeonardo(
				initArduinoBoardDefinition(
					"Arduino Diecimila ATmega168", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_DIECIMILA, 
					ARDUINO_COMM.USB, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_DIECIMILA
				)
			)
		);
		
		//
		// Mini 168
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.MINI_ATMEGA_168,
			initPortsMini(
				initArduinoBoardDefinition(
					"Arduino Mini ATmega168", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_DIECIMILA, 
					ARDUINO_COMM.NONE, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_MINI
				)
			)
		);
		
		//
		// Mini 328
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.MINI_ATMEGA_168,
			initPortsMini(
				initArduinoBoardDefinition(
					"Arduino Mini ATmega328", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_328, 
					ARDUINO_COMM.NONE, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_MINI
				)
			)
		);
		
		//
		// Duemilanove ATmega168
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.DUEMILANOVE_ATMEGA_168,
			initPortsDiecimilaOrDuemilanoveOrUnoOrLeonardo(
				initArduinoBoardDefinition(
					"Arduino Duemilanove ATmega168", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_168, 
					ARDUINO_COMM.USB, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_DUEMILANOVE
				)
			)
		);
		
		//
		// Duemilanove ATmega328
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.DUEMILANOVE_ATMEGA_328,
			initPortsDiecimilaOrDuemilanoveOrUnoOrLeonardo(
				initArduinoBoardDefinition(
					"Arduino Duemilanove ATmega328", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_328, 
					ARDUINO_COMM.USB, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_DUEMILANOVE
				)
			)	
		);
		
		//
		// FunnelIO ATmega328P
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.FUNNEL_IO_ATMEGA328P,
			initPortsFunnelIO(
				initArduinoBoardDefinition(
					"FunnelIO", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_328, 
					ARDUINO_COMM.XBEE_SERIES_1, 
					ARDUINO_VER_BRAND_NAME.FUNNEL_IO
				)
			)
		);
		
		//
		// Leonardo ATmega32U4
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.LEONARDO_ATMEGA32U4,
			initPortsDiecimilaOrDuemilanoveOrUnoOrLeonardo(
				initArduinoBoardDefinition(
					"Leonardo", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_32U4, 
					ARDUINO_COMM.MINI_USB, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_LEONARDO
				)
			)
		);
		
		//
		// Leonardo ATmega32U4
		//
		commonArduinoDevices.put(
			ARDUINO_BOARD_UID.UNO_ATMEGA328,
			initPortsDiecimilaOrDuemilanoveOrUnoOrLeonardo(
				initArduinoBoardDefinition(
					"Uno", 
					ARDUINO_BOARD_KIND.ATMEGA_168, 
					ARDUINO_ATMEGA_168_SERIES._168_ATMEGA_328, 
					ARDUINO_COMM.USB, 
					ARDUINO_VER_BRAND_NAME.ARDUINO_UNO
				)
			)
		);
		
		//
		// ... More to come ...
		//
	}
	
	private Arduino initArduinoBoardDefinition(
			String label, 
			ARDUINO_BOARD_KIND kind,
			ARDUINO_ATMEGA_168_SERIES series, 
			ARDUINO_COMM comm,
			ARDUINO_VER_BRAND_NAME version) {
		Arduino arduino = new ArduinoImpl();
		
		arduino.setLabel(label);
		arduino.setBoard(kind);
		arduino.setSeries(series);
		arduino.setVer(version);
		arduino.setComm(comm);
		
		return arduino;
	}
	
	Port createPortsFIO(PIN_MAPPING mapping) {
		Port port = new PortImpl();
		switch(mapping) {
			case PIN_AREF:
				port = new AREFPortImpl();
				break;
			case PIN_3V3_1:
			case PIN_3V3_2:
				 port = new Port3V3Impl();
				break;
			case PIN_5V:
				 port = new Port5VImpl();
				break;
			case PIN_9V:
				 port = new Port9VImpl();
				break;
			case PIN_A0:
			case PIN_A1:
			case PIN_A2:
			case PIN_A3:
			case PIN_A4:
			case PIN_A5:
			case PIN_A6:
			case PIN_A7:
				 port = new AnalogPortImpl();
				break;
			case PIN_D2:
			case PIN_D3:
			case PIN_D4:
			case PIN_D5:
			case PIN_D6:
			case PIN_D7:
			case PIN_D8:
			case PIN_D9:
			case PIN_D10:
			case PIN_D11:
			case PIN_D12:
			case PIN_D13:
			case PIN_D14:
			case PIN_D15:
			case PIN_D16:
			case PIN_D17:
			case PIN_D18:
			case PIN_D19:
			case PIN_D20:
			case PIN_D21:
			case PIN_D22:
			case PIN_D23:
			case PIN_D24:
			case PIN_D25:
			case PIN_D26:
			case PIN_D27:
			case PIN_D28:
			case PIN_D29:
			case PIN_D30:
			case PIN_D31:
			case PIN_D32:
			case PIN_D33:
			case PIN_D34:
			case PIN_D35:
			case PIN_D36:
			case PIN_D37:
			case PIN_D38:
			case PIN_D39:
			case PIN_D40:
			case PIN_D41:
			case PIN_D42:
			case PIN_D43:
			case PIN_D44:
			case PIN_D45:
			case PIN_D46:
			case PIN_D47:
			case PIN_D48:
			case PIN_D49:
			case PIN_D50:
			case PIN_D51:
			case PIN_D52:
				 port = new DigitalPortImpl();
				break;
			case PIN_GND_3V:
			case PIN_GND_9V:
			case PIN_GND_D:
				 port = new GndPortImpl();
				break;
			case PIN_RST:
				 port = new RstPortImpl();
				break;
			case PIN_RX:
				 port = new RxPortImpl();
				 break;
			case PIN_TX:
			case PIN_TX_I:
			case PIN_TX_O:
				 port = new TxPortImpl();
				break;
			case PIN_IO7:
				 port = new PortIO7Impl();
				break;
			case PIN_VIN:
				 port = new PortVINImpl();
				break;
		};
		port.setMap(mapping);
		return port;
	}

	
	private Arduino initPortsFunnelIO(Arduino arduino) {
		Port3V3 PIN_3V3_1 = (Port3V3) createPortsFIO(PIN_MAPPING.PIN_3V3_1);
		AnalogPort PIN_A0 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A0);
		AnalogPort PIN_A1 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A1);
		AnalogPort PIN_A2 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A2);
		AnalogPort PIN_A3 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A3);
		AnalogPort PIN_A4 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A4);
		AnalogPort PIN_A5 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A5);
		AnalogPort PIN_A6 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A6);
		AnalogPort PIN_A7 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A7);
		DigitalPort PIN_D2 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D2);
		DigitalPort PIN_D3 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D3);
		DigitalPort PIN_D4 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D4);
		DigitalPort PIN_D5 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D5);
		DigitalPort PIN_D6 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D6);
		DigitalPort PIN_D7 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D7);
		DigitalPort PIN_D8 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D8);
		DigitalPort PIN_D9 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D9);
		DigitalPort PIN_D10 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D10);
		DigitalPort PIN_D11 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D11);
		DigitalPort PIN_D12 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D12);
		DigitalPort PIN_D13 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D13);
		GndPort PIN_GND_1 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_3V);
		GndPort PIN_GND_2 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_9V);
		RxPort PIN_RX = (RxPort) createPortsFIO(PIN_MAPPING.PIN_RX);
		TxPort PIN_TX = (TxPort) createPortsFIO(PIN_MAPPING.PIN_TX);
		RstPort PIN_RST = (RstPort) createPortsFIO(PIN_MAPPING.PIN_RST);
		
		//
		// Analog ports
		//
		
		arduino.getAnalogPorts().add(PIN_A0);
		arduino.getAnalogPorts().add(PIN_A1);
		arduino.getAnalogPorts().add(PIN_A2);
		arduino.getAnalogPorts().add(PIN_A3);
		arduino.getAnalogPorts().add(PIN_A4);
		arduino.getAnalogPorts().add(PIN_A5);
		arduino.getAnalogPorts().add(PIN_A6);
		arduino.getAnalogPorts().add(PIN_A7);

		//
		// Digital ports
		//
		
		arduino.getDigitalPorts().add(PIN_D2);
		arduino.getDigitalPorts().add(PIN_D3);
		arduino.getDigitalPorts().add(PIN_D4);
		arduino.getDigitalPorts().add(PIN_D5);
		arduino.getDigitalPorts().add(PIN_D6);
		arduino.getDigitalPorts().add(PIN_D7);
		arduino.getDigitalPorts().add(PIN_D8);
		arduino.getDigitalPorts().add(PIN_D9);
		arduino.getDigitalPorts().add(PIN_D10);
		arduino.getDigitalPorts().add(PIN_D11);
		arduino.getDigitalPorts().add(PIN_D12);
		arduino.getDigitalPorts().add(PIN_D13);

		//
		// Rx/Tx ports
		//
		
		arduino.setRx(PIN_RX);
		arduino.setTx(PIN_TX);
	
		//
		// GND ports
		//
		
		arduino.getGroundPorts().add(PIN_GND_1);
		arduino.getGroundPorts().add(PIN_GND_2);
		
		//
		// RST port
		//
		arduino.setResetPort(PIN_RST);
		
		//
		// 3V3 Port
		//
		arduino.setPwm3V3(PIN_3V3_1);
		
		//
		// Rx alone
		//
		
		arduino.setRx(PIN_RX);
		
		//
		// Tx alone 
		//
		
		arduino.setTx(PIN_TX);

		return arduino;
	}
	
	private Arduino initPortsDiecimilaOrDuemilanoveOrUnoOrLeonardo(Arduino arduino) {
		AREFPort PIN_AREF = (AREFPort) createPortsFIO(PIN_MAPPING.PIN_AREF);
		Port3V3 PIN_3V3_1 = (Port3V3) createPortsFIO(PIN_MAPPING.PIN_3V3_1);
		AnalogPort PIN_A0 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A0);
		AnalogPort PIN_A1 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A1);
		AnalogPort PIN_A2 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A2);
		AnalogPort PIN_A3 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A3);
		AnalogPort PIN_A4 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A4);
		AnalogPort PIN_A5 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A5);
		AnalogPort PIN_A6 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A6);
		AnalogPort PIN_A7 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A7);
		DigitalPort PIN_D2 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D2);
		DigitalPort PIN_D3 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D3);
		DigitalPort PIN_D4 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D4);
		DigitalPort PIN_D5 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D5);
		DigitalPort PIN_D6 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D6);
		DigitalPort PIN_D7 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D7);
		DigitalPort PIN_D8 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D8);
		DigitalPort PIN_D9 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D9);
		DigitalPort PIN_D10 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D10);
		DigitalPort PIN_D11 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D11);
		DigitalPort PIN_D12 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D12);
		DigitalPort PIN_D13 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D13);
		GndPort PIN_GND_1 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_3V);
		GndPort PIN_GND_2 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_9V);
		RxPort PIN_RX = (RxPort) createPortsFIO(PIN_MAPPING.PIN_RX);
		TxPort PIN_TX = (TxPort) createPortsFIO(PIN_MAPPING.PIN_TX);
		RstPort PIN_RST = (RstPort) createPortsFIO(PIN_MAPPING.PIN_RST);
		
		//
		// Analog ports
		//
		
		arduino.getAnalogPorts().add(PIN_A0);
		arduino.getAnalogPorts().add(PIN_A1);
		arduino.getAnalogPorts().add(PIN_A2);
		arduino.getAnalogPorts().add(PIN_A3);
		arduino.getAnalogPorts().add(PIN_A4);
		arduino.getAnalogPorts().add(PIN_A5);
		arduino.getAnalogPorts().add(PIN_A6);
		arduino.getAnalogPorts().add(PIN_A7);

		//
		// Digital ports
		//
		
		arduino.getDigitalPorts().add(PIN_D2);
		arduino.getDigitalPorts().add(PIN_D3);
		arduino.getDigitalPorts().add(PIN_D4);
		arduino.getDigitalPorts().add(PIN_D5);
		arduino.getDigitalPorts().add(PIN_D6);
		arduino.getDigitalPorts().add(PIN_D7);
		arduino.getDigitalPorts().add(PIN_D8);
		arduino.getDigitalPorts().add(PIN_D9);
		arduino.getDigitalPorts().add(PIN_D10);
		arduino.getDigitalPorts().add(PIN_D11);
		arduino.getDigitalPorts().add(PIN_D12);
		arduino.getDigitalPorts().add(PIN_D13);

		//
		// Rx/Tx ports
		//
		
		arduino.setRx(PIN_RX);
		arduino.setTx(PIN_TX);
	
		//
		// GND ports
		//
		
		arduino.getGroundPorts().add(PIN_GND_1);
		arduino.getGroundPorts().add(PIN_GND_2);
		
		//
		// RST port
		//
		arduino.setResetPort(PIN_RST);
		
		//
		// 3V3 Port
		//
		arduino.setPwm3V3(PIN_3V3_1);
		
		//
		// Rx alone
		//
		
		arduino.setRx(PIN_RX);
		
		//
		// Tx alone 
		//
		
		arduino.setTx(PIN_TX);

		//
		// Aref alone 
		//
		
		arduino.setAref(PIN_AREF);
		
		//
		// register port listeners
		//

		return arduino;
	}
	
	
	private Arduino initPortsMini(Arduino arduino) {
		Port5V PIN_5V_1 = (Port5V) createPortsFIO(PIN_MAPPING.PIN_5V);
		Port9V PIN_9V = (Port9V) createPortsFIO(PIN_MAPPING.PIN_9V);
		PortIO7 PIN_IO7 = (PortIO7) createPortsFIO(PIN_MAPPING.PIN_IO7);
		AnalogPort PIN_A0 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A0);
		AnalogPort PIN_A1 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A1);
		AnalogPort PIN_A2 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A2);
		AnalogPort PIN_A3 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A3);
		AnalogPort PIN_A4 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A4);
		AnalogPort PIN_A5 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A5);
		AnalogPort PIN_A6 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A6);
		AnalogPort PIN_A7 = (AnalogPort) createPortsFIO(PIN_MAPPING.PIN_A7);
		DigitalPort PIN_D2 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D2);
		DigitalPort PIN_D3 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D3);
		DigitalPort PIN_D4 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D4);
		DigitalPort PIN_D5 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D5);
		DigitalPort PIN_D6 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D6);
		DigitalPort PIN_D7 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D7);
		DigitalPort PIN_D8 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D8);
		DigitalPort PIN_D9 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D9);
		DigitalPort PIN_D10 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D10);
		DigitalPort PIN_D11 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D11);
		DigitalPort PIN_D12 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D12);
		DigitalPort PIN_D13 = (DigitalPort) createPortsFIO(PIN_MAPPING.PIN_D13);
		GndPort PIN_GND_1 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_D);
		GndPort PIN_GND_2 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_D);
		GndPort PIN_GND_3 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_D);
		GndPort PIN_GND_4 = (GndPort) createPortsFIO(PIN_MAPPING.PIN_GND_D);
		RxPort PIN_RX = (RxPort) createPortsFIO(PIN_MAPPING.PIN_RX);
		TxPort PIN_TX = (TxPort) createPortsFIO(PIN_MAPPING.PIN_TX);
		RstPort PIN_RST = (RstPort) createPortsFIO(PIN_MAPPING.PIN_RST);
		
		
		//
		// Analog ports
		//
		
		arduino.getAnalogPorts().add(PIN_A0);
		arduino.getAnalogPorts().add(PIN_A1);
		arduino.getAnalogPorts().add(PIN_A2);
		arduino.getAnalogPorts().add(PIN_A3);
		arduino.getAnalogPorts().add(PIN_A4);
		arduino.getAnalogPorts().add(PIN_A5);
		arduino.getAnalogPorts().add(PIN_A6);
		arduino.getAnalogPorts().add(PIN_A7);

		//
		// Digital ports
		//
		
		arduino.getDigitalPorts().add(PIN_D2);
		arduino.getDigitalPorts().add(PIN_D3);
		arduino.getDigitalPorts().add(PIN_D4);
		arduino.getDigitalPorts().add(PIN_D5);
		arduino.getDigitalPorts().add(PIN_D6);
		arduino.getDigitalPorts().add(PIN_D7);
		arduino.getDigitalPorts().add(PIN_D8);
		arduino.getDigitalPorts().add(PIN_D9);
		arduino.getDigitalPorts().add(PIN_D10);
		arduino.getDigitalPorts().add(PIN_D11);
		arduino.getDigitalPorts().add(PIN_D12);
		arduino.getDigitalPorts().add(PIN_D13);

		//
		// Rx/Tx ports
		//
		
		arduino.setRx(PIN_RX);
		arduino.setTx(PIN_TX);
	
		//
		// GND ports
		//
		
		arduino.getGroundPorts().add(PIN_GND_1);
		arduino.getGroundPorts().add(PIN_GND_2);
		arduino.getGroundPorts().add(PIN_GND_3);
		arduino.getGroundPorts().add(PIN_GND_4);
		
		//
		// RST port
		//
		arduino.setResetPort(PIN_RST);
		
		//
		// 3V3 Port
		//
		arduino.setPwm5V(PIN_5V_1);

		//
		// 9V Port
		//
		arduino.setPwm9V(PIN_9V);
		
		//
		// Rx alone
		//
		
		arduino.setRx(PIN_RX);
		
		//
		// Tx alone 
		//
		
		arduino.setTx(PIN_TX);

		//
		// IO7 alone 
		//
		
		arduino.setIo7(PIN_IO7);

		return arduino;
	}
	
	/**
	 * This method gets bootloader name from an Arduino compatible board
	 * as modeled w/ Arduino.ecore support.
	 *  
	 * @param board a valuated instance of an {@link Arduino} board
	 * 
	 * @return bootloader ".hex" file name, void String otherwise 
	 */
	public String getBootloaderFilename(Arduino board) {
		String bootloadRelPath = "hardware/bootloaders/";
		switch(board.getBoard()) {
			case ATMEGA_168:
				bootloadRelPath += "atmega/";
				bootloadRelPath += "ATmegaBOOT_168";				
				break;
			case ATMEGA_8:
				bootloadRelPath += "atmega8/";
				bootloadRelPath += "ATmegaBOOT.hex";				
				return bootloadRelPath;
			case BT_ATMEGA_168:
				bootloadRelPath += "bt/";
				bootloadRelPath += "ATmegaBOOT_168.hex";				
				return bootloadRelPath;
			case LILYPAD_168:
				bootloadRelPath += "lilypad/";
				// Likely a single option here ...
				{
					bootloadRelPath += "LilyPadBOOT_168.hex";
				}
				return bootloadRelPath;
		};
		
		switch(board.getSeries()) {
			case _168_ATMEGA_1280:
				return bootloadRelPath += "_atmega1280.hex";
			case _168_ATMEGA_328_PRO_8M_HZ:
				return bootloadRelPath += "_atmega328_pro_8MHz.hex";
			case _168_ATMEGA_328:
				return bootloadRelPath += "_atmega328.hex";
			case _168_ATMEGA_DIECIMILA:
				return bootloadRelPath += "_diecimila.hex";
			case _168_NG:
				return bootloadRelPath += "_ng.hex";
			case _168_PRO:
				return bootloadRelPath += "_pro_8MHz.hex";
		}
		
		return "";
	}

}
