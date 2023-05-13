package com.pdai.javafx.app.controller;

import com.pdai.javafx.app.poto.Info;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.pdai.javafx.app.utils.JsonUtils.getInfo;
import static com.pdai.javafx.app.utils.JsonUtils.getStudentInfo;

@Component
public class ForumController extends BaseController implements Initializable {

    @FXML private Button sendButton;
    @FXML private GridPane messageContainer;
    private ArrayList<Info> infos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        infos = getInfo();
//        int i = 0;
//        for (Info info : infos) {
//            i++;
//            RowConstraints rowConstraints = new RowConstraints(30);
//            rowConstraints.setVgrow(Priority.SOMETIMES);
//            messageContainer.getRowConstraints().add(rowConstraints);
//            messageContainer.getRowConstraints().add(rowConstraints);
//            Label Namelabel = new Label(info.getUsername());
//            Namelabel.setStyle("-fx-fill: -text-color;");
//            Namelabel.getStyleClass().add("h4");
//            messageContainer.add(Namelabel, 0, 2*i);
//            Label Messagelabel = new Label(info.getMessage());
//            Messagelabel.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
//            Messagelabel.getStyleClass().add("h4");
//            messageContainer.add(Messagelabel, 0, 2*i+1, 2, 1);
//        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    @FXML
    public void sendMessage() {
        System.out.println("sendButtonAction");
    }

}
