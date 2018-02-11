package ubiquisense.iorx.ui.fx.fiducial;

import com.sun.javafx.sg.prism.NGCircle;
import com.sun.javafx.sg.prism.NGNode;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MTFiducial extends MTCircle {

	float tempo;
    double minAlpha = 0.2;
    double maxAlpha = 0.8;
    double mult = 1;
    
	public synchronized void beat(double curso)
	{
		Color p = (Color) getFill();
		if (p.getOpacity()>=maxAlpha)
		{
			mult = -1;
		} 
		else if (p.getOpacity()<=minAlpha)
		{
			mult = 1;
		}
		Color p2 = Color.color(p.getRed(), p.getGreen(), p.getBlue(), p.getOpacity()+ (mult*0.01));
		setFill(p2);
		
       ((NGFiducial)impl_getPeer()).setCursor(curso, tempo);
	}
	

	public MTFiducial(double radius, float tempo) {
		super(radius);
		
		this.tempo = tempo;
		
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
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("mouap");
				setCenterX(event.getX());
				setCenterY(event.getY());
			}
		});
		
		setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("draaaaag");
				setCenterX(event.getX());
				setCenterY(event.getY());
			}
		});
		
	}
	
	

}
