package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import sample.animations.Fader;

import java.net.URL;
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
    private ListView<String> taskListViw_inlist;

    ObservableList<String> listView = FXCollections.observableArrayList("John",
            "Paulo",
            "Mancity",
            "Man United"
    );

    CheckBoxListCell<String> checkBoxListCellList = new CheckBoxListCell<>();

    public void setCheckBoxListCellList(CheckBoxListCell<String> checkBoxListCellList) {
        this.checkBoxListCellList = checkBoxListCellList;
        //TODO: understand and populate this thing
    }

    @FXML
    void initialize() {
        taskListViw_inlist.getItems().setAll(listView);
        taskListViw_inlist.setCellFactory(param -> new Cell());
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    static class Cell extends ListCell<String>{
        //Hbox is horizontal box
        CheckBox checkBox = new CheckBox();
        HBox hBox = new HBox();
        Button button = new Button("Hello");
        Label task = new Label();

        Pane pane = new Pane();
        Image icon = new Image("sample/assets/ic_addtasks.png");
        ImageView iconImg = new ImageView(icon);



        public Cell() {
            super();

            hBox.getChildren().setAll(checkBox, task, button);
            hBox.setHgrow(pane, Priority.ALWAYS);
        }

        public void updateItem(String taskName, boolean empty){
            super.updateItem(taskName, empty);
            setText(null);
            setGraphic(null);

            if(taskName != null && !empty){
                task.setText(taskName);
                setGraphic(hBox);
            }
        }
    }
}
