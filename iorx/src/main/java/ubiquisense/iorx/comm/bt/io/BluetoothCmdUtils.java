

package ubiquisense.iorx.comm.bt.io;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.impl.CmdImpl;

@Deprecated
public class BluetoothCmdUtils {
	
	// Useless ... ?
	
	public final static BluetoothCmdUtils INSTANCE = new BluetoothCmdUtils();

	public BluetoothCmdUtils() {
		
	}
	
	public byte[] dumpCmd(Cmd cmd) {
		return new byte[0];
	}
	
	public Cmd cmdFrameHandler(byte[] frame) {
		return new CmdImpl() {
		};
	}
}
