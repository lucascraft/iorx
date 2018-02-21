package ubiquisense.iorx.ui.fx.fiducial;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.javatuples.Pair;

import com.google.common.collect.Sets;
import com.illposed.osc.OSCMessage;

import javafx.animation.RotateTransition;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.impl.SimpleMTFiducial;

public class MTPane extends Pane {
	
	private Group p;
	private MTFiducial fiducial;
	private RotateTransition rt;
	private MTFiducialConfig cfg;
	private OscSender oscSender;
	private Set<Pair<MTFiducial, MTFiducial>> connected;
	private float tempo;
	private double minAlpha = 0.33;
	private double maxAlpha = 0.8;
	private double mult = 1;
	private float mCursor;
	private boolean fixed;
    
    public MTPane() {
    	fixed = false;
    	connected = Sets.newHashSet();
    	initHandlers();
	}
    
    public void setFiducial(MTFiducial fiducial) {
		this.fiducial = fiducial;
	}
    
    public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
    
    public boolean isFixed() {
		return fixed;
	}

    public MTPane(MTFiducialConfig cfg) {
    	this();
    	this.cfg = cfg;
    	createShape();
    }
    
	public synchronized void beat(OscSender oscSender, double curso)
	{
		this.oscSender = oscSender;
		fiducial.setOscSender(oscSender);
		mCursor = (tempo / 5) * (float)curso;
		
		float cos = Double.valueOf(Math.cos(mCursor)).floatValue();
		float sin = Double.valueOf(Math.sin(mCursor)).floatValue();
		
		if (1 >= sin && sin <0.95 && 0 < cos && cos < 0.5)
		{
			if (oscSender != null && cfg != null)
			{
				OSCMessage msg = new OSCMessage("/smurf/fid/"+fiducial.getId()+"/add/");

				Point2D pt = fiducial.localToScene(new Point2D(fiducial.getCenterX(), fiducial.getCenterY()));

			    float x = Double.valueOf(pt.getX()).floatValue();
			    float y = Double.valueOf(pt.getY()).floatValue();
			    
			    float r = Double.valueOf(fiducial.getAngle()).floatValue();
			    
			    msg.addArgument(x);
				msg.addArgument(y);
				
			    msg.addArgument(r);

				oscSender.sendMessage(msg);
			}
		}
	}

	public MTFiducial getFiducial() {
		return fiducial;
	}

	
	public void updateConnections()
	{
		Set<Pair<MTFiducial, MTFiducial>> connectibles = computeConnectibles();
		
		Set<Line> lines = ((Pane)getParent()).getChildren().stream().filter(c -> c instanceof Line).map(c -> (Line) c).collect(Collectors.toSet());
		
		((Pane)getParent()).getChildren().removeAll(lines);
		
		connectibles.forEach(k -> {
			Line line = new Line();
			((Pane)getParent()).getChildren().add(line);
			line.setFill(Color.RED);
			line.setStrokeWidth(12);
			line.setStroke(Color.RED);
			Point2D p1 = k.getValue0().localToScene(new Point2D(k.getValue0().getCenterX(), k.getValue0().getCenterY()));
			Point2D p2 = k.getValue1().localToScene(new Point2D(k.getValue1().getCenterX(), k.getValue1().getCenterY()));
			line.setStartX(p1.getX());
			line.setStartY(p1.getY());
			line.setEndX(p2.getX());
			line.setEndY(p2.getY());
			line.toBack();
		});
		
		handleEvents(connectibles);
	}
	
	private void handleEvents(Set<Pair<MTFiducial, MTFiducial>> connectibles)
	{
		Set<Pair<MTFiducial, MTFiducial>> removed = Sets.newHashSet();
		for (Pair<MTFiducial, MTFiducial> alreadyConected : connected)
		{
			boolean wasRemoved = true;
			for (Pair<MTFiducial, MTFiducial> connectible : connectibles)
			{
				if (connectible.getValue0().equals(alreadyConected.getValue0()) && connectible.getValue1().equals(alreadyConected.getValue1()))
				{
					wasRemoved = false;
				}
				else if (connectible.getValue0().equals(alreadyConected.getValue1()) && connectible.getValue1().equals(alreadyConected.getValue0()))
				{
					wasRemoved = false;
				} 
			}
			if (wasRemoved)
			{
					removed.add(alreadyConected);
			}
		}
		for (Pair<MTFiducial, MTFiducial> toRemove : removed)
		{
			if (toRemove.getValue0().equals(getFiducial()) || toRemove.getValue1().equals(getFiducial()))
			{
				onRemove(toRemove);
			}
		}
		
		Set<Pair<MTFiducial, MTFiducial>>  added = Sets.newHashSet();
		for (Pair<MTFiducial, MTFiducial> connectible : connectibles)
		{
			boolean wasAdded = true;
			for (Pair<MTFiducial, MTFiducial> c : connected)
			{
				if (connectible.getValue0().equals(c.getValue0()) && connectible.getValue1().equals(c.getValue1()))
				{
					wasAdded = false;
					break;
				}
				else if (connectible.getValue0().equals(c.getValue1()) && connectible.getValue1().equals(c.getValue0()))
				{
					wasAdded = false;
					break;
				} 
			}
			if (wasAdded)
			{
				added.add(connectible);
			}
		}
		for (Pair<MTFiducial, MTFiducial> toAdd : added)
		{
			if (toAdd.getValue0().equals(getFiducial()) || toAdd.getValue1().equals(getFiducial()))
			{
				onAdd(toAdd);
			}
		}
		
		connected.clear();
		connected.addAll(connectibles);
	}
	
	private void onAdd(Pair<MTFiducial, MTFiducial> added)
	{
		OSCMessage msg = new OSCMessage("/smurf/connection/add");
		
		int from = Integer.valueOf(added.getValue0().getID());
		int to = Integer.valueOf(added.getValue1().getID());
		int r = Double.valueOf(fiducial.getAngle()).intValue();
		
		msg.addArgument(from);
		msg.addArgument(to);
	    msg.addArgument(r);
	    
	    System.out.println("/smurf/connection/add (" + from + " to " + to + ")");
		
	    fiducial.getOscSender().sendMessage(msg);
	}
	
	private void onRemove(Pair<MTFiducial, MTFiducial> removed)
	{
		OSCMessage msg = new OSCMessage("/smurf/connection/remove");
		
		int from = Integer.valueOf(removed.getValue0().getID());
		int to = Integer.valueOf(removed.getValue1().getID());
		int r = Double.valueOf(fiducial.getAngle()).intValue();
		
		msg.addArgument(from);
		msg.addArgument(to);
	    msg.addArgument(r);
	
	    System.out.println("/smurf/connection/remove (" + from + " to " + to + ")");

		fiducial.getOscSender().sendMessage(msg);
	}

	public Set<Pair<MTFiducial, MTFiducial>> computeConnectibles()
	{
		Set<Pair<MTFiducial, MTFiducial>> connectibles = Sets.newHashSet();
		for (Node n : ((Pane)getParent()).getChildrenUnmodifiable())
		{
			Function<Node, MTFiducial> n2m = nm -> ((MTPane)nm).getFiducial();
			Predicate<Node> p1 = c -> (n instanceof MTPane) && (c instanceof MTPane) && ((MTPane)n).getFiducial() != ((MTPane)c).getFiducial();
			((Pane)getParent()).getChildrenUnmodifiable().stream().filter(p1).map(n2m).forEach(fid -> {
				MTFiducial fid2 = ((MTPane)n).getFiducial();
				double dist = fid2.localToScene(new Point2D(fid2.getCenterX(), fid2.getCenterY())).distance(fid.localToScene(new Point2D(fid.getCenterX(), fid.getCenterY())));
				if (dist < fid2.getRange()*6 && dist < fid.getRange()*6)
				{
					Predicate<Pair<MTFiducial, MTFiducial>> alreadyConnected = t -> (t.getValue0() == fid && t.getValue1() == fid2) || (t.getValue1() == fid && t.getValue0() == fid2); 
					if (connectibles.stream().noneMatch(alreadyConnected))
					{
						connectibles.add(new Pair<MTFiducial, MTFiducial>(fid, fid2));
					}
				}
			});
		}
		return connectibles;
	}
	

	private void initHandlers()
	{
		setOnTouchMoved(event -> {
			setManaged(false);
			if (!isFixed())
			{
			    this.setTranslateX(event.getTouchPoint().getX() + this.getTranslateX());
			    this.setTranslateY(event.getTouchPoint().getY() + this.getTranslateY());
			    rt.setAxis(new Point3D(event.getTouchPoint().getX(), event.getTouchPoint().getY(), 0));
			    
				Point2D pt = fiducial.localToScene(new Point2D(event.getTouchPoint().getX() + this.getTranslateX(), event.getTouchPoint().getY() + this.getTranslateY()));

			    float x = Double.valueOf(pt.getX()).floatValue();
			    float y = Double.valueOf(pt.getY()).floatValue();
			    
			    float r = Double.valueOf(fiducial.getAngle()).floatValue();
			    
			    OSCMessage msg = new OSCMessage("/smurf/fid/"+fiducial.getID()+"/update");
			    
			    msg.addArgument(x);
			    msg.addArgument(y);
			    msg.addArgument(r);
			    msg.addArgument(100f);
			    
			    System.out.println("/smurf/fid/"+fiducial.getID()+"/update"+ "("+x+","+y+","+r+")");

			    fiducial.getOscSender().sendMessage(msg);
			    
			    event.consume();
			}
			updateConnections();
		});
		
		setOnMouseDragged(event -> {
		    setManaged(false);
			if (!isFixed())
			{
			    this.setTranslateX(event.getX() + this.getTranslateX());
			    this.setTranslateY(event.getY() + this.getTranslateY());
			    rt.setAxis(new Point3D(event.getX(), event.getY(), 0));
			    
				Point2D pt = fiducial.localToScene(new Point2D(event.getX() + this.getTranslateX(), event.getY() + this.getTranslateY()));

			    float x = Double.valueOf(pt.getX()).floatValue();
			    float y = Double.valueOf(pt.getY()).floatValue();
			    
			    float r = Double.valueOf(fiducial.getAngle()).floatValue();
			    
			    OSCMessage msg = new OSCMessage("/smurf/fid/"+fiducial.getID()+"/update");
			    
			    msg.addArgument(x);
			    msg.addArgument(y);
			    msg.addArgument(r);
			    msg.addArgument(100f);
	    
			    System.out.println("/smurf/fid/"+fiducial.getID()+"/update"+ "("+x+","+y+","+r+")");

			    fiducial.getOscSender().sendMessage(msg);
			    event.consume();
			}
		    updateConnections();
		});
	}

	private void createShape()
	{
		Group p = new Group();

		rt = new RotateTransition(Duration.millis(1250), p);
		
		fiducial = new SimpleMTFiducial(cfg);
		fiducial.setOscSender(oscSender);
		getChildren().add(fiducial);
		
		Rectangle c3 = new Rectangle(60, 60);
		c3.setFill(Color.BLUE);
		c3.setStroke(Color.BLUE);
		c3.setTranslateX(-c3.getWidth()/2);
		c3.setTranslateY(-c3.getHeight()/2);
		getChildren().add(c3);
		
		Text text = new Text(fiducial.getID());
		text.setFont(new Font("Tahoma", 32));
		text.setFill(getFiducial().getFill());
		text.setStroke(getFiducial().getStroke());
		text.setTranslateX(-text.getBoundsInLocal().getHeight()/4);
		text.setTranslateY(+text.getBoundsInLocal().getWidth()/2);

		getChildren().add(text);
		
		p.getChildren().add(fiducial);
		p.getChildren().add(c3);

		getChildren().add(p);
		text.toFront();
		
		Arc arc = new Arc();
		arc.setCenterX(getFiducial().getCenterX());
		arc.setCenterY(getFiducial().getCenterY());
		arc.setRadiusX(getFiducial().getRadius()-8);
		arc.setRadiusY(getFiducial().getRadius()-8);
		arc.setStartAngle(0f);
		arc.setStroke(Color.RED);
		arc.setStrokeWidth(12);
		arc.setFill(null);
		arc.setType(ArcType.OPEN);

		MTCursor cursor = new MTCursor(getFiducial(), arc);
		cursor.setRadius(20);
		
        arc.toFront();
		cursor.toFront();

		getChildren().add(arc);
		getChildren().add(cursor);

	    rt.setByAngle(180);
	    rt.setCycleCount(Integer.MAX_VALUE);
	    rt.setAutoReverse(true);
	    rt.play();
	    
	}
}
