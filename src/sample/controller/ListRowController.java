package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.models.Task;

import java.io.IOException;

public class ListRowController extends ListCell<Task> {

    @FXML
    private AnchorPane rootanchorpane_inlistrow;

    @FXML
    private ImageView taskicon_inlistrow;

    @FXML
    private Label tasknamelabel_inlistrow;

    @FXML
    private Label taskdescription_inlistrow;

    @FXML
    private Label datecreatedlabel_inlistrow;

    @FXML
    private ImageView deleteimage_inlistrow;

    private FXMLLoader listRowFXMLloader;

    @FXML
    void initialize() {

    }

    @Override
    protected void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);
        if (empty || myTask == null) {
            setText(null);
            setGraphic(null);
        } else {
            if(listRowFXMLloader == null){
                listRowFXMLloader = new FXMLLoader(getClass().getResource("sample/view/listRow.fxml"));
                listRowFXMLloader.setController(this);

                try {
                    listRowFXMLloader.setLocation(getClass().getResource("/sample/view/listRow.fxml"));
                    listRowFXMLloader.load();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            tasknamelabel_inlistrow.setText(myTask.getTask());
            taskdescription_inlistrow.setText(myTask.getDescription());
            datecreatedlabel_inlistrow.setText(myTask.getDateCreated().toString());

            setText(null);
            setGraphic(rootanchorpane_inlistrow);

        }
    }
}
