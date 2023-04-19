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
    @FXML private Label Internship1;
    @FXML private Label Internship2;
    @FXML private Label InternshipPosition1;
    @FXML private Label InternshipPosition2;
    @FXML private Label InternshipTime1;
    @FXML private Label InternshipTime2;
    @FXML private Label CompetitionName1;
    @FXML private Label CompetitionName2;
    @FXML private Label AwardLevel1;
    @FXML private Label AwardLevel2;
    @FXML private Label AwardTime1;
    @FXML private Label AwardTime2;
    @FXML private Label ProjectName1;
    @FXML private Label ProjectName2;
    @FXML private Label ProjectDescription1;
    @FXML private Label ProjectDescription2;
    @FXML private Label ProjectLink1;
    @FXML private Label ProjectLink2;
    @FXML private Label ProjectTime1;
    @FXML private Label ProjectTime2;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Student studentInfo = getStudentInfo();

        note.textProperty().bind(rating.ratingProperty().asString(Locale.ENGLISH, "%.2f"));
		//TODO fullName.textProperty().bind(/* App.getUserDetail().textProperty() */);
        age.setText(String.valueOf(studentInfo.getAge()));
        major.setText(studentInfo.getMajor());
        College.setText("Queen Mary");
        gpa.setText("gpa : "+studentInfo.getGpa());
        rank.setText("rank : "+studentInfo.getRank());
        fullName.setText(studentInfo.getName());
        grade.setText("Junior");
        position.setText(studentInfo.getPosition().get(0) + "\n" + studentInfo.getPosition().get(1));
        Internship1.setText(studentInfo.getWorkExperience().get(0).get("Company Name"));
        Internship2.setText(studentInfo.getWorkExperience().get(1).get("Company Name"));
        InternshipPosition1.setText(studentInfo.getWorkExperience().get(0).get("Position"));
        InternshipPosition2.setText(studentInfo.getWorkExperience().get(1).get("Position"));
        InternshipTime1.setText(studentInfo.getWorkExperience().get(0).get("Time"));
        InternshipTime2.setText(studentInfo.getWorkExperience().get(1).get("Time"));
        CompetitionName1.setText(studentInfo.getAwards().get(0).get("Competition Name"));
        CompetitionName2.setText(studentInfo.getAwards().get(1).get("Competition Name"));
        AwardLevel1.setText(studentInfo.getAwards().get(0).get("Award"));
        AwardLevel2.setText(studentInfo.getAwards().get(1).get("Award"));
        AwardTime1.setText(studentInfo.getAwards().get(0).get("Time"));
        AwardTime2.setText(studentInfo.getAwards().get(1).get("Time"));
        ProjectName1.setText(studentInfo.getPersonalProjects().get(0).get("Project Name"));
        ProjectName2.setText(studentInfo.getPersonalProjects().get(1).get("Project Name"));
        ProjectDescription1.setText(studentInfo.getPersonalProjects().get(0).get("Description"));
        ProjectDescription2.setText(studentInfo.getPersonalProjects().get(1).get("Description"));
        ProjectLink1.setText(studentInfo.getPersonalProjects().get(0).get("Link"));
        ProjectLink2.setText(studentInfo.getPersonalProjects().get(1).get("Link"));
        ProjectTime1.setText(studentInfo.getPersonalProjects().get(0).get("Time"));
        ProjectTime2.setText(studentInfo.getPersonalProjects().get(1).get("Time"));

    }

}
