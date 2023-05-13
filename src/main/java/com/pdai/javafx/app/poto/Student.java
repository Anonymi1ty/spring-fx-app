package com.pdai.javafx.app.poto;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class Student {
    //本类负责承接Student_info.json文件中的数据
    private String name;
    private int age;
    private String major;
    private double gpa;
    private int rank;

    private String[] courses;
    private Map<String, Map<String, String>> PastCourses;
    private Map<String, String> PersonalPlanning;
    private Map<String, List> RecentEvents;
    private List<String> Position;
    private List<Map<String,String>> WorkExperience;
    private List<Map<String,String>> Awards;
    private List<Map<String,String>> PersonalProjects;
    private List<Map<String,String>> notifaction;

}