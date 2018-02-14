package ubiquisense.iorx.ui.fx.fiducial;

import java.util.Random;

import com.illposed.osc.OSCMessage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public class MTFiducial extends Circle {

	float tempo;
    double minAlpha = 0.33;
    double maxAlpha = 0.8;
    double mult = 1;
    MTFiducialConfig cfg;
    OscSender oscSender;
    float mCursor;
    int range;
    public int getRange() {
		return range;
	}
	public synchronized void beat(OscSender oscSender, double curso)
	{
		this.oscSender = oscSender;
		mCursor = (tempo / 5) * (float)curso;
		range = cfg.getRange();
		
		float cos = Double.valueOf(Math.cos(mCursor)).floatValue();
		float sin = Double.valueOf(Math.sin(mCursor)).floatValue();
		
		if (1 >= sin && sin <0.95 && 0 < cos && cos < 0.5)
		{
			if (oscSender != null && cfg != null)
			{
				oscSender.sendMessage(new OSCMessage("/fmurf/live/"+cfg.getId()+"/bang/"+mCursor));
			}
		}

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
	}

	

	public MTFiducial(OscSender oscSender) {
		super((int)Math.min(100d, new Random().nextInt()*175));
		this.oscSender = oscSender;
		Random ran =new Random();
		this.tempo = 50 * ran.nextInt();
		Color c = Color.color(Math.min(0.7, ran.nextDouble()), Math.min(0.5, ran.nextDouble()), Math.min(0.6, ran.nextDouble()));
		setFill(c/*.deriveColor(1.0, 1.0, 1.0, 0.2)*/);
		setStroke(c);
		range = 120;
	}
	
	private void init()
	{
		setFill(cfg.getFg());
		setStroke(cfg.getFg());
		range = cfg.getRange();
	}
	
	public MTFiducial(MTFiducialConfig cfg) {
		super(cfg.getRadius());
		this.cfg = cfg;
		this.tempo = cfg.getTempo();
		init();
	}

	public MTFiducial(int radius, int tempo) {
		super(radius);
		this.cfg = new MTFiducialConfig(radius, tempo);
		this.tempo = tempo;
		init();
	}

	private void react(double x, double y)
	{
		OSCMessage msg = new OSCMessage("/fmurf/live/"+cfg.getId()+"/fid/touch/"+mCursor);
		msg.addArgument(x);
		msg.addArgument(y);
		oscSender.sendMessage(msg);
	}
}
