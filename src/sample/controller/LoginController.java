package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.animations.Fader;
import sample.animations.Shaker;
import sample.database.DatabaseHandler;
import sample.models.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    private int userId;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootanchorpane_inlogin;

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
        btn_login_signup.setOnAction(actionEvent -> openSignUpWindow());
        btn_login_login.setOnAction(actionEvent -> {
            logInUser();
        });

    }

    private void logInUser() {
        String logInUserName = txtfield_login_username.getText().trim();
        String logInPassword = passfield_login_password.getText().trim();
        User user = new User(logInUserName, logInPassword);

        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet userRow = databaseHandler.getUser(user);
        try {
            int counter = 0;
            while (userRow.next()){
                userId = userRow.getInt("userid");
                System.out.println(userId);
                counter++;
            }

            if(counter == 1){
                System.out.println("Log In successful!");
                showAddTasksWindow();
            }else{
                Shaker shaker = new Shaker(txtfield_login_username, passfield_login_password);
                shaker.shakeBoth();
                txtfield_login_username.clear();
                passfield_login_password.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    private void openSignUpWindow() {
        //take users to sign up screen
        try {
            AnchorPane showSignUpWindow = FXMLLoader
                    .load(getClass().getResource("/sample/view/signup.fxml"));

            Fader fadeTaskAdditionForm = new Fader();
            fadeTaskAdditionForm.appearFadeIn(showSignUpWindow);

            rootanchorpane_inlogin.getChildren().setAll(showSignUpWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAddTasksWindow(){
        //take users to sign up screen
        btn_login_login.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/addItem.fxml"));

        try {
            loader.setRoot(loader.getRoot());
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        AddItemController addItemController = loader.getController();
        addItemController.setUserId(userId);


        stage.showAndWait();



    }

}
