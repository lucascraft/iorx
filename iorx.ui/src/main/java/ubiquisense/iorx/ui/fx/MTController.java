package ubiquisense.iorx.ui.fx;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.application.PlatformImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import ubiquisense.iorx.ui.AppFX;
import ubiquisense.iorx.ui.config.MTConfig;
import ubiquisense.iorx.ui.config.MTFiducialConfig;
import ubiquisense.iorx.ui.fx.fiducial.MTFiducial;

//@IDProperty(value="mtMenuEdit")
public class MTController implements Initializable {
	private Pane mtPane;
	private AppFX app;
	private MTConfig cfg;
	
	private double cursor;

	
	public void initData(AppFX app, MTConfig cfg, Pane pane) {
		this.app = app;
		this.cfg = cfg;
		this.mtPane = pane;
		
		cfg.getFiducials().forEach(fidCfg -> { mtPane.getChildren().add(createMTFiducial(fidCfg)); });
		
	  	Runnable r = new Runnable() {
				@Override
			public void run() {
				do {
					try {
						cursor += 0.01;
						pane.getChildrenUnmodifiable().forEach(c -> { if (c instanceof MTFiducial) {((MTFiducial)c).beat(cursor);}});
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
		mtPane.getChildren().add(new MTFiducial());
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
	
	private MTFiducial createMTFiducial(MTFiducialConfig cfg)
	{
		return new MTFiducial(cfg);
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