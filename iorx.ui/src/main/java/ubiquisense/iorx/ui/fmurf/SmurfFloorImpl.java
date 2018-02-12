package ubiquisense.iorx.ui.fmurf;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.layout.GridPane;
import ubiquisense.iorx.ui.config.MTConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscReceiver;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public class SmurfFloorImpl {
	SmurfBrainImpl brain;
	Set<SWave> waves;
	int bpm;
	int waveSpeed;
	int lastWaveUid;
	boolean verbose;
	
	public SmurfFloorImpl(GridPane mtPane, int _bpm, int _speed, MTConfig cfg) {
		waves = new HashSet<SWave>();
		brain = new SmurfBrainImpl(mtPane, _bpm, cfg.getOscInPort(), cfg.getOutAddr(), cfg.getOutOscPort());
		bpm = _bpm;	
		waveSpeed = _speed;
		lastWaveUid = 0;
		verbose = false;
		
	}

	public SmurfBrainImpl getBrain() {
		return brain;
	}
	
	public void think() {
		brain.handleBeat(getNextWaveUid(), waves);
		brain.handleOscReceive();
	}

	public void setWaveSpeed(int _speed) {
		waveSpeed = _speed;
	}

	public int getWaveSpeed() {
		return waveSpeed;
	}

	public void setBPM(int _bpm) {
		bpm = _bpm;
		brain.setBPM(bpm);
	}

	public int getBPM() {
		return bpm;
	}

	public void setOscSender(OscSender _sender) {
		brain.setOscSender(_sender);
	}

	public void setOscReceiver(OscReceiver _receiver) {
		brain.setOscReceiver(_receiver);
	}

	public void setSmurfCfg(SmurfCfg _cfg) {
		brain.setSmurfCfg(_cfg);
	}

	public int getNextWaveUid() {
		return lastWaveUid++;
	}

	public void setVerbose(boolean _verbose) {
		verbose = _verbose;
	}

	public boolean isVerbose() {
		return verbose;
	}

	boolean isConnectionModeOn() {
		return brain.isConnectionModeOn();
	}

	public void toggleConnectionMode() {
		brain.toggleConnectionMode();
	}

	
}
