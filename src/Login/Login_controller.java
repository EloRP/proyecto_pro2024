package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login_controller {

    @FXML
    private Button botonLogin;

    @FXML
    private Button botonSignup;

    @FXML
    private PasswordField campoPassword;

    @FXML
    private TextField campoUsername;

    @FXML
    void loginMethod(ActionEvent event) {
        Login_modelo.login(campoUsername.getText(), campoPassword.getText());
    }

    @FXML
    void signupMethod(ActionEvent event) {
        Login_modelo.signup(campoUsername.getText(), campoPassword.getText());
    }
}
