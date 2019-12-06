package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.database.DatabaseHandler;
import sample.models.Task;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddItemFormController {

    private int userId;

    private DatabaseHandler databaseHandler;
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
        databaseHandler = new DatabaseHandler();
        savetask_additemform.setOnAction(actionEvent -> {
            //Task title and description
            String taskTitle = Tasktitle_additemform.getText().trim();
            String taskDescription = Taskdescription_additemform.getText().trim();
            //Task time stamp
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());


            //create Task and pass to insertTask Method
            if(!taskTitle.equals("") && !taskDescription.equals("")){
                //Task task = new Task(timestamp, taskTitle, taskDescription);

                Task task = new Task(AddItemController.userId, timestamp, taskTitle, taskDescription);
                databaseHandler.insertTask(task);
                System.out.println("Task Saved");
            }
        });
    }
}
