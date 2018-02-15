package ubiquisense.iorx.ui.fx.fiducial;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.javatuples.Pair;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.illposed.osc.OSCMessage;

import javafx.animation.RotateTransition;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;

public class MTPane extends Pane {
	
	Group p;
	MTFiducial fiducial;
	RotateTransition rt;
	MTFiducialConfig cfg;
	OscSender oscSender;
	
	float tempo;
    double minAlpha = 0.33;
    double maxAlpha = 0.8;
    double mult = 1;
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

	
	public void updateConnections()
	{
		Set<Pair<MTFiducial, MTFiducial>> connectibles = computeConnectibles();
		
		Set<Line> lines = ((Pane)getParent()).getChildren().stream().filter(c -> c instanceof Line).map(c -> (Line) c).collect(Collectors.toSet());
		
		((Pane)getParent()).getChildren().removeAll(lines);
		
		connectibles.forEach(k -> {
			Line line = new Line();
			((Pane)getParent()).getChildren().add(line);
			line.setFill(Color.RED);
			line.setStrokeWidth(4);
			line.setStroke(Color.RED);
			Point2D p1 = k.getValue0().localToScene(new Point2D(k.getValue0().getCenterX(), k.getValue0().getCenterY()));
			Point2D p2 = k.getValue1().localToScene(new Point2D(k.getValue1().getCenterX(), k.getValue1().getCenterY()));
			line.setStartX(p1.getX());
			line.setStartY(p1.getY());
			line.setEndX(p2.getX());
			line.setEndY(p2.getY());
			line.toBack();
		});
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
		    this.setTranslateX(event.getTouchPoint().getX() + this.getTranslateX());
		    this.setTranslateY(event.getTouchPoint().getY() + this.getTranslateY());
		    rt.setAxis(new Point3D(event.getTouchPoint().getX(), event.getTouchPoint().getY(), 0));
		    event.consume();
		    updateConnections();
		});
		setOnMouseDragged(event -> {
		    setManaged(false);
		    this.setTranslateX(event.getX() + this.getTranslateX());
		    this.setTranslateY(event.getY() + this.getTranslateY());
		    rt.setAxis(new Point3D(event.getX(), event.getY(), 0));
		    event.consume();
		    updateConnections();
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
		c3.setTranslateY(-c3.getHeight()/2);
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
