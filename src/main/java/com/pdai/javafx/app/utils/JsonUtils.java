package com.pdai.javafx.app.utils;

import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Component
public class JsonUtils {
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
}
