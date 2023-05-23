package com.pdai.javafx.app.utilsTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.pdai.javafx.app.utils.SpringUtils.getApplicationContext;

@SpringBootTest
public class SpringUtilsTest {
    @Test
    public void testApplicationContext() {
        getApplicationContext();
    }
}
