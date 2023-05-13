package com.pdai.javafx.app.poto;

import lombok.Data;

@Data
public class Info {
    //本类负责承接Forum.json文件中的数据
    private int id;
    private String username;
    private String message;
}
