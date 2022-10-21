package dad.login;

import dad.login.fxml.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {

	LoginController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new LoginController(primaryStage);
		
		primaryStage.setTitle("Login.fxml");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
