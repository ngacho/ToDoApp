package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtfield_login_username;

    @FXML
    private Button btn_login_login;

    @FXML
    private PasswordField passfield_login_password;

    @FXML
    private Button btn_login_signup;

    @FXML
    void initialize() {
        btn_login_login.setOnAction(actionEvent -> {

        });

    }
}
