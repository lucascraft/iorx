package ubiquisense.iorx.ui.fmurf;

import javafx.scene.paint.Color;
import ubiquisense.iorx.ui.fmurf.enums.SmurfAspect;
import ubiquisense.iorx.ui.fmurf.enums.SmurfFunction;

public class SmurfDetails 
{
		public float uid;
		public float sessionId;
		public Color bg;
		public Color fg;
		public SmurfAspect aspect;
		public float radius;
		public float proxima;
		public float range;
		public SmurfFunction function;
		public String kind;
		public boolean proximaVisible;
		
		public SmurfDetails(float _uid, float _sessionId, Color _bg, Color _fg, SmurfAspect _aspect, float _radius, float _proxima, float _range, SmurfFunction _function, String _kind, boolean _proximaVisible) {
			uid = _uid;
			sessionId = _sessionId;
			bg = _bg;
			fg = _fg;
			aspect = _aspect;
			radius = _radius;
			proxima = _proxima;
			range = _range;
			function = _function;
			kind = _kind;
		}	}
