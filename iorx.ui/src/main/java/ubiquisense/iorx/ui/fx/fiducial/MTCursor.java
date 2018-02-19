package ubiquisense.iorx.ui.fx.fiducial;

import com.illposed.osc.OSCMessage;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class MTCursor extends Circle {
	double angle;
	double value;
	MTFiducial fiducial;
	Arc arc;

	public double getValue() {
		return value;
	}
	
	public MTCursor(MTFiducial fiducial, Arc arc) {
		this.angle = 0;
		this.arc = arc;
		this.fiducial = fiducial;
		
		setFill(Color.RED);
		setStroke(Color.RED);
		
		setTranslateX(Math.cos(angle)*fiducial.getRadius());
		setTranslateY(Math.sin(angle)*fiducial.getRadius());
		
		setOnMouseDragged(event -> {
			setManaged(false);
			Point2D pt = localToParent(new Point2D(event.getX(), event.getY()));
			angle = borderLayouted(pt.getX(),pt.getY());
			double angleDegrees = Math.toDegrees(angle);

		    if (angleDegrees < 0) {
		    	angleDegrees += 360;
		    };
			value = angleDegrees / 360;
			
			setTranslateX(Math.cos(angle)*fiducial.getRadius());
			setTranslateY(Math.sin(angle)*fiducial.getRadius());

			OSCMessage msg = new OSCMessage("/fmurf/live/"+fiducial.getID()+"/rotate");
			msg.addArgument(Double.valueOf(value).floatValue());
			
			fiducial.getOscSender().sendMessage(msg);

			arc.setLength(getValue()*-360f);
			event.consume();
		});
		
		setOnTouchMoved(event -> {
			setManaged(false);
			setTranslateX(Math.cos(angle)*fiducial.getRadius());
			setTranslateY(Math.sin(angle)*fiducial.getRadius());
			event.consume();
		});
	}
	
	private double borderLayouted(double x, double y)
	{
		return calcRotationAngleInRadians(new Point2D(0, 0), new Point2D(x, y));
	}

	public static double calcRotationAngleInRadians(Point2D centerPt, Point2D targetPt)
	{
	    return Math.atan2(targetPt.getY() - centerPt.getY() , targetPt.getX()  - centerPt.getX());
	}

}
