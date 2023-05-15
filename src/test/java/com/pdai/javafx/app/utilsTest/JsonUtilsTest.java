package com.pdai.javafx.app.utilsTest;

import com.pdai.javafx.app.poto.ForumInfo;
import com.pdai.javafx.app.poto.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.pdai.javafx.app.utils.JsonUtils.*;

public class JsonUtilsTest {
    @Test
    public void getJsonTest() {
        String jsonString;
        try {
            jsonString = getJson("src/main/resources/data/Forum.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        System.out.println(jsonString1);
        Student testStringToJson = jsonToJavaBean(jsonString1, Student.class);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(testStringToJson);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(testStringToJson.getRecentEvents().size());
    }
    @Test
    public void testGetStudentInfo() {
        Student student = getStudentInfo();
        System.out.println(student);
    }
    @Test
    public void InfoTest(){
        List<ForumInfo> forumInfos = getInfo();
        System.out.println(forumInfos);
    }

    @Test
    public void testJavaBeanToJsonFile() {
        try {
            scheduleJsonToCsv();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
