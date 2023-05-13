package com.pdai.javafx.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ForumController extends BaseController implements Initializable {
    @FXML private Button sendButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}
