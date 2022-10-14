package dad.login.fxml;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	
	LoginView view = new LoginView();
	LoginModel model = new LoginModel();
	
	Stage primaryStage;
	
	public LoginController(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		
		model.usernameProperty().bind(view.getUsernameText().textProperty());
		model.passwordProperty().bind(view.getPasswordText().textProperty());
		model.IdapProperty().bind(view.getLdapCheck().selectedProperty());
		
		view.getCancelarButton().setOnAction(this::onCancelarAction);
		view.getAccederButton().setOnAction(this::onAccederAction);
	}
	
	private void onAccederAction(ActionEvent e) {
		boolean useLdap = model.isIdap();
		
		AuthService auth = useLdap ? new LdapAuthService() : new FileAuthService();
		try {
			if(auth.login(model.getUsername(), model.getPassword()))
				loginCorrecto();
			else 
				loginIncorrecto();
		} catch (Exception e1) { e1.printStackTrace(); }
	}
	
	private void loginCorrecto() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(primaryStage); // para que la ventana salga centralizada en torno al dueño
		alert.setTitle("Iniciar Sesión");
		alert.setHeaderText("Acceso permitido");
		alert.setContentText("Las credenciales de acceso son válidas");
		alert.showAndWait();
		close();
	}
	
	private void loginIncorrecto() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(primaryStage); // para que la ventana salga centralizada en torno al dueño
		alert.setTitle("Iniciar Sesión");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o contraseña no son válidos");
		alert.showAndWait();
		limpiar();
	}
	
	private void onCancelarAction(ActionEvent e) {
		close();
	}
	
	private void limpiar() {
		view.getUsernameText().setText("");
		view.getPasswordText().setText("");
		view.getLdapCheck().setSelected(false);
	}
	
	private void close() {
		primaryStage.close();
	}
	
	public LoginView getView() {
		return view;
	}
	
	public LoginModel getModel() {
		return model;
	}

}