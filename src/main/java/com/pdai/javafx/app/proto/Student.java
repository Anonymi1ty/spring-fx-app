package com.pdai.javafx.app.proto;

import java.util.Map;

public class Student {
    //本类负责承接Student_info.json文件中的数据
    private String name;
    private int age;
    private String major;
    private double gpa;
    private int rank;

    private String[] courses;
    private Map<String,Map<String,String>> PastCourses;
    private Map<String,String>PersonalPlanning;
    private Map<String,String>RecentEvents;
    private Map<String,String>FutureEvents;
    private String[] PortfolioPositions;
    private Map<String,String>[] WorkExperience;
    private Map<String,String>[] Awards;
    private Map<String,String>[] personalProjects;

}
