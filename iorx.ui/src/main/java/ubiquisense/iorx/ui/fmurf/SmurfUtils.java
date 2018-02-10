package ubiquisense.iorx.ui.fmurf;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.paint.Color;
import ubiquisense.iorx.protocols.tuio.TuioContainer;
import ubiquisense.iorx.protocols.tuio.TuioObject;
import ubiquisense.iorx.protocols.tuio.TuioPoint;

public class SmurfUtils {
	static long virtualID;

	SmurfUtils() {
		virtualID = 100;
	}

	static float getNextVirtualID() {
		return virtualID++;
	}

	//
	// Stupid Geometry utilities
	//
	public static Smuon getCloserSmuonWithinGivenRadiusAndKind(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius, CloserEnum _discriminationKind) {
		float dist = Float.MAX_VALUE;
		Smuon smuon = null;

		if (_discriminationKind == CloserEnum.CLOSER_SMUON || _discriminationKind == CloserEnum.CLOSER_CURSOR) {
			for (SmurfFinger finger : fingers) {
				float dv = finger.getTuio().getDistance(tuioObj);
				if (dv < dist && radius > dv) {
					dist = dv;
					return finger;
				}
			}
		}

		if (_discriminationKind == CloserEnum.CLOSER_SMUON || _discriminationKind == CloserEnum.CLOSER_SMURF) {
			for (Smurf smurf : smurfs) {
				float dv = smurf.getTuio().getDistance(tuioObj);
				if (dv < dist && radius > dv) {
					dist = dv;
					return smurf;
				}
			}
		}

		return smuon;

	}

	public static Set<Smuon> getSmuonsWithinGivenRadiusAndKind(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius, CloserEnum _discriminationKind) {
		Set<Smuon> smuons = new HashSet<Smuon>();

		if (_discriminationKind == CloserEnum.CLOSER_SMUON || _discriminationKind == CloserEnum.CLOSER_CURSOR) {
			for (SmurfFinger finger : fingers) {
				float dv = finger.getTuio().getDistance(tuioObj);
				if (radius > dv) {
					smuons.add(finger);
				}
			}
		}

		if (_discriminationKind == CloserEnum.CLOSER_SMUON || _discriminationKind == CloserEnum.CLOSER_SMURF) {
			for (Smurf smurf : smurfs) {
				float dv = smurf.getTuio().getDistance(tuioObj);
				if (radius > dv) {
					smuons.add(smurf);
				}
			}
		}

		return smuons;
	}

	public static Smuon getCloserSmuonWithinGivenRadius(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius) {
		return getCloserSmuonWithinGivenRadiusAndKind(smurfs, fingers, tuioObj, radius, CloserEnum.CLOSER_SMUON);
	}

	public static Set<Smuon> getSmuonsWithinGivenRadius(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius) {
		return getSmuonsWithinGivenRadiusAndKind(smurfs, fingers, tuioObj, radius, CloserEnum.CLOSER_SMUON);
	}

	public static Smurf getCloserSmurfWithinGivenRadius(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius) {
		return (Smurf) getCloserSmuonWithinGivenRadiusAndKind(smurfs, fingers, tuioObj, radius,
				CloserEnum.CLOSER_SMURF);
	}

	public static Set<Smuon> getSmurfsWithinGivenRadius(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius) {
		return getSmuonsWithinGivenRadiusAndKind(smurfs, fingers, tuioObj, radius, CloserEnum.CLOSER_SMURF);
	}

	public static SmurfFinger getCloserCursorWithinGivenRadius(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius) {
		return (SmurfFinger) getCloserSmuonWithinGivenRadiusAndKind(smurfs, fingers, tuioObj, radius,
				CloserEnum.CLOSER_CURSOR);
	}

	public static Set<Smuon> getCursorsWithinGivenRadius(Set<Smurf> smurfs, Set<SmurfFinger> fingers,
			TuioContainer tuioObj, float radius) {
		return getSmuonsWithinGivenRadiusAndKind(smurfs, fingers, tuioObj, radius, CloserEnum.CLOSER_CURSOR);
	}

	// Atypical smurfs creation utilities
	// -----------------------------------

	public static Smurf createAtypicalSmurf(Smuon smuon, SmurfKind kind) {
		if (smuon == null)
			return null;

		SmurfFinger finger = (SmurfFinger) smuon;

		if (finger.getPoints().size() == 0)
			return null;

		TuioPoint pt = finger.getPoints().get(0);

		float vID = getNextVirtualID();

		TuioObject tuioObj = new TuioObject(new Float(vID).longValue(), new Float(vID).intValue(), new Float(pt.getX()), new Float(pt.getY()), 0.0f);

		Smurf smurf = new SmurfImpl(tuioObj, kind);

		return smurf;
	}

	public static SmurfAnchor createSmurfAnchor(Smuon smuon, float _ownerId, AnchorKind _anchorKind) {
		TuioPoint pt = new TuioPoint(0.5f, 0.5f);

		if (smuon == null)
			return null;

		if (smuon instanceof SmurfFinger) {
			SmurfFinger finger = (SmurfFinger) smuon;

			if (finger.getPoints().size() == 0)
				return null;

			pt = finger.getPoints().get(0);
		} else if (smuon instanceof Smurf) {
			pt = smuon.getTuio().getPosition();
		}

		float vID = getNextVirtualID();

		TuioObject tuioObj = new TuioObject(new Float(vID).longValue(), new Float(vID).intValue(), new Float(pt.getX()), new Float(pt.getY()), 0.0f);

		SmurfAnchor smurfAnchor = new SmurfAnchor(_ownerId, tuioObj, SmurfKind.SMURF_KIND_ANCHOR);
		smurfAnchor.setKind(SmurfKind.SMURF_KIND_ANCHOR);
		smurfAnchor.setRadius(12);
		smurfAnchor.setProxima(12);
		smurfAnchor.setFG(new Color((int) 0xAD, (int) 0xEA, (int) 0xEA, 255));
		smurfAnchor.setBG(new Color((int) 0xAD, (int) 0xEA, (int) 0xEA, 255));
		smurfAnchor.setLabelVisible(false);

		return smurfAnchor;
	}

}
