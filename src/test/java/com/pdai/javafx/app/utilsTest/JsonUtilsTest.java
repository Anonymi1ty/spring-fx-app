package com.pdai.javafx.app.utilsTest;

import com.pdai.javafx.app.poto.ForumInfo;
import com.pdai.javafx.app.poto.Schedule;
import com.pdai.javafx.app.poto.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.pdai.javafx.app.utils.JsonUtils.*;
import static org.junit.Assert.assertEquals;

public class JsonUtilsTest {
    @Test
    public void getJsonTest() {
        String jsonString;
        try {
            jsonString = getJson("src/main/resources/data/Forum.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //使用assert断言，判断是否符合预期
        System.out.println(jsonString);
    }
    @Test
    public void testJsonToJavaBean() {
        String jsonString1;
        try {
            jsonString1 = getJson("src/main/resources/data/Student_Info.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Student testStringToJson = jsonToJavaBean(jsonString1, Student.class);
        assertEquals((testStringToJson.getName()), "Jason");
    }
    @Test
    public void testGetStudentInfo() {
        Student student = getStudentInfo();
        assertEquals((student.getName()), "Jason");
    }
    @Test
    public void InfoTest(){
        List<ForumInfo> forumInfos = getInfo();
        assertEquals((forumInfos.get(0).getMessage()), "Hello everyone!");
    }

    @Test
    public void testJavaBeanToJsonFile() {
        try {
            scheduleJsonToCsv("src/main/resources/data/schedule.csv");
            System.out.println("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testGetSchedule() {
        Schedule schedule = getSchedule();
        assertEquals((schedule.getMonday().get("1")),"Biology");
    }
}
