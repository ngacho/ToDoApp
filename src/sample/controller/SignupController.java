package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signup_loginbutton;

    @FXML
    private TextField signup_firstname;

    @FXML
    private TextField signup_lastname;

    @FXML
    private TextField signup_username;

    @FXML
    private PasswordField signup_password;

    @FXML
    private CheckBox signup_male_checkbox;

    @FXML
    private CheckBox signup_female_checkbox;

    @FXML
    private Button signup_signupbutton;

    @FXML
    void initialize() {

    }
}
