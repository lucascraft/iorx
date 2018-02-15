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
    public String getID()
    {
    	return "" + cfg.getId();
    }

	public MTFiducial(OscSender oscSender) {
		super((int)Math.min(100d, new Random().nextInt()*175));
		this.oscSender = oscSender;
		Random ran =new Random();
		this.tempo = 50 * ran.nextInt();
		Color c = Color.color(Math.min(0.7, ran.nextDouble()), Math.min(0.5, ran.nextDouble()), Math.min(0.6, ran.nextDouble()));
		setFill(c);
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
