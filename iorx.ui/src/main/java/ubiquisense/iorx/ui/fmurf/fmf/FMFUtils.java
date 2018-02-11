package ubiquisense.iorx.ui.fmurf.fmf;

import javafx.scene.paint.Color;
import ubiquisense.iorx.protocols.tuio.TuioObject;
import ubiquisense.iorx.ui.fmurf.Smurf;
import ubiquisense.iorx.ui.fmurf.enums.SmurfKind;

public class FMFUtils {
	

public Smurf createFMFElement(FMFType _type, float _fid){

		switch (_type) {
			case FMF_TYPE_ADD:
				return createADD(_fid);
			case FMF_TYPE_DAC:
				return createDAC(_fid);
			case FMF_TYPE_OSC:
				return createOSC(_fid);
			case FMF_TYPE_PHAZOR:
				return createPHAZOR(_fid);
			case FMF_TYPE_MULT:
				return createMULT(_fid);
			case FMF_TYPE_SAMPLER:
				return createSAMPLER(_fid);
			case FMF_TYPE_SEQUENCER:
				return createSEQUENCER(_fid);
			case FMF_TYPE_TEMPO:
				return createTEMPO(_fid);
			default:
				break;
		}
		return null;
	}


	public FMFDac createDAC(float _fid) {
		FMFDac dac = new FMFDac(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f), SmurfKind.SMURF_KIND_TANGIBLE);
		dac.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		dac.setBG(new Color((int)0xA8, (int)0xA8, (int)0xA8, 255));
		dac.setFG(new Color((int)0xA8, (int)0xA8, (int)0xA8, 255));
		dac.setLabelVisible(false);
		dac.setRadius(18);
		return dac;
	}

	public FMFOscillator createOSC(float _fid) {
		FMFOscillator osc = new FMFOscillator(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f), SmurfKind.SMURF_KIND_TANGIBLE);
		osc.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return osc;
	}

	public FMFPhazor createPHAZOR(float _fid) {
		FMFPhazor phazor = new FMFPhazor(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f), SmurfKind.SMURF_KIND_TANGIBLE);
		phazor.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return phazor;
	}

	public FMFMultiply createMULT(float _fid) {
		FMFMultiply mult = new FMFMultiply(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f), SmurfKind.SMURF_KIND_TANGIBLE);
		mult.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return mult;
	}

	public FMFAdd createADD(float _fid) {
		FMFAdd add = new FMFAdd(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f), SmurfKind.SMURF_KIND_TANGIBLE);
		add.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return add;
	}

	public FMFSequencer createSEQUENCER(float _fid) {
		FMFSequencer sequencer = new FMFSequencer(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f), SmurfKind.SMURF_KIND_TANGIBLE);
		sequencer.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return sequencer;
	}

	public FMFSampler createSAMPLER(float _fid) {
		FMFSampler sampler = new FMFSampler(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f),  SmurfKind.SMURF_KIND_TANGIBLE);
		sampler.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return sampler;
	}

	public FMFTempo createTEMPO(float _fid) {
		FMFTempo tempo = new FMFTempo(new TuioObject(Float.valueOf(_fid).longValue(), Float.valueOf(_fid).intValue(), 0.5f, 0.5f, 0.0f),  SmurfKind.SMURF_KIND_TANGIBLE);
		tempo.setKind(SmurfKind.SMURF_KIND_TANGIBLE);
		return tempo;
	}

}
