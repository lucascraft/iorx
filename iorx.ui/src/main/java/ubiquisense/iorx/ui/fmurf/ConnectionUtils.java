package ubiquisense.iorx.ui.fmurf;

public class ConnectionUtils {
//	SConnectionVisual ConnectionsUtils::getVisualFromGesture(SmurfGestureClassification _classification) {
//		if (_classification == GESTURE_CREATE_SIN_FREQ_LINK) {
//			return CONNECTION_SIN_FREQ;
//		} else if (_classification == GESTURE_CREATE_SQUARE_FREQ_LINK) {
//			return CONNECTION_SQUARE_FREQ;
//		}
//		else if (_classification == GESTURE_CREATE_TRIANGLE_FREQ_LINK) {
//			return CONNECTION_TRIANGLE_FREQ;
//		}
//		return CONNECTION_LINE;
//	}

	public static float getConnectionAngle() {
		double x1, x2, y1, y2;
		
		x1 = 2*Math.cos(Math.PI/6);
		y1 = 2*Math.sin(Math.PI/6);
		x2 = 3*Math.cos(Math.PI/2);
		y2 = 3*Math.sin(Math.PI/2);
		
		return Double.valueOf(Math.atan(y2/x2)-Math.atan(y1/x1)).floatValue();
	}

}
