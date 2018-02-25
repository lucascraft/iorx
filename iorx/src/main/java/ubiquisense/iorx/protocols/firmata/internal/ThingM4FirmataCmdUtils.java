
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
