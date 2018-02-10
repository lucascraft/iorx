package ubiquisense.iorx.ui.fx;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MTRectangle extends Rectangle {

	public MTRectangle(double w, double h) {
		super(w, h);
		
		setOnTouchPressed(new EventHandler<TouchEvent>() {
			@Override
			public void handle(TouchEvent event) {
				System.out.println("mouap");
				TouchPoint pt = event.getTouchPoint();
				setX(pt.getX());
				setY(pt.getY());
			}
		});
		setOnTouchMoved(new EventHandler<TouchEvent>() {
			@Override
			public void handle(TouchEvent event) {
				System.out.println("draaaaag");
				TouchPoint pt = event.getTouchPoint();
				setX(pt.getX());
				setY(pt.getY());
			}
		});
		setWidth(60);
		setHeight(60);
		setArcWidth(6);
		setArcHeight(6);                
		setFill(Color.BLUEVIOLET.deriveColor(0, 1.2, 1, 0.6));
		setStroke(Color.BLUEVIOLET);
		
	}
	
	
	

}
