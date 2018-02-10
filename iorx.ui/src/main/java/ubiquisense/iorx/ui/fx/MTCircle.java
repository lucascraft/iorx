package ubiquisense.iorx.ui.fx;

import javafx.event.EventHandler;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MTCircle extends Circle {

	public MTCircle(double r) {
		super(r);
		
		setOnTouchPressed(new EventHandler<TouchEvent>() {
			@Override
			public void handle(TouchEvent event) {
				System.out.println("mouap");
				TouchPoint pt = event.getTouchPoint();
				setCenterX(pt.getX());
				setCenterY(pt.getY());
			}
		});
		setOnTouchMoved(new EventHandler<TouchEvent>() {
			@Override
			public void handle(TouchEvent event) {
				System.out.println("draaaaag");
				TouchPoint pt = event.getTouchPoint();
				setCenterX(pt.getX());
				setCenterY(pt.getY());
			}
		});
		setFill(Color.BLUEVIOLET.deriveColor(0, 1.2, 1, 0.6));
		setStroke(Color.BLUEVIOLET);
		
	}
	
	
	

}
