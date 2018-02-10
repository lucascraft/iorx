package ubiquisense.iorx.ui.fmurf;

public class SWave {
	int fidId, uid, radius, range, x, y;
	SWave(int _fidId, int _uid, int _x, int _y, int _range) {
		fidId = _fidId;
		x = _x;
		y = _y;
		uid = _uid;
		radius = 0;
		range = _range;
	}

	int getUid() {
		return uid;
	}

	void setRadius(int _radius) {
		radius = _radius;
	}

	int getRadius() {
		return radius;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	int getRange() {
		return range;
	}

	int getFid() {
		return fidId;
	}

	void draw() {
//		ofSetLineWidth(1);
//	    ofCircle(getX(), getY(), getRadius());
	}

}
