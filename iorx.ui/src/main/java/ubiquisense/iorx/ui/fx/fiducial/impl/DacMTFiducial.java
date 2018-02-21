package ubiquisense.iorx.ui.fx.fiducial.impl;

import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.MTFiducial;

public class DacMTFiducial extends MTFiducial {
	public DacMTFiducial(int radius, int tempo) {
		super(radius, tempo);
	}
	public DacMTFiducial(OscSender oscSender) {
		super(oscSender);
	}
	public DacMTFiducial(MTFiducialConfig cfg) {
		super(cfg);
	}

	@Override
	public String getID() {
		return "-440";
	}
}
