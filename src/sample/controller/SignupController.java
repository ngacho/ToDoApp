package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.animations.Fader;
import sample.database.DatabaseHandler;
import sample.models.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootanchorpane_insignup;


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

        signup_loginbutton.setOnAction(actionEvent -> openLogInWindow());

        signup_signupbutton.setOnAction(actionEvent -> createUser());

    }

    private void openLogInWindow() {
        //Take users to log in screen
        try {
            AnchorPane showLogInWindow = FXMLLoader
                    .load(getClass().getResource("/sample/view/login.fxml"));

            Fader fadeTaskAdditionForm = new Fader();
            fadeTaskAdditionForm.appearFadeIn(showLogInWindow);

            rootanchorpane_insignup.getChildren().setAll(showLogInWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
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
            //adding data to our database
            if (firstNameText.equals("") || lastNameText.equals("") || userNameText.equals("") || passwordText.equals("")) {
                System.out.println("One of the fields is empty, cannot add to database");
            } else {
                User user = new User(firstNameText, lastNameText, userNameText, passwordText, genderText);
                databaseHandler.signUpUser(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        openLogInWindow();

    }
}
