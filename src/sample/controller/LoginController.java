package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
        String loginUsername = txtfield_login_username.getText().trim();
        String loginPassword = passfield_login_password.getText().trim();

        btn_login_signup.setOnAction(actionEvent -> {
            //take users to sign up screen
            btn_login_signup.getScene().getWindow().hide();//use the sign up button to get the active window then hide the active window to show sign up activity
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/signup.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();

        });
        btn_login_login.setOnAction(actionEvent -> {
            if (!loginUsername.equals("") || !loginPassword.equals("")){
                loginUser(loginUsername, loginPassword);
            }else{
                System.out.println("Error in logging in user");
            }

        });

    }

    private void loginUser(String username, String Password) {
        //check if user exists in database.

    }
}
