package com.pdai.javafx.app.poto;

import lombok.Data;

import java.util.Map;

/**
 * {@code @description:} This class is responsible for taking data from the Schedule.json file
 */
@Data
public class Schedule {

    private Map<String,String> Monday;
    private Map<String,String> Tuesday;
    private Map<String,String> Wednesday;
    private Map<String,String> Thursday;
    private Map<String,String> Friday;

}
