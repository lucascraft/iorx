package ubiquisense.iorx.ui.fx.fiducial;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.Shape;
import com.sun.prism.Graphics;
import com.sun.prism.impl.shape.BasicShapeRep;

public class FducialShapeRep extends BasicShapeRep {

	public FducialShapeRep() {
	}

	volatile double cursor;
	volatile float tempo;

	public synchronized void setCursor(double cursor, float tempo) {
		this.cursor = cursor;
		this.tempo = tempo;
	}

	@Override
	public synchronized void fill(Graphics g, Shape shape, BaseBounds bounds) {
		Ellipse2D e = (Ellipse2D) shape;
		// g.fillEllipse(e.x, e.y, e.width, e.height);
		g.fillRect(e.x + e.width / 4, e.y + e.height / 4, e.width / 2, e.height / 2);
		
		float mCursor = tempo * (float)cursor;
		float circumX = Double.valueOf(Math.cos(mCursor)*(Math.min(e.width, e.height)/2)).floatValue();
		float circumY = Double.valueOf(Math.sin(mCursor)*(Math.min(e.width, e.height)/2)).floatValue();
		
		
		g.drawLine(e.x + e.width / 2,  e.y + e.height / 2, e.x + e.width / 2 + circumX, e.y + e.height / 2 + circumY);
	}

	@Override
	public synchronized void draw(Graphics g, Shape shape, BaseBounds bounds) {
		Ellipse2D e = (Ellipse2D) shape;
		g.drawEllipse(e.x, e.y, e.width, e.height);
		// g.drawRect(e.x+e.width/4, e.y+e.height/4, e.width/2, e.height/2);
//
//		float circumX = Double.valueOf(Math.cos(cursor)*(e.width)).floatValue();
//		float circumY = Double.valueOf(Math.sin(cursor)*(e.height)).floatValue();
//		g.drawLine(e.x + e.width / 2,  e.y + e.height / 2, circumX, circumY);
	}

}
