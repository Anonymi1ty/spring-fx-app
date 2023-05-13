package com.pdai.javafx.app.poto;

import lombok.Data;

@Data
public class ForumInfo {
    //本类负责承接Forum.json文件中的数据
    private String username;
    private String message;

    public ForumInfo(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
