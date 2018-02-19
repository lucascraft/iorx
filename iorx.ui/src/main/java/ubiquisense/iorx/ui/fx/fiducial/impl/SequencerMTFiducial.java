package ubiquisense.iorx.ui.fx.fiducial.impl;

import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.MTFiducial;

public class SequencerMTFiducial extends MTFiducial {

	public SequencerMTFiducial(int radius, int tempo) {
		super(radius, tempo);
	}
	public SequencerMTFiducial(OscSender oscSender) {
		super(oscSender);
	}
	public SequencerMTFiducial(MTFiducialConfig cfg) {
		super(cfg);
	}

}
