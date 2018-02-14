package ubiquisense.iorx.ui.fx.fiducial;

import com.illposed.osc.OSCMessage;

import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public class MTPane extends Pane {
	Group p;
	MTFiducial fiducial;
	RotateTransition rt;
	MTFiducialConfig cfg;
	float tempo;
    double minAlpha = 0.33;
    double maxAlpha = 0.8;
    double mult = 1;
    OscSender oscSender;
    float mCursor;
    
    public MTPane(MTFiducialConfig cfg) {
    	this.cfg = cfg;
    	initHandlers();
    	createShape();
    }
    
	public synchronized void beat(OscSender oscSender, double curso)
	{
		this.oscSender = oscSender;
		mCursor = (tempo / 5) * (float)curso;
		
		float cos = Double.valueOf(Math.cos(mCursor)).floatValue();
		float sin = Double.valueOf(Math.sin(mCursor)).floatValue();
		
		if (1 >= sin && sin <0.95 && 0 < cos && cos < 0.5)
		{
			if (oscSender != null && cfg != null)
			{
				oscSender.sendMessage(new OSCMessage("/fmurf/live/"+cfg.getId()+"/bang/"+mCursor));
			}
		}
	}

	public MTFiducial getFiducial() {
		return fiducial;
	}

	private void initHandlers()
	{
		setOnTouchMoved(event -> {
		    setManaged(false);
		    this.setTranslateX(event.getTouchPoint().getX() + this.getTranslateX());
		    this.setTranslateY(event.getTouchPoint().getY() + this.getTranslateY());
		    rt.setAxis(new Point3D(event.getTouchPoint().getX(), event.getTouchPoint().getY(), 0));
		    event.consume();
		});
		setOnMouseDragged(event -> {
		    setManaged(false);
		    this.setTranslateX(event.getX() + this.getTranslateX());
		    this.setTranslateY(event.getY() + this.getTranslateY());
		    rt.setAxis(new Point3D(event.getX(), event.getY(), 0));
		    event.consume();
		});
	}

	private void createShape()
	{
		Group p = new Group();

		rt = new RotateTransition(Duration.millis(1250), p);
		
		fiducial = new MTFiducial(cfg);
		getChildren().add(fiducial);
		
		Rectangle c3 = new Rectangle(60, 60);
		c3.setFill(Color.BLUE);
		c3.setStroke(Color.BLUE);
		c3.setTranslateX(-c3.getWidth()/2);
		c3.setTranslateY(+-c3.getHeight()/2);
		getChildren().add(c3);
		
		p.getChildren().add(fiducial);
		p.getChildren().add(c3);

		getChildren().add(p);
		
	    rt.setByAngle(180);
	    rt.setCycleCount(Integer.MAX_VALUE);
	    rt.setAutoReverse(true);
	    rt.play();
	}
}
