package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.animations.Fader;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {

    public static int userId;

    @FXML
    private AnchorPane rootanchorpane_inaddItem;


    @FXML
    private Label noTaskLabel_inaddItem;

    @FXML
    private ImageView addTask_inaddItem;

    @FXML
    private ImageView tasklistimage_inaddItem;

    @FXML
    private Label TaskListlabel_inaddItem;

    @FXML
    void initialize() {

        addTask_inaddItem.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            System.out.println("New task added");
            showTaskAdditionForm();
        });

        tasklistimage_inaddItem.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            showTasksWindow();
        });


    }

    private void showTasksWindow() {
        try {
            AnchorPane addTasksForm = FXMLLoader
                    .load(getClass().getResource("/sample/view/tasklist.fxml"));

            AddItemController.userId = getUserId();

            Fader fadeTaskAdditionForm = new Fader();
            fadeTaskAdditionForm.appearFadeIn(addTasksForm);

            rootanchorpane_inaddItem.getChildren().setAll(addTasksForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showTaskAdditionForm() {
        try {
            AnchorPane addTasksForm = FXMLLoader
                    .load(getClass().getResource("/sample/view/addItemForm.fxml"));

            AddItemController.userId = getUserId();

            Fader fadeTaskAdditionForm = new Fader();
            fadeTaskAdditionForm.appearFadeIn(addTasksForm);

            rootanchorpane_inaddItem.getChildren().setAll(addTasksForm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {

        AddItemController.userId = userId;
    }


}
