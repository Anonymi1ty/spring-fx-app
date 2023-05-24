package com.pdai.javafx.app.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.reflect.TypeToken;
import com.pdai.javafx.app.poto.ForumInfo;
import com.pdai.javafx.app.poto.Schedule;
import com.pdai.javafx.app.poto.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

import java.io.*;
import java.util.*;

/**
 * {@code @description:} This class is responsible for reading and writing data to the json file
 */
@ComponentScan
@Component
public class JsonUtils {

    /**
     * Reading a json file and return a string
     * @param filePath json file path
     * @return Returns the corresponding json string
     * @throws IOException File not found exception
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
     * Converts a Java object to a Json string
     * @param object Java Objects
     * @throws IOException File not found exception
     */
    public static void javaBeanToJsonFile(Object object) throws IOException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data/Forum.json"));
        writer.write(jsonString);
        writer.close();
    }

    public static void StudentToJsonFile(Object object) throws IOException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data/Student_Info.json"));
        writer.write(jsonString);
        writer.close();
    }

    /**
     * Converting Json to Java objects
     * @param json json string
     * @param clazz Java class
     * @return Java objects
     * @param <T> Transformed class
     */
    public static <T> T jsonToJavaBean(String json, Class<T> clazz) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, clazz);
        return t;
    }

    /**
     * (Reuse method) Gets the data in Student_Info.json and returns a Student object
     * @return Student Object
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

    /**
     * (Reuse method) Gets the data in Forum.json and returns a List of Info objects
     * @return List of ForumInfo objects
     */
    public static List<ForumInfo> getInfo() {
        String jsonString;
        try {
            jsonString = getJson("src/main/resources/data/Forum.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonString, new TypeToken<List<ForumInfo>>(){}.getType());
    }
    /**
     * (Reuse method) Gets the data in schedule.json and returns a Schedule object
     * @return Schedule对象
     */
    public static Schedule getSchedule() {
        String jsonString;
        try {
            jsonString = getJson("src/main/resources/data/schedule.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Schedule schedule = jsonToJavaBean(jsonString, Schedule.class);
        return schedule;
    }

    /**
     * To schedule the JSON file into a CSV file, and save the SRC/main/resources/data/schedule. CSV path
     * @throws IOException File not found exception
     */
    public static void scheduleJsonToCsv() throws IOException {
        // 读取JSON文件
        ObjectMapper mapper = new ObjectMapper();
        JsonParser jsonParser = mapper.getFactory().createParser(new File("src/main/resources/data/schedule.json"));
        Map<String, Map<String, String>> data = mapper.readValue(jsonParser, Map.class);


        Set<String> headerSet = new LinkedHashSet<>();
        for (Map<String, String> day : data.values()) {
            headerSet.addAll(day.keySet());
        }
        List<String> headerList = new ArrayList<>(headerSet);
//        Collections.sort(headerList);


        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        csvSchemaBuilder.setUseHeader(true).setColumnSeparator(',');
        for (String header : headerList) {
            csvSchemaBuilder.addColumn(header);
        }
        CsvSchema csvSchema = csvSchemaBuilder.build();

        // 写入CSV文件
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(Map.class)
                .with(csvSchema)
                .writeValues(new File("src/main/resources/data/schedule.csv"))
                .writeAll(data.values());
    }
}
