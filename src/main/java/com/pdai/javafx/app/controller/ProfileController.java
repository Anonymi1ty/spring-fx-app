package com.pdai.javafx.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.pdai.javafx.app.poto.ForumInfo;
import com.pdai.javafx.app.poto.Schedule;
import com.pdai.javafx.app.poto.Student;
import javafx.application.HostServices;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.Rating;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.layout.*;

import static com.pdai.javafx.app.utils.JsonUtils.*;

/**
 * {@code @description:} The controller for the profile
 */
@Component
public class ProfileController extends BaseController implements Initializable {

    private PopOver pop = new PopOver();

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
    @FXML private GridPane WorkExperience;
    @FXML private GridPane Awards;
    @FXML private GridPane Grade;
    @FXML private GridPane Project;
    @FXML private GridPane ClassSchedule;
    private Student studentInfo;
    private Schedule schedule;
    int i = 0;


    /**
     * {@code @description:} The method for the popover
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
        // 获取学生信息
        studentInfo = getStudentInfo();
        schedule = getSchedule();

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


        setWorkExperience();
        setAwards();
        setProject();
        setGrade();


        i=0;
        schedule.getMonday().forEach((key,value)->{
            Label label = new Label(value);
            label.setStyle("-fx-fill: -text-color;");
            ClassSchedule.add(label,1,++i);
        });
        i=0;
        schedule.getTuesday().forEach((key,value)->{
            Label label = new Label(value);
            label.setStyle("-fx-fill: -text-color;");
            ClassSchedule.add(label,2,++i);
        });
        i=0;
        schedule.getWednesday().forEach((key,value)->{
            Label label = new Label(value);
            label.setStyle("-fx-fill: -text-color;");
            ClassSchedule.add(label,3,++i);
        });
        i=0;
        schedule.getThursday().forEach((key,value)->{
            Label label = new Label(value);
            label.setStyle("-fx-fill: -text-color;");
            ClassSchedule.add(label,4,++i);
        });
        i=0;
        schedule.getFriday().forEach((key,value)->{
            Label label = new Label(value);
            label.setStyle("-fx-fill: -text-color;");
            ClassSchedule.add(label,5,++i);
        });

    }
    private void setGrade(){
        Grade.getChildren().clear();
        i=0;
        studentInfo.getPastCourses().forEach((key, value) -> {
            RowConstraints rowConstraints = new RowConstraints(30);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            Grade.getRowConstraints().add(rowConstraints);
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
    private void setWorkExperience(){
        WorkExperience.getChildren().clear();
        ColumnConstraints columnConstraints = new ColumnConstraints(500);
        columnConstraints.setHgrow(Priority.SOMETIMES);
        WorkExperience.getColumnConstraints().add(columnConstraints);
        WorkExperience.getColumnConstraints().add(columnConstraints);
        WorkExperience.getColumnConstraints().add(columnConstraints);

        Label caption = new Label("Practical and Internship");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        WorkExperience.add(caption, 0, 0);
        caption = new Label("Position");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        WorkExperience.add(caption, 1, 0);
        caption = new Label("Time Period");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        WorkExperience.add(caption, 2, 0);

        int i = 0;
        for (Map<String, String> workexperience : studentInfo.getWorkExperience()) {
            i++;
            RowConstraints rowConstraints = new RowConstraints(50);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            WorkExperience.getRowConstraints().add(rowConstraints);
            Label companyName = new Label(workexperience.get("Company Name"));
            companyName.setStyle("-fx-fill: -text-color;");
            companyName.getStyleClass().add("h4");
            WorkExperience.add(companyName, 0, i);
            Label position = new Label(workexperience.get("Position"));
            position.setStyle("-fx-fill: -text-color;");
            position.getStyleClass().add("h4");
            WorkExperience.add(position, 1, i);
            Label time = new Label(workexperience.get("Time"));
            time.setStyle("-fx-fill: -text-color;");
            time.getStyleClass().add("h4");
            WorkExperience.add(time, 2, i);
        }
    }
    private void setAwards() {
        Awards.getChildren().clear();
        ColumnConstraints columnConstraints = new ColumnConstraints(500);
        columnConstraints.setHgrow(Priority.SOMETIMES);
        Awards.getColumnConstraints().add(columnConstraints);
        Awards.getColumnConstraints().add(columnConstraints);
        Awards.getColumnConstraints().add(columnConstraints);

        Label caption = new Label("Competition Name");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Awards.add(caption, 0, 0);
        caption = new Label("Award Level");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Awards.add(caption, 1, 0);
        caption = new Label("Time");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Awards.add(caption, 2, 0);

        int i = 0;
        for (Map<String, String> award : studentInfo.getAwards()) {
            i++;
            RowConstraints rowConstraints = new RowConstraints(50);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            Awards.getRowConstraints().add(rowConstraints);
            Label Content = new Label(award.get("Competition Name"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Awards.add(Content, 0, i);
            Content = new Label(award.get("Award"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Awards.add(Content, 1, i);
            Content = new Label(award.get("Time"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Awards.add(Content, 2, i);
        }
    }

    private void setProject(){
        Project.getChildren().clear();
        ColumnConstraints columnConstraints = new ColumnConstraints(400);
        columnConstraints.setHgrow(Priority.SOMETIMES);
        Project.getColumnConstraints().add(columnConstraints);
        columnConstraints = new ColumnConstraints(650);
        Project.getColumnConstraints().add(columnConstraints);
        columnConstraints = new ColumnConstraints(400);
        Project.getColumnConstraints().add(columnConstraints);
        Project.getColumnConstraints().add(columnConstraints);

        Label caption = new Label("Project Name");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Project.add(caption, 0, 0);
        caption = new Label("Description");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Project.add(caption, 1, 0);
        caption = new Label("Link");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Project.add(caption, 2, 0);
        caption = new Label("Time");
        caption.setStyle("-fx-fill: -text-color;-fx-font-weight: bold;");
        caption.getStyleClass().add("h4");
        caption.setAlignment(Pos.CENTER);
        Project.add(caption, 3, 0);

        int i = 0;
        for (Map<String, String> projects : studentInfo.getPersonalProjects()) {
            i++;
            RowConstraints rowConstraints = new RowConstraints(50);
            rowConstraints.setVgrow(Priority.SOMETIMES);
            Project.getRowConstraints().add(rowConstraints);
            Label Content = new Label(projects.get("Project Name"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Project.add(Content, 0, i);
            Content = new Label(projects.get("Description"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Project.add(Content, 1, i);
            Content = new Label(projects.get("Link"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Project.add(Content, 2, i);
            Content = new Label(projects.get("Time"));
            Content.setStyle("-fx-fill: -text-color;");
            Content.getStyleClass().add("h4");
            Project.add(Content, 3, i);
        }
    }

    @FXML
    private void WorkExperienceAdd(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // 确认弹窗
        alert.setTitle("Add Work Experience");
        alert.setHeaderText("Please enter the information of your work experience");
        alert.setContentText("Please enter the information of your work experience");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        TextField Company = new TextField();
        Company.setPromptText("Company");
        Company.setAlignment(Pos.CENTER);
        TextField Position = new TextField();
        Position.setPromptText("Position");
        Position.setAlignment(Pos.CENTER);
        TextField Time = new TextField();
        Time.setPromptText("Time");
        Time.setAlignment(Pos.CENTER);
        gridPane.add(new Label("Company:"), 0, 0);
        gridPane.add(Company, 1, 0);
        gridPane.add(new Label("Position:"), 0, 1);
        gridPane.add(Position, 1, 1);
        gridPane.add(new Label("Time:"), 0, 2);
        gridPane.add(Time, 1, 2);
        gridPane.setAlignment(Pos.CENTER);
        alert.getDialogPane().setContent(gridPane);
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes && !Company.getText().equals("") && !Position.getText().equals("") && !Time.getText().equals("")){
            Map<String, String> workExperience = new HashMap<>();
            workExperience.put("Company Name", Company.getText());
            workExperience.put("Position", Position.getText());
            workExperience.put("Time", Time.getText());
            studentInfo.getWorkExperience().add(workExperience);
            setWorkExperience();
            try {
                StudentToJsonFile(studentInfo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

@FXML
private void AwardsAdd(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // 确认弹窗
    alert.setTitle("Add Awards");
    alert.setHeaderText("Please enter the information of your Award");
    alert.setContentText("Please enter the information of your Award");
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    TextField Competition = new TextField();
    Competition.setPromptText("Competition Name");
    Competition.setAlignment(Pos.CENTER);
    TextField Award = new TextField();
    Award.setPromptText("Award Level");
    Award.setAlignment(Pos.CENTER);
    TextField Time = new TextField();
    Time.setPromptText("Time");
    Time.setAlignment(Pos.CENTER);
    gridPane.add(new Label("Competition Name:"), 0, 0);
    gridPane.add(Competition, 1, 0);
    gridPane.add(new Label("Award Level:"), 0, 1);
    gridPane.add(Award, 1, 1);
    gridPane.add(new Label("Time:"), 0, 2);
    gridPane.add(Time, 1, 2);
    gridPane.setAlignment(Pos.CENTER);
    alert.getDialogPane().setContent(gridPane);
    ButtonType buttonTypeYes = new ButtonType("Yes");
    ButtonType buttonTypeNo = new ButtonType("No");
    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == buttonTypeYes && !Competition.getText().equals("") && !Award.getText().equals("") && !Time.getText().equals("")){
        Map<String, String> award = new HashMap<>();
        award.put("Competition Name", Competition.getText());
        award.put("Award", Award.getText());
        award.put("Time", Time.getText());
        studentInfo.getAwards().add(award);
        setAwards();
        try {
            StudentToJsonFile(studentInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

    @FXML
    private void ProjectAdd(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // 确认弹窗
        alert.setTitle("Add Projects");
        alert.setHeaderText("Please enter the information of your Project");
        alert.setContentText("Please enter the information of your Project");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        TextField ProjectName = new TextField();
        ProjectName.setPromptText("Project Name");
        ProjectName.setAlignment(Pos.CENTER);
        TextField Description = new TextField();
        Description.setPromptText("Description");
        Description.setAlignment(Pos.CENTER);
        TextField Link = new TextField();
        Link.setPromptText("Link");
        Link.setAlignment(Pos.CENTER);
        TextField Time = new TextField();
        Time.setPromptText("Time");
        Time.setAlignment(Pos.CENTER);
        gridPane.add(new Label("Project Name:"), 0, 0);
        gridPane.add(ProjectName, 1, 0);
        gridPane.add(new Label("Description:"), 0, 1);
        gridPane.add(Description, 1, 1);
        gridPane.add(new Label("Link:"), 0, 2);
        gridPane.add(Link, 1, 2);
        gridPane.add(new Label("Time:"), 0, 3);
        gridPane.add(Time, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        alert.getDialogPane().setContent(gridPane);
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes && !ProjectName.getText().equals("") && !Description.getText().equals("") && !Link.getText().equals("") && !Time.getText().equals("")){
            Map<String, String> project = new HashMap<>();
            project.put("Project Name", ProjectName.getText());
            project.put("Description", Description.getText());
            project.put("Time", Time.getText());
            project.put("Link", Link.getText());
            studentInfo.getPersonalProjects().add(project);
            setProject();
            try {
                StudentToJsonFile(studentInfo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    private void GradeAdd(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // 确认弹窗
        alert.setTitle("Add Grades");
        alert.setHeaderText("Please enter the information of your Grade");
        alert.setContentText("Please enter the information of your Grade");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        TextField Crouse = new TextField();
        Crouse.setPromptText("Crouse Name");
        Crouse.setAlignment(Pos.CENTER);
        TextField Grade = new TextField();
        Grade.setPromptText("Grade");
        Grade.setAlignment(Pos.CENTER);
        TextField Year = new TextField();
        Year.setPromptText("Year");
        Year.setAlignment(Pos.CENTER);
        gridPane.add(new Label("Crouse Name:"), 0, 0);
        gridPane.add(Crouse, 1, 0);
        gridPane.add(new Label("Grade:"), 0, 1);
        gridPane.add(Grade, 1, 1);
        gridPane.add(new Label("Year:"), 0, 2);
        gridPane.add(Year, 1, 2);
        gridPane.setAlignment(Pos.CENTER);
        alert.getDialogPane().setContent(gridPane);
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes && !Crouse.getText().equals("") && !Grade.getText().equals("") && !Year.getText().equals("")){
            Map<String, String> PastCourses = new HashMap<>();
            PastCourses.put("grade", Grade.getText());
            PastCourses.put("year", Year.getText());
            studentInfo.getPastCourses().put(Crouse.getText(), PastCourses);
            setGrade();
            try {
                StudentToJsonFile(studentInfo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    private void ExportSchedule() throws IOException {
        scheduleJsonToCsv();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 点击链接ProjectLink1后跳转到网页
//        ProjectLink1.setOnAction(event -> {
//            HostServices hostServices = getHostServices();
//            hostServices.showDocument(ProjectLink1.getText());
//        });
//        // 点击链接ProjectLink2后跳转到网页
//        ProjectLink2.setOnAction(event -> {
//            HostServices hostServices = getHostServices();
//            hostServices.showDocument(ProjectLink2.getText());
//        });
    }
}
