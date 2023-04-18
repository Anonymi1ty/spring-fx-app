package com.pdai.javafx.app.controller;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.xml.soap.Text;

@Component
public class ProfileController extends BaseController implements Initializable {

    @FXML private Label note;
    @FXML private Rating rating;
    @FXML private Label fullName;
    @FXML private Label age;
    @FXML private Label major;
    @FXML private Label College;
    @FXML private Label gpa;
    @FXML private Label rank;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        note.textProperty().bind(rating.ratingProperty().asString(Locale.ENGLISH, "%.2f"));
		//TODO fullName.textProperty().bind(/* App.getUserDetail().textProperty() */);
        age.setText("age : "+"20");
        major.setText("major : "+"E-commerce");
        College.setText("College : "+"International School");
        gpa.setText("gpa : "+"4.5");
        rank.setText("rank : "+"10");
    }

}
