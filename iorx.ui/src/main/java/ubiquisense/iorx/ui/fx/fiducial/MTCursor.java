package ubiquisense.iorx.ui.fx.fiducial;

import com.illposed.osc.OSCMessage;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MTCursor extends Circle {
	double angle;
	double value;
	MTFiducial fiducial;
	
	public MTCursor(MTFiducial fiducial) {
		angle = 0;
		this.fiducial = fiducial;
		
		setFill(Color.RED);
		setStroke(Color.RED);
		
		setTranslateX(Math.cos(angle)*fiducial.getRadius());
		setTranslateY(Math.sin(angle)*fiducial.getRadius());
		
		setOnMouseDragged(event -> {
			setManaged(false);
			Point2D pt = localToParent(new Point2D(event.getX(), event.getY()));
			angle = borderLayouted(pt.getX(),pt.getY());
			value = angle * (Math.PI * 2);
			
			setTranslateX(Math.cos(angle)*fiducial.getRadius());
			setTranslateY(Math.sin(angle)*fiducial.getRadius());

			OSCMessage msg = new OSCMessage("/fmurf/live/"+fiducial.getID()+"/rotate");
			msg.addArgument(Double.valueOf(value).floatValue());
			
			fiducial.getOscSender().sendMessage(msg);
			
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
