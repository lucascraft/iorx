package ubiquisense.iorx.ui.fmurf;

import javafx.scene.paint.Color;
import ubiquisense.iorx.ui.tuio11.impl.TuioContainer;

public interface Smuon {
	//
	void setFG(Color _fg);
	void setBG(Color _bg);
	void setVisible(boolean _visible);
	void setEnabled(boolean _enabled);
	void setRadius(float _radius);	
	void setProxima(float _proxima);	
	void setTuio(TuioContainer _tuio);
	void setDragging(float _dragging);
	void setSelected(boolean _selected);
	void setProximaVisible(boolean _status);
	void setLabelVisible(boolean _status);

	//
	Color getFG();
	Color getBG();
	boolean isEnabled();
	boolean isVisible();
	float getDragging();
	float getRadius();
	float getProxima();
	boolean isSelected();
	TuioContainer getTuio();
	boolean isAlreadyDragging();
	void toggleSelected();
	boolean isProximaVisible();
	boolean isLabelVisible();
}
