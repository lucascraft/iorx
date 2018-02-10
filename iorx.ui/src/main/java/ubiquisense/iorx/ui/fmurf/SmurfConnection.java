package ubiquisense.iorx.ui.fmurf;

import java.util.HashSet;
import java.util.Set;

enum SConnectKind {
	CONNECT_INPUT,
	CONNECT_OUTPUT,
	CONNECT_INOUT,
	CONNECT_UNKNOWN
};

enum SConnectionVisual {
	CONNECTION_SQUARE_FREQ,
	CONNECTION_TRIANGLE_FREQ,
	CONNECTION_SIN_FREQ,
	CONNECTION_CHUNKS,
	CONNECTION_DOTS,
	CONNECTION_LINE
};

public class SmurfConnection {

int CONNECTION_MAX_HEIGHT = 25;

SmurfAnchor fAnchor;
SmurfAnchor tAnchor;
Set<Float> liveData;
SConnectionVisual visual;
SConnectKind kind;
boolean enabled;



public SmurfConnection(SmurfAnchor _anchorFrom, SmurfAnchor _anchorTo, SConnectionVisual _visual, SConnectKind _kind){
	fAnchor = _anchorFrom;
	tAnchor = _anchorTo;
	visual = _visual;
	kind = _kind;
	liveData = new HashSet<Float>();
}


public SmurfConnection(SmurfAnchor _anchorFrom, SmurfAnchor _anchorTo, SConnectionVisual _visual) {
	this(_anchorFrom, _anchorTo, _visual, SConnectKind.CONNECT_UNKNOWN);
}

public void setConnectionKind(SConnectKind _kind) {
	kind = _kind;
}

public SConnectKind getConnectionKind() {
	return kind;
}

public void setConnectionVisual(SConnectionVisual _visual) {
	visual = _visual;
}

public SConnectionVisual getConnectionVisual() {
	return visual;
}

public float fromID() {
		return fAnchor != null ? fAnchor.getOwnerFid() : -Float.MAX_VALUE;
}

public void setFromID(float _fromID) {
	if (fAnchor != null) {
		fAnchor.setOwnerFid(_fromID);
	}
}

public float toID() {
	return tAnchor==null?-Float.MAX_VALUE : tAnchor.getOwnerFid();
}

public void setToID(float _toID) {
	if (tAnchor != null) {
		tAnchor.setOwnerFid(_toID);
	}
}

public SmurfAnchor fromAnchor() {
	return fAnchor;
}

public void setFromAnchor(SmurfAnchor _from) {
	fAnchor = _from;
}

public SmurfAnchor toAnchor() {
	return tAnchor;
}

public void setToAnchor(SmurfAnchor _to) {
	tAnchor = _to;
}


public Set<Float> getLiveData() {
	return liveData;
}

public void setLiveData(Set<Float> _liveData) {
	liveData = _liveData;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean _status) {
	enabled = _status;
}

public void toggleEnabled() {
	enabled = enabled ? false : true;
}

public void draw(Set<Float> livedata) {
//			
//	TuioPoint fromPt = new ofxTuioPoint(fAnchor.getTuio().getPosition().getX(),fAnchor.getTuio().getPosition().getY());
//	TuioPoint toPt = new ofxTuioPoint(tAnchor.getTuio().getPosition().getX(),tAnchor.getTuio().getPosition().getY());
//	
//	float fX = fromPt.getX()  ofGetWidth();
//	float fY = fromPt.getY()  ofGetHeight();
//	float tX = toPt.getX()  ofGetWidth();
//	float tY = toPt.getY()  ofGetHeight();
//	
//	TuioPoint fnPt = new ofxTuioPoint(fX, fY);
//	TuioPoint tnPt = new ofxTuioPoint(tX, tY);
//	
//	//ofLine(fX, fY, tX, tY);
//	
//	glPushMatrix();
//	
//	glTranslatef(fX, fY, 0.0);
//		
//	float dx = fX-tX;
//	float dy = fY-tY;
//	
//	float dist = sqrtf(dxdx+dydy);
//
//	glRotatef(180.0-ofRadToDeg(fnPt.getAngle(tnPt)), 0.0, 0.0, 1.0);
//	
//	
//	glColor3f(0.3, 0.3, 0.3);
//	
//	ofLine(0.0, 0.0, dist, 0.0);
//	
//	ofLine(dist - 5.0, 0.0, dist - 12.0, -5.0);
//	ofLine(dist - 5.0, 0.0, dist -12.0, 5.0);
//	
//	glColor3f(0.7, 0.7, 0.7);
//
//	// drawing live data feedback if any
//	// A simple line otherwise
//	ofBeginShape();
//
//	ofVertex(0.0, 0.0);
//
//	float incr = dist / livedata.size();
//
//	
//	rotate(livedata.rbegin(), livedata.rbegin()+1, livedata.rend());
//	
//	for (int idx=0; idx<livedata.size(); idx++) {
//		if (idxincr>dist) break;
//		
//		ofVertex(idxincr, livedata.at(idx)50);
//			
//		if (idxincr+incr>dist) break;		
//	}
//		
//	ofVertex(dist, 0.0);
//	
//	ofEndShape(false);
//	
//	
//	glPopMatrix();
//	
//	if (getConnectionVisual() == CONNECTION_SIN_FREQ) {
//	
//	} else if (getConnectionVisual() == CONNECTION_SQUARE_FREQ) {
//		
//	} else if (getConnectionVisual() == CONNECTION_TRIANGLE_FREQ) {
//	
//	} else if (getConnectionVisual() == CONNECTION_CHUNKS) {
//	
//	}	
}
}
