package com.pdai.javafx.app.utilsTest;

import com.pdai.javafx.app.poto.Student;
import com.pdai.javafx.app.utils.SpringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.pdai.javafx.app.utils.SpringUtils.getApplicationContext;
import static com.pdai.javafx.app.utils.SpringUtils.getBean;

@SpringBootTest
public class SpringUtilsTest {
    @Test
    public void testApplicationContext() {
        getApplicationContext();
    }
}
