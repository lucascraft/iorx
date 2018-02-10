package ubiquisense.iorx.ui.fx;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ubiquisense.iorx.ui.fmurf.SmurfBrainImpl;

//@IDProperty(value="mtMenuEdit")
public class MTController implements Initializable {
	private SmurfBrainImpl brain;
	private Pane mtPane;

	public void initData(SmurfBrainImpl smurfBrain, Pane pane) {
		brain = smurfBrain;
		mtPane = pane;
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
		System.out.println("addFiducialAction");

		MTCircle r = new MTCircle(100d);
		Random ran = new Random();
		
		r.setTranslateX(ran.nextDouble()*mtPane.getWidth());
		r.setTranslateY(ran.nextDouble()*mtPane.getHeight());

		mtPane.getChildren().add(r);
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
	}

	@FXML
	private void closeMTApp(ActionEvent e) {
		System.out.println("exit");
		System.exit(0);
	}

}