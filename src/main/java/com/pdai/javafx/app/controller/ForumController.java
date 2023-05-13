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
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.pdai.javafx.app.utils.JsonUtils.*;

@Component
public class ForumController extends BaseController implements Initializable {

    @FXML private Button sendButton;
    @FXML private GridPane messageContainer;
    @FXML private TextArea messageInput;
    private List<ForumInfo> forumInfos;
    private Student student;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        forumInfos = getInfo();
        student = getStudentInfo();
        display();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    @FXML
    public void sendMessage() {
        forumInfos.add(new ForumInfo(student.getName(), messageInput.getText()));
        try {
            javaBeanToJsonFile(forumInfos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        display();
        messageInput.clear();
    }

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
