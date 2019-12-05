package sample.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.animations.Shaker;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {
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
            Shaker addTaskShaker = new Shaker(addTask_inaddItem);
            addTaskShaker.shake();
            System.out.println("Added Task...");
            makeItemsFade();
        });


    }

    private void makeItemsFade() {
        FadeTransition addTaskImageTransition = new FadeTransition(Duration.millis(1000), addTask_inaddItem);
        FadeTransition noTaskLabelTransition = new FadeTransition(Duration.millis(1000), noTaskLabel_inaddItem);

        //Relocate Items to corner
        addTask_inaddItem.relocate(0, 0);
        noTaskLabel_inaddItem.relocate(0, 10);

        //Add Transition to add button
        addTaskImageTransition.setFromValue(1f);
        addTaskImageTransition.setToValue(0f);
        addTaskImageTransition.setCycleCount(1);
        addTaskImageTransition.setAutoReverse(false);
        addTaskImageTransition.play();
        //Add Transition to no-task-label
        noTaskLabelTransition.setFromValue(1f);
        noTaskLabelTransition.setToValue(0f);
        noTaskLabelTransition.setCycleCount(1);
        noTaskLabelTransition.setAutoReverse(false);
        noTaskLabelTransition.play();

        showTaskAdditionForm();

    }

    private void showTaskAdditionForm() {
        try {
            AnchorPane addTasksForm = FXMLLoader
                    .load(getClass().getResource("/sample/view/addItemForm.fxml"));

            FadeTransition taskAdditionFormTransition = new FadeTransition(Duration.millis(1000), addTasksForm);
            taskAdditionFormTransition.setFromValue(0f);
            taskAdditionFormTransition.setToValue(1f);
            taskAdditionFormTransition.setCycleCount(1);
            taskAdditionFormTransition.setAutoReverse(false);
            taskAdditionFormTransition.play();
            rootanchorpane_inaddItem.getChildren().setAll(addTasksForm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
