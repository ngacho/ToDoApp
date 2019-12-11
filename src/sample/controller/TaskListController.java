package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import sample.animations.Fader;
import sample.database.DatabaseHandler;
import sample.models.Task;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TaskListController {

    private int userId;

    @FXML
    private AnchorPane rootanchor_inList;

    @FXML
    private Button addtaskbutton_inlist;

    @FXML
    private ListView<Task> taskListViw_inlist;


    @FXML
    void initialize() {
        //Setting the userid
        setUserId(AddItemController.userId);

        ObservableList<Task> tasks = FXCollections.observableArrayList();

        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet tasksResultSet = databaseHandler.getTasksbyUserId(userId);
        try {
            while (tasksResultSet.next()) {
                Timestamp taskDateCreated = tasksResultSet.getTimestamp("datecreated");
                String taskName = tasksResultSet.getString("task");
                String taskDescription = tasksResultSet.getString("description");
                Task task = new Task(taskDateCreated, taskName, taskDescription);
                task.setTaskId(tasksResultSet.getInt("taskId"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        taskListViw_inlist.setItems(tasks);
        taskListViw_inlist.setCellFactory(ListRowController -> new ListRowController());

        addtaskbutton_inlist.setOnAction(actionEvent -> openAddTaskForm());


    }

    private void openAddTaskForm() {
        try {
            AnchorPane addTasksForm = FXMLLoader
                    .load(getClass().getResource("/sample/view/addItemForm.fxml"));

            Fader fadeTaskAdditionForm = new Fader();
            fadeTaskAdditionForm.appearFadeIn(addTasksForm);

            rootanchor_inList.getChildren().setAll(addTasksForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }

}
