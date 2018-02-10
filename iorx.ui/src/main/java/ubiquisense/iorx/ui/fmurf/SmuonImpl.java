package ubiquisense.iorx.ui.fmurf;

import javafx.scene.paint.Color;
import ubiquisense.iorx.protocols.tuio.TuioContainer;

public class SmuonImpl implements Smuon {

	static Color SMUON_DEFAULT_BG = Color.BEIGE, SMUON_DEFAULT_FG = Color.AQUA;

	// Smuon() {
	// SMUON_DEFAULT_BG = ofColor();
	// SMUON_DEFAULT_BG.r = 255;
	// SMUON_DEFAULT_BG.g = 123;
	// SMUON_DEFAULT_BG.b = 122;
	//
	// SMUON_DEFAULT_FG = ofColor();
	// SMUON_DEFAULT_FG.r = 123;
	// SMUON_DEFAULT_FG.g = 255;
	// SMUON_DEFAULT_FG.b = 122;
	//
	// bg = SMUON_DEFAULT_BG;
	// fg = SMUON_DEFAULT_FG;
	//
	// radius = 20;
	// proxima = 75;
	// visible = true;
	// enabled = true;
	// dragging = false;
	// proximaVisible = false;
	// labelVisible = true;
	// }
	Color bg, fg;

	float radius;
	float proxima;
	boolean visible;
	boolean enabled;
	boolean selected;
	float dragging;
	boolean proximaVisible;
	boolean labelVisible;

	TuioContainer tuio;

	public SmuonImpl()
	{
		
	}
	public SmuonImpl(Color _bg, Color _fg) {

	}

	public SmuonImpl(Color _bg, Color _fg, int _radius) {
		this(_bg, _fg);
		radius = _radius;
	}

	public SmuonImpl(Color _bg, Color _fg, int _radius, boolean _visible) {
		this(_bg, _fg, _radius);
		visible = _visible;
	}

	public SmuonImpl(Color _bg, Color _fg, int _radius, boolean _visible, boolean _enabled) {
		this(_bg, _fg, _radius, _visible);
		enabled = _enabled;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float _radius) {
		radius = _radius;
	}

	public float getProxima() {
		return proxima;
	}

	public void setProxima(float _proxima) {
		proxima = _proxima;
	}

	public void setBG(Color _bg) {
		bg = _bg;
	}

	public Color getBG() {
		return bg;
	}

	public TuioContainer getTuio() {
		return tuio;
	}

	public void setFG(Color _fg) {
		fg = _fg;
	}

	public Color getFG() {
		return fg;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setEnabled(boolean _enabled) {
		enabled = _enabled;
	}

	public void setVisible(boolean _visible) {
		visible = _visible;
	}

	public void setTuio(TuioContainer _tuio) {
		tuio = _tuio;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean _selected) {
		selected = _selected;
	}

	public float getDragging() {
		return dragging;
	}

	public void setDragging(float sid) {
		dragging = sid;
	}

	public void toggleSelected() {
		selected = selected == true ? false : true;
	}

	public boolean isAlreadyDragging() {
		return dragging == -Float.MAX_VALUE;
	}

	public boolean isProximaVisible() {
		return proximaVisible;
	}

	public void setProximaVisible(boolean _status) {
		proximaVisible = _status;
	}

	public boolean isLabelVisible() {
		return labelVisible;
	}

	public void setLabelVisible(boolean _status) {
		labelVisible = _status;
	}

}
