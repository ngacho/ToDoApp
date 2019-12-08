package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Affine;
import sample.animations.Fader;
import sample.animations.Shaker;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {

    public static int userId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootanchorpane_inaddItem;


    @FXML
    private Label noTaskLabel_inaddItem;

    @FXML
    private ImageView addTask_inaddItem;

    @FXML
    void initialize() {

        addTask_inaddItem.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            System.out.println("New task added");
            showTaskAdditionForm();
        });


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

        this.userId = userId;
    }


}
