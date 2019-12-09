package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import sample.animations.Fader;
import sample.models.Task;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ListController {

    private int userId;


    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane rootanchor_inList;

    @FXML
    private URL location;

    @FXML
    private Button addtaskbutton_inlist;

    @FXML
    private ListView<Task> taskListViw_inlist;

    private ObservableList<Task> tasks;


    @FXML
    void initialize() {
        addtaskbutton_inlist.setOnAction(actionEvent -> openAddTaskForm());

        Task testTask = new Task(Timestamp.valueOf(LocalDateTime.now()), "Test Task", "We are testing to see if task is working");

        tasks = FXCollections.observableArrayList();
        tasks.add(testTask);

        taskListViw_inlist.setItems(tasks);
        taskListViw_inlist.setCellFactory(ListRowController -> new ListRowController());

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
