package sample.controller;

import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    void initialize(){

        signup_loginbutton.setOnAction(actionEvent -> {
            //Take users to log in screen
            signup_loginbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/login.fxml"));

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

        DatabaseHandler databaseHandler = new DatabaseHandler();
        signup_signupbutton.setOnAction(actionEvent -> {
            //Getting text from input fields.
            String gender = "";
            String firstNameText = signup_firstname.getText().trim();
            String lastNameText = signup_lastname.getText().trim();
            String userNameText = signup_username.getText().trim();
            String passwordText = signup_password.getText().trim();
            if(signup_female_checkbox.isSelected()){
                gender = "female";
            }else if(signup_male_checkbox.isSelected()) {
                gender = "male";
            }
            String genderText = gender;
            System.out.println("Boop Beep: Sign up button clicked");
            try {
                databaseHandler.signUpUser(firstNameText, lastNameText, userNameText, passwordText, genderText);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}
