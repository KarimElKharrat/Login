package dad.login.fxml;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {
	
	private StringProperty username = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private BooleanProperty Idap = new SimpleBooleanProperty();
	
	public final StringProperty usernameProperty() {
		return this.username;
	}
	
	public final String getUsername() {
		return this.usernameProperty().get();
	}
	
	public final void setUsername(final String username) {
		this.usernameProperty().set(username);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	public final BooleanProperty IdapProperty() {
		return this.Idap;
	}
	
	public final boolean isIdap() {
		return this.IdapProperty().get();
	}
	
	public final void setIdap(final boolean Idap) {
		this.IdapProperty().set(Idap);
	}
	
	
	

}
