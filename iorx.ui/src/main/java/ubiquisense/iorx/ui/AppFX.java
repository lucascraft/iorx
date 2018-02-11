package ubiquisense.iorx.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ubiquisense.iorx.ui.config.JsonMTConfigParser;
import ubiquisense.iorx.ui.config.MTConfig;
import ubiquisense.iorx.ui.fx.MTController;

public class AppFX extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		
		
		initRootLayout();

		initMTPane();
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
	public void initMTPane() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AppFX.class.getResource("fxml/MTScene.fxml"));
			
			GridPane mtPane = (GridPane) loader.load();
			
			MTConfig cfg = new JsonMTConfigParser().parse("src/config//iorx.config");

			MTController controller = loader.<MTController>getController();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(mtPane);
			
			controller.initData(this, cfg, (Pane) mtPane.getChildren().get(1));

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
