package dad.login.fxml;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class LoginView extends GridPane {

	private HBox buttonsBox;
	private TextField usernameText;
	private PasswordField passwordText;
	private CheckBox ldapCheck;
	private Button accederButton, cancelarButton;
	
	public LoginView() {
		super();
		
		usernameText = new TextField();
		usernameText.setPromptText("Nombre de usuario");

		passwordText = new PasswordField();
		passwordText.setPromptText("Contraseña");
		
		ldapCheck = new CheckBox("Usar LDAP");
		
		accederButton = new Button("Acceder");
		accederButton.setMinWidth(USE_PREF_SIZE);
		accederButton.setDefaultButton(true);
		cancelarButton = new Button("Cancelar");
		cancelarButton.setMinWidth(USE_PREF_SIZE);
		buttonsBox = new HBox(5, accederButton, cancelarButton);
		
		setAlignment(Pos.CENTER);
//		setGridLinesVisible(true);
		setPadding(new Insets(10,10,10,10));;
		setHgap(5);
		setVgap(5);
		addRow(0, new Label("Usuario:"), usernameText);
		addRow(1, new Label("Contraseña:"), passwordText);
		addRow(2, new Label(""), ldapCheck);
		addRow(3, buttonsBox);
		
		ColumnConstraints[] cols = {
			new ColumnConstraints(),
			new ColumnConstraints()
		};
		getColumnConstraints().setAll(cols);
		cols[0].setMaxWidth(USE_PREF_SIZE);
		cols[1].setHgrow(Priority.ALWAYS);

		buttonsBox.setAlignment(Pos.CENTER);
		
		setColumnSpan(buttonsBox, 2);
		
	}

	public HBox getButtonsBox() {
		return buttonsBox;
	}

	public TextField getUsernameText() {
		return usernameText;
	}

	public PasswordField getPasswordText() {
		return passwordText;
	}

	public CheckBox getLdapCheck() {
		return ldapCheck;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}
	
}
