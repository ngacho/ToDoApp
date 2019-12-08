package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.animations.Fader;
import sample.database.DatabaseHandler;
import sample.models.Task;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddItemFormController {

    private int userId;
    int taskNumber;

    private DatabaseHandler databaseHandler;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootAnchorpane_inaddItemform;

    @FXML
    private TextField Tasktitle_additemform;

    @FXML
    private TextField Taskdescription_additemform;

    @FXML
    private Button savetask_additemform;

    @FXML
    private Label taskaddedsucessLabel_inaddItemform;

    @FXML
    private ImageView taskaddedsuccessimage_inaddItemForm;

    @FXML
    private Button myTasksbutton_inaddItemForm;


    @FXML
    private Label addAnotherTasklabel_inaddItemForm;



    @FXML
    void initialize() {
        databaseHandler = new DatabaseHandler();
        setNoTasks();
        //if(taskNumber>0) openTaskList();
        savetask_additemform.setOnAction(actionEvent -> saveTasktoDatabase());
        myTasksbutton_inaddItemForm.setOnAction(actionEvent -> openTaskList());
    }

    private void saveTasktoDatabase() {
        //Task title and description
        String taskTitle = Tasktitle_additemform.getText().trim();
        String taskDescription = Taskdescription_additemform.getText().trim();
        //Task time stamp
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());


        //create Task and pass to insertTask Method
        if(!taskTitle.equals("") && !taskDescription.equals("")) {
            //Task task = new Task(timestamp, taskTitle, taskDescription);

            Task task = new Task(AddItemController.userId, timestamp, taskTitle, taskDescription);

            try {
                databaseHandler.insertTask(task);
                showLabelandclearTextViews();
                setNoTasks();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Task Saved");


        }

    }

    private void showLabelandclearTextViews(){
        taskaddedsuccessimage_inaddItemForm.setVisible(true);
        taskaddedsucessLabel_inaddItemform.setVisible(true);

        Fader labelandButtonFader = new Fader();
        labelandButtonFader.disappearFadeOut(taskaddedsuccessimage_inaddItemForm);
        labelandButtonFader.disappearFadeOut(taskaddedsucessLabel_inaddItemform);

        Tasktitle_additemform.clear();
        Taskdescription_additemform.clear();


    }

    public void setNoTasks(){
        taskNumber = databaseHandler.getAllTasks(AddItemController.userId);

        myTasksbutton_inaddItemForm.setText("My Tasks: " + taskNumber);
    }

    public int getNoTasks(){

        return taskNumber;
    }

    public void openTaskList(){
        try {
            AnchorPane tasksList = FXMLLoader
                    .load(getClass().getResource("/sample/view/tasklist.fxml"));

            Fader fadeTaskAdditionForm = new Fader();
            fadeTaskAdditionForm.appearFadeIn(tasksList);

            rootAnchorpane_inaddItemform.getChildren().setAll(tasksList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
