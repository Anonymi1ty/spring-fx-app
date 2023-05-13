package com.pdai.javafx.app.utils;

import com.pdai.javafx.app.poto.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@ComponentScan
@Component
public class JsonUtils {
    // 从JSON文件中读取数据，返回一个String类型的字符串

    /**
     * 读取json文件
     * @param filePath json文件路径
     * @return 返回对应的json字符串
     * @throws IOException
     */
    public static String getJson(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder.toString();
    }

    /**
     * 将Json转化为Java对象
     * @param json json字符串
     * @param clazz 转化的类
     * @return 转化后的proto对象
     * @param <T> 转化的类
     */
    public static <T> T jsonToJavaBean(String json, Class<T> clazz) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, clazz);
        return t;
    }

    /**
     * （复用方法）获取Student_Info.json中的数据，返回一个Student对象
     * @return Student对象
     */
    public static Student getStudentInfo() {
        String jsonString;
        try {
            jsonString = getJson("src/main/resources/data/Student_Info.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Student student = jsonToJavaBean(jsonString, Student.class);
        return student;
    }
}
