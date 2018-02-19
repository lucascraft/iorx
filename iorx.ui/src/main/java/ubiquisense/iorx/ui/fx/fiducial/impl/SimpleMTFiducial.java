package ubiquisense.iorx.ui.fx.fiducial.impl;

import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.MTFiducial;

public class SimpleMTFiducial extends MTFiducial {

	public SimpleMTFiducial(int radius, int tempo) {
		super(radius, tempo);
	}
	public SimpleMTFiducial(OscSender oscSender) {
		super(oscSender);
	}
	public SimpleMTFiducial(MTFiducialConfig cfg) {
		super(cfg);
	}

}
