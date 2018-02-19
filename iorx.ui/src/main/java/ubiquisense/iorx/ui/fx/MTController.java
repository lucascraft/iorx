package ubiquisense.iorx.ui.fx;

import java.net.URL;
import java.util.ResourceBundle;

import com.illposed.osc.OSCMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import ubiquisense.iorx.ui.AppFX;
import ubiquisense.iorx.ui.config.MTConfig;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fmurf.osc.OscSender;
import ubiquisense.iorx.ui.fx.fiducial.MTPane;
import ubiquisense.iorx.ui.fx.fiducial.impl.DacMTFiducial;

public class MTController implements Initializable {
	
	private Pane mtPane;
	private AppFX app;
	private OscSender oscSender;
	
	private double cursor;
	private double lastBang = Double.MIN_VALUE;
	private DacMTFiducial dac;
	
	public void initData(AppFX app, MTConfig cfg, Pane pane) {
		
		this.app = app;
		this.mtPane = pane;
		this.oscSender = new OscSender(cfg.getOutAddr(), cfg.getOutOscPort());
		
		
		MTPane dacPAne = new MTPane();
		
		dac = new DacMTFiducial(oscSender);
		dac.setOscSender(oscSender);
		dac.setId("440");
		dac.setFill(Color.WHITE);
		dac.setRadius(50);
		dac.setRange(50);
		dacPAne.setFixed(true);;
		dacPAne.setFiducial(dac);
		dacPAne.getChildren().add(dac);
		mtPane.getChildren().add(dacPAne);
		
		
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
						
						dac.setCenterX(mtPane.getWidth()/2);
						dac.setCenterY(mtPane.getHeight()/2);

						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while (true);
			}
		};
		new Thread(r).start();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	}
	
	@FXML
	public void onTouchMovedAction(TouchEvent e) {
		System.out.println("onTouchMovedAction");
		OSCMessage msg = new OSCMessage("/fmurf/live/touch/"+e.getTouchPoint().getId()+"/moved");
		msg.addArgument(e.getTouchPoint().getX());
		msg.addArgument(e.getTouchPoint().getY());
		oscSender.sendMessage(msg);
	}

	@FXML
	public void onTouchPressedAction(TouchEvent e) {
		System.out.println("onTouchPressedAction");
		OSCMessage msg = new OSCMessage("/fmurf/live/touch/"+e.getTouchPoint().getId()+"/pressed");
		msg.addArgument(e.getTouchPoint().getX());
		msg.addArgument(e.getTouchPoint().getY());
		oscSender.sendMessage(msg);
	}

	@FXML
	public void onTouchReleasedAction(TouchEvent e) {
		System.out.println("onTouchReleasedAction");
		OSCMessage msg = new OSCMessage("/fmurf/live/touch/"+e.getTouchPoint().getId()+"/released");
		msg.addArgument(e.getTouchPoint().getX());
		msg.addArgument(e.getTouchPoint().getY());
		oscSender.sendMessage(msg);
	}

	@FXML
	public void onTouchStationaryAction(TouchEvent e) {
		OSCMessage msg = new OSCMessage("/fmurf/live/touch/"+e.getTouchPoint().getId()+"/stationnary");
		msg.addArgument(e.getTouchPoint().getX());
		msg.addArgument(e.getTouchPoint().getY());
		oscSender.sendMessage(msg);
	}

	@FXML
	private void addFiducialAction(ActionEvent e) {
		mtPane.getChildren().add(new MTPane(new MTFiducialConfig(100, 100)));
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