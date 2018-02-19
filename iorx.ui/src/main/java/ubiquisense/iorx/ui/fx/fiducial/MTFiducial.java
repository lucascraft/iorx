package ubiquisense.iorx.ui.fx.fiducial;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public abstract class MTFiducial extends Circle {

	private float tempo;
	private int range;
	private String id;
	private MTFiducialConfig cfg;
	private OscSender oscSender;
    
    public OscSender getOscSender() {
		return oscSender;
	}
    
    public int getRange() {
		return range;
	}
    
    public void setID(String id)
    {
    	this.id = id;
    }
    
    public String getID()
    {
    	return this.id;
    }
    public void setRange(int range) {
		this.range = range;
	}

    public void setOscSender(OscSender oscSender) {
		this.oscSender = oscSender;
	}
    
	public MTFiducial(OscSender oscSender) {
		super((int)Math.min(100d, new Random().nextInt()*175));
		this.oscSender = oscSender;
		Random ran =new Random();
		this.tempo = 50 * ran.nextInt();
		Color c = Color.color(Math.min(0.7, ran.nextDouble()), Math.min(0.5, ran.nextDouble()), Math.min(0.6, ran.nextDouble()));
		setFill(c);
		setStroke(c);
		range = 0;
		id = "-1";
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
		id = "" + cfg.getId();
		init();
	}

	public MTFiducial(int radius, int tempo) {
		super(radius);
		this.cfg = new MTFiducialConfig(radius, tempo);
		this.tempo = tempo;
		id = "-1";
		init();
	}
	
}
