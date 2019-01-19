package ubiquisense.iorx.protocols.ubiquino;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.event.EVENT_KIND;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.event.IQxEventHandler;
import ubiquisense.iorx.hardware.ArduinoBoardUtils;
import ubiquisense.iorx.hardware.arduino.ARDUINO_BOARD_UID;
import ubiquisense.iorx.hardware.arduino.ARDUINO_FIRMWARE_MODE;
import ubiquisense.iorx.hardware.arduino.ARDUINO_REPORT_MODE;
import ubiquisense.iorx.hardware.arduino.AnalogPort;
import ubiquisense.iorx.hardware.arduino.Arduino;
import ubiquisense.iorx.hardware.arduino.DigitalPort;
import ubiquisense.iorx.hardware.arduino.PIN_MAPPING;
import ubiquisense.iorx.hardware.arduino.PIN_MODE;
import ubiquisense.iorx.hardware.arduino.PWM_MODE;
import ubiquisense.iorx.hardware.arduino.Port;
import ubiquisense.iorx.hardware.arduino.impl.AnalogPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.DigitalPortImpl;
import ubiquisense.iorx.hardware.arduino.impl.PortImpl;
import ubiquisense.iorx.hardware.arduino.utils.IPortListener;
import ubiquisense.iorx.protocols.firmata.internal.FirmataCmdUtils;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataPinStateResponse;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataProtocolVersionCmd;
import ubiquisense.iorx.protocols.midi.internal.dsl.DSLMidiMessage;
import ubiquisense.iorx.protocols.midi.internal.dsl.NoteON;
import ubiquisense.iorx.protocols.midi.internal.dsl.SysexMessage;
import ubiquisense.iorx.protocols.raw.internal.ByteCmd;
import ubiquisense.iorx.protocols.raw.internal.impl.ByteCmdImpl;
import ubiquisense.iorx.protocols.ubiquino.dsl.PortConfig;
import ubiquisense.iorx.protocols.ubiquino.dsl.PortConfigKind;
import ubiquisense.iorx.protocols.ubiquino.dsl.Ubiquino;
import ubiquisense.iorx.protocols.ubiquino.dsl.UbiquinoConfig;
import ubiquisense.iorx.protocols.ubiquino.dsl.impl.PortConfigImpl;
import ubiquisense.iorx.protocols.ubiquino.dsl.impl.UbiquinoConfigImpl;
import ubiquisense.iorx.protocols.ubiquino.dsl.impl.UbiquinoImpl;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.utils.CmdUtil;
import ubiquisense.iorx.utils.Platform;


public class UbiquinoUtils {
	
	public final static UbiquinoUtils INSTANCE = new UbiquinoUtils();
	
	
	//
	//
	// Ubiquino / Firmata / Sysex Event handling
	//
	//
	
	public PortConfig createPortCfg(PortConfigKind cfgKind, int pinNumber, int channel) {
		Port p = cfgKind==PortConfigKind.ANALOGIC?new AnalogPortImpl():new DigitalPortImpl();
		PIN_MAPPING pinMapping = PIN_MAPPING.UNKNOWN;
		if (cfgKind==PortConfigKind.ANALOGIC) {
			pinMapping = UbiquinoUtils.INSTANCE.getMappingFromKindAndNumber(true, pinNumber);
		} else if (cfgKind==PortConfigKind.DIGITAL) {
			pinMapping = UbiquinoUtils.INSTANCE.getMappingFromKindAndNumber(false, pinNumber);
		}
		p.setMap(pinMapping);
		p.setReport(ARDUINO_REPORT_MODE.DEACTIVATE);					
		
		PortConfig pCfg = new PortConfigImpl();
		pCfg.setEnabled(true);
		pCfg.setKind(cfgKind);
		pCfg.setMode(cfgKind==PortConfigKind.ANALOGIC?PIN_MODE.ANALOG:PIN_MODE.INPUT);
		pCfg.setPwm(PWM_MODE.NONE);
		pCfg.setTarget(p);
		pCfg.setChannel(channel);
		
		return pCfg;
	}

	public Ubiquino updateArduinoBoard(Ubiquino ubiquino, ARDUINO_BOARD_UID boardID, ARDUINO_FIRMWARE_MODE firmataMode, CmdPipe engine) {
		
		Arduino arduinoBoard	= ubiquino.getBoard();
		UbiquinoConfig config 	= ubiquino.getConfig();
		
		if (arduinoBoard != null) {
			arduinoBoard.setFirmataMode(firmataMode);
			arduinoBoard.setKind(boardID);
			if (engine != null) {
				for (DigitalPort dp : arduinoBoard.getDigitalPorts()) {
					arduinoBoard.getPortsToListen().add(new PortListener(dp, engine.getTx()));
					arduinoBoard.reportDigitalPin(ARDUINO_REPORT_MODE.ACTIVATE, dp.getMap());
					
					PortConfig pCfg = new PortConfigImpl();
					
					Port port = new PortImpl();
					port.setMap(dp.getMap());
					port.setReport(dp.getReport());
					
					pCfg.setTarget(port);
					pCfg.setKind(PortConfigKind.DIGITAL);
					
					config.getPorts().add(pCfg);
				}
				
				for (AnalogPort ap : arduinoBoard.getAnalogPorts()) {
					arduinoBoard.getPortsToListen().add(new PortListener(ap, engine.getTx()));
					arduinoBoard.reportAnalogPin(ARDUINO_REPORT_MODE.ACTIVATE, ap.getMap());

					PortConfig pCfg = new PortConfigImpl();

					Port port = new PortImpl();
					port.setMap(ap.getMap());
					port.setReport(ap.getReport());
					
					pCfg.setTarget(port);

					pCfg.setKind(PortConfigKind.ANALOGIC);
					
					config.getPorts().add(pCfg);
				}
			}
		} else {
			throw new UnsupportedOperationException("Arduino board not supported !!!");
		}
		return ubiquino;
	}
	
	public PIN_MAPPING getMappingFromKindAndNumber(boolean isOfAnalogKind, int number) {
		if (isOfAnalogKind) {
			switch(number) {
				case 0: return PIN_MAPPING.PIN_A0;
				case 1: return PIN_MAPPING.PIN_A1;
				case 2: return PIN_MAPPING.PIN_A2;
				case 3: return PIN_MAPPING.PIN_A3;
				case 4: return PIN_MAPPING.PIN_A4;
				case 5: return PIN_MAPPING.PIN_A5;
				case 6: return PIN_MAPPING.PIN_A6;
				case 7: return PIN_MAPPING.PIN_A7;
				case 8: return PIN_MAPPING.PIN_A8;
				case 9: return PIN_MAPPING.PIN_A9;
				case 10: return PIN_MAPPING.PIN_A10;
				case 11: return PIN_MAPPING.PIN_A11;
				case 12: return PIN_MAPPING.PIN_A12;
				case 13: return PIN_MAPPING.PIN_A13;
				case 14: return PIN_MAPPING.PIN_A14;
				case 15: return PIN_MAPPING.PIN_A15;
				case 16: return PIN_MAPPING.PIN_A16;
				case 17: return PIN_MAPPING.PIN_A17;
				case 18: return PIN_MAPPING.PIN_A18;
				case 19: return PIN_MAPPING.PIN_A19;
				case 20: return PIN_MAPPING.PIN_A20;
				case 21: return PIN_MAPPING.PIN_A21;
				case 22: return PIN_MAPPING.PIN_A22;
				case 23: return PIN_MAPPING.PIN_A23;
				case 24: return PIN_MAPPING.PIN_A24;
			}
		} else {
			switch(number) {
				case 2: return PIN_MAPPING.PIN_D2;
				case 3: return PIN_MAPPING.PIN_D3;
				case 4: return PIN_MAPPING.PIN_D4;
				case 5: return PIN_MAPPING.PIN_D5;
				case 6: return PIN_MAPPING.PIN_D6;
				case 7: return PIN_MAPPING.PIN_D7;
				case 8: return PIN_MAPPING.PIN_D8;
				case 9: return PIN_MAPPING.PIN_D9;
				case 10: return PIN_MAPPING.PIN_D10;
				case 11: return PIN_MAPPING.PIN_D11;
				case 12: return PIN_MAPPING.PIN_D12;
				case 13: return PIN_MAPPING.PIN_D13;
				case 14: return PIN_MAPPING.PIN_D14;
				case 15: return PIN_MAPPING.PIN_D15;
				case 16: return PIN_MAPPING.PIN_D16;
				case 17: return PIN_MAPPING.PIN_D17;
				case 18: return PIN_MAPPING.PIN_D18;
				case 19: return PIN_MAPPING.PIN_D19;
				case 20: return PIN_MAPPING.PIN_D20;
				case 21: return PIN_MAPPING.PIN_D21;
				case 22: return PIN_MAPPING.PIN_D22;
				case 23: return PIN_MAPPING.PIN_D23;
				case 24: return PIN_MAPPING.PIN_D24;
				case 25: return PIN_MAPPING.PIN_D25;
				case 26: return PIN_MAPPING.PIN_D26;
				case 27: return PIN_MAPPING.PIN_D27;
				case 28: return PIN_MAPPING.PIN_D28;
				case 29: return PIN_MAPPING.PIN_D29;
				case 30: return PIN_MAPPING.PIN_D30;
				case 31: return PIN_MAPPING.PIN_D31;
				case 32: return PIN_MAPPING.PIN_D32;
				case 33: return PIN_MAPPING.PIN_D33;
				case 34: return PIN_MAPPING.PIN_D34;
				case 35: return PIN_MAPPING.PIN_D35;
				case 36: return PIN_MAPPING.PIN_D36;
				case 37: return PIN_MAPPING.PIN_D37;
				case 38: return PIN_MAPPING.PIN_D38;
				case 39: return PIN_MAPPING.PIN_D39;
				case 40: return PIN_MAPPING.PIN_D40;
				case 41: return PIN_MAPPING.PIN_D41;
				case 42: return PIN_MAPPING.PIN_D42;
				case 43: return PIN_MAPPING.PIN_D43;
				case 44: return PIN_MAPPING.PIN_D44;
				case 45: return PIN_MAPPING.PIN_D45;
				case 46: return PIN_MAPPING.PIN_D46;
				case 47: return PIN_MAPPING.PIN_D47;
				case 48: return PIN_MAPPING.PIN_D48;
				case 49: return PIN_MAPPING.PIN_D49;
				case 50: return PIN_MAPPING.PIN_D50;
				case 51: return PIN_MAPPING.PIN_D51;
				case 52: return PIN_MAPPING.PIN_D52;
			}
		}
		return PIN_MAPPING.UNKNOWN;
	}
	
	public Ubiquino createArduinoBoard(ARDUINO_BOARD_UID boardID, ARDUINO_FIRMWARE_MODE firmataMode) {
		Ubiquino ubiquino = new UbiquinoImpl();
		
		Arduino arduinoBoard = ArduinoBoardUtils.INSTANCE.getSupportedArduinoDevices().get(boardID);
		arduinoBoard.setKind(boardID);
		ubiquino.setBoard(arduinoBoard);
		
		UbiquinoConfig config = new UbiquinoConfigImpl();
		ubiquino.setConfig(config);
		
		if (arduinoBoard != null) {
			arduinoBoard.setFirmataMode(firmataMode);
		} 

		return ubiquino;
	}
	
	
	public Ubiquino createVoidArduinoBoard(ARDUINO_FIRMWARE_MODE firmataMode) {
		Ubiquino ubiquino = new UbiquinoImpl();
		
		Arduino arduinoBoard = ArduinoBoardUtils.INSTANCE.getSupportedArduinoDevices().get(ARDUINO_BOARD_UID.PLACEHOLDER_VOID_BOARD);
		arduinoBoard.setKind(ARDUINO_BOARD_UID.PLACEHOLDER_VOID_BOARD);
		ubiquino.setBoard(arduinoBoard);
		
		UbiquinoConfig config = new UbiquinoConfigImpl();
		ubiquino.setConfig(config);
		
		if (arduinoBoard != null) {
			arduinoBoard.setFirmataMode(firmataMode);
		} 

		return ubiquino;
	}
	
	/*
	 * 
	 */
	private class PortListener implements IPortListener {
		Port _port;
		Qx _qx;
		
		public PortListener(Port _p, Qx _q) {
			_port = _p;
			_qx = _q;
		}
		
		@Override
		public PIN_MAPPING getMonitoredPort() {
			return _port.getMap();
		}
		
		@Override
		public void handleDigitalOutputMessage(DigitalPort port, int oldValue, int newValue) {
			if (port == _port) {
				if (oldValue == newValue) {
					return; // Stupid ...
				}
//				if (port.eContainer() != null && port.eContainer() instanceof Arduino) {
//					Arduino board = (Arduino) port.eContainer();
//					if (board.isSynchronizing() && port.getMap().equals(board.getLockedPin())) {
//						return; // Bounce the event while device input synch is on its way
//					}
//					ARDUINO_FIRMWARE_MODE mode = board.getFirmataMode();
//					if ( mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23_I2C)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22_I2C)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21_I2C)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20_I2C)
//					) { 
//						throw new UnsupportedOperationException("FIRMATA I2C MODE NOT IMPLEMENTED YET");
////						_qx.postCommand(
////							FirmataCmdUtils.INSTANCE.createFIRMATA_DIGITAL_IO_MSG_CMD(port.getMap().getValue(), newValue)
////						);
//					} else if (mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20)
//					) {
//						DSLMidiMessage msg = FirmataCmdUtils.INSTANCE.createDigitalIO(
//								port.getMap().getValue(), 
//								newValue);
//						_qx.postCommand(msg);
//					} else if (mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23_SERVO)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22_SERVO)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21_SERVO)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20_SERVO)
//					) {
//						throw new UnsupportedOperationException("FIRMATA SERVO MODE NOT IMPLEMENTED YET");
////						_qx.postCommand(
////							FirmataCmdUtils.INSTANCE.createFIRMATA_DIGITAL_IO_MSG_CMD(port.getMap().getValue(), newValue)
////						);
//					} else {
//						throw new UnsupportedOperationException("The board is not configured for Firmata support : set firmataMode first before being able to snd/rcv firmata sysex messages");
//					}
//				}
			}
		}
		@Override
		public void handleAnalogicOutputMessage(AnalogPort port, float oldValue, float newValue) {
			if (oldValue == newValue) {
				return; // Stupid ...
			}
//			if (port == _port) {
//				if (port.eContainer() != null && port.eContainer() instanceof Arduino) {
//					Arduino board = (Arduino) port.eContainer();
//					if (board.isSynchronizing() && port.getMap().equals(board.getLockedPin())) {
//						return; // Bounce the event while device input synch is on its way. Eg: avoid infinite loop
//					}
//					ARDUINO_FIRMWARE_MODE mode = board.getFirmataMode();
//					if (   mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23_I2C)
//						|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22_I2C)
//						|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21_I2C)
//						|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20_I2C)
//					) { 
//						throw new UnsupportedOperationException("FIRMATA I2C MODE NOT IMPLEMENTED YET");
////						_qx.postCommand(
////							FirmataCmdUtils.INSTANCE.createFIRMATA_ANALOG_IO_MSG_CMD(port.getMap().getValue(), newValue)
////						);
//					} else if (mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20)
//					) {
//						DSLMidiMessage msg = FirmataCmdUtils.INSTANCE.createAnalogIO(port.getMap().getValue(), newValue);
//						_qx.postCommand(msg);
//					} else if (mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23_SERVO)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22_SERVO)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21_SERVO)
//							|| mode.equals(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20_SERVO)
//					) {
//						throw new UnsupportedOperationException("FIRMATA SERVO MODE NOT IMPLEMENTED YET");
////						_qx.postCommand(
////							FirmataCmdUtils.INSTANCE.createFIRMATA_ANALOG_IO_MSG_CMD(port.getMap().getValue(), newValue)
////						);
//					} else {
//						throw new UnsupportedOperationException("The board is not configured for Firmata support : set firmataMode first before being able to snd/rcv firmata sysex messages");
//					}
//				}
			}

		@Override
		public void handleDigitalInputMessage(DigitalPort port, int oldValue, int newValue) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void handleAnalogicInputMessage(AnalogPort port, float oldValue, float newValue) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void handleDigitalPortModeChange(DigitalPort port, float oldValue, float newValue) {
			// TODO Auto-generated method stub
			
		}
		}
		
//		@Override
//		public void handleDigitalInputMessage(DigitalPort port, int oldValue, int newValue) {
//			if (port == _port) {
//				if (port.eContainer() != null && port.eContainer() instanceof Arduino) {
//					Arduino board = ((Arduino)port.eContainer());
//					synchronized(board) {
//						board.setSynchronizing(true);
//						board.setLockedPin(port.getMap());
//						if (oldValue != newValue) {
//							port.setValue(newValue);
//						}
//					}
//				}
//			}
//		}
//		
//		@Override
//		public void handleAnalogicInputMessage(AnalogPort port, float oldValue, float newValue) {
//			if (port == _port) {
//				if (port.eContainer() != null && port.eContainer() instanceof Arduino) {
//					Arduino board = ((Arduino)port.eContainer());
//					synchronized(board) {
//						board.setSynchronizing(true);
//						board.setLockedPin(port.getMap());
//						if (oldValue != newValue) {
//							port.setValue(newValue);
//						}
//					}
//				}
//			}
//		}
//		
//		@Override
//		public void handleDigitalPortModeChange(DigitalPort port, float oldValue, float newValue) {
//			
//		}
//	}

	//
	// Think compound
	//
	public void handleUbiquinoSysexCmdEvent(Arduino board, Cmd cmd) {
		if (cmd instanceof CompoundCmd) {
			for (Cmd c : ((CompoundCmd)cmd).getChildren()) {
				if (c instanceof Cmd) {
					handleUbiquinoSysexCmdEvent(board, c);
				}
			}
		} else {
			processUbiquinoSysexMessage(board, cmd);
		}
	}
	
	
	public void processUbiquinoSysexMessage(Arduino board, Cmd cmd) {
		//
		// Lets only consider Analog and Digital I/O messages first
		//
		if (board==null) return;
		
		if (cmd instanceof NoteON) {
			NoteON noteON = (NoteON) cmd;
			if (noteON.getCmd() == Integer.decode("0x90")) {
				int channel = noteON.getChannel();
				DigitalPort port = board.getDigitalPortFromChannel(channel);
				if (port != null) {
					int value = noteON.getByte1()<<7 | noteON.getByte2();
					if (Platform.inDebugMode()) {
						System.out.println("Ubiquinotils::DIGITAL " + channel + " : " + value);
					}
	
					board.setSynchronizing(true);
					board.setLockedPin(port.getMap());
					port.setValue(value);
					board.setSynchronizing(false);
				}
			} else if (noteON.getCmd() == Integer.decode("0xe0")) {
				int channel = noteON.getChannel();
				AnalogPort port = board.getAnalogicPortFromChannel(channel);
				if (port != null) {
					int v = noteON.getByte1()<<7 | noteON.getByte2();
					
					float value = new Float(v);
					
					if (Platform.inDebugMode()) {
						System.out.println("Ubiquinotils::ANALOG " + channel + " : " + value);
					}
					
					board.setSynchronizing(true);
					board.setLockedPin(port.getMap());
					port.setValue(value);
					board.setSynchronizing(false);
				}
			} 
		} else if (cmd instanceof SysexMessage) {
			SysexMessage sysex = (SysexMessage) cmd;
			if (sysex.getCmd() == Integer.decode("0x6c")) {
				System.out.println("[0x6c] : Firmata capabilities response");
				@SuppressWarnings("unused")
				byte[] data = sysex.getMessage();
			} else if (sysex.getCmd() == Integer.decode("0x6e")) {
				System.out.println("[0x6e] : Firmata pin state mapping");
			} else if (cmd instanceof FirmataProtocolVersionCmd){
				FirmataProtocolVersionCmd verCmd = (FirmataProtocolVersionCmd) cmd;
				int major = verCmd.getByte1();
				int minor = verCmd.getByte2();
				
				if (major == 2 && minor == 0) {
					board.setFirmataMode(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20);
				} else if (major == 2 && minor == 1) {
					board.setFirmataMode(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21);
				} else if (major == 2 && minor == 2) {
					board.setFirmataMode(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22);
				} else if (major == 2 && minor == 3) {
					board.setFirmataMode(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23);
				} else {
					// default as of UNO board
					board.setFirmataMode(ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23);
				}
			} else if (sysex.getCmd() == Integer.decode("0x73")) {
				// Pin mode response
				System.out.println("[0x73] :Pin Mode response");
			}
		}
	}
	
	//
	//
	// URI Resource load/save
	//
	//

//	public void save(IEditorInput uriInput, Ubiquino project) {
//		if (project != null) {
//			if (uriInput instanceof FileEditorInput) {
//				IFile file = ((FileEditorInput)uriInput).getFile();
//				ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
//				try {
//					URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
//					Resource resource = resourceSetImpl.createResource(uri);
//					resource.getContents().add(project);
//					resource.save(new HashMap<Object, Object>());
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	
	private void updateBoard(Ubiquino ubiquino, FirmataPinStateResponse response) {			
		Arduino board = ubiquino.getBoard();
	
		PortConfigKind cfgKind = PortConfigKind.UNKNOWN;
		if (response.getModel()==2) {
			cfgKind = PortConfigKind.ANALOGIC;
		} else if (response.getModel()==1) {
			cfgKind = PortConfigKind.DIGITAL;
		}
		PortConfig p = UbiquinoUtils.INSTANCE.createPortCfg(cfgKind, response.getPin(), response.getChannel());
		if (cfgKind==PortConfigKind.ANALOGIC) {
			board.getAnalogPorts().add((AnalogPort)p.getTarget());
		} else if (cfgKind==PortConfigKind.DIGITAL) {
			board.getDigitalPorts().add((DigitalPort)p.getTarget());
		}
		ubiquino.getConfig().getPorts().add(p);
	}
	
	public String getKind(byte hex) {
		return valueOf((byte) (hex & 0xff));
	}
	private String valueOf(byte num) {
		String hex = Integer.toHexString((int) num & 0xFF);
		return "0x" + (hex.length() == 1 ? "0" : "") + hex;
	}

	public String getIOKind(byte hex) {
		return valueOf((byte) (hex & 0xf0));
	}

	public void processCmd(Cmd cmd, Ubiquino ubiquino, final CmdPipe arduinoPipe, IFirmataInitDoneListener l) {
		if (cmd instanceof DSLMidiMessage) {
			DSLMidiMessage sysex  = (DSLMidiMessage) cmd;
			String kind = getKind((byte)sysex.getCmd());
			if ("0x6a".equals(kind)) {
				System.out.println("Analog mapping response");
				int pin = 0;
				for (int i=2;i<sysex.getMessage().length-1;i++) {
					byte mapping = sysex.getMessage()[i];
					if (mapping != 0x7f) {
						for (PortConfig p : ubiquino.getConfig().getPorts()) {
							if (p.getTarget().getMap().getValue() == pin) {
								System.out.println("pin " + pin + " <--> channel : " + CmdUtil.INSTANCE.getFrameHexInfo(new byte[]{mapping}));
								p.setChannel(mapping);
								p.getTarget().setChannel(mapping);
							}
						}
					}
					pin++;
				}
				
			} else if ("0x6e".equals(kind)) {
				byte[] bytes = sysex.getMessage();
	
				FirmataPinStateResponse response = FirmataCmdUtils.INSTANCE.createPinStateResponse(bytes);
				
				//if (Platform.inDebugMode()) {
					System.out.println("------> RCV : Port " + response.getPin() + ", channel : " + response.getChannel() + ", value : " + (int)response.getValue() + " ==> " + CmdUtil.INSTANCE.getFrameHexInfo(response.getMessage()));
					
					int mode = response.getModel();					
					if ((mode & PIN_MODE.INPUT_VALUE)!=0) {
						System.out.println(PIN_MODE.INPUT.getName() + " mode supported");
					} else if ((mode & PIN_MODE.OUTPUT_VALUE)!=0) {
						System.out.println(PIN_MODE.OUTPUT.getName() + " mode supported");
					} else 	if ((mode & PIN_MODE.ANALOG_VALUE)!=0) {
						System.out.println(PIN_MODE.ANALOG.getName() + " mode supported");
					} else 	if ((mode & PIN_MODE.PWM_VALUE)!=0) {
						System.out.println(PIN_MODE.PWM.getName() + " mode supported");
					} else 	if ((mode & PIN_MODE.I2C_VALUE)!=0) {
						System.out.println(PIN_MODE.I2C.getName() + " mode supported");
					} else 	if ((mode & PIN_MODE.SERVO_VALUE)!=0) {
						System.out.println(PIN_MODE.SERVO.getName() + " mode supported");
					} 
				//}
				
				updateBoard(ubiquino, response);
				
				arduinoPipe.send(FirmataCmdUtils.INSTANCE.createAnalogMappingQuery());
	
			} else if ("0x6c".equals(kind)) {
				byte[] capabilties = sysex.getMessage();
								
				if (Platform.inDebugMode()) {
					System.out.println("Capabilities Frame : " + CmdUtil.INSTANCE.getFrameHexInfo(capabilties));
				}
				
				//
				// Init from capabilities response
				//
				long[]  supported_modes = new long[128];
				if (capabilties != null && capabilties.length>0) {
																					
					int pin, i, n;
					for (pin=0; pin < 128; pin++) {
						supported_modes[pin] = 0;
					}
					for (i=2, n=0, pin=0; i<capabilties.length; i++) {
						if (capabilties[i] == 127) {
							pin++;
							n = 0;
							continue;
						}
						if (n == 0) {
							// first byte is supported mode
							supported_modes[pin] |= (1<<capabilties[i]);
							System.out.println(i+ " --> Pin #"+pin + " : ");
						}
						n = n ^ 1;
					}
																						
					byte[] message = new byte[512];
					int len = 0;
					// send a state query for for every pin with any modes
					for (pin=0; pin < 128; pin++) {
						if (supported_modes[pin] != 0) {
							// 0x6D																		
							//if (Platform.inDebugMode()) {
								System.out.println("Query pin #" + pin + " current state");
							//}
							message[len++] = (byte) 0xf0;
							message[len++] = (byte) 0x6d;
							message[len++] = (byte) pin;
							message[len++] = (byte) 0xF7;
						}																		
					}
	
					//
					// !!! Update here arduino model from queried capabilities !!!
					//
					ByteCmd bCmd = new ByteCmdImpl();
					bCmd.setMessage(message);
					arduinoPipe.send(bCmd);
					l.handleInitFirmataDone(ubiquino, arduinoPipe);
				}
			} else if ("0xf9".equals(kind)) {
				int major = Integer.valueOf(sysex.getByte1());
				int minor = Integer.valueOf(sysex.getByte2());
																				
				System.out.println("Firmata ver. " + major +"." + minor);
				
				Ubiquino newUbiquino = UbiquinoUtils.INSTANCE.createArduinoBoard(
					ARDUINO_BOARD_UID.PLACEHOLDER_VOID_BOARD,
					getFirmwareMode(major, minor)
				);
						
				ubiquino.setBoard(newUbiquino.getBoard());
				
				new Thread("Firmata capabilities query job") {
					@Override
					public void run() {
						System.out.println("Query board for Firmata capabilities");
						arduinoPipe.send(FirmataCmdUtils.INSTANCE.createCapabiltiesQuery());					
					}
				}.start();
			}
		}
	}
	
	public void initFirmata(final Ubiquino ubiquino, final CmdPipe arduinoPipe, final IFirmataInitDoneListener l) {
		if (arduinoPipe instanceof CmdPipe) {
			arduinoPipe.addQxEventHandler(
				new IQxEventHandler() {
					public void handleQxEvent(final Event event) {
						if (event.getKind().equals(EVENT_KIND.RX_DONE)) {
							if (event.getCmd() instanceof CompoundCmd) {
								for (Cmd cmd : ((CompoundCmd)event.getCmd()).getChildren()) {
									processCmd(cmd, ubiquino, arduinoPipe, l);
								}
							} else {
								processCmd(event.getCmd(), ubiquino, arduinoPipe, l);
							}
						}
					}

					@Override
					public String getID() {
						return "";
					}
				}
			);
		}
	}


	public static String bytesToStringUTFCustom(byte[] bytes) {
		char[] buffer = new char[bytes.length >> 1];
		for(int i = 0; i < buffer.length; i++) {
			int bpos = i << 1;
			char c = (char)((bytes[bpos] & 0x7F) | ((bytes[bpos] & 0x7F) << 7));
			buffer[i] = c;
		}
		return new String(buffer);
	}
	
	public ARDUINO_FIRMWARE_MODE getFirmwareMode(int major, int minor) {
		ARDUINO_FIRMWARE_MODE firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23;
		if (major == 1 && minor == 0) {
			firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V10;
		} else if (major == 1 && minor == 1) {
			firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V11;
		} else if (major == 2 && minor == 0) {
			firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V20;
		} else if (major == 2 && minor == 1) {
			firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V21;
		} else if (major == 2 && minor == 2) {
			firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V22;
		} else if (major == 2 && minor == 3) {
			firmwareMode = ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23;
		}
		return firmwareMode;
	}

//	
//	@SuppressWarnings("unused")
//	public Ubiquino load(IEditorInput uriInput) {
//		TemporalPackage		p0	= TemporalPackage.eINSTANCE;
//		ArduinoPackage		p1	= ArduinoPackage.eINSTANCE;
//		UbiquinoPackage		p2	= UbiquinoPackage.eINSTANCE;
//		XcpPackage			p3	= XcpPackage.eINSTANCE;
//		
//		if (uriInput instanceof FileEditorInput) {
//			IFile file = ((FileEditorInput)uriInput).getFile();
//			ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
//			try {
//				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
//				Resource resource = resourceSetImpl.getResource(uri, true);
//				resource.load(new HashMap<Object, Object>());
//				return (Ubiquino) resource.getContents().get(0);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
}
