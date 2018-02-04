package ubiquisense.iorx.nojunit;

import java.util.Timer;
import java.util.TimerTask;

import ubiquisense.iorx.Ubq;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.hardware.arduino.ARDUINO_BOARD_UID;
import ubiquisense.iorx.hardware.arduino.ARDUINO_FIRMWARE_MODE;
import ubiquisense.iorx.protocols.firmata.internal.ThingM4FirmataCmdUtils;
import ubiquisense.iorx.protocols.firmata.internal.dsl.FirmataSysexMessage;
import ubiquisense.iorx.protocols.ubiquino.IFirmataInitDoneListener;
import ubiquisense.iorx.protocols.ubiquino.UbiquinoUtils;
import ubiquisense.iorx.protocols.ubiquino.dsl.Ubiquino;
import ubiquisense.iorx.utils.CmdUtil;

public class TestFirmataConnectionEquinoxApplication  {
	private CmdPipe arduinoPipe;
	public void  testUbiquinoBadic() {
		Ubiquino ubiquino = UbiquinoUtils.INSTANCE.createArduinoBoard(ARDUINO_BOARD_UID.UNO_ATMEGA328, ARDUINO_FIRMWARE_MODE.ARDUINO_FIRMATA_V23);
		arduinoPipe = Ubq.Reactor.openUsbPipe("firmata", "/dev/tty.usbmodem411", 57600);
		if (arduinoPipe != null) {
			UbiquinoUtils.INSTANCE.initFirmata(
				ubiquino, 
				arduinoPipe, 
				new IFirmataInitDoneListener() {
				@Override
					public void handleInitFirmataDone(Ubiquino ubiquino, final CmdPipe pipe) {
						System.out.println("Arduino Firmata connection established !");
						new Thread("later") {
							@Override
							public void run() {
								for (int i=0;i<10;i++) {
									Cmd cmd = ThingM4FirmataCmdUtils.INSTANCE.createThingM4FimataFadeToRGBCmd("0x00", 255, 0, 0);
									if (cmd instanceof FirmataSysexMessage){
										System.out.println(CmdUtil.INSTANCE.getFrameHexInfo(((FirmataSysexMessage)cmd).getMessage()));
										pipe.send(cmd);
										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}	
									}
								}
							}
						}.start();	
					}
				}
			);
		}
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				
			}
		}, 5000);
			
	}

	public void stop() {
		Ubq.Reactor.closePipe(true, arduinoPipe);
	}
}
