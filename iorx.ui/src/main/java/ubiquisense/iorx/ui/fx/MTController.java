package ubiquisense.iorx.ui.fx;

import java.awt.Point;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import org.javatuples.Pair;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.illposed.osc.OSCMessage;
import com.sun.javafx.application.PlatformImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import ubiquisense.iorx.ui.AppFX;
import ubiquisense.iorx.ui.config.MTConfig;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.MTFiducial;
import ubiquisense.iorx.ui.fx.fiducial.MTPane;

//@IDProperty(value="mtMenuEdit")
public class MTController implements Initializable {
	private Pane mtPane;
	private AppFX app;
	private MTConfig cfg;
	private OscSender oscSender;
	
	private double cursor;
	private double lastBang = Double.MIN_VALUE;
	Map<Pair<MTFiducial, MTFiducial>, Line> connectionsMap;
	
	public void initData(AppFX app, MTConfig cfg, Pane pane) {
		this.app = app;
		this.cfg = cfg;
		this.mtPane = pane;
		oscSender = new OscSender(cfg.getOutAddr(), cfg.getOutOscPort());
		connectionsMap = Maps.newHashMap();
		cfg.getFiducials().forEach(fidCfg -> { mtPane.getChildren().add(createMTFiducial(fidCfg)); });
		
	  	Runnable r = new Runnable() {
				@Override
			public void run() {
				do {
					try {
						if (cursor > lastBang)
						{
							oscSender.sendMessage(new OSCMessage("/fmurf/live/bang/"+lastBang));
							lastBang = cursor+0.33; // 60 bpm
						}
						cursor += 0.01;
						pane.getChildrenUnmodifiable().forEach(c -> { if (c instanceof MTPane) {((MTPane)c).beat(oscSender, cursor);}});

						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while (true);
			}
		};
		new Thread(r).start();
			
	}
	
	public void updateConnections()
	{
		Set<Pair<MTFiducial, MTFiducial>> connectibles = computeConnectibles();
		Set<Pair<MTFiducial, MTFiducial>> pairs = Sets.difference(connectionsMap.keySet(), connectibles);
		
		pairs.forEach(p -> {
			mtPane.getChildren().remove(connectionsMap.get(p));
			connectionsMap.remove(p);
		});
		connectibles.forEach(p -> {
			if (!connectionsMap.containsKey(p))
			{
				Line line = new Line();
				connectionsMap.put(p, line);
				mtPane.getChildren().add(line);
			}
		});
		
		for (Pair<MTFiducial, MTFiducial> k :connectionsMap.keySet())
		{
			Line line = connectionsMap.get(k);
			line.setFill(Color.RED);
			line.setStroke(Color.RED);
			line.setStartX(k.getValue0().getCenterX());
			line.setStartY(k.getValue0().getCenterY());
			line.setEndX(k.getValue1().getCenterX());
			line.setEndX(k.getValue1().getCenterY());
		}

	}

	public Set<Pair<MTFiducial, MTFiducial>> computeConnectibles()
	{
		Set<Pair<MTFiducial, MTFiducial>> connectibles = Sets.newHashSet();
		for (Node n : mtPane.getChildrenUnmodifiable())
		{
			Function<Node, MTFiducial> n2m = nm -> ((MTPane)nm).getFiducial();
			Predicate<Node> p1 = c -> (n instanceof MTPane) && (c instanceof MTPane) && ((MTPane)n).getFiducial() != ((MTPane)c).getFiducial();
			mtPane.getChildrenUnmodifiable().stream().filter(p1).map(n2m).forEach(fid -> {
				MTFiducial fid2 = ((MTPane)n).getFiducial();
				double dist = fid2.localToScene(new Point2D(fid2.getCenterX(), fid2.getCenterY())).distance(fid.localToScene(new Point2D(fid.getCenterX(), fid.getCenterY())));
				if (dist < fid2.getRange() || dist < fid.getRange())
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
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	}
	

	@FXML
	public void onTouchMovedAction(TouchEvent e) {
		System.out.println("onTouchMovedAction");
	}

	@FXML
	public void onTouchPressedAction(TouchEvent e) {
		System.out.println("onTouchPressedAction");
	}

	@FXML
	public void onTouchReleasedAction(TouchEvent e) {
		System.out.println("onTouchReleasedAction");
	}

	@FXML
	public void onTouchStationaryAction(TouchEvent e) {
		System.out.println("onTouchStationaryAction");
	}

	@FXML
	private void addFiducialAction(ActionEvent e) {
		Random ran = new Random();
		mtPane.getChildren().add(new MTPane( new MTFiducialConfig(100, 100)));
	}

	@FXML
	private void deleteFiducialAction(ActionEvent e) {
		System.out.println("deleteFiducialAction");
	}

	@FXML
	private void editFiducialAction(ActionEvent e) {
		System.out.println("editFiducialAction");
	}

	@FXML
	private void resetFiducialsAction(ActionEvent e) {
		System.out.println("resetFiducialsAction");
		mtPane.getChildren().clear();
	}

	@FXML
	private void closeMTApp(ActionEvent e) {
		System.out.println("exit");
		try {
			app.stop();
			PlatformImpl.exit();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private MTPane createMTFiducial(MTFiducialConfig cfg)
	{
		return new MTPane(cfg);
	}
	
	@FXML
	private void onContextMenuRequestedAction()
	{
	}
	@FXML
	private void OnRotateAction()
	{
	}
	@FXML
	private void OnRotationFinishedAction()
	{
	}
	@FXML
	private void OnRotationStartedAction()
	{
	}
	@FXML
	private void onSwipeDownAction()
	{
	}
	@FXML
	private void onSwipeLeftAction()
	{
	}
	@FXML
	private void onSwipeRightAction()
	{
	}
	@FXML
	private void onSwipeUpAction()
	{
	}
	@FXML
	private void onZoomAction()
	{
	}
	@FXML
	private void onZoomAFinishedction()
	{
	}
	@FXML
	private void onZoomStartedAction()
	{
	}
}