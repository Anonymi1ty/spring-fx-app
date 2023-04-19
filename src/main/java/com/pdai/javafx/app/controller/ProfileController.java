package com.pdai.javafx.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.pdai.javafx.app.proto.Student;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;
import com.pdai.javafx.app.proto.Student;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import com.pdai.javafx.app.fx.FxmlView;
import com.pdai.javafx.app.fx.StageManager;
import com.pdai.javafx.app.utils.SpringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;

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
    @FXML private Hyperlink ProjectLink1;
    @FXML private Hyperlink ProjectLink2;
    @FXML private Label ProjectTime1;
    @FXML private Label ProjectTime2;
    @FXML private GridPane Grade;
    private Student studentInfo;
    int i = 0;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 获取学生信息
        studentInfo = getStudentInfo();

        note.textProperty().bind(rating.ratingProperty().asString(Locale.ENGLISH, "%.2f"));
		//TODO fullName.textProperty().bind(/* App.getUserDetail().textProperty() */);
        age.setText(String.valueOf(studentInfo.getAge()));
        major.setText(studentInfo.getMajor());
        College.setText("Queen Mary");
        gpa.setText(String.valueOf(studentInfo.getGpa()));
        rank.setText(String.valueOf(studentInfo.getRank()));
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

        i=1;
        studentInfo.getPastCourses().forEach((key, value) -> {

            Label courseName = new Label(key);
            courseName.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
            Grade.add(courseName, 0, i);
            Label mygrade = new Label(value.get("grade"));
            mygrade.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
            Grade.add(mygrade, 1, i);
            Label mytime = new Label(value.get("year"));
            mytime.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
            Grade.add(mytime, 2, i);
            i++;
        });


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 点击链接ProjectLink1后跳转到网页
        ProjectLink1.setOnAction(event -> {
            HostServices hostServices = getHostServices();
            hostServices.showDocument(ProjectLink1.getText());
        });
        // 点击链接ProjectLink2后跳转到网页
        ProjectLink2.setOnAction(event -> {
            HostServices hostServices = getHostServices();
            hostServices.showDocument(ProjectLink2.getText());
        });
    }
}
