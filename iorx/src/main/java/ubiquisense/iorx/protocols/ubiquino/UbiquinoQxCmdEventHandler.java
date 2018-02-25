
package ubiquisense.iorx.protocols.ubiquino;

import ubiquisense.iorx.annotations.CommunicationProtocol;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.hardware.arduino.Arduino;
import ubiquisense.iorx.protocols.firmata.FirmataCmdQxEventHandler;

@CommunicationProtocol(type = "ubiquino")
public class UbiquinoQxCmdEventHandler extends FirmataCmdQxEventHandler {
	private Arduino arduino;
	
	public UbiquinoQxCmdEventHandler() 
	{
	}
	
	public UbiquinoQxCmdEventHandler(Arduino _arduino) {
		arduino = _arduino;
	}
	
	public Arduino getArduino() {
		return arduino;
	}
	
	@Override
	public synchronized void handleQxEvent(Event event) {
		super.handleQxEvent(event);
	}
}
