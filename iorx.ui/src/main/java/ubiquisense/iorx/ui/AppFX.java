package ubiquisense.iorx.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ubiquisense.iorx.ui.fmurf.SmurfFloorImpl;
import ubiquisense.iorx.ui.fx.MTController;

public class AppFX extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();

		showPersonOverview();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AppFX.class.getResource("fxml/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showPersonOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AppFX.class.getResource("fxml/MTScene.fxml"));
			
			GridPane mtPane = (GridPane) loader.load();
			SmurfFloorImpl smurfFloor = new SmurfFloorImpl(primaryStage.getScene(), mtPane, 80, 80);

			MTController controller = loader.<MTController>getController();
			controller.initData(smurfFloor.getBrain(), (Pane) mtPane.getChildren().get(1));

			// Set person overview into the center of root layout.
			rootLayout.setCenter(mtPane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
