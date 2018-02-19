package ubiquisense.iorx.ui.fx.fiducial.impl;

import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.MTFiducial;

public class SongMTFiducial extends MTFiducial {

	public SongMTFiducial(int radius, int tempo) {
		super(radius, tempo);
	}
	public SongMTFiducial(OscSender oscSender) {
		super(oscSender);
	}
	public SongMTFiducial(MTFiducialConfig cfg) {
		super(cfg);
	}

}
