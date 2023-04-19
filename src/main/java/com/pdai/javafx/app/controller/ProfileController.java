package com.pdai.javafx.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.pdai.javafx.app.proto.Student;
import org.controlsfx.control.Rating;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.xml.soap.Text;

import static com.pdai.javafx.app.utils.JsonUtils.getJson;
import static com.pdai.javafx.app.utils.JsonUtils.getStudentInfo;

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
    @FXML private Label grade;
    @FXML private Label position;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Student studentInfo = getStudentInfo();

        note.textProperty().bind(rating.ratingProperty().asString(Locale.ENGLISH, "%.2f"));
		//TODO fullName.textProperty().bind(/* App.getUserDetail().textProperty() */);
        age.setText("age : "+studentInfo.getAge());
        major.setText("major : "+studentInfo.getMajor());
        College.setText("College : "+"QM");
        gpa.setText("gpa : "+studentInfo.getGpa());
        rank.setText("rank : "+studentInfo.getRank());
        fullName.setText(studentInfo.getName());
        grade.setText("Junior");
        position.setText(studentInfo.getPosition().get(0) + "\n" + studentInfo.getPosition().get(1));
    }

}
