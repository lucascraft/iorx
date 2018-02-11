package ubiquisense.iorx.ui.fx.fiducial;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.paint.Color;
import ubiquisense.iorx.ui.config.MTFiducialConfig;

public class MTFiducial extends MTCircle {

	float tempo;
    double minAlpha = 0.33;
    double maxAlpha = 0.8;
    double mult = 1;
    MTFiducialConfig cfg;
    
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
		setStroke(p2);
		
       ((NGFiducial)impl_getPeer()).setCursor(curso, tempo);
	}

	public MTFiducial() {
		super((int)Math.min(100d, new Random().nextInt()*175));
		Random ran =new Random();
		this.tempo = 50 * ran.nextInt();
		setTranslateX(ran.nextDouble()*640);
		setTranslateY(ran.nextDouble()*480);
		initHandlers();
		Color c = Color.color(Math.min(0.7, ran.nextDouble()), Math.min(0.5, ran.nextDouble()), Math.min(0.6, ran.nextDouble()));
		setFill(c/*.deriveColor(1.0, 1.0, 1.0, 0.2)*/);
		setStroke(c);
	}
	
	public MTFiducial(MTFiducialConfig cfg) {
		super(cfg.getRadius());
		this.cfg = cfg;
		this.tempo = cfg.getTempo();
		Random ran = new Random();
		setTranslateX(ran.nextDouble()*640);
		setTranslateY(ran.nextDouble()*480);
		setFill(cfg.getFg());
		setStroke(cfg.getFg());
		initHandlers();
	}

	public MTFiducial(int radius, int tempo) {
		super(radius);
		this.cfg = new MTFiducialConfig(radius, tempo);
		this.tempo = tempo;
		Random ran = new Random();
		setTranslateX(ran.nextDouble()*640);
		setTranslateY(ran.nextDouble()*480);
		setFill(cfg.getFg());
		setStroke(cfg.getFg());
		initHandlers();
	}

	private void initHandlers()
	{
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
