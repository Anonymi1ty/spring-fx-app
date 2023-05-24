package com.pdai.javafx.app.controller;

import com.pdai.javafx.app.poto.ForumInfo;
import com.pdai.javafx.app.poto.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.pdai.javafx.app.utils.JsonUtils.*;

/**
 * {@code @description:} The controller for drawing the forum.
 */
@Data
@Component
public class ForumController extends BaseController implements Initializable {

    @FXML private Button sendButton;
    @FXML private GridPane messageContainer;
    @FXML private TextArea messageInput;
    private List<ForumInfo> forumInfos;
    private Student student;


    /**
     * Initializes the controller class.
     * @param location
     * The location used to resolve relative paths for the root object, or
     * <tt>null</tt> if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or <tt>null</tt> if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        forumInfos = getInfo();
        student = getStudentInfo();
        display();
    }

    /**
     * Called when the application should stop, and provides a convenient place
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     * @throws Exception if something goes wrong during stopping the application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    /**
     * Send message to the forum
     */
    @FXML
    public void sendMessage() {
        if (!messageInput.getText().equals("")) {
            forumInfos.add(new ForumInfo(student.getName(), messageInput.getText()));
            try {
                javaBeanToJsonFile(forumInfos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            display();
            messageInput.clear();
        }
    }

    /**
     * Display the message on the forum
     */
    public void display() {
        messageContainer.getChildren().clear();
        int i = 0;
        for (ForumInfo forumInfo : forumInfos) {
            i++;
            ColumnConstraints columnConstraints = new ColumnConstraints(1000);
            columnConstraints.setHgrow(Priority.SOMETIMES);
            messageContainer.getColumnConstraints().add(columnConstraints);
            messageContainer.getColumnConstraints().add(columnConstraints);
            messageContainer.getColumnConstraints().add(columnConstraints);
            RowConstraints rowConstraints = new RowConstraints(30);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            messageContainer.getRowConstraints().add(rowConstraints);
            messageContainer.getRowConstraints().add(rowConstraints);
            messageContainer.getRowConstraints().add(rowConstraints);
            Label Namelabel = new Label(forumInfo.getUsername());
            Namelabel.setStyle("-fx-fill: -text-color;");
            Namelabel.getStyleClass().add("h4");
            messageContainer.add(Namelabel, 0, 3*i);
            Label Messagelabel = new Label(forumInfo.getMessage());
            Messagelabel.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
            Messagelabel.getStyleClass().add("h4");
            messageContainer.add(Messagelabel, 0, 3*i+1, 3, 1);
            Separator separator = new Separator();
            separator.setStyle("-fx-background-color: #dddddd;");
            separator.setPrefWidth(1000);
            messageContainer.add(separator, 0, 3*i+2, 3, 1);
        }
    }
}
