package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Tasktitle_additemform;

    @FXML
    private TextField Taskdescription_additemform;

    @FXML
    private Button savetask_additemform;

    @FXML
    void initialize() {
        savetask_additemform.setOnAction(actionEvent -> System.out.println("Task Saved"));
    }
}
