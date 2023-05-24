package com.pdai.javafx.app.poto;

import lombok.Data;

/**
 * {@code @description:} This class is responsible for taking data from the Forum.json file
 */
@Data
public class ForumInfo {
    private String username;
    private String message;

    public ForumInfo(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
