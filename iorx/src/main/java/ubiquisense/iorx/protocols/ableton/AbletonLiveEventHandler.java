package ubiquisense.iorx.protocols.ableton;

import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.protocols.ableton.internal.AbletonLiveSndCmd;
import ubiquisense.iorx.protocols.osc.OSCQxCmdHandler;

public class AbletonLiveEventHandler extends OSCQxCmdHandler {
	@Override
	public void handleQxEvent(Event evt) {
		if (evt.getCmd() instanceof AbletonLiveSndCmd) {
			try {
				super.handleQxEvent(evt);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(
					"It's very liekly that no OSC plugin is running on your Ableton Live 8+ ... \n" +
					"Please grab LiveControl OSC python addon from http://liine.net/livecontrol/" +
					""
				);
			}
		}
	}

	@Override
	public String getID() {
		return "ableton";
	}
}
