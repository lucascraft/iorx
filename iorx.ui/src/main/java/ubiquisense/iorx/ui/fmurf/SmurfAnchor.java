package ubiquisense.iorx.ui.fmurf;

import ubiquisense.iorx.ui.fmurf.enums.AnchorKind;
import ubiquisense.iorx.ui.fmurf.enums.SmurfKind;
import ubiquisense.iorx.ui.tuio11.impl.TuioObject;

public class SmurfAnchor extends SmurfImpl{
	float ownerFid;
	AnchorKind anchorKind;
	
	public SmurfAnchor(float ownerFid, TuioObject tuioObj, SmurfKind kind) {
		super(tuioObj, kind);
		this.ownerFid = ownerFid;
	}
float getOwnerFid() {
	return ownerFid;
}

void setOwnerFid(float _fid) {
	ownerFid = _fid;
}

AnchorKind getAcnhorKind() {
	return anchorKind;
}

void setAnchorKind(AnchorKind _kind) {
	anchorKind = _kind;
}
}
