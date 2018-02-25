
package ubiquisense.iorx.protocols.ubiquino;

import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.protocols.ubiquino.dsl.Ubiquino;

public interface IFirmataInitDoneListener {
	public void handleInitFirmataDone(Ubiquino ubiquino, CmdPipe arduinoPipe);
}
